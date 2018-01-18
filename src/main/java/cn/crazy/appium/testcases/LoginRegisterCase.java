package cn.crazy.appium.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import cn.crazy.appium.base.AndroidDriverBase;
import cn.crazy.appium.datadriver.ExcelUtil;
import cn.crazy.appium.page.HomePage;
import cn.crazy.appium.page.LoginRegisterPage;
import cn.crazy.appium.testng.Assertion;

public class LoginRegisterCase extends CaseBaseTest {
	public static AndroidDriverBase driver;
	public LoginRegisterPage loginTest;
	public Assertion as;
	
	
	
	@BeforeClass
	@Parameters({ "udid", "port" })
	public void beforeClass(String udid, String port) {
		try {
			System.out.println("读到的udid是："+udid+"读到的port是："+port);
			driver=driverInit(udid, port);
			driver.implicitlyWait(10);
			as=new Assertion(driver);
			loginTest=new LoginRegisterPage(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("执行测试test");
	}
	
	@DataProvider
	public Object[][] loginData(){
		Object[][] data=null;
		try {
			data = ExcelUtil.getTestData("configs/logindata.xlsx", "Sheet1");
		} catch (IOException e) {
			// TODO Auto-generated catch block"configs/test.xlsx", "Sheet1"
			e.printStackTrace();
		}
		return data;
	}
//	@Test(dataProvider="loginData",retryAnalyzer=TestngRetry.class)//错误重新执行
	@Test(dataProvider="loginData" , priority=0)
	public void login(String username,String password,String toast) throws Exception{
		System.out.println("username="+username+","+"password="+password);
		HomePage hp=loginTest.login(username,password);
		try {
			boolean flag = true;
			if(!toast.equals("无toast")){
				flag = driver.isToast(toast);
			}else{
				if(hp.pageSource.contains("下次再说")){
					flag = true;
				}else if(hp.pageSource.contains("物业公告")){
					flag = true;
				}
			}
			as.assertEquals(flag, true, "错误结果截图");
		} catch (AssertionError e) {
			// TODO: handle exception
//			excel.setCellData(Integer.valueOf(caseNumber),excel.getLastColumnNum(), "测试用例执行失败");
			Assert.fail("login failure");
		}
	}
	
	@DataProvider
	public Object[][] forgetData(){
		Object[][] data=null;
		try {
			data = ExcelUtil.getTestData("configs/forgetdata.xlsx", "Sheet1");
		} catch (IOException e) {
			// TODO Auto-generated catch block"configs/test.xlsx", "Sheet1"
			e.printStackTrace();
		}
		return data;
	}
	
	@Test(dataProvider="forgetData" , priority=1)
	public void forget(String username , String pwd1 , String pwd2 ,String codestring, String toast) throws Exception{
		HomePage hp=loginTest.forgetpwd(username, pwd1, pwd2, codestring);
		try {
			boolean flag = true;
			if(!toast.equals("成功")){
				flag = driver.isToast(toast);
			}else{
				flag = driver.isToast(toast);
				flag = hp.pageSource.contains("登录");
				if(flag){
					loginTest.login(username, pwd1);
					if(hp.pageSource.contains("下次再说")){
						flag = true;
					}else if(hp.pageSource.contains("物业公告")){
						flag = true;
					}
				}else {
					flag=false;
				}
			}
			as.assertEquals(flag, true, "错误结果截图");
		} catch (AssertionError e) {
			// TODO: handle exception
//			excel.setCellData(Integer.valueOf(caseNumber),excel.getLastColumnNum(), "测试用例执行失败");
			Assert.fail("login failure");
		}
	}
	
	@DataProvider
	public Object[][] regData(){
		Object[][] data=null;
		try {
			data = ExcelUtil.getTestData("configs/regdata.xlsx", "Sheet1");
		} catch (IOException e) {
			// TODO Auto-generated catch block"
			e.printStackTrace();
		}
		return data;
	}
	
	@Test(dataProvider="regData" , priority=2)
	public void regCase(String username , String pwd1 , String pwd2 ,String codestring, String toast) throws Exception{
		HomePage hp=loginTest.reg(username, pwd1, pwd2, codestring, toast);
		try {
			boolean flag = true;
			if(!username.equals("number")){
				flag = driver.isToast(toast);
			}else{
				flag = hp.pageSource.contains("下次再说");
				if (!flag) {
					flag = hp.pageSource.contains("物业公告");
				}
			}
			System.out.println("flag:"+flag);
			as.assertEquals(flag, true, "错误结果截图");
		} catch (AssertionError e) {
			// TODO: handle exception
			Assert.fail("login failure");
		}
	}
	@AfterMethod
	public void afterMethod(){
		driver.resetApp();
//		ProUtil p=new ProUtil("configs/caps.properties");
//		driver.startActivity(p.getPro("appPackage"), p.getPro("appActivity"));
	}
	
	@AfterSuite
	public void quit(){
		driver.quit();
	}

}
