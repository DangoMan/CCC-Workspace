package Week1;

import java.util.*;

public class Sol {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int d = a - b - c;
		
		int e = 3*(a /4);
		
		int rc = -(Math.min(0, e - b));
		int f = e - b;
		int rin = -(Math.min(0, Math.max(0,f) - c));
		System.out.println(rin);
		
		System.out.println(b*2 + c - 2*rc - rin);
				
		
	}

}
