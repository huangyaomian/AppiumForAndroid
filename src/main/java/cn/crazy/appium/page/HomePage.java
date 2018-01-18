package cn.crazy.appium.page;

import io.appium.java_client.android.AndroidElement;

import java.util.ArrayList;
import java.util.List;

import cn.crazy.appium.base.AndroidDriverBase;
import cn.crazy.appium.util.GetByLocator;
import cn.crazy.appium.util.Log;
import cn.crazy.appium.util.RandomUtil;

//import cn.crazy.appium.base.AndroidElementBase;

public class HomePage extends BasePage {
	private Log logger = Log.getLogger(HomePage.class);
	private String community;

	public HomePage(AndroidDriverBase driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// 标题栏显示小罗小区
	public boolean titleText() throws Exception {
		boolean flag = true;
		community = driver.findElement(GetByLocator.getLocator("titleText")).getText();
		String community1 = driver.findElement(GetByLocator.getLocator("rbHomeText")).getText();
		flag = community1.equals(community);
		return flag;
	}

	// 消息验证（物业公告）
	public boolean message() throws Exception {
		this.click(GetByLocator.getLocator("message"));
		boolean flag = true;
		Thread.sleep(1000);
		String titleText = driver.findElement(GetByLocator.getLocator("titleText")).getText();
		flag = "物业公告".equals(titleText);
		if (flag) {
			List<AndroidElement> list = new ArrayList<>();
			Thread.sleep(4000);
			list = driver.findElements(GetByLocator.getLocator("smallRectangle"));
			System.out.println(list.size());
			if (!list.isEmpty()) {
				for (int i = 0; i < list.size(); i++) {
					this.click(list.get(i));
					this.click(GetByLocator.getLocator("back"));
					Thread.sleep(4000);
					titleText = driver.findElement(GetByLocator.getLocator("titleText")).getText();
					flag = "物业公告".equals(titleText);
					if (!flag) {
						return false;
					}
				}
			} else {
				this.click(GetByLocator.getLocator("annBannerImage"));
				this.click(GetByLocator.getLocator("back"));
				Thread.sleep(500);
				titleText = driver.findElement(GetByLocator.getLocator("titleText")).getText();
				flag = "物业公告".equals(titleText);
				if (!flag) {
					return false;
				}
			}
		}
		return flag;
	}

	// 物业公告中的公告消息和二级物业广告验证
	public boolean announcement() throws Exception {
		this.click(GetByLocator.getLocator("message"));
		boolean flag = true;
		Thread.sleep(1000);
		String titleText = driver.findElement(GetByLocator.getLocator("titleText")).getText();
		flag = "物业公告".equals(titleText);
		if (flag) {
			List<AndroidElement> list = new ArrayList<>();
			list = driver.findElements(GetByLocator.getLocator("announcementTitle"));
			System.out.println(list.size());
			if (!list.isEmpty()) {
				for (int i = 0; i < list.size(); i++) {
					String titleText2 = list.get(i).getText();
					this.click(list.get(i));
					Thread.sleep(1500);
					String titleText3 = driver.findElement(GetByLocator.getLocator("titleText")).getText();
					flag = titleText2.equals(titleText3);
					System.out.println(titleText2 + titleText3);
					if (!flag) {
						return false;
					}

					List<AndroidElement> list1 = new ArrayList<>();
					Thread.sleep(4000);
					list1 = driver.findElements(GetByLocator.getLocator("smallRectangle"));
					System.out.println(list1.size());
					if (!list1.isEmpty()) {
						for (int j = 0; j < list1.size(); j++) {
							this.click(list1.get(j));
							this.click(GetByLocator.getLocator("back"));
							Thread.sleep(4000);
							titleText = driver.findElement(GetByLocator.getLocator("titleText")).getText();
							flag = titleText2.equals(titleText);
							if (!flag) {
								return false;
							}
						}
						this.click(GetByLocator.getLocator("back"));
						Thread.sleep(500);
						titleText = driver.findElement(GetByLocator.getLocator("titleText")).getText();
						// System.out.println(list.get(i).getText()+titleText);
						flag = "物业公告".equals(titleText);
						if (!flag) {
							return false;
						}
					} else {
						this.click(GetByLocator.getLocator("annBannerImage"));
						this.click(GetByLocator.getLocator("back"));
						this.click(GetByLocator.getLocator("back"));
						Thread.sleep(500);
						titleText = driver.findElement(GetByLocator.getLocator("titleText")).getText();
						flag = "物业公告".equals(titleText);
						if (!flag) {
							return false;
						}
					}
				}
			}
		} else if (driver.isElementExist(GetByLocator.getLocator("noAnnouncement"))) {
			return true;
		}
		return flag;
	}

	// 首页banner点击验证
	public boolean homeBanner() throws Exception {
		boolean flag = true;
		Thread.sleep(4000);
		community = driver.findElement(GetByLocator.getLocator("titleText")).getText();
		String titleText = driver.findElement(GetByLocator.getLocator("titleText")).getText();
		flag = community.equals(titleText);
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
					flag = community.equals(titleText);
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
				flag = community.equals(titleText);
				if (!flag) {
					return false;
				}
			}
		} else {
			System.out.println("不是在首页");
		}
		return flag;
	}

	// 验证首页物业公告
	public boolean homeAnnouncement() throws Exception {
		this.click(GetByLocator.getLocator("homeAnnouncement"));
		boolean flag = true;
		Thread.sleep(1000);
		String titleText = driver.findElement(GetByLocator.getLocator("titleText")).getText();
		flag = "物业公告".equals(titleText);
		if (flag) {
			List<AndroidElement> list = new ArrayList<>();
			Thread.sleep(4000);
			list = driver.findElements(GetByLocator.getLocator("smallRectangle"));
			System.out.println(list.size());
			if (!list.isEmpty()) {
				for (int i = 0; i < list.size(); i++) {
					this.click(list.get(i));
					this.click(GetByLocator.getLocator("back"));
					// driver.swipeOnElement(driver.findElements(GetByLocator.getLocator("bannerImage")).get(1),
					// "left", 1000);
					Thread.sleep(4000);
					titleText = driver.findElement(GetByLocator.getLocator("titleText")).getText();
					flag = "物业公告".equals(titleText);
					if (!flag) {
						return false;
					}
				}
			} else {
				this.click(GetByLocator.getLocator("annBannerImage"));
				this.click(GetByLocator.getLocator("back"));
				Thread.sleep(500);
				titleText = driver.findElement(GetByLocator.getLocator("titleText")).getText();
				flag = "物业公告".equals(titleText);
				if (!flag) {
					return false;
				}
			}
		}
		return flag;
	}

	// 验证生活服务banner
	public boolean lifeSerBanner() throws Exception {
		this.click(GetByLocator.getLocator("homeLifeSer"));
		boolean flag = true;
		Thread.sleep(4000);
		String titleText = driver.findElement(GetByLocator.getLocator("titleText")).getText();
		flag = "生活服务".equals(titleText);
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
					flag = "生活服务".equals(titleText);
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
				flag = "生活服务".equals(titleText);
				if (!flag) {
					return false;
				}
			}
		} else {
			System.out.println("不是在生活服务");
		}
		return flag;
	}

	// 验证生活服务类型
	public boolean lifeSerType() throws Exception {
		this.click(GetByLocator.getLocator("homeLifeSer"));
		boolean flag = true;
		Thread.sleep(1000);
		String titleText = driver.findElement(GetByLocator.getLocator("titleText")).getText();
		flag = "生活服务".equals(titleText);
		if (flag) {
			List<String> listText = new ArrayList<>();
			int flag1 = 1;
			while (flag1 != 0) {
				flag1 = 0;
				List<AndroidElement> list = new ArrayList<>();
				list = driver.findElements(GetByLocator.getLocator("commodityTpyeBtn"));
				for (int i = 0; i < list.size(); i++) {
					AndroidElement an = list.get(i);
					String text = an.getText();
					if (!listText.contains(text)) {
						listText.add(text);
						System.out.println(listText);
						this.click(an);
						// 遍历生活服务店铺
						if (driver.isElementExist(GetByLocator.getLocator("serviceName"), 2)) {
							List<String> listName = new ArrayList<>();
							int flag2 = 1;
							while (flag2 != 0) {
								flag2 = 0;
								List<AndroidElement> listNameEl = new ArrayList<>();
								listNameEl = driver.findElements(GetByLocator.getLocator("serviceName"));
								for (int j = 0; j < listNameEl.size(); j++) {
									AndroidElement el = listNameEl.get(j);
									String nameText = el.getText();
									if (!listName.contains(nameText)) {
										listName.add(nameText);
										System.out.println(nameText);
										this.click(el);
										Thread.sleep(2000);
										if (!nameText.isEmpty()) {
											if (!nameText.equals(driver.findElement(GetByLocator.getLocator("titleText")).getText())) {
												System.out.println("点进去的服务项目标题不对");
												return false;
											}
											this.click(GetByLocator.getLocator("back"));
											flag2++;
											Thread.sleep(2000);
										}
									}
								}
								driver.swipeOnElement(driver.findElement(GetByLocator.getLocator("serviceList")), "up", 3000);
							}
							driver.swipeUntilElementAppear(GetByLocator.getLocator("commodityTpyeBtn"), "down", 1000, 10);
						} else if (driver.isElementExist(GetByLocator.getLocator("noLifeService"), 2)) {
							System.out.println("没有服务店铺不点击");
						} else {
							return false;
						}
						flag1++;
					}
				}
				driver.swipeOnElement(driver.findElement(GetByLocator.getLocator("serTypeLayout")), "left", 1000);
			}
		}
		return flag;
	}

	// 验证生活服务中修改地址
	public boolean lifeAddress() throws Exception {
		this.click(GetByLocator.getLocator("homeLifeSer"));
		boolean flag = true;
		int number = 0;
		Thread.sleep(1500);
		String titleText = driver.findElement(GetByLocator.getLocator("titleText")).getText();
		flag = "生活服务".equals(titleText);
		if (flag) {
			String addressText = driver.findElement(GetByLocator.getLocator("lifeChAddrees")).getText();
			this.click(GetByLocator.getLocator("lifeChAddrees"));
			List<AndroidElement> listAreasEl = new ArrayList<>();
			listAreasEl = driver.findElements(GetByLocator.getLocator("lifeChAreas"));
			for (int i = 0; i < listAreasEl.size(); i++) {
				this.click(listAreasEl.get(i));
				if (driver.isToast("所选地区暂未开通，请重新选择")) {
					Thread.sleep(3000);
				} else {
					number = i;
				}
			}
			Thread.sleep(2000);
			this.click(listAreasEl.get(number));
			String areasText = listAreasEl.get(number).getText();
			this.click(GetByLocator.getLocator("save"));
			Thread.sleep(2000);
			if (driver.findElement(GetByLocator.getLocator("lifeChAddrees")).getText().contains(areasText)) {
				// 验证返回重新进来还是显示所选的小区地址
				this.click(GetByLocator.getLocator("back"));
				this.click(GetByLocator.getLocator("homeLifeSer"));
				if (driver.findElement(GetByLocator.getLocator("lifeChAddrees")).getText().equals(addressText)) {
					return true;
				} else {
					return false;
				}
			} else {
				System.out.println("地址选择有误");
				return false;
			}

		}
		return false;
	}

	// 验证社区商家banner
	public boolean communityBusinessBanner() throws Exception {
		this.click(GetByLocator.getLocator("homeBusinessSer"));
		boolean flag = true;
		Thread.sleep(4000);
		String titleText = driver.findElement(GetByLocator.getLocator("titleText")).getText();
		flag = "社区商家".equals(titleText);
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
					flag = "社区商家".equals(titleText);
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
				flag = "社区商家".equals(titleText);
				if (!flag) {
					return false;
				}
			}
		} else {
			System.out.println("不是在社区商家");
		}
		return flag;
	}

	// 验证社区商家类型
	public boolean communityBusinessType() throws Exception {
		this.click(GetByLocator.getLocator("homeBusinessSer"));
		boolean flag = true;
		Thread.sleep(1000);
		String titleText = driver.findElement(GetByLocator.getLocator("titleText")).getText();
		flag = "社区商家".equals(titleText);
		if (flag) {
			List<String> listText = new ArrayList<>();
			int flag1 = 1;
			while (flag1 != 0) {
				flag1 = 0;
				List<AndroidElement> list = new ArrayList<>();
				list = driver.findElements(GetByLocator.getLocator("communityBusinessTpyeBtn"));
				for (int i = 0; i < list.size(); i++) {
					AndroidElement an = list.get(i);
					String text = an.getText();
					if (!listText.contains(text)) {
						listText.add(text);
						System.out.println(listText);
						this.click(an);
						// 遍历社区商家店铺
						if (driver.isElementExist(GetByLocator.getLocator("comBusinessName"), 2)) {
							List<String> listName = new ArrayList<>();
							int flag2 = 1;
							while (flag2 != 0) {
								flag2 = 0;
								List<AndroidElement> listNameEl = new ArrayList<>();
								listNameEl = driver.findElements(GetByLocator.getLocator("comBusinessName"));
								for (int j = 0; j < listNameEl.size(); j++) {
									AndroidElement el = listNameEl.get(j);
									String nameText = el.getText();
									if (!listName.contains(nameText)) {
										listName.add(nameText);
										System.out.println(nameText);
										this.click(el);
										Thread.sleep(2000);
										if (!nameText.isEmpty()) {
											if (!nameText.equals(driver.findElement(GetByLocator.getLocator("titleText")).getText())) {
												System.out.println("点进去的社区商家标题不对");
												return false;
											}
											this.click(GetByLocator.getLocator("back"));
											flag2++;
											Thread.sleep(2000);
										}
									}
								}
								driver.swipeOnElement(driver.findElement(GetByLocator.getLocator("comBusinessList")), "up", 3000);
							}
							driver.swipeUntilElementAppear(GetByLocator.getLocator("communityBusinessTpyeBtn"), "down", 1000, 10);
						} else if (driver.isElementExist(GetByLocator.getLocator("noCommunityBusiness"), 2)) {
							System.out.println("没有社区店铺不点击");
						} else {
							return false;
						}
						flag1++;
					}
				}
				driver.swipeOnElement(driver.findElement(GetByLocator.getLocator("businessTypeLayout")), "left", 1000);
			}
		}
		return flag;
	}

	// 验证社区商家为您推荐
	public boolean communityBusinessRecommend() throws Exception {
		this.click(GetByLocator.getLocator("homeBusinessSer"));
		boolean flag = true;
		Thread.sleep(1000);
		String titleText = driver.findElement(GetByLocator.getLocator("titleText")).getText();
		flag = "社区商家".equals(titleText);
		if (flag) {
			List<String> listText = new ArrayList<>();
			int flag1 = 1;
			while (flag1 != 0) {
				flag1 = 0;
				List<AndroidElement> list = new ArrayList<>();
				list = driver.findElements(GetByLocator.getLocator("communityBusinessTpyeBtn"));
				for (int i = 0; i < list.size(); i++) {
					AndroidElement an = list.get(i);
					String text = an.getText();
					if (!listText.contains(text)) {
						listText.add(text);
						System.out.println(listText);
						this.click(an);
						// 遍历社区商家为您推荐店铺 只点前面几个
						AndroidElement an1 = driver.findElement(GetByLocator.getLocator("comBusinessName"));
						if (an1 != null) {
							this.click(an1);
							List<AndroidElement> listNameEl = new ArrayList<>();
							listNameEl = driver.findElements(GetByLocator.getLocator("recommenBusinessName"));
							for (int j = 0; j < listNameEl.size(); j++) {
								String nameText = driver.findElements(GetByLocator.getLocator("recommenBusinessName")).get(j).getText();
								System.out.println(nameText);
								this.click(driver.findElements(GetByLocator.getLocator("recommenBusinessName")).get(j));
								Thread.sleep(2000);
								if (nameText != null) {
									if (!nameText.equals(driver.findElement(GetByLocator.getLocator("titleText")).getText())) {
										System.out.println("点进去的社区商家标题不对");
										return false;
									}
									Thread.sleep(2000);
								}
							}
							this.click(GetByLocator.getLocator("back"));
						} else if (driver.isElementExist(GetByLocator.getLocator("noCommunityBusiness"), 2)) {
							System.out.println("没有社区店铺不点击");
						} else {
							return false;
						}
						flag1++;
					}
				}
				driver.swipeOnElement(driver.findElement(GetByLocator.getLocator("businessTypeLayout")), "left", 1000);
			}
		}
		return flag;
	}

	// 验证首页商品推荐
	public boolean homeSales() throws Exception {
		List<String> listName = new ArrayList<>();
		int mun = 1;
		while (mun != 0) {
			mun = 0;
			List<AndroidElement> list = new ArrayList<>();
			List<AndroidElement> listBuyCount = new ArrayList<>();
			list = driver.findElements(GetByLocator.getLocator("homeSalesName"));
			listBuyCount = driver.findElements(GetByLocator.getLocator("homeSalesBuyCount"));
			if (list.size() == listBuyCount.size()) {
				for (int i = 0; i < list.size(); i++) {
					System.out.println(list.size());
					AndroidElement an = list.get(i);
					String textName = an.getText();
					System.out.println(textName);
					if (!listName.contains(textName)) {
						String textBuyCount = listBuyCount.get(i).getText();
						listName.add(textName);
						this.click(an);
						Thread.sleep(2000);
						if (driver.isElementExist(GetByLocator.getLocator("onlineCartImage"))){
							if (textName.equals(driver.findElement(GetByLocator.getLocator("commodityName")).getText())) {
								System.out.println(textBuyCount);
								System.out.println(driver.findElement(GetByLocator.getLocator("commodityBuyCount")).getText());
								if (!(textBuyCount.equals(driver.findElement(GetByLocator.getLocator("commodityBuyCount")).getText()))) {
									System.out.println("商品购买人数有误");
									return false;
								}
							}else {
								System.out.println("商品名称有误");
								return false;
							}	
								
						}else {
							return false;
						}
						this.click(GetByLocator.getLocator("onlineBackImage"));
						mun++;
					}
				}
			}else if (list.size() > listBuyCount.size()) {
				for (int i = 0; i < list.size()-1; i++) {
					System.out.println(list.size());
					AndroidElement an = list.get(i);
					String textName = an.getText();
					System.out.println(textName);
					if (!listName.contains(textName)) {
						String textBuyCount = listBuyCount.get(i).getText();
						listName.add(textName);
						this.click(an);
						Thread.sleep(2000);
						if (driver.isElementExist(GetByLocator.getLocator("onlineCartImage"))){
							if (textName.equals(driver.findElement(GetByLocator.getLocator("commodityName")).getText())) {
								System.out.println(textBuyCount);
								System.out.println(driver.findElement(GetByLocator.getLocator("commodityBuyCount")).getText());
								if (!(textBuyCount.equals(driver.findElement(GetByLocator.getLocator("commodityBuyCount")).getText()))) {
									System.out.println("商品购买人数有误");
									return false;
								}
							}else {
								System.out.println("商品名称有误");
								return false;
							}	
								
						}else {
							return false;
						}
						this.click(GetByLocator.getLocator("onlineBackImage"));
						mun++;
					}
				}
			}else {
				for (int i = 0; i < list.size(); i++) {
					System.out.println(list.size());
					AndroidElement an = list.get(i);
					String textName = an.getText();
					System.out.println(textName);
					if (!listName.contains(textName)) {
						String textBuyCount = listBuyCount.get(i+1).getText();
						listName.add(textName);
						this.click(an);
						Thread.sleep(2000);
						if (driver.isElementExist(GetByLocator.getLocator("onlineCartImage"))){
							if (textName.equals(driver.findElement(GetByLocator.getLocator("commodityName")).getText())) {
								System.out.println(textBuyCount);
								System.out.println(driver.findElement(GetByLocator.getLocator("commodityBuyCount")).getText());
								if (!(textBuyCount.equals(driver.findElement(GetByLocator.getLocator("commodityBuyCount")).getText()))) {
									System.out.println("商品购买人数有误");
									return false;
								}
							}else {
								System.out.println("商品名称有误");
								return false;
							}	
								
						}else {
							return false;
						}
						this.click(GetByLocator.getLocator("onlineBackImage"));
						mun++;
					}
				}
			}
			driver.swipeOnElement(driver.findElement(GetByLocator.getLocator("homeSalesLayout")), "up", 1000);
		}
		return true;
	}



	// 验证更多商品推荐
	public boolean homeMoreSales() throws Exception {
		this.click(GetByLocator.getLocator("moreSalesBtn"));
		return homeSales();
	}

	// 验证更多促销推荐对比价格
	public boolean homeMoreSalesPrice() throws Exception {
		this.click(GetByLocator.getLocator("imgClose"));
		String salesString = driver.getMyText(GetByLocator.getLocator("homeSalesText"));
		this.click(GetByLocator.getLocator("moreSalesBtn"));
		boolean flag = true;
		Thread.sleep(1000);
		String titleText = driver.findElement(GetByLocator.getLocator("titleText")).getText();
		flag = salesString.equals(titleText);
		if (flag) {
			List<String> listName = new ArrayList<>();
			int mun = 1;
			while (mun != 0) {
				mun = 0;
				List<AndroidElement> list = new ArrayList<>();
				list = driver.findElements(GetByLocator.getLocator("commodityPrice"));
				for (int i = 0; i < list.size(); i++) {
					AndroidElement an = list.get(i);
					String textPrice = an.getText();
					System.out.println(textPrice);
					if (!listName.contains(textPrice)) {
						listName.add(textPrice);
						this.click(an);
						Thread.sleep(2000);
						if (!textPrice.equals(driver.findElement(GetByLocator.getLocator("commodityPrice")).getText())) {
							System.out.println("商品价格有误");
							return false;
						}
						this.click(GetByLocator.getLocator("back"));
						mun++;
						Thread.sleep(2000);
					}
				}
				driver.swipeOnElement(driver.findElement(GetByLocator.getLocator("moreSalesList")), "up", 1500);
				Thread.sleep(2000);
			}
		}
		return flag;
	}
	
    //验证首页热门邻里群
	public boolean homeHotGroup() throws Exception {
		if (driver.isElementExist(GetByLocator.getLocator("homeGroupEmpty"))) {
			return true;
		}
		else {
			List<String> listName = new ArrayList<>();
			int mun = 1;
			while (mun != 0) {
				mun = 0;
				List<AndroidElement> list = new ArrayList<>();
				list = driver.findElements(GetByLocator.getLocator("homeHotGroupName"));
				for (int i = 0; i < list.size(); i++) {
					AndroidElement an = list.get(i);
					String textGroupName1 = an.getText();
					System.out.println(textGroupName1);
					if (!listName.contains(textGroupName1)) {
						listName.add(textGroupName1);
						String textGroupNum = driver.findElements(GetByLocator.getLocator("homeHotGroupNum")).get(i).getText().split(" : ")[1];
//						String textGroupDesc = driver.findElements(GetByLocator.getLocator("homeHotGroupDesc")).get(i).getText();
						this.click(an);
						Thread.sleep(2000);
						if (driver.isElementExist(GetByLocator.getLocator("joinGroupBtn"))) {
							if (driver.findElement(GetByLocator.getLocator("groupName")).getText().contains(textGroupName1)) {
								if (!textGroupNum.equals(driver.findElement(GetByLocator.getLocator("groupFriendNum")).getText())) {
//									if (!textGroupDesc.equals(driver.findElement(GetByLocator.getLocator("groupDesc")).getText())) {
//										System.out.println("社区群简介有误");
//										return false;
//									}
//								}else {
									System.out.println("社区群人数有误");
									return false;
								}
							} else {
								System.out.println("社区群名称有误");
								return false;
							}
							this.click(GetByLocator.getLocator("imgBack"));
						}else {
							this.click(GetByLocator.getLocator("menuImage"));
							Thread.sleep(500);
							if (driver.findElement(GetByLocator.getLocator("groupName")).getText().contains(textGroupName1)) {
								if (!textGroupNum.equals(driver.findElement(GetByLocator.getLocator("groupFriendNum")).getText())) {
//									if (!textGroupDesc.equals(driver.findElement(GetByLocator.getLocator("groupDesc")).getText())) {
//										System.out.println("社区群简介有误");
//										return false;
//									}
//								}else {
									System.out.println("社区群人数有误");
									return false;
								}
							} else {
								System.out.println("社区群名称有误");
								return false;
							}
							this.click(GetByLocator.getLocator("imgBack"));
							this.click(GetByLocator.getLocator("back"));
						}
						mun++;
					}
				}
				driver.swipeOnElement(driver.findElement(GetByLocator.getLocator("homeHotGroupLayout")), "left", 2500);
			}
		}
		return true;
	}
