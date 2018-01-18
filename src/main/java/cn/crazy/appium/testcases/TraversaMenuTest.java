package cn.crazy.appium.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import cn.crazy.appium.base.AndroidDriverBase;
import cn.crazy.appium.page.LeftMenuPage;
import cn.crazy.appium.page.LoginRegisterPage;
import cn.crazy.appium.testng.Assertion;

public class TraversaMenuTest extends CaseBaseTest{
	public AndroidDriverBase driver;
	public LeftMenuPage traversaTest;
	public Assertion as;
	
	
	@BeforeClass
	@Parameters({ "udid", "port" })
	public void beforeClass(String udid, String port) {
		try {
			System.out.println("读到的udid是："+udid+"读到的port是："+port);
			driver=driverInit(udid, port);
			driver.implicitlyWait(10);
			as=new Assertion(driver);
			traversaTest=new LeftMenuPage(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("执行测试test");
	}
	
	@Test
	public void traversaMenuCase() throws Exception{
		boolean flag = traversaTest.traversalMenu();
		as.assertEquals(flag, true, "traversaMenuError.png");
	}
	
	@AfterClass
	public void afterclass(){
		driver.quit();
	}



}
