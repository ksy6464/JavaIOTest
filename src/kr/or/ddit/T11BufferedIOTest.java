package kr.or.ddit;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class T11BufferedIOTest {
	public static void main(String[] args) throws IOException {
		// 입출력 성능향상을 위해 버퍼를 이용하는 보조스트림
		
		FileOutputStream fos = new FileOutputStream("d:/D_Other/bufferTest2.txt");
		
		// 버퍼의 크기를 지정하지 않으면 기복적으로 버퍼의크기는 8192byte(8KB)로 설정된다.
		
		// 버퍼크기가 5byte인 보조스트림 객체 생성하기
		/// 바이트 기반
		BufferedOutputStream bos = new BufferedOutputStream(fos,5);
//		BufferedInputStream도 있다
		
		for(char ch='1'; ch<='9';ch++) {
			bos.write(ch);
		}
		
		bos.flush(); //작업을 종료하기 전에 버퍼에 남아있는 데이터를 모두 출력(방출)시킨다.
					 // close()  호출시 자동으로 호출됨.
		bos.close();
		
		System.out.println("버퍼를 이용한 쓰기 작업 끝...");
	}
}
