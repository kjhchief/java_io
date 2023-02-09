package ezen.io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author 김재훈
 * @Date 2023. 1. 27.
 */

public class DataInputStreamExample {

	public static void main(String[] args) throws IOException {
		String fileName = "myInfo.dat";
		
		boolean flag = false;
		byte score = 0;
		int age = 0;
		double weight = 0.0;
		String comment = null; // String은 객체
		Student student = null;
		
		// Node 스트림
		InputStream in = new FileInputStream(fileName);
		// Filter 스트림
		DataInputStream dis = new DataInputStream(in);
		flag = dis.readBoolean();
//		dos.read(score);
		score = dis.readByte();
		age = dis.readInt();
		weight = dis.readDouble();
		// 문자디코딩 기능이 추가된 메소드 - (UTF-8 문자셋 사용)
		comment = dis.readUTF();
		
		int no = dis.readInt();
		String name = dis.readUTF();
		int score2 = dis.readInt();
		String studentInfo = dis.readUTF();
		//...
		student = new Student(no, name, 0);
		
		dis.close();
//		out.close();
		
		System.out.println(flag);
		System.out.println(score);
		System.out.println(age);
		System.out.println(weight);
		System.out.println(comment);
		
		System.out.println(student);
		System.out.println(studentInfo);
		
		
		System.out.println("내 정보 저장 완료");
		
		
	}

}