//	验证更多邻里群
	public boolean homeMoreHotGroup() throws Exception {
		this.click(GetByLocator.getLocator("moreGroupBtn"));
		if (driver.isElementExist(GetByLocator.getLocator("homeGroupEmpty"))) {
			return true;
		}
		else {
			List<String> listName = new ArrayList<>();
			int mun = 1;
			while (mun != 0) {
				mun = 0;
				List<AndroidElement> list = new ArrayList<>();
				list = driver.findElements(GetByLocator.getLocator("homeHotGroupName"));
				for (int i = 0; i < list.size(); i++) {
					AndroidElement an = list.get(i);
					String textGroupName1 = an.getText();
					System.out.println(textGroupName1);
					if (!listName.contains(textGroupName1)) {
						listName.add(textGroupName1);
						String textGroupNum = driver.findElements(GetByLocator.getLocator("homeHotGroupNum")).get(i).getText().split(" : ")[1];
//						String textGroupDesc = driver.findElements(GetByLocator.getLocator("homeHotGroupDesc")).get(i).getText();
						this.click(an);
						Thread.sleep(2000);
						if (driver.isElementExist(GetByLocator.getLocator("joinGroupBtn"))) {
							if (driver.findElement(GetByLocator.getLocator("groupName")).getText().contains(textGroupName1)) {
								if (!textGroupNum.equals(driver.findElement(GetByLocator.getLocator("groupFriendNum")).getText())) {
//									if (!textGroupDesc.equals(driver.findElement(GetByLocator.getLocator("groupDesc")).getText())) {
//										System.out.println("社区群简介有误");
//										return false;
//									}
//								}else {
									System.out.println("社区群人数有误");
									return false;
								}
							} else {
								System.out.println("社区群名称有误");
								return false;
							}
							this.click(GetByLocator.getLocator("imgBack"));
						}else {
							this.click(GetByLocator.getLocator("menuImage"));
							Thread.sleep(500);
							if (driver.findElement(GetByLocator.getLocator("groupName")).getText().contains(textGroupName1)) {
								if (!textGroupNum.equals(driver.findElement(GetByLocator.getLocator("groupFriendNum")).getText())) {
//									if (!textGroupDesc.equals(driver.findElement(GetByLocator.getLocator("groupDesc")).getText())) {
//										System.out.println("社区群简介有误");
//										return false;
//									}
//								}else {
									System.out.println("社区群人数有误");
									return false;
								}
							} else {
								System.out.println("社区群名称有误");
								return false;
							}
							this.click(GetByLocator.getLocator("imgBack"));
							this.click(GetByLocator.getLocator("back"));
						}
						mun++;
					}
				}
				driver.swipeOnElement(driver.findElement(GetByLocator.getLocator("groupRefreshLayout")), "up", 2500);
			}
		}
		return true;
	}
	


}
