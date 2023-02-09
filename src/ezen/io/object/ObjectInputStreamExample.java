package ezen.io.object;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

public class ObjectInputStreamExample {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Student student = null;
		String message = null;
		int age = 0;
		
		String fileName = "students.ser";
		
		ObjectInput in = new ObjectInputStream(new FileInputStream(fileName));
		// 파일의 연속적인 바이트 흐름을 -> 메모리상의 Object로 변환 (역직렬화) 
		
		student = (Student) in.readObject();
		message = (String) in.readObject();
		age = (int) in.readObject(); // UnBoxing 적용
		System.out.println(student.toString());
		System.out.println(message);
		System.out.println(age);
		in.close();
	}

}
