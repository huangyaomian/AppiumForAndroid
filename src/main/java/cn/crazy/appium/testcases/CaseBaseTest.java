package cn.crazy.appium.testcases;


import cn.crazy.appium.base.AndroidDriverBase;
import cn.crazy.appium.base.AndroidSpecific;
import cn.crazy.appium.base.CrazyPath;
import cn.crazy.appium.util.ProUtil;

public class CaseBaseTest {
	
	public static AndroidDriverBase driver;

	public AndroidDriverBase driverInit(String udid, String port)
			throws Exception {
		ProUtil p = new ProUtil(CrazyPath.globalPath);
		String server=p.getPro("server");
		String capsPath=CrazyPath.capsPath;
		System.out.println(capsPath);
		AndroidSpecific as=new AndroidSpecific();
		//获取原本输入法，方便后续设置回去
		String input=as.getDefaultInput(udid);
		System.out.println("连接"+udid+"端口"+port);
		System.out.println("开始创建server连接");
		driver = new AndroidDriverBase(server, port, capsPath, udid, input);
		return driver;
	}
}
