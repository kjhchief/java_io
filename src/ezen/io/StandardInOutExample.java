package ezen.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * 표준 입출력(키보드, 모니터)
 * @Author 김재훈
 * @Date 2023. 1. 30.
 */
public class StandardInOutExample {

	public static void main(String[] args) throws IOException {
		System.out.print("나이 입력 : ");
		
		// 20 -> 2에 해당하는 아스키코드, 0에 해당하는 아스키 코드가 입력
		// 13이랑 10은? 엔터값. \r\n
		
		byte[] buffer = new byte[20];
		int count = System.in.read(buffer); // byte단위로 읽음.
		/*
		for (byte b : buffer) {
			System.out.println(b);
		}
		*/
		// 내가 직접 디코딩
		String no = new String(buffer, 0, count-2); // 0, 2 빼면 10개 배열 다 하는거.
		int no2 = Integer.parseInt(no);
		System.out.println(no2);
		System.out.print("이름 입력: ");
		count = System.in.read(buffer);
		String name = new String(buffer, 0, count-2);
		System.out.println(name);
		
		// Java5 버젼 이후 Scanner 클래스를 이용하여 편리하게 작성
		Scanner scanner = new Scanner(System.in); //BufferedInputStream
		System.out.print("나이: ");
		int age = scanner.nextInt();
		System.out.println("몸무게: ");
		double weight = scanner.nextDouble();
		System.out.println("이름: ");
		name = scanner.nextLine();
		System.out.println(age);
		System.out.println(weight);
		System.out.println(name);
		
//		Scanner scanner2 = new Scanner(new FileInputStream("some.txt"));
		

	}

}
