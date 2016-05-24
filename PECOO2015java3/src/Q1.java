import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.math.*;

public class Q1 {

	static void solver(String number){

		/*
		int dyn[] = new int[31];
		dyn[0] = 0;

		int j = number%10;
		number = (int) Math.floor(number/10);

		dyn[1] = j;

		int dn = 0;
		int ds = 0;
		 */
		String solution = "";

		int i = 0;
		int digspent = 1;

		while(!number.equals("")){
			//System.out.println(number);
			if(i >= (number.charAt(number.length()-1) - '0')){
				//extract two digit
				if(number.length() != 1){
					if(i >= Integer.parseInt(number.substring(number.length()-2,number.length()))){
						solution = " " + Integer.parseInt(number.substring(number.length()-2,number.length())) + solution;
						number = number.substring(0,number.length()-2);
					}
					
					else{
						int j =  (number.charAt(number.length()-1)) - '0';
						solution = " " + Integer.toString(j) + solution;
						number =   number.substring(0,number.length()-1);
					}
				}

				else{
					int j =  (number.charAt(number.length()-1)) - '0';
					solution = " " + Integer.toString(j) + solution;
					number =   number.substring(0,number.length()-1);
				}

			}

			else{
				solution = " 0" + solution;
			}
			i++;

		}

		System.out.println(solution.substring(1, solution.length()));


	}
	public static void main(String args[]) throws IOException{
		Scanner sc = new Scanner(new File("src/DATA11.txt"));
		for(int i = 0; i<10;i++){
			solver(sc.next());
		}
	}
}
