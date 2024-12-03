package yang;

import java.util.Scanner;

import org.junit.Test;

public class TryCatch {
	
	//1.기본
	@Test
	public void test1() {
		Scanner scan = null;
		try {
			scan = new Scanner(System.in);
			System.out.println("입력하라: ");
			System.out.println(scan.nextInt());
			System.out.println("입력 테스트 완료");
		}catch(Exception e) {
			
		}finally {
			scan.close();
		}
	}
	
	//2. try with resource
	public void test2() {
		//리소스가 사용되고 자동으로 해제된다. 
		try(Scanner scan = new Scanner(System.in)){
			
			System.out.println("입력하라: ");
			System.out.println(scan.nextInt());
			System.out.println("입력 테스트 완료");
		}catch(Exception e) {
			
		}
	}
	
	//3. try with resource 편의성 확장(java 9부터)
	public void test3() {
		Scanner scan = new Scanner(System.in);
		try(scan){
			
			System.out.println("입력하라: ");
			System.out.println(scan.nextInt());
			System.out.println("입력 테스트 완료");
		}catch(Exception e) {
			
		}
	}
}
