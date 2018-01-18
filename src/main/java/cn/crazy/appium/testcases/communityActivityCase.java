package cn.crazy.appium.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import cn.crazy.appium.base.AndroidDriverBase;
import cn.crazy.appium.page.LoginRegisterPage;
import cn.crazy.appium.page.communityActivityPage;
import cn.crazy.appium.testng.Assertion;
import cn.crazy.appium.util.GetByLocator;
import cn.crazy.appium.util.ProUtil;

public class communityActivityCase extends CaseBaseTest {
	public AndroidDriverBase driver;
	public LoginRegisterPage loginTest;
	public communityActivityPage communityActivityText;
	public Assertion as;
	public ProUtil p;
	
	@BeforeClass
	@Parameters({ "udid", "port" })
	public void beforeClass(String udid, String port) {
		try {
			System.out.println("读到的udid是："+udid+"读到的port是："+port);
			driver=driverInit(udid, port);
			driver.implicitlyWait(10);
//			driver = LoginRegisterCase.driver;
			as=new Assertion(driver);
			loginTest=new LoginRegisterPage(driver);
			communityActivityText  = new communityActivityPage(driver);
			p=new ProUtil("configs/caps.properties");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("执行测试test");
	}
	
//	@Test(priority=0)
	public void activityBannerCase() throws Exception{
		loginTest.loginUser("13510526235", "12345678");
		boolean flag = communityActivityText.activityBanner();
		as.assertEquals(flag, true, "验证社区活动banner");
	}
	
//	@Test(priority=1)
	public void releaseActivityCase() throws Exception{
//		loginTest.loginUser("13510526235", "12345678");
//		for (int i = 0; i < 20; i++) {
//			communityActivityText.releaseActivity();
//		}
		boolean flag = communityActivityText.releaseActivity();
		as.assertEquals(flag, true, "验证发布活动");
	}
	
//	@Test(priority=2)
	public void deleteActivityCase() throws Exception{
		loginTest.loginUser("13510526235", "12345678");
		boolean flag = communityActivityText.deleteActivity();
		as.assertEquals(flag, true, "验证删除活动");
	}
	
//	@Test(priority=3)
	public void compareInfoForActCase() throws Exception{
		loginTest.loginUser("13510526235", "12345678");
		boolean flag = communityActivityText.compareInfoForAct();
		as.assertEquals(flag, true, "验证活动列表跟活动详情内容一致");
	}
	
	
	@Test(priority=4)
	public void activityPraiseCase() throws Exception{
		loginTest.loginUser("13510526235", "12345678");
		boolean flag = communityActivityText.activityPraise();
		as.assertEquals(flag, true, "验证活动列表跟活动详情点赞");
	}
	
	
//	@Test(priority=5)
	public void activityJoinCancelSendCase() throws Exception{
		loginTest.loginUser("13510526235", "12345678");
		boolean flag = communityActivityText.activityJoinCancelSend();
		as.assertEquals(flag, true, "验证参加取消活动、加入群聊并发送聊天信息");
	}
	
	
	
	
	
	@AfterMethod
	public void afterMethod(){
//		driver.resetApp();
//		ProUtil p=new ProUtil("configs/caps.properties");
		driver.startActivity("com.hx.socialapp","com.hx.socialapp.MainActivity");
		try {
			Thread.sleep(2500);
			driver.findElement(GetByLocator.getLocator("imgClose")).click();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("没有找到弹窗广告关闭按钮");
		}
		
	}
	@AfterSuite
	public void quit(){
		driver.quit();
	}


}
