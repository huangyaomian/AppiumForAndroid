package cn.crazy.appium.connectionofpost;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.util.TextUtils;
import net.sf.json.JSONObject;

public class ConnectionHttp {
	// 获取服务器反馈的所有内容以String返回
	public static String getPostAllMessage(String qurl, JSONObject obj)
			throws Exception {
		final String message;
		// 连接服务器
		URL url = new URL(qurl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setUseCaches(false);
		connection.setRequestProperty("Content-type", "application/json");
		connection.setRequestMethod("POST");
		// post信息
		// 连接,也可以不用明文connect，使用下面的connection.getOutputStream()会自动connect
		OutputStream os = connection.getOutputStream();
		System.out.println(obj.toString());
		os.write(obj.toString().getBytes("utf-8"));
		os.flush();
		os.close();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				connection.getInputStream()));
		String lines;
		StringBuffer sb = new StringBuffer("");
		while ((lines = reader.readLine()) != null) {
			lines = new String(lines.getBytes(), "utf-8");
			System.out.println(lines);
			sb.append(lines);
		}
		message = sb.toString();
		reader.close();
		if (!TextUtils.isEmpty(message)) {
			return message;
		} else {
			return null;
		}
	}
	
	// 获取服务器反馈的所有内容以String返回
		public static String getPostAllMessage(String qurl)
				throws Exception {
			final String message;
			// 连接服务器
			URL url = new URL(qurl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.setRequestProperty("Content-type", "application/json");
			connection.setRequestMethod("POST");
			connection.connect();
			// post信息
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String lines;
			StringBuffer sb = new StringBuffer("");
			while ((lines = reader.readLine()) != null) {
				lines = new String(lines.getBytes(), "utf-8");
				System.out.println(lines);
				sb.append(lines);
			}
			message = sb.toString();
			reader.close();
			if (!TextUtils.isEmpty(message)) {
				return message;
			} else {
				return null;
			}
		}
	
	//放回Post信息中是否含有Message
	public static boolean isMessageForPostJion(String qurl, JSONObject obj,
			String message) throws Exception {
		String allMessage = getPostAllMessage(qurl, obj);
		if (!TextUtils.isEmpty(allMessage) && allMessage != null) {
			return allMessage.contains(message);
		} else {
			return false;
		}
	}
	//获取对应键值的值，以String返回
	public static String getPostValuseString(String qurl, JSONObject obj , String key) throws Exception {
		String value;
		JSONObject jsonObj;
		jsonObj = JSONObject.fromObject(getPostAllMessage(qurl, obj));
		value = jsonObj.get(key).toString();
		return value;
	}
	
	public static String getPostValuseString(String qurl, String key) throws Exception {
		String value;
		JSONObject jsonObj;
		jsonObj = JSONObject.fromObject(getPostAllMessage(qurl));
		value = jsonObj.get(key).toString();
		return value;
	}

	public static void main(String[] args) throws Exception {
		JSONObject obj = new JSONObject();
		obj.put("page", "100");
		obj.put("size", "1");
		System.out.println(ConnectionHttp.getPostValuseString(
				"http://120.24.224.208:28081/manager/user/page_query", obj,
				"body"));
		List<String> list=new ArrayList<>();
//		list.add("");
		list.add("f67ed3ce962f490d8ecade599bbdbbaa");
		list.add("f5cdb14a5c934f90b10bb420adb8b771");
		list.add("f1be7eb0cc9d4d26bc6e2fcac56968cd");
		list.add("f0bf8409db7d4e52b0efc2ae10dcd4b6");
		list.add("e919033cfbb9462cb4c6107930612993");
		list.add("e84efc23f619436aaea22377685a8b57");
		list.add("e456c55ced6541418930dd8fb2b6bcde");
		list.add("e1af70f8461c483fa9f48d24df3adf26");
		list.add("de5651857812428ab53e654460d10de3");
		list.add("faa35a03c72940b09d8f14759b5f63c5");
		list.add("fb8734ce4937437f94c890e5e725a743");
		list.add("fead86237bc145d4a7a28d3d8b182766");
		list.add("6a7d3d778abf423caf49980aecee7a0a");
		list.add("674702e4e9014f73be2524d73de57266");
		list.add("60739466d53e4d1996fc924226de870d");
		list.add("59c70f64a27c4c7186659e21a208be3e");
		list.add("5712e406cff044979601c2e20430c31a");
		list.add("46346a2933d940e9baed42b146a1f6b0");
		list.add("42e9b4e1374a441ea950314dd5ef7a0a");
		list.add("40f568a3069347e0a96dfbb8af78bb57");
		list.add("3aa8e4e0e69442e0aa7714b8e80d153c");
		list.add("3663d8d888d44c059c672df13c1ab31a");
		list.add("30bf1188dbef45f8937d35f05d144176");
		list.add("2b8d617da3074581b953475889e3ce24");
		list.add("1ede86d20f8a4caaa69113ecc37d7113");
		list.add("1d3f8428f12e47d692a39e2208afeafd");
		list.add("1ac935214138491cafc5e83a99229b58");
		list.add("197ac55f20d845e38a199a2e5d3d1657");
		list.add("0f61996b933540ed9fdc3dc1421c4ac1");
		list.add("0e1a42247aa241f7bcad159a22769c81");
		list.add("ddc4afeb2fec44c3bbdcde3956531366");
		list.add("db117a33600048dda4da040333226c76");
		list.add("d8efdb17f50d4211bf785c3656f65b81");
		list.add("d8ae39004b3d4330af60fbbb970fac97");
		list.add("d52ff0a04e3f49a6bd46d9e2e87f06dc");
		list.add("d3bea44c78a242aba8605fe39bb749c9");
		list.add("ccf9c7c5bc2e4c6cb85e9e837cd69620");
		list.add("cc77385a55a64acbbca370d2bafe7030");
		list.add("c9e43636154447aab4e8d7893320d92f");
		list.add("c56b79e3aefc440da21434e7041cf63c");
		list.add("c55333071b2a4abb80c90bd746c37a48");
		list.add("c52bbfc62ba1477aa97261d396c93053");
		list.add("c407604b92f5431cb406f3cc64a7adf4");
		list.add("c3314959915d497490c2f40bbaeb90b9");
		list.add("bfb5197e92ff4c3298b970af6fe1538c");
		list.add("be6b9549aa4d4c2babd979afd66be2fc");
		list.add("bcf9976e780a4a239bc1ba7172262017");
		list.add("bb5dabdbc15644348a13e2c4cacfa3e8");
		list.add("ba2dae19f9b14e39a1207c827a9afe4c");
		list.add("af9fb61b7cc511e7951e00163e0016ff");
		list.add("af1e6c16ee81497996d13e895cd15a49");
		list.add("a98b245b8a904fa3af83b572e28d21c3");
		list.add("a82ab2fea75744f3b47b85a592968737");
		list.add("a4a240356d6a4145b8ac150a76221ea8");
		list.add("a1f601d1f5234c11a0978742b1f460e3");
		list.add("a01f4949d2d4436a85cae5305281f043");
		list.add("9e66b99e9778400da172d428698931e8");
		list.add("9ab6af265a9b4fe199b8887414dd0235");
		list.add("96fa6c27d5ba468e99b174b73059d260");
		list.add("944ab1ec8f5242589ee530889b163103");
		list.add("8f4a6b7f0f9a487aa150a796980d7481");
		list.add("8c29233dab3f40299caa37e33d2bf9c9");
		list.add("8a14186745994c969d69096e4b616622");
		list.add("8374673f97174ae7b362e753b89d1abc");
		list.add("816ea78741d9492f93223bf26791fa04");
		list.add("80847001b4c340c58f963610658b33b5");
		list.add("8027e6efe47148f89ec1d06dc881dbe8");
		list.add("801d1b4c8cb34b16a010fd2056afe007");
		list.add("785639ccd9b9s3j90ytuyuaf191888");
		list.add("74e97ac5a2f14d48ae05666ba1d070cb");
		list.add("709869716eb24dc0859e9ec65ef4530a");
		list.add("6fad12ff938c468698d1b84ce6957b60");
		//上面是同个小区的
		list.add("0206e040f1d64f08bc84e85a582ffb41");
		list.add("0203afd89e3e49a8a6f6de068a04341f");
		list.add("01f2a78e3dff47b88275cfc2ff95f2ea");
		list.add("01ec4f7785d64ad7a43d1534382dc022");
		list.add("01e0e3f510b945c6bc1ef09b43b0a983");
		list.add("01c37aff87f748c7b797cf4b526b0375");
		list.add("0198ab5e06bb49da8ac8f57943a480aa");
		list.add("018bbe47f6e84d50a384b98da1144286");
		list.add("0208803ac23f4044b209691c39cce81a");
		list.add("0222b3f281cb404386293c3746e3f301");
		list.add("0222e042afe84d3090cc6d8025d4a22e");
		list.add("01543234c85d487094ffab1cd06ed27b");
		list.add("01497e2a5ea34159b9b53e5b074f4158");
		list.add("012d1a8796c84ed88a3e7c3bebac0e96");
		list.add("012b7285f37949b382b129629652b73b");
		list.add("0119f837d4144effa9af02c73f1628fa");
		list.add("00ca33530c4c440fac1b3bc1322749a6");
		list.add("00bc41417cb04042b654e6140f28cadc");
		list.add("00b6f7f7856e441c80a1dfcd7d35bb99");
		list.add("00a7e08b4dd04be48c5e57054011bd7c");
		list.add("00996be34f7e4b7ab26df7d124dc6011");
		list.add("008dc76dce58428e96d7d59d0ae43987");
		list.add("0082b7bc19ca4dda86f86d7d0b7ca588");
		list.add("0078bb07b8e041e59cd9bb5d1439c45b");
		list.add("004a344818ae463db4b33a3ecf335c8c");
		list.add("00347d13cf6d47ddb1bd5ec7d240cefe");
		list.add("001d02af902d44168d9308a17b5eca7f");
		list.add("0017199052444ffca5a38910bfbc661f");
		list.add("0001ca4473a541b388cb5adcc7e3d2bf");
		list.add("028a03b1bb1e4748848fd43996e5674c");
		list.add("02c4b0fbcd754283b5f40b153b25feaf");
		list.add("02d505893c3f42749854961d9154461f");
		list.add("02e897d3e4894113ac9ad8ff08408534");
		list.add("032103d8450947b39eb47abbd11921da");
		list.add("03216d37b69c4d06957fae3401769f32");
		list.add("03244388ebd542bebdb607c4ec65cd0d");
		list.add("034cb0ef083e4acaa7b4a3bb358291c2");
		list.add("034d8a2a77314396aa15894abe2f4423");
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			
			String aString= "http://www2.hxinside.com:9998/uc_r2/webchat/praiseCount?terminal=android&praiseuserid="+list.get(i)+"&webchatid=59e06da4e4b05ae6d2b2fa13&version=1.01";
			ConnectionHttp.getPostAllMessage(aString);
			
		}
		System.out.println("执行完了");
//		JSONObject jsonObj = JSONObject.fromObject(ob);
//		System.out.println(jsonObj.get("code").toString());

//		for (int i = 0; i < 999; i++) {
//			String aString2="http://www2.hxinside.com:9998/uc_r2/webchat/praiseCount?terminal=android&praiseuserid=cc77385a55a64acbbca370d2bafe7030&webchatid=59e05bdce4b07ae109aa0f74&version=1.01";
//			String aString1="http://www2.hxinside.com:9998/uc_r2/webchat/praisePosit?terminal=android&praiseuserid=cc77385a55a64acbbca370d2bafe7030&webchatid=59e06078e4b07ae109aa1062&version=1.01";
//			String aString= "http://www2.hxinside.com:9998/uc_r2/webchat/praiseCount?terminal=android&praiseuserid=cc77385a55a64acbbca370d2bafe7030&webchatid=59e06078e4b07ae109aa1062&version=1.01";
////			String aString1= "http://www2.hxinside.com:9998/uc_r2/webchat/cancelPraise?terminal=android&praiseuserid=cc77385a55a64acbbca370d2bafe7030&webchatid=59e06078e4b07ae109aa1062&version=1.01";
//			ConnectionHttp.getPostAllMessage(aString2);
//			ConnectionHttp.getPostAllMessage(aString1);
//			
//		}

	}
	
}
