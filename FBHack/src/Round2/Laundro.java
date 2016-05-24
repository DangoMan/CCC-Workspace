package Round2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Laundro {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("src/coding_contest_creation.txt"));
		BufferedWriter br = new BufferedWriter(new FileWriter("src/Output.txt"));
		int times = sc.nextInt();
		for(int i = 0; i< times; i++){
			int L = sc.nextInt();
			int N = sc.nextInt();
			int M= sc.nextInt();
			int D = sc.nextInt();
		}

	}

}
