package kr.or.ddit;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class T07FileWriterTest {
	
	public static void main(String[] args) throws IOException {
		// 사용자가 입력한 내용을 그대로 파일로 저장하기
		
		// 콘솔(표준 입출력장치)과 연결된 입력용 문자 스트림 객체 생성하기
		// InputStreamReader => 바이트 기반 스트림을 문자기반 스트림으로 변환해주기 위한 보조 스트림
		InputStreamReader isr = new InputStreamReader(System.in);
		///in은 사용자 입력을 받는 inputstream(바이트 기반)객체
		///Input은 바이트 기반, Reader은 문자기반으로 바이트 기반데이터를 문자기반으로 변환
		///다른것들은 기본스트림 또는 일반스트림, 일반스트림을 보조해주는것이 보조스트림
		///여기서 기본은 스트림은 input이다
		
		///가독성을 위해서 try/catch 안쓰고 던져주겠다
		FileWriter fw = new FileWriter("d:/D_Other/testChar.txt");
		///문자 기반 처리하는것
		
		int data = 0;
		
		System.out.println("아무거나 입력하세요.");
		
		// 콘솔에서 입력할때 입력의 끝(EOF)을 나타내기 위해서는 Curl+Z 키를 누르면 된다.
		/// End Of File이 -1 역할을 한다
//		while ((data = System.in.read())!=-1) { ///이렇게 하면 바이트 기반이라서 한글을 표현할 수가 없다
		while ((data = isr.read())!=-1) {
			fw.write(data);
		}
		
		System.out.println("출력 작업 끝...");
		
		isr.close();
		fw.close();
		
	}

}
