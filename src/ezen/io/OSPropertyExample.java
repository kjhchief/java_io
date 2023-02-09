package ezen.io;

import java.util.Properties;
import java.util.Set;

public class OSPropertyExample {

	public static void main(String[] args) {
		String osName = System.getProperty("os.name");
		System.out.println(osName);
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("user.dir"));
		System.out.println(System.getProperty("user.home"));
		
		// 운영체제와 관련된 모든 설정 정보 얻기
		Properties prop = System.getProperties();
		Set<Object> keys= prop.keySet();
		
		for (Object obj : keys) {
			String key = (String) obj; // 형변환. 안 하면 밑에서 빨간줄
			String value = prop.getProperty(key);
			System.out.println(key + " = " + value);
		}
		
	}

}
