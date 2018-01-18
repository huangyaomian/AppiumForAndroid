package cn.crazy.appium.page;

import cn.crazy.appium.base.AndroidDriverBase;
import cn.crazy.appium.base.SwipeScreen;
import cn.crazy.appium.util.GetByLocator;

public class RegPage extends BasePage{
	public RegPage(AndroidDriverBase driver) {
//		this.driver=driver;
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public boolean  regTestCase() throws Exception {
		Thread.sleep(3000);
		SwipeScreen huadong = new SwipeScreen(driver);
		
		for (int i = 0; i < 3; i++) {
			huadong.swipe("left", 1000);
			Thread.sleep(800);
		}
		this.click(GetByLocator.getLocator("startUse"));
		this.click(GetByLocator.getLocator("regNewUser"));
		return (driver.getPageSource().contains("注册"));
		
	}

	

}
