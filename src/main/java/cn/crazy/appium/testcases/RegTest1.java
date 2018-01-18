package cn.crazy.appium.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import cn.crazy.appium.base.AndroidDriverBase;
import cn.crazy.appium.page.RegPage;
import cn.crazy.appium.testng.Assertion;

public class RegTest1 extends CaseBaseTest{
	public AndroidDriverBase driver;
	public RegPage regTest;
	Assertion as=new Assertion(driver);
	
	@BeforeClass
	public void iniDirver(){	
	    this.driver = super.driver;
	  }

	@Test
	public void regCase() throws Exception{
		System.out.println("====================="+this.driver);	
		regTest = new RegPage(driver);
		boolean flag = regTest.regTestCase();
		as.verifyEquals(flag, true, "修改个人信息结果");
	}

}
