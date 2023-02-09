package ezen.io;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FileExample2 {
	// 파일이나 디렉토리 관련 정보 얻기
	public static void main(String[] args) throws IOException {
		String path = "c:/ezen-academy/temp/some.txt";
		File file = new File(path);
		String fileName = file.getName();
		System.out.println(fileName);
		System.out.println(file.getParent());
		System.out.println(file.getPath());
		
		String path2 = "example1.dat"; //상대 경로
		File file2 = new File(path2);
		System.out.println(file2.getPath());
		System.out.println(file2.getAbsolutePath());
		System.out.println(file2.canRead());
		System.out.println(file2.canWrite());
		System.out.println(file2.canExecute());
		System.out.println(file2.isHidden());
		System.out.println(file2.length());
		System.out.println(file2.exists());
		System.out.println(file2.lastModified());
		
		long ms = file2.lastModified();
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(ms);
		System.out.printf("%1$tF %1$tT\n", calendar);
		
		Date date = new Date(ms);
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String formattedDate = sd.format(date);
		System.out.println(formattedDate);
		dir();
		fileNameFilter();
		fileRename();
		printDrive();
	}
	public static void dir() {
		String path = "C:/Users/i7A-56";
		
		File file = new File(path);
		File[] list = file.listFiles();
		for (File f : list) {
			// System.out.println(f.getName());
			if(f.isFile()) {
				System.out.println("     " + f.length() + " " + f.getName());
				// System.out.printf();
			}else {
				System.out.println("<DIR>" + "       " + f.getName());
				// System.out.printf();
			}
		}
	}
	
	// 파일 이름 필터링.
	public static void fileNameFilter() {
		System.out.println("--------------------------------------");
		File currentDirectory = new File(".");
//		File[] list = currentDirectory.listFiles();
		File[] list = currentDirectory.listFiles(new FileFilter() { // 익명 클래스는 인터페이스로만 하나?
			
			@Override
			public boolean accept(File pathname) {
//				return pathname.getName().endsWith("dat");
				return pathname.getName().startsWith("IO");
				
			}
		});
		
		for (File file : list) {
			System.out.println(file.getName());
		}
	}
	
	// 파일 이름 변경
	public static void fileRename() {
		File file = new File("IO Programming_copy.pdf");
		boolean result= file.renameTo(new File("xxx.pdf"));
		System.out.println(result);
		
		File deletoFile = new File("IO Programming.pdf");
		System.out.println(deletoFile.delete());
	}
	
	// 내 컴퓨터의 드라이브명 출력
	public static void printDrive() {
		File[] roots= File.listRoots();
		for (File file : roots) {
			System.out.println(file);
		}
	}

}
