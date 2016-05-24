package Qs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class High_sec {
	public static void main(String args[]) throws IOException{
		Scanner sc = new Scanner(new File("src/high_security.txt"));
		BufferedWriter br = new BufferedWriter(new FileWriter("src/price.in"));
		int times = sc.nextInt();

		for(int i = 0; i< times; i++){
			int size = sc.nextInt();
			sc.nextLine();
			String str1 = sc.nextLine();
			String str2 = sc.nextLine();

			int arr[][] = new int[size+2][2];
			arr[0][0] = 1;
			arr[0][1] = 1;
			arr[size+1][0] = 1;
			arr[size+1][1] = 1;

			for(int j = 1; j<= size;j++){
				if (str1.charAt(j-1) == '.'){
					arr[j][0] = 0;
				}
				else{
					arr[j][0] = 1;
				}

				if (str2.charAt(j-1) == '.'){
					arr[j][1] = 0;
				}
				else{
					arr[j][1] = 1;
				}
			}

			int head = 0;
			int tail = 0;


			int count = 0;

			while(head < size  || tail < size ){
				for(int l = 0; l<size+2;l++){
					System.out.print(arr[l][0]);
				}
				System.out.println();
				for(int l = 0; l<size+2;l++){
					System.out.print(arr[l][1]);
				}
				System.out.println();
				System.out.println(count);
				//System.out.println(head+ " " + tail);

				while(arr[head+1][0] == 1 && arr[head][0] == 1 && head+1 < size ){
					head++;
				}
				while(arr[tail+1][1] == 1 && arr[tail][1] == 1 && tail+1< size){
					tail++;
				}

				if (head < size ){
					
					if(arr[head+2][0] == 1 && arr[head+1][1] == 0 && arr[head][1] == 1 && arr[head+2][1] == 1){

						arr[head+1][0] = 1;
						arr[head+1][1] = 1;
						count++;
						head+=2;
						if(head > size){
							head = size;
						}
					}
					else if(arr[head+2][0] == 1 && arr[head][1] == 1 && arr[head+1][1] == 1 && arr[head+2][1] == 1){

						arr[head+1][0] = 1;
						arr[head+1][1] = 1;
						count++;
						head+=2;
						if(head > size){
							head = size;
						}
					}

					else if(arr[head+2][0] == 1){
						head+=2;
						if(head > size){
							head = size;
						}
					}

					else if(arr[head+2][0] == 0){

						if(arr[head+3][0] == 1){
							arr[head+1][0] = 1;
							arr[head+2][0] = 1;
							count ++;
							head+=3;

							if(head > size){
								head = size;
							}
						}

						else{
							int gcount = 0;
							while(arr[head+2][0] == 0){
								if(arr[head][1] == 1 && arr[head+1][1] == 0 && arr[head+2][1] == 1){
									gcount += 1;
									arr[head+1][1] = 1;
								}
								arr[head][0] = 1;
								arr[head+1][0] = 1;
								head++; 
							}

							arr[head+1][0] = 1;
							head+=2;

							if(head > size){
								head = size;
							}

							if(gcount == 0){
								count ++;
							}
							else {
								count += gcount;
							}
						}
					}

				}
				
				if (tail < size ){
					if(arr[tail+1][1] ==0){
						if(arr[tail+2][1] == 1 && arr[tail+1][0] == 0 && arr[tail][0] == 1 && arr[tail+2][0] == 1){
							arr[tail+1][0] = 1;
							arr[tail+1][1] = 1;
							count++;
							tail+= 2;
							if(tail > size){
								tail = size;
							}
						}
						else if(arr[tail+2][1] == 1 && arr[tail][0] == 1 && arr[tail+1][0] == 1 && arr[tail+2][0] == 1){

							arr[tail+1][0] = 1;
							arr[tail+1][1] = 1;
							count++;
							tail+=2;
							if(tail > size){
								tail = size;
							}
						}


						else if(arr[tail+2][1] == 1){
							tail+=2;
							if(tail > size){
								tail = size;
							}
						}

						else if(arr[tail+2][1] == 0){
							//System.out.println(arr[tail+2][1]);
							if(arr[tail+3][1] == 1){
								arr[tail+1][1] = 1;
								arr[tail+2][1] = 1;
								count ++;
								tail+=3;

								if(tail > size){
									tail = size;
								}
							}

							else{
								int gcount = 0;
								while(arr[tail+2][1] == 0){
									if(arr[tail][0] == 1 && arr[tail+1][0] == 0 && arr[tail+2][0] == 1){
										gcount += 1;
										arr[tail+1][0] = 1;
									}
									arr[tail][1] = 1;
									tail++; 
								}
								arr[tail][1] = 1;
								arr[tail+1][1] = 1;
								tail+=2;

								if(tail > size){
									tail = size;
								}

								if(gcount == 0){
									count ++;
								}
								else {
									count += gcount;
								}
							}
						}

					}
				}
				boolean exit =true;
				for(int l = 0; l<size+2;l++){
					if(arr[l][0] == 0) exit =false;
				}
				for(int l = 0; l<size+2;l++){
					if(arr[l][1] == 0) exit =false;
				}
				if (exit){
					head= Integer.MAX_VALUE;
					tail = Integer.MAX_VALUE;
				}

			}
			br.write("Case #" +  (i + 1) + ": " + count);
			br.newLine();
		}		
		br.close();
	}
}
