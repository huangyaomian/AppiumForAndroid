package cn.crazy.appium.page;

import io.appium.java_client.android.AndroidElement;

import java.util.ArrayList;
import java.util.List;

import net.sf.saxon.expr.TreatExpression;

import org.apache.tools.ant.taskdefs.Sleep;
import org.openqa.selenium.By;

import com.sun.mail.handlers.text_html;

import cn.crazy.appium.base.AndroidDriverBase;
import cn.crazy.appium.util.GetByLocator;
import cn.crazy.appium.util.Log;
import cn.crazy.appium.util.MyImageUtil;
import cn.crazy.appium.util.ProUtil;
import cn.crazy.appium.util.RandomUtil;

public class communityActivityPage extends BasePage {
	private Log logger=Log.getLogger(HomePage.class);
	public communityActivityPage(AndroidDriverBase driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
    
	
    
    
	// 验证社区活动banner
		public boolean activityBanner() throws Exception {
			this.click(GetByLocator.getLocator("homeActivity"));
			boolean flag = true;
			Thread.sleep(4000);
			String titleText = driver.findElement(GetByLocator.getLocator("titleText")).getText();
			flag = "社区活动".equals(titleText);
			if (flag) {
				List<AndroidElement> list = new ArrayList<>();
				list = driver.findElements(GetByLocator.getLocator("smallRectangle"));
				System.out.println(list.size());
				if (!list.isEmpty()) {
					for (int i = 0; i < list.size(); i++) {
						this.click(list.get(i));
						Thread.sleep(1000);
						this.click(GetByLocator.getLocator("back"));
						Thread.sleep(4000);
						titleText = driver.findElement(GetByLocator.getLocator("titleText")).getText();
						flag = "社区活动".equals(titleText);
						if (!flag) {
							System.out.println("返回页面错误");
							return false;
						}
					}
				} else {
					this.click(GetByLocator.getLocator("annBannerImage"));
					this.click(GetByLocator.getLocator("back"));
					Thread.sleep(500);
					titleText = driver.findElement(GetByLocator.getLocator("titleText")).getText();
					flag = "社区活动".equals(titleText);
					if (!flag) {
						return false;
					}
				}
			} else {
				System.out.println("不是在社区活动页");
			}
			return flag;
		}
    
//	验证点击进入社区活动页面
	public boolean releaseActivity() throws Exception {
		this.click(GetByLocator.getLocator("homeActivity"));
		Thread.sleep(3000);
		String titleText = driver.findElement(GetByLocator.getLocator("titleText")).getText();
		if ("社区活动".equals(titleText)) {
			this.click(GetByLocator.getLocator("activityRelease"));
			Thread.sleep(2000);
			titleText = driver.findElement(GetByLocator.getLocator("titleText")).getText();
			if ("发布活动".equals(titleText)) {
				String activityTitleText = RandomUtil.getRndStrZhByLen(RandomUtil.getExtentRandomNumber(11)+1);
				String activityDescText = RandomUtil.getRndStrZhByLen(RandomUtil.getExtentRandomNumber(110)+1);
				this.replaceValue(GetByLocator.getLocator("activityTitleInput"),activityTitleText);
				this.replaceValue(GetByLocator.getLocator("activityDescInput"),activityDescText);
				this.click(GetByLocator.getLocator("choicePicture"));
				this.click(GetByLocator.getLocator("buttonAlbun"));
				List<AndroidElement> list = new ArrayList<>();
				list = driver.findElements(GetByLocator.getLocator("pictureCheck"));
				int num = RandomUtil.getExtentRandomNumber(8);
				for (int i = 0; i < num+1; i++) {
					this.click(list.get(i));
				}
				this.click(GetByLocator.getLocator("buttonOk"));
				this.click(GetByLocator.getLocator("choiceStartTime"));
				List<AndroidElement> timeList = new ArrayList<>();
				timeList = driver.findElements(GetByLocator.getLocator("timeInput"));
				this.setValue(timeList.get(0),"2018");
				this.setValue(timeList.get(1),"12");
				this.setValue(timeList.get(2),"10");
				this.setValue(timeList.get(3),"16");
				this.setValue(timeList.get(4),"15");
				Thread.sleep(500);
				this.setValue(timeList.get(5),"2018");
				this.setValue(timeList.get(6),"12");
				this.setValue(timeList.get(7),"21");
				this.setValue(timeList.get(8),"16");
				this.setValue(timeList.get(9),"17");
				this.setValue(timeList.get(9),"17");
				Thread.sleep(1000);
				this.click(GetByLocator.getLocator("timeSureBtn"));
				this.click(GetByLocator.getLocator("choiceEnrollTime"));
				timeList = driver.findElements(GetByLocator.getLocator("timeInput"));
				this.setValue(timeList.get(0),"2018");
				this.setValue(timeList.get(1),"11");
				this.setValue(timeList.get(2),"10");
				this.setValue(timeList.get(3),"10");
				this.setValue(timeList.get(4),"18");
				this.setValue(timeList.get(4),"18");
				this.click(GetByLocator.getLocator("timeSureBtn"));
				String choiceEnrollTimeText = driver.findElement(GetByLocator.getLocator("choiceEnrollTimeText")).getText();
				this.click(GetByLocator.getLocator("activityPlace"));
				this.click(GetByLocator.getLocator("butAllow"));
				this.replaceValue(GetByLocator.getLocator("activitySearchImput"),"世界之窗");
				this.click(GetByLocator.getLocator("activitySearchBtn"));
				Thread.sleep(2000);
				this.click(GetByLocator.getLocator("save"));
				String activityPlaceText = driver.findElement(GetByLocator.getLocator("activityPlaceText")).getText();
				this.click(GetByLocator.getLocator("activityNumber"));
				String activityNumberText = RandomUtil.getRndNumByLen(2);
				this.setValue(GetByLocator.getLocator("activityNumberInput"),activityNumberText);
				this.click(GetByLocator.getLocator("save"));
				Thread.sleep(1000);
				this.click(GetByLocator.getLocator("save"));
				Thread.sleep(3000);
				if (driver.findElement(GetByLocator.getLocator("activityTitleText")).getText().contains(activityTitleText)) {
					if (activityDescText.equals(driver.findElement(GetByLocator.getLocator("activityContentText")).getText())) {
						if (driver.findElement(GetByLocator.getLocator("activityStartTimeText"))==null) {
							driver.swipeOnElement(GetByLocator.getLocator("actImage"), "up", 500);
						}
						if ("2018-12-10 16:15 至 12-21 16:17".equals(driver.findElement(GetByLocator.getLocator("activityStartTimeText")).getText())) {
							if (choiceEnrollTimeText.contains(driver.findElement(GetByLocator.getLocator("activityEnrollTimeText")).getText())) {
								if (activityNumberText.equals(driver.findElement(GetByLocator.getLocator("activityNumberText")).getText())) {
									if (driver.findElement(GetByLocator.getLocator("activityListPlaceText"))==null) {
										driver.swipeOnElement(GetByLocator.getLocator("actImage"), "up", 500);
									}
									if (activityPlaceText.equals(driver.findElement(GetByLocator.getLocator("activityListPlaceText")).getText())) {
										return true;
									}else {
										System.out.println("地址不对应");
										return false;
									}
								}else {
									System.out.println("人数不对应");
									return false;
								}
							}else {
								System.out.println("报名截止时间不对应");
								return false;
							}
						}else {
							System.out.println("开始结束时间不对应");
							return false;
						}
					}else {
						System.out.println("详情不对应");
						return false;
					}
				}else {
					System.out.println("标题不对应");
					return false;
				}
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	public boolean deleteActivity() throws Exception {
		this.click(GetByLocator.getLocator("homeActivity"));
		Thread.sleep(2000);
		boolean flag = true;
		if (driver.swipeUntilElementAppear(GetByLocator.getLocator("activityDelByList"), "up", 1100, 20)) {
			String activityTitleText = driver.findElement(GetByLocator.getLocator("activityTitleText")).getText();
			this.click(GetByLocator.getLocator("activityDelByList"));
			this.click(GetByLocator.getLocator("confirmBtn"));
			Thread.sleep(2000);
			this.click(GetByLocator.getLocator("back"));
			this.click(GetByLocator.getLocator("homeActivity"));
			List<String> titleTextList = new ArrayList<String>(); 
			while (flag) {
				flag=false;
				List<AndroidElement> list = new ArrayList<>();
				list = driver.findElements(GetByLocator.getLocator("activityTitleText"));
				if (list.size()!=0) {
					for (int i = 0; i < list.size(); i++) {
						String titleText = list.get(i).getText();
						System.out.println(titleText);
						if (!titleTextList.contains(titleText)) {
							flag=true;
							titleTextList.add(titleText);
							if (activityTitleText.equals(titleText)){
								System.out.println("匹配到了相同的标题");
								return false;
							}
						}
					}
				}else {
					flag=true;
				}
				driver.swipeOnElement(GetByLocator.getLocator("activityList"), "up", 1100);
				Thread.sleep(2000);
			}
		}
		return true;
	}
	
	public boolean compareInfoForAct() throws Exception {
		ProUtil properties=new ProUtil("configs/element.properties");
		this.click(GetByLocator.getLocator("homeActivity"));
		Thread.sleep(2000);
		this.click(GetByLocator.getLocator("activityContentText"));
		
		int listSize = driver.findElements(GetByLocator.getLocator("actImage")).size();
		this.click(GetByLocator.getLocator("back"));
		Thread.sleep(2000);
//		列表中的元素
		AndroidElement element = driver.findElement(GetByLocator.getLocator("actuserImageByList"));
		driver.takeScreenForElement(element, properties.getPro("imagesPath"), "actuserImageByList");
		String actUserNameByList = driver.findElement(GetByLocator.getLocator("actUserNameByList")).getText();
		AndroidElement elementSex = driver.findElement(GetByLocator.getLocator("actSexImageByList"));
		driver.takeScreenForElement(elementSex, properties.getPro("imagesPath"), "actSexImageByList");
		String actLevelTextByList = driver.findElement(GetByLocator.getLocator("actLevelTextByList")).getText();
		String actTimeTextByList = driver.findElement(GetByLocator.getLocator("actTimeTextByList")).getText();
		String actStatusTextByList = driver.findElement(GetByLocator.getLocator("actStatusTextByList")).getText();
		String activityTitleText = driver.findElement(GetByLocator.getLocator("activityTitleText")).getText();
		String activityContentText = driver.findElement(GetByLocator.getLocator("activityContentText")).getText();
		if (listSize!=0) {
			List<AndroidElement> imgElements = new ArrayList<AndroidElement>();
			imgElements = driver.findElements(GetByLocator.getLocator("actImage"));
			for (int i = 0; i < listSize; i++) {
				driver.takeScreenForElement(imgElements.get(i), properties.getPro("imagesPath"), "actImage"+i);
			}
		}
		if (driver.findElement(GetByLocator.getLocator("activityStartTimeText"))==null) {
			driver.swipeOnElement(GetByLocator.getLocator("actImage"), "up", 500);
		}
		String activityStartTimeText = driver.findElement(GetByLocator.getLocator("activityStartTimeText")).getText();
		String activityEnrollTimeText = driver.findElement(GetByLocator.getLocator("activityEnrollTimeText")).getText();
		String activityNumberText = driver.findElement(GetByLocator.getLocator("activityNumberText")).getText();
		if (driver.findElement(GetByLocator.getLocator("activityListPlaceText"))==null) {
			driver.swipeOnElement(GetByLocator.getLocator("actImage"), "up", 500);
		}
		String activityListPlaceText = driver.findElement(GetByLocator.getLocator("activityListPlaceText")).getText();
		if (driver.findElement(GetByLocator.getLocator("actPraiseTextByList"))==null) {
			driver.swipeOnElement(GetByLocator.getLocator("actImage"), "up", 500);
		}
		String actPraiseTextByList = driver.findElement(GetByLocator.getLocator("actPraiseTextByList")).getText();
		String actPeopleTextByList = driver.findElement(GetByLocator.getLocator("actPeopleTextByList")).getText();
		this.click(GetByLocator.getLocator("actPeopleTextByList"));
		
		
		Thread.sleep(1000);
		
//		详情中的元素
		AndroidElement elementByDetail = driver.findElement(GetByLocator.getLocator("actUserImageByDetail"));
		driver.takeScreenForElement(elementByDetail, properties.getPro("imagesPath"), "actuserImageByList");
		if (!MyImageUtil.compareImage("images/"+"actuserImageByList.png", "images/"+"actuserImageByList.png")) {
			return false;
		}
		String actUserNameByDetail = driver.findElement(GetByLocator.getLocator("actUserNameByDetail")).getText();
		if (!actUserNameByDetail.equals(actUserNameByList)) {
			return false;
		}
		AndroidElement elementSexByDetail = driver.findElement(GetByLocator.getLocator("actSexImageByDetail"));
		driver.takeScreenForElement(elementSexByDetail, properties.getPro("imagesPath"), "actSexImageByDetail");
		if (!MyImageUtil.compareImage("images/"+"actSexImageByDetail.png", "images/"+"actSexImageByList.png")) {
			return false;
		}
		String actLevelTextByDetail = driver.findElement(GetByLocator.getLocator("actLevelTextByDetail")).getText();
		if (!actLevelTextByDetail.equals(actLevelTextByList)) {
			return false;
		}
		String actTimeTextByDetail = driver.findElement(GetByLocator.getLocator("actTimeTextByDetail")).getText();
		if (!actTimeTextByDetail.equals(actTimeTextByList)) {
			return false;
		}
		String actStatusTextByDetail = driver.findElement(GetByLocator.getLocator("actStatusTextByDetail")).getText();
		if (!actStatusTextByDetail.equals(actStatusTextByList)) {
			return false;
		}
		String activityTitleTextByDetail = driver.findElement(GetByLocator.getLocator("activityTitleTextByDetail")).getText();
		if (!activityTitleTextByDetail.equals(activityTitleText)) {
			return false;
		}
		String activityContentTextByDetail = driver.findElement(GetByLocator.getLocator("activityContentTextByDetail")).getText();
		if (!activityContentTextByDetail.equals(activityContentText)) {
			return false;
		}
		if (listSize!=0) {
			List<AndroidElement> imgElementsByDetail = new ArrayList<AndroidElement>();
			imgElementsByDetail = driver.findElements(GetByLocator.getLocator("actImage"));
			for (int i = 0; i < imgElementsByDetail.size(); i++) {
				driver.takeScreenForElement(imgElementsByDetail.get(i), properties.getPro("imagesPath"), "actImageByDetail"+i);
			}
			for (int i = 0; i < imgElementsByDetail.size(); i++) {
				if (!MyImageUtil.compareImage("images/"+"actImageByDetail"+i+".png", "images/"+"actImage"+i+".png")) {
					return false;
				}
			}
		}
		String activityStartTimeTextByDetail = driver.findElement(GetByLocator.getLocator("activityStartTimeTextByDetail")).getText();
		if (!activityStartTimeTextByDetail.equals(activityStartTimeText)) {
			return false;
		}
		String activityEnrollTimeTextByDetail = driver.findElement(GetByLocator.getLocator("activityEnrollTimeTextByDetail")).getText();
		if (!activityEnrollTimeTextByDetail.equals(activityEnrollTimeText)) {
			return false;
		}
		String activityNumberTextByDetail = driver.findElement(GetByLocator.getLocator("activityNumberTextByDetail")).getText().split("人")[0];
		if (!activityNumberTextByDetail.equals(activityNumberText)) {
			return false;
		}
		String activityPlaceTextByDetail = driver.findElement(GetByLocator.getLocator("activityPlaceTextByDetail")).getText();
		if (!activityPlaceTextByDetail.equals(activityListPlaceText)) {
			return false;
		}
		String actPraiseTextByDetail = driver.findElement(GetByLocator.getLocator("actPraiseTextByDetail")).getText();
		if (!actPraiseTextByDetail.equals(actPraiseTextByList)) {
			return false;
		}
		String actPeopleTextByDetail = driver.findElement(GetByLocator.getLocator("actPeopleTextByDetail")).getText();
		if (actPeopleTextByDetail.equals(actPeopleTextByList)) {
			this.click(GetByLocator.getLocator("actPeopleTextByDetail"));
			String titleTextNum = super.getNumForString(driver.findElement(GetByLocator.getLocator("titleText")).getText());
			if (titleTextNum.equals(actPeopleTextByDetail.split("人")[0])) {
				String num = driver.findElements(GetByLocator.getLocator("actListUserName")).size()+"";
				if (num.equals(titleTextNum)) {
					return true;
				}
			}
		}else {
			return false;
		}
		
		return false;
	}
	
	
	public boolean activityPraise() throws Exception {
		boolean flag = true;
		this.click(GetByLocator.getLocator("homeActivity"));
		Thread.sleep(2000);
		List<String> contentList = new ArrayList<>();
		while (flag) {
			flag = false;
			List<AndroidElement> contentElements = driver.findElements(GetByLocator.getLocator("activityContentText"));
			List<AndroidElement> praiseElements = driver.findElements(GetByLocator.getLocator("actPraiseTextByList"));
			List<AndroidElement> peopleElements = driver.findElements(GetByLocator.getLocator("actPeopleTextByList"));
			if (contentElements.size() != 0) {
				for (int i = 0; i < contentElements.size(); i++) {
					String contentText = contentElements.get(i).getText();
					if (!contentList.contains(contentText)) {
						flag=true;
						contentList.add(contentText);
					}
				}
				if (!flag) {
					break;
				}
			}
			for (int i = 0; i < praiseElements.size(); i++) {
				String praiseText = praiseElements.get(i).getText();
				int praiseNum = Integer.parseInt(praiseText.split("赞")[0]);
				System.out.println(praiseNum);
				if (praiseNum > 0 || praiseNum == 0) {
					this.click(praiseElements.get(i));
					Thread.sleep(1000);
					praiseText = praiseElements.get(i).getText();
					int praiseNum2 = Integer.parseInt(praiseText.split("赞")[0]);
					if (praiseNum > praiseNum2) {
						System.out.println("列表取消点赞成功");
					}else if (praiseNum < praiseNum2) {
						System.out.println("列表点赞成功");
					}else {
						System.out.println("点赞数量异常，退出程序");
						return false;
					}
					this.click(peopleElements.get(i));
					Thread.sleep(2000);
					if ("发布活动".equals(driver.findElement(GetByLocator.getLocator("titleText")).getText())) {
						this.click(GetByLocator.getLocator("back"));
						driver.swipeOnElement(GetByLocator.getLocator("actImage"), "up", 700);
						praiseElements = driver.findElements(GetByLocator.getLocator("actPraiseTextByList"));
						this.click(peopleElements.get(i));
						Thread.sleep(1000);
					}
					if (driver.findElement(GetByLocator.getLocator("actPraiseTextByDetail")).getText().equals(praiseText)) {
						int praiseNumByDetail1 = Integer.parseInt(driver.findElement(GetByLocator.getLocator("actPraiseTextByDetail")).getText().split("赞")[0]);
						this.click(GetByLocator.getLocator("actPraiseTextByDetail"));
						Thread.sleep(1000);
						String praiseTextByDetail = driver.findElement(GetByLocator.getLocator("actPraiseTextByDetail")).getText();
						int praiseNumByDetail2 = Integer.parseInt(praiseTextByDetail.split("赞")[0]);
						if (praiseNumByDetail1>praiseNumByDetail2) {
							System.out.println("详情取消点赞成功");
						}else if (praiseNumByDetail1<praiseNumByDetail2) {
							System.out.println("详情点赞成功");
						}else {
							System.out.println("点赞数量异常，退出程序");
							return false;
						}
						this.click(GetByLocator.getLocator("back"));
						if (!praiseElements.get(i).getText().equals(praiseTextByDetail)) {
							return false;
						}
					}else {
						return false;
					}
				}else {
					System.out.println("列表出现负数的点赞数");
					return false;
				}
			}
			driver.swipeOnElement(GetByLocator.getLocator("activityList"), "up", 1800);
			Thread.sleep(2000);
		}
		return true;
	}
	
	
//	验证参加取消活动、加入群聊并发送聊天信息
	public boolean activityJoinCancelSend() throws Exception {
		boolean flag = true;
		this.click(GetByLocator.getLocator("homeActivity"));
		Thread.sleep(2000);
		List<String> contentList = new ArrayList<>();
		while (flag) {
			flag = false;
			List<AndroidElement> contentElements = driver.findElements(GetByLocator.getLocator("activityContentText"));
			if (contentElements.size() != 0) {
				for (int i = 0; i < contentElements.size(); i++) {
					String contentText = contentElements.get(i).getText();
					if (!contentList.contains(contentText)) {
						flag=true;
						contentList.add(contentText);
						this.click(contentElements.get(i));
						Thread.sleep(2000);
						driver.swipeOnElement(GetByLocator.getLocator("activityDetailList"), "up", 1000);
						AndroidElement element = driver.findElement(GetByLocator.getLocator("activityJoinCancelDelBtn"));
						if (element.getAttribute("enabled").equals("true")) {
							if ("我要参加".equals(element.getText())) {
								if (driver.findElement(GetByLocator.getLocator("activityInChatBtn")).getAttribute("enabled").equals("false")) {
									this.click(element);
									this.click(GetByLocator.getLocator("confirmBtn"));
									Thread.sleep(2000);
									if ((driver.findElement(GetByLocator.getLocator("activityInChatBtn")).getAttribute("enabled").equals("true"))
											|| ("取消参加".equals(driver.findElement(GetByLocator.getLocator("activityJoinCancelDelBtn"))))) {
//										下面验证群聊功能能正常发送数据
										this.click(GetByLocator.getLocator("activityInChatBtn"));
										String text =  RandomUtil.getRndStrByLen(20);
										this.setValue(GetByLocator.getLocator("chatInputText"),text);
//										this.click(GetByLocator.getLocator("emoticonBtn"));
										this.click(GetByLocator.getLocator("sendBtn"));
										Thread.sleep(1000);
										List<AndroidElement> listElements = driver.findElements(GetByLocator.getLocator("messageText"));
										if (!text.equals(listElements.get(listElements.size()-1).getText())) {
											System.out.println("发送的内容对不上");
											return false;
										}else {
											this.click(GetByLocator.getLocator("back"));
											this.click(GetByLocator.getLocator("back"));
										}
									}else {
										System.out.println("参加完活动群聊按键应该为可点击 或参加活动文本显示不对");
										return false;
									}
								}else {
									System.out.println("进入群聊的安装状态不对，应为不可点击");
									return false;
								}
							}else if ("取消参加".equals(element.getText())) {
								if (driver.findElement(GetByLocator.getLocator("activityInChatBtn")).getAttribute("enabled").equals("true")) {
									this.click(element);
									this.click(GetByLocator.getLocator("confirmBtn"));
									Thread.sleep(1000);
									if (!(driver.findElement(GetByLocator.getLocator("activityInChatBtn")).getAttribute("enabled").equals("false")
											|| "我要参加".equals(driver.findElement(GetByLocator.getLocator("activityJoinCancelDelBtn")).getText()))) {
										System.out.println("参加完活动群聊按键应该为可点击 或参加活动文本显示不对");
										return false;
									}
									this.click(GetByLocator.getLocator("back"));
									Thread.sleep(2000);
								}else {
									System.out.println("取消参加活动时，群聊按键应该为可点击的");
								}
								
							}else {
								this.click(element);
								this.click(GetByLocator.getLocator("confirmBtn"));
								Thread.sleep(2000);
								if (!("社区活动".equals(driver.findElement(GetByLocator.getLocator("titleText")).getText()))) {
									return false;
								}
							}

						}else {
							this.click(GetByLocator.getLocator("back"));
							System.out.println("按键属性不可点击");
						}
					}
				}
			}
			driver.swipeOnElement(GetByLocator.getLocator("activityList"), "up", 1800);
			Thread.sleep(2000);
		}
		return true;
	}
	

}
