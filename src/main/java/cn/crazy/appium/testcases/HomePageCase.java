package cn.crazy.appium.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import cn.crazy.appium.base.AndroidDriverBase;
import cn.crazy.appium.page.HomePage;
import cn.crazy.appium.page.LoginRegisterPage;
import cn.crazy.appium.testng.Assertion;
import cn.crazy.appium.util.GetByLocator;
import cn.crazy.appium.util.ProUtil;

public class HomePageCase extends CaseBaseTest{
	public AndroidDriverBase driver;
	public LoginRegisterPage loginTest;
	public HomePage homeTest;
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
			homeTest=new HomePage(driver);
			p=new ProUtil("configs/caps.properties");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("执行测试test");
	}
	
	
	
	/*		
	@Test(priority=0)
	public void titleTextCase() throws Exception{
		loginTest.loginUser("13510526236", "12345678");
		boolean flag = homeTest.titleText();
		as.assertEquals(flag, true, "标题栏显示小罗小区截图");
	}
	
	@Test(priority=1)
	public void messageCase() throws Exception{
		loginTest.loginUser("13510526236", "12345678");
		boolean flag = homeTest.message();
		as.assertEquals(flag, true, "消息验证（物业公告）截图");
	}
	@Test(priority=2)
	public void announcementCase() throws Exception{
		boolean flag = homeTest.announcement();
		as.assertEquals(flag, true, "首页banner点击验证图");
	}
	
	@Test(priority=3)
	public void homeBannerCase() throws Exception{
		boolean flag = homeTest.homeBanner();
		as.assertEquals(flag, true, "错误结果截图");
	}
	
	@Test(priority=4)
	public void homeAnnouncementCase() throws Exception{
		boolean flag = homeTest.homeAnnouncement();
		as.assertEquals(flag, true, "验证首页物业公告截图");
	}
	
	@Test(priority=5)
	public void lifeSerBannerCase() throws Exception{
		boolean flag = homeTest.lifeSerBanner();
		as.assertEquals(flag, true, "验证生活服务banner截图");
	}
	
	@Test(priority=6)
	public void lifeSerTypeCase() throws Exception{
		boolean flag = homeTest.lifeSerType();
		as.assertEquals(flag, true, "验证生活服务类型截图");
	}
	
	@Test(priority=7)
	public void lifeAddressCase() throws Exception{
		boolean flag = homeTest.lifeAddress();
		as.assertEquals(flag, true, "验证生活服务中修改地址截图");
	}
	
	@Test(priority=8)
	public void communityBusinessBannerCase() throws Exception{
		boolean flag = homeTest.communityBusinessBanner();
		as.assertEquals(flag, true, "验证社区商家banner截图");
	}
	@Test(priority=9)
	public void communityBusinessCase() throws Exception{
		boolean flag = homeTest.communityBusinessType();
		as.assertEquals(flag, true, "验证社区商家类型截图");
	}
	@Test(priority=10)
	public void communityBusinessRecommendCase() throws Exception{
		boolean flag = homeTest.communityBusinessRecommend();
		as.assertEquals(flag, true, "社区商家为您推荐截图");
	}
	@Test(priority=11)
	public void homeSalesCase() throws Exception{
		boolean flag = homeTest.homeSales();
		as.assertEquals(flag, true, "首页促销内容截图");
	}
	
	@Test(priority=12)
	public void homeMoreSalesCase() throws Exception{
		boolean flag = homeTest.homeMoreSales();
		as.assertEquals(flag, true, "首页更多促销截图");
	}
	
//	@Test(priority=13)
	public void homeMoreSalesPriceCase() throws Exception{
		boolean flag = homeTest.homeMoreSalesPrice();
		as.assertEquals(flag, true, "首页更多促销价格验证截图");
	}
	
	@Test(priority=14)
	public void homeHotGroupCase() throws Exception{
		boolean flag = homeTest.homeHotGroup();
		as.assertEquals(flag, true, "验证首页邻里群截图");
	}
	
	@Test(priority=15)
	public void homeMoreHotGroupCase() throws Exception{
		boolean flag = homeTest.homeMoreHotGroup();
		as.assertEquals(flag, true, "验证首页全部邻里群截图");
	}
		*/
	
	


	
//	@Test(priority=7)
//	public void lifeAddressCase() throws Exception{
//		boolean flag = homeTest.lifeAddress();
//		as.assertEquals(flag, true, "验证生活服务中修改地址截图");
//	}
//	
	//执行朋友圈点赞后取消点赞。
	@Test(priority=8)
	public void lifeAddressCase() throws Exception{
		boolean flag = homeTest.lifeAddress();
		as.assertEquals(flag, true, "验证生活服务中修改地址截图");
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
//		driver.quit();
	}
	

}
