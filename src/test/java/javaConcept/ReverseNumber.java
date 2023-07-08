package javaConcept;

public class ReverseNumber {

	public static void main(String[] args) {

		int num = 12346;
		int rev = 0;
		
		
		while (num!=0) {
		int rim =	num%10;
		rev = rev*10+rim;
		num=num/10;	
						
		}
		System.out.println(rev);
	}

}
