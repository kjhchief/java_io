package ezen.io.raf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
/**
 * 친구정보 파일 저장 및 관리 구현체
 * ObjectStream 활용
 * @author 김기정
 */
public class ObjectFriendRepository implements FriendRepository {
	/** 파일 저장 경로 */
	private static final String FILE_PATH = "friends.ser"; //파일경로 상수처리, 객체는 ser로 저장

	private List<Friend> list;
	
	private ObjectOutputStream out;
	private ObjectInputStream in;

	public ObjectFriendRepository() throws IOException, ClassNotFoundException  {
		File file = new File(FILE_PATH);
		
		// 기존의 파일이 없는 경우...
		if(!file.exists()) {
			list = new ArrayList<Friend>();
		}else {
			in = new ObjectInputStream(new FileInputStream(FILE_PATH));
			list = (List<Friend>) in.readObject();
			System.out.println("기존 사이즈: " + list.size());
			in.close();
		}
		
	}
	
	@Override
	public int getRecordCount() {
		return list.size(); //list에 저장하니까 list사이즈로 확인
	}

	@Override
	public void save(Friend friend) throws IOException {
		// 기존에 등록된 친구인지 검증 필요
		
		// 리스트에 친구 저장
		list.add(friend);
		// 리스트를 파일에 저장
		saveFile();
	}
	
	public void saveFile() throws IOException {
		out = new ObjectOutputStream(new FileOutputStream(FILE_PATH));		
		out.writeObject(list); //내부적으로 buffer 기능 탑재
		out.flush(); // 강제로 출력

	}

	@Override
	public List<Friend> findAll() throws IOException {
		return list; //저장을 list에 해서 그냥 반환만하면됨
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

}
