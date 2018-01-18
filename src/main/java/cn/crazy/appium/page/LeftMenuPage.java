package cn.crazy.appium.page;

import io.appium.java_client.android.AndroidElement;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import cn.crazy.appium.base.AndroidDriverBase;
import cn.crazy.appium.util.GetByLocator;

public class LeftMenuPage extends BasePage {

	public LeftMenuPage(AndroidDriverBase driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public AndroidElement getBooleButton() {
		AndroidElement booleButton=driver.findElement(GetByLocator.getLocator("booleButton"));
		return booleButton;
	}
	public AndroidElement getECGButton() {
		AndroidElement ECGButton=driver.findElement(GetByLocator.getLocator("ECGButton"));
		return ECGButton;
	}
	public AndroidElement getHGDataButton() {
		AndroidElement HGDataButton=driver.findElement(GetByLocator.getLocator("HGDataButton"));
		return HGDataButton;
	}
	public AndroidElement getBreathButton() {
		AndroidElement breathButton=driver.findElement(GetByLocator.getLocator("breathButton"));
		return breathButton;
	}
	public AndroidElement getStepButton() {
		AndroidElement stepButton=driver.findElement(GetByLocator.getLocator("stepButton"));
		return stepButton;
	}
	public AndroidElement getSleepButton() {
		AndroidElement sleepButton=driver.findElement(GetByLocator.getLocator("sleepButton"));
		return sleepButton;
	}
	public AndroidElement getDeviceButton() {
		AndroidElement deviceButton=driver.findElement(GetByLocator.getLocator("deviceButton"));
		return deviceButton;
	}
	public AndroidElement getProblemButton() {
		AndroidElement problemButton=driver.findElement(GetByLocator.getLocator("problemButton"));
		return problemButton;
	}
	public AndroidElement getTitleText() {
		AndroidElement titleText=driver.findElement(GetByLocator.getLocator("titleText"));
		return titleText;
	}
	public AndroidElement getBackButton() {
		AndroidElement backButton=driver.findElement(GetByLocator.getLocator("backButton"));
		return backButton;
	}
	
	public AndroidElement booleButton;       //name>血　　压
	public AndroidElement ECGButton;         //=name>心电监测
	public AndroidElement HGDataButton;      //=name>心率数据
	public AndroidElement breathButton;      //=name>呼吸训练
	public AndroidElement stepButton;        //=name>运动记步
	public AndroidElement sleepButton;       //=name>睡　　眠
	public AndroidElement deviceButton;      //=name>设　　备
	public AndroidElement problemButton;     //=name>常见问题
	public AndroidElement titleText;         //=id>com.createbest.app.a16.flyband:id/tv_title
	public AndroidElement backButton;
	
	boolean flag = false;
	
	public boolean traversalMenu() throws Exception{
		
		
		List<String> oldList = new ArrayList<>();
		List<String> getList = new ArrayList<>();
		LoginRegisterPage loginPage1 = new LoginRegisterPage(driver);
		loginPage1.login("13510526236", "1234567");
		this.click(GetByLocator.getLocator("scanBackButton"));
		this.click(GetByLocator.getLocator("homePageMenu"));
		
		oldList.add(getBooleButton().getText().replaceAll("\u3000", ""));
		this.click(getBooleButton());
		Thread.sleep(1000);
		getList.add(getTitleText().getText());
		this.click(getBackButton());
		Thread.sleep(1000);
		
		oldList.add(getECGButton().getText());
		this.click(getECGButton());
		Thread.sleep(1000);
		getList.add(getTitleText().getText());
		this.click(getBackButton());
		Thread.sleep(1000);
		
		oldList.add(getHGDataButton().getText());
		this.click(getHGDataButton());
		Thread.sleep(1000);
		getList.add(getTitleText().getText());
		this.click(getBackButton());
		Thread.sleep(1000);
		
		oldList.add(getBreathButton().getText());
		this.click(getBreathButton());
		Thread.sleep(1000);
		getList.add(getTitleText().getText());
		this.click(getBackButton());
		Thread.sleep(1000);
		
		oldList.add(getStepButton().getText());
		this.click(getStepButton());
		Thread.sleep(1000);
		getList.add(getTitleText().getText());
		this.click(getBackButton());
		Thread.sleep(1000);
		
		oldList.add(getSleepButton().getText().replaceAll("\u3000", ""));
		this.click(getSleepButton());
		Thread.sleep(1000);
		getList.add(getTitleText().getText());
		this.click(getBackButton());
		Thread.sleep(1000);
		
		oldList.add(getDeviceButton().getText().replaceAll("\u3000", ""));
		this.click(getDeviceButton());
		Thread.sleep(1000);
		getList.add(getTitleText().getText());
		this.click(getBackButton());
		Thread.sleep(1000);
		
		oldList.add(getProblemButton().getText());
		this.click(getProblemButton());
		Thread.sleep(1000);
		getList.add(getTitleText().getText());
//		this.click(getBackButton());
		if (oldList.size()==getList.size()) {
			for (int i = 0; i < oldList.size(); i++) {
				System.out.println(oldList.get(i)+"======="+getList.get(i));
				if (oldList.get(i).equals(getList.get(i))){		
					flag=true;
				}else {
					flag=false;
					break;
				}
			}
			return flag;
		}else{
			return false;
		}
		
	}
	
	public boolean getToast() throws Exception{
		LoginRegisterPage loginPage1 = new LoginRegisterPage(driver);
		loginPage1.login("13510526236", "1234567");
		this.click(GetByLocator.getLocator("scanBackButton"));
		Thread.sleep(10000);
		this.click(GetByLocator.getLocator("homePageMenu"));
		this.click(getDeviceButton());
		driver.findElement(By.id("com.createbest.app.a16.flyband:id/screen_set_spinner")).click();
		driver.findElement(By.name("横屏")).click();
		return driver.isToast("设备未连接");
		
	}



}
