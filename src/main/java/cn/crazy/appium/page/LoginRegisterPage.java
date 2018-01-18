package cn.crazy.appium.page;

import java.util.ArrayList;
import java.util.List;


import io.appium.java_client.android.AndroidElement;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import cn.crazy.appium.base.AndroidDriverBase;
import cn.crazy.appium.base.CrazyPath;
import cn.crazy.appium.connectionofpost.ConnectionHttp;
import cn.crazy.appium.util.GetByLocator;
import cn.crazy.appium.util.Log;
import cn.crazy.appium.util.ProUtil;
import cn.crazy.appium.util.RandomUtil;

public class LoginRegisterPage extends BasePage {
	private Log logger=Log.getLogger(LoginRegisterPage.class);
	private static ProUtil  p = new ProUtil(CrazyPath.elementPath);
	public AndroidElement inputName;
	public LoginRegisterPage(AndroidDriverBase driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public AndroidElement getInputName() {
		AndroidElement inputName=driver.findElement(GetByLocator.getLocator("inputName"));
		return inputName;
	}
	
	public AndroidElement getCommunityInputSearch() {
		AndroidElement communityInputSearch=driver.findElement(GetByLocator.getLocator("communityInputSearch"));
		return communityInputSearch;
	}


	//登录账号用
	public void loginUser(String username,String pwd) throws Exception {
		this.login(username, pwd);
		this.click(GetByLocator.getLocator("imgClose"));
		Thread.sleep(1000);
		try {
			this.click(GetByLocator.getLocator("nextTime"));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("没有出现下次再说");
		}
	}
	
	
	//登录测试
	public HomePage login(String username,String pwd) throws Exception{
		this.click(GetByLocator.getLocator("butAllow"));
		this.click(GetByLocator.getLocator("splash"));
		driver.swipeUntilElementAppear(GetByLocator.getLocator("startUse"), "left", 1000 , 5);
		this.click(GetByLocator.getLocator("startUse"));
		this.setValue(GetByLocator.getLocator("inputUsername"), username);
		this.click(GetByLocator.getLocator("smallEyes"));
		this.setValue(GetByLocator.getLocator("inputPassword"), pwd);
		this.click(GetByLocator.getLocator("loginButton"));
		return new HomePage(driver);
	}
	
	//忘记密码
	public HomePage forgetpwd(String username , String pwd1 , String pwd2 ,String codestring) throws Exception {
//		this.click(GetByLocator.getLocator("butAllow"));
		this.click(GetByLocator.getLocator("splash"));
		driver.swipeUntilElementAppear(GetByLocator.getLocator("startUse"), "left", 1000 , 5);
		this.click(GetByLocator.getLocator("startUse"));
		this.click(GetByLocator.getLocator("forgetPasswordButton"));
		if(codestring.equals("code")){
			Object ob;
			for (int i = 0; i < 2; i++) {
				try {
					ob = ConnectionHttp.getPostValuseString(p.getPro("postPath")+"/uc_r2/user/getCheckCode?version=1.01&recNum="+username+"&cat=modpasswd&terminal=ios","object");
					JSONObject jsonObj = JSONObject.fromObject(ob);
					codestring = jsonObj.get("code").toString();
					i=4;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("请求验证码失败，自动等待2分钟后重新请求");
					Thread.sleep(120000);
					e.printStackTrace();
				}
			}
		}
		this.sendkeys(GetByLocator.getLocator("inputUsername"), username);
		this.sendkeys(GetByLocator.getLocator("inputCode"), codestring);
		this.click(GetByLocator.getLocator("smallEyes"));
		this.sendkeys(GetByLocator.getLocator("inputPassword"), pwd1);
		this.click(GetByLocator.getLocator("smallEyesAgain"));
		this.sendkeys(GetByLocator.getLocator("inputPwdAgain"), pwd2);
		this.click(GetByLocator.getLocator("complete"));		
		return new HomePage(driver);
	}
	//注册
	public HomePage reg(String username , String pwd1 , String pwd2 ,String codestring ,String toast) throws Exception{
//		this.click(GetByLocator.getLocator("butAllow"));
		this.click(GetByLocator.getLocator("splash"));
		driver.swipeUntilElementAppear(GetByLocator.getLocator("startUse"), "left", 1000 , 5);
//		p = new ProUtil(CrazyPath.elementPath);
		this.click(GetByLocator.getLocator("startUse"));
		this.click(GetByLocator.getLocator("regNewUser"));
		if (codestring != null) {
			if("code".equals(codestring)){
				Object ob;
				username="135"+RandomUtil.getRndNumByLen(8);
//				username="13510526232";
				for (int i = 0; i < 2; i++) {
					try {
						ob = ConnectionHttp.getPostValuseString(p.getPro("postPath")+"/uc_r2/user/getCheckCode?version=1.01&recNum="+username+"&cat=register&terminal=android","object");
						JSONObject jsonObj = JSONObject.fromObject(ob);
						codestring = jsonObj.get("code").toString();
						i=4;
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("请求验证码失败，自动等待2分钟后重新请求");
						Thread.sleep(120000);
					}
				}
			}
		}
		System.out.println("codestring:"+codestring);
		this.setValue(GetByLocator.getLocator("inputUsername"), username);
		this.setValue(GetByLocator.getLocator("inputCode"), codestring);
		this.click(GetByLocator.getLocator("smallEyes"));
		this.setValue(GetByLocator.getLocator("inputPassword"), pwd1);
		this.click(GetByLocator.getLocator("regSmallEyes"));
		this.setValue(GetByLocator.getLocator("regInputPwdAgain"), pwd2);
		this.click(GetByLocator.getLocator("next"));
		System.out.println(username+","+pwd1+","+toast);
		if("没有toast".equals(toast)){
			this.click(GetByLocator.getLocator("titleText"));
			for (int i = 0; i < 4; i++) {
				driver.swipeOnElement(driver.findElement(GetByLocator.getLocator("chooseBox")), "up", 2000);
				if(driver.getPageSouce().contains("广东省")){
					this.click(GetByLocator.getLocator("chooseProvince"));
					i=6;
				}else{
					System.out.println("没有滑动到对应的省");
				}
			}
			for (int i = 0; i < 4; i++) {
				driver.swipeOnElement(driver.findElement(GetByLocator.getLocator("chooseBox")), "down", 2000);
				if(driver.getPageSouce().contains("深圳市")){
					this.click(GetByLocator.getLocator("chooseCity"));
					i=6;
				}else{
					System.out.println("没有滑动到对应的城市");
				}
			}
			for (int i = 0; i < 4; i++) {
				if(driver.getPageSouce().contains("罗湖区")){
					this.click(GetByLocator.getLocator("chooseArea"));
					i=6;
				}else{
					driver.swipeOnElement(driver.findElement(GetByLocator.getLocator("chooseBox")), "up", 2000);
					System.out.println("没有滑动到对应的区");
				}
			}
//			for (int i = 0; i < 4; i++) {
//				if(driver.getPageSouce().contains("小罗小区")){
//					this.click(GetByLocator.getLocator("chooseCommunity"));
//					i=6;
//				}else{
//					driver.swipeOnElement(driver.findElement(GetByLocator.getLocator("chooseBox")), "up", 2000);
//					System.out.println("没有滑动到对应的社区");
//				}
//			}
			driver.swipe("up", 1000);
//			this.click(getCommunityInputSearch());
//			this.setValue(getCommunityInputSearch(),"小罗小区");
			List<AndroidElement> list = new ArrayList<AndroidElement>();
			list = driver.findElements(GetByLocator.getLocator("communitySearch"));
			if (list!=null) {
				for (int i = 0; i < list.size(); i++) {
					if ("小罗小区".equals(list.get(i).getText())) {
						this.click(list.get(i));
					}
				}
			}
			this.click(GetByLocator.getLocator("btnNext"));
			this.click(getInputName());
			this.setValue(getInputName(),RandomUtil.getRndStrByLen(5));
			this.click(GetByLocator.getLocator("chooseHead"));
			this.click(GetByLocator.getLocator("buttonAlbun"));
			this.click(GetByLocator.getLocator("buttonThumb"));
			this.click(GetByLocator.getLocator("buttonOk"));
			this.click(GetByLocator.getLocator("buttonReg"));
			Thread.sleep(1000);
			this.click(GetByLocator.getLocator("imgClose"));
		}
		return new HomePage(driver);
	}
	
	
	
	//点击关闭启动页广告和弹窗广告
	public void closeImg() throws Exception {
		this.click(GetByLocator.getLocator("splash"));
		Thread.sleep(2500);
		this.click(GetByLocator.getLocator("imgClose"));
	}
	

}
