import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Q4 {
	public static void main(String args[]) throws IOException{
		Scanner sc = new Scanner("src/DATA00.txt");
		BufferedWriter br = new BufferedWriter(new FileWriter("src/Test.txt"));
		int gridX = 0, gridY = 0;
		while(sc.nextLine() != null)
		{
			
		}
		
		br.write("Hello");
		
		br.close();
	}
}

