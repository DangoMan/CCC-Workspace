package Round2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Coding_contest {

	public static void main(String args[]) throws IOException{
		Scanner sc = new Scanner(new File("src/test.txt"));
		BufferedWriter br = new BufferedWriter(new FileWriter("src/Output.txt"));
		int times = sc.nextInt();

		for(int i = 0; i< times; i++){
			int n = sc.nextInt();
			int counter = 0;

			int[] data= new int[n];
			for(int j = 0;j<n;j++){
				data[j] = sc.nextInt();
			}
			int j = 0;
			int list_seq = 1;
			for(; j< n-1;j++){
				if(list_seq == 4 && j < n-2){
					list_seq = 1;
					j++;
				}
				
				if(data[j+1] == data[j]){
					counter += 4 - list_seq;
					list_seq = 1;
				}
				
				else{
					boolean ischeck =false;
					
					
					for(int l = 1; l <= 4-list_seq;l++){
						if(data[j+1] - data[j]<= 10* l){
							list_seq += l;
							counter += l-1;
							l += 10;
							ischeck = true;
						}

					}
					
					if(!ischeck&& j !=n-1){
						counter += 4- list_seq;
						list_seq = 1;
					}

				}
			}
			System.out.println();
			counter+= 4-list_seq;

			br.write("Case #" +  (i + 1) + ": " + counter);
			br.newLine();
		}		
		br.close();
	}
}
