package cn.crazy.appium.page;

import java.util.ArrayList;
import java.util.List;

import cn.crazy.appium.base.AndroidDriverBase;
import cn.crazy.appium.base.SwipeScreen;
import cn.crazy.appium.util.GetByLocator;
import cn.crazy.appium.util.RandomUtil;

public class PerInfoPage extends BasePage{

	public PerInfoPage(AndroidDriverBase driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public boolean changePersonInfo() throws Exception{
		boolean flag=false;
		LoginRegisterPage loginPage1=new LoginRegisterPage(driver);
		List<String> oldInfoList=new ArrayList<>();
		List<String> newInfoList=new ArrayList<>();
		loginPage1.login("13510526236", "1234567");
		this.click(GetByLocator.getLocator("scanBackButton"));
		this.click(GetByLocator.getLocator("homePageMenu"));
		this.click(GetByLocator.getLocator("userIcon"));
		this.click(GetByLocator.getLocator("mePagePerInfo"));
		String name=RandomUtil.getRndStrZhByLen(3);
		this.sendkeys(GetByLocator.getLocator("userName"), name);
		oldInfoList.add(driver.findElement(GetByLocator.getLocator("userName")).getText());
		String Sex=driver.findElement(GetByLocator.getLocator("userSex")).getText();
		this.click(GetByLocator.getLocator("userSex"));
		if(Sex.equals("男")){
			this.click(GetByLocator.getLocator("choiseSexWoman"));
		}else{
			this.click(GetByLocator.getLocator("choiseSexMan"));
		}
		oldInfoList.add(driver.findElement(GetByLocator.getLocator("userSex")).getText());
		this.click(GetByLocator.getLocator("userBirthday"));
		this.click(GetByLocator.getLocator("birthdayYear"));
//		driver.swipeOnElement(GetByLocator.getLocator("yearList"), "UP", 500);
		this.click(GetByLocator.getLocator("choiseBirthdayYear"));
		this.click(GetByLocator.getLocator("finishButton"));
		oldInfoList.add(driver.findElement(GetByLocator.getLocator("userBirthday")).getText());
		this.click(GetByLocator.getLocator("userHeight"));
//		driver.swipeOnElement(GetByLocator.getLocator("choiseHeightOrWeight"), "UP", 500);
		click(GetByLocator.getLocator("sureButton"));
		oldInfoList.add((driver.findElement(GetByLocator.getLocator("userHeight")).getText()).split("c")[0]);
		System.out.println((driver.findElement(GetByLocator.getLocator("userHeight")).getText()).split("c")[0]);
		this.click(GetByLocator.getLocator("userWeight"));
//		driver.swipeOnElement(GetByLocator.getLocator("choiseHeightOrWeight"), "UP", 500);
		click(GetByLocator.getLocator("sureButton"));
		oldInfoList.add((driver.findElement(GetByLocator.getLocator("userWeight")).getText()).split("k")[0]);
		System.out.println(driver.findElement(GetByLocator.getLocator("userWeight")).getText().split("k")[0]);
		this.click(GetByLocator.getLocator("userFocous"));
		String Focous=RandomUtil.getRndNumByLen(5);
		this.sendkeys(GetByLocator.getLocator("inputFocous"), Focous);
		click(GetByLocator.getLocator("sureButton"));
		oldInfoList.add(driver.findElement(GetByLocator.getLocator("userFocous")).getText());
		click(GetByLocator.getLocator("finishButton"));
		Thread.sleep(2000);
		this.click(GetByLocator.getLocator("mePagePerInfo"));
		newInfoList.add(driver.findElement(GetByLocator.getLocator("userName")).getText());
		System.out.println(driver.findElement(GetByLocator.getLocator("userName")).getText());
		newInfoList.add(driver.findElement(GetByLocator.getLocator("userSex")).getText());
		newInfoList.add((driver.findElement(GetByLocator.getLocator("userBirthday")).getText()));
		newInfoList.add(driver.findElement(GetByLocator.getLocator("userHeight")).getText().split("\\.")[0]);
		newInfoList.add(driver.findElement(GetByLocator.getLocator("userWeight")).getText().split("\\.")[0]);
		newInfoList.add(driver.findElement(GetByLocator.getLocator("userFocous")).getText());
		if(oldInfoList.size()==newInfoList.size()){
			for (int i = 0; i < oldInfoList.size(); i++) {
				if(oldInfoList.get(i).equals(newInfoList.get(i))){
					System.out.println(oldInfoList.size());
					System.out.println(oldInfoList.get(i)+"...."+newInfoList.get(i));
					flag=true;
				}else{
					flag=false;
					break;
				}		
			}
			return flag;
		}else {
			System.out.println("两个集合大小不一致");
			return false;
		}
	}

}
