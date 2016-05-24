import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ECOO2015P3 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("DATA31.txt"));
		while(scan.hasNext()){
			int n=scan.nextInt();
			int t=scan.nextInt();
			System.out.println(n*2-1);
		}
	}
}
