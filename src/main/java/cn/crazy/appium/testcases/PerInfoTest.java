package cn.crazy.appium.testcases;

import io.appium.java_client.android.AndroidDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import cn.crazy.appium.base.AndroidDriverBase;
import cn.crazy.appium.page.PerInfoPage;
import cn.crazy.appium.page.RegPage;
import cn.crazy.appium.testng.Assertion;

public class PerInfoTest extends CaseBaseTest {
	public PerInfoPage perInfoTest;
	public RegPage regTest;
	Assertion as=new Assertion(driver);


//	@Parameters({ "udid", "port" })
//	public void beforeClass(String udid, String port) {
//		try {
//			System.out.println("读到的udid是："+udid+"读到的port是："+port);
//			driver=driverInit(udid, port);
//			driver.implicitlyWait(10);
//			perInfoTest=new PerInfoPage(driver);
//			as=new Assertion(driver);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println("执行测试test");
//	}
	@BeforeClass
	public void iniDirver(){
		   this.driver = super.driver;
	}

	@Test
	public void changePerInfoTest() throws Exception{
		perInfoTest = new PerInfoPage(driver);
		boolean flag = perInfoTest.changePersonInfo(); 
		as.verifyEquals(flag, true, "修改个人信息结果");	
	}
	
//	@Test
	public void regCase() throws Exception{
		regTest = new RegPage(driver);
		boolean flag = regTest.regTestCase();
		as.verifyEquals(flag, true, "修改个人信息结果");
	}
	
	
	@AfterMethod
	public void afterMethod(){
		driver.resetApp();
		//driver.startActivity(appPackage, appActivity);
	}
//	@AfterClass
	public void quit(){
		driver.quit();
		System.out.println("onebandtest中的afterclass");
	}
//	
	
	
}
