package cn.crazy.appium.main;

import java.util.ArrayList;
import java.util.List;

import cn.crazy.appium.server.Port;
import cn.crazy.appium.server.Servers;
import cn.crazy.appium.util.DosCmd;
import cn.crazy.appium.util.XmlUtil;

public class AppiumInit {
	public static void init(){
		Servers servers=new Servers(new Port(new DosCmd()), new DosCmd());
		DosCmd dc=new DosCmd();
		if(dc.killServer()){
			try {
				System.out.println("开始启动服务");
				servers.startServers();
				System.out.println("服务启动完毕");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				List<String> classes=new ArrayList<String>();
				classes.add("cn.crazy.appium.testcases.LoginNewCase");
				classes.add("cn.crazy.appium.testcases.ChooseAreaCase");
				classes.add("cn.crazy.appium.testcases.intallStoreCase");
				classes.add("cn.crazy.appium.testcases.OnStoreCase");
				classes.add("cn.crazy.appium.testcases.NeighborhoodCase");
				classes.add("cn.crazy.appium.testcases.MeCase");
//				classes.add("cn.crazy.appium.testcases.JoinGroupCase");
				classes.add("cn.crazy.appium.testcases.OffStoreCase");
				classes.add("cn.crazy.appium.testcases.UserDetailCase");
				XmlUtil.createTestngXml(classes);
//				XmlUtil.createTestngXml("cn.crazy.appium.testcases.PerInfoTest");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			System.out.println("清除appium服务失败");
		}
	}
}
