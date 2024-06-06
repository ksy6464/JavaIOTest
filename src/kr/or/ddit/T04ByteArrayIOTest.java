package kr.or.ddit;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class T04ByteArrayIOTest {

	public static void main(String[] args) throws IOException {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		
		///1byte씩 하니간 느려서 버퍼를 이용해서  IO작업을 해보자
		byte[] temp = new byte[4];
		
	

		ByteArrayInputStream bias = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		int readBytes = 0;///읽은 바이트의 개수
		
		while ((readBytes = bias.read(temp)) != -1) {
			
			System.out.println("temp => "+ Arrays.toString(temp));
			
//			baos.write(temp);/// 이렇게 하면 마지막에 데이터 2개 더 읽어서 원하는 복사가 안됨 
			baos.write(temp, 0, readBytes); 
			
			
		}///while문 byte 4개씩 3번만 읽으면 10개 데이터 복사가능
		
		outSrc = baos.toByteArray();
		
		System.out.println("스트림 클래스이용하여 복사 후 outSrc => "+ Arrays.toString(outSrc));
		
		
		
		
		
		
		
		
		
		
	}

}
