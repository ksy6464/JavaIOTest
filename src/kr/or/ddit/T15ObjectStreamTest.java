package kr.or.ddit;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 객체 입출력을 위한 보조스트림 예제
 * @author 10
 *
 */
public class T15ObjectStreamTest {
	public static void main(String[] args) throws IOException {
		
		MemberVO mem1 = new MemberVO("홍길동", 20 , "대전");
		MemberVO mem2 = new MemberVO("이순신", 30 , "부산");
		MemberVO mem3 = new MemberVO("일지매", 40 , "대구");
		MemberVO mem4 = new MemberVO("강감찬", 50 , "광주");
		
//		FileOutputStream fos = new FileOutputStream("d:/D_Other/memObj.bin");
		///멤버 객체4개를 만들었고 그걸 지금 위에 파일 위치에 저장하고 싶다
		
		/// 버퍼 사용
//		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		
		// 객채 출력을 위한 보조스트림 생성하기
//		ObjectOutputStream oos = new ObjectOutputStream(fos);
//		ObjectOutputStream oos = new ObjectOutputStream(bos);
		ObjectOutputStream oos = new ObjectOutputStream(
									new BufferedOutputStream(
											new FileOutputStream("d:/D_Other/memObj.bin")));
		
		// 객체 쓰기(저장)
		oos.writeObject(mem1); // 직렬화
		oos.writeObject(mem2); // 직렬화
		oos.writeObject(mem3); // 직렬화
		oos.writeObject(mem4); // 직렬화
		///눈에 보이진 않지만 내부적으로 직렬화가 일어나고 있다.
		
		oos.close();
		
		System.out.println("객체 쓰기 작업 완료...");
		
		//////////////////////////////////////////////////////////////////////////
		
		///역직렬화
		// 저장된 객체정보를 읽어와 출력하기
		
		///기반스트림
//		FileInputStream fis = new FileInputStream("d:/D_Other/memObj.bin");
		
		// 객체 입력처리를 위한 보조스트림 생성하기
//		ObjectInputStream ois = new ObjectInputStream(fis);
		///버퍼쓰는데 한꺼번에 쓰기
		ObjectInputStream ois = new ObjectInputStream(
									new BufferedInputStream(
											new FileInputStream("d:/D_Other/memObj.bin")));
		
		Object obj = null;
		
		try {
			while ((obj = ois.readObject()) != null) { // 역직렬화...
				// 읽어온 데이터를 원래의 객체형으로 변환 후 사용한다.
				MemberVO mem = (MemberVO) obj;
				System.out.println("이름 : " + mem.getName());
				System.out.println("나이 : " + mem.getAge());
				System.out.println("주소 : " + mem.getAddr());
				System.out.println("---------------------------------------");
			}
			
		} catch (IOException ex) { ///파일에 있는 데이터를 읽다보면 예외가 발생할 수가 있다
//			ex.printStackTrace();
			System.out.println("읽기 작업 끝...");
			
		} catch (ClassNotFoundException e) { ///이게 더 발생할 수도 있어서 별도로 추가해줬다
			/// 클래스가 없을때 발생하는 예외인데 발생하는 이유는 readObject()의 리턴값이 스트링으로부터 읽은 오브젝트이다
			/// 근데 역직렬화 할때 내가 만들었던 클래스가 없을 수도 있다 그래서 예외처리해준거다
			e.printStackTrace();
		}
		
		
	}
}

//class MemberVO {  NotSerializableException 라는 에러가 났다
class MemberVO implements Serializable { ///직렬화 대상으로 바꿔주었다.
	
	/*
	 	transient => 직렬화가 되지 않을 멤버변수에 지정한다.
	 				(static 필드도 직렬화가 되지 않는다.)
	 		직렬화가 되지 않는 멤버변수는 기본값으로 저장된다.
	 			(참조형 변수 : null, 숫자형 변수 : 0, 논리형 변수 : false)
	*/
	
	private String name;
//	private int age;
	transient private int age; ///직렬화 대상에서 제외시키고 싶다
//	private String addr;
	transient private String addr; ///직렬과 대상에서 제외시키고 싶다

	///필드값을 이용한 생성자
	public MemberVO(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	
	///getter setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	///to string
	@Override
	public String toString() {
		return "MemberVO [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
	
}