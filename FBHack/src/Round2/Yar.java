package Round2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Yar {
	public static void main(String args[]) throws IOException{

		Scanner sc = new Scanner(new File("src/yachtzee.txt"));
		BufferedWriter br = new BufferedWriter(new FileWriter("src/Output.txt"));
		int times = sc.nextInt();

		for(int i = 0; i< times; i++){
			int N = sc.nextInt();
			int A = sc.nextInt();
			int B  = sc.nextInt();

			double sum = 0;
			double data[] = new double[N];
			double ave = 0;
			for (int j = 0; j< N;j++){
				data[j] = sc.nextInt();
				sum += data[j];
				ave += data[j]*data[j]/2;

			}

			ave = ave/sum;

			//System.out.println(ave);
			double result = 0; 

			//System.out.println(midint);

			int counter = 0;
			int track = 0;
			while(counter + data[track] < A){
				counter += data[track];
				track ++;
				
				if (track >= N){
					track = 0;
				}
			}

			//Add midpoint 
			if(counter != A){
				counter += data[track];

				result += (data[track] *2 + A - counter)*(counter-A)/2;
				track++;

				if (track >= N){
					track = 0;
				}
			}


			while(counter % sum != 0 && counter + data[track] < B){
				counter += data[track];
				result += (data[track]/2 )*data[track];
				track ++;
				if(counter % sum == 0){
					track = 0;
				}
			}


			if(counter % sum == 0){
				int midint = (int) Math.floor((B-counter)/sum);

				counter += midint*sum;
				result += ave*midint*sum;
				track = 0;
				while(counter + data[track] < B){
					
					counter += data[track];

					result += (data[track]/2 )*data[track];
					track ++;
				}
			}
			

			result += (B - counter)*(B-counter)/2;

			//System.out.println(result);



			if(B-A < sum){
				br.write("Case #" +  (i + 1) + ": " + (A+B)/2);
				br.newLine();
			}

			else{
				result = result/(B-A);

				br.write("Case #" +  (i + 1) + ": " + result);
				br.newLine();
			}

		}
		br.close();
	}
}	
