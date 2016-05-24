package Qs;

import java.io.*;
import java.util.Scanner;

public class Boomerang_const {
	public static void main(String args[]) throws IOException{
		Scanner sc = new Scanner(new File("src/Boomerang_Constellations.txt"));
		BufferedWriter br = new BufferedWriter(new FileWriter("src/Output.txt"));
		int times = sc.nextInt();

		for(int i = 0; i< times; i++){
			int numbers = sc.nextInt();
			int [][] boom = new int [numbers][2];
			int count = 0;

			for(int j = 0 ; j< numbers; j++){
				boom [j] [0] = sc.nextInt();
				boom [j] [1] = sc.nextInt();
			}

			for(int j = 0 ; j< numbers; j++){
				double solutions [] = new double[numbers];

				for (int k = 0; k <numbers; k++){
					solutions[k] = Math.sqrt((boom[j][0] - boom[k][0])*(boom[j][0] - boom[k][0]) + (boom[j][1] - boom[k][1])*(boom[j][1] - boom[k][1]));
					if(k==j){
						solutions[k] = Integer.MIN_VALUE;
					}
					//System.out.println(solutions[k]);
				}

				for (int k = 0; k <numbers; k++){
					for(int l = k+1; l<numbers;l++){
						//System.out.println(solutions[k]);
						//System.out.println(solutions[l]);
						if(solutions[k] == solutions[l]){
							count++;
						}
					}
				}
				//System.out.println();
			}
			br.write("Case #" +  (i + 1) + ": " + count);
			br.newLine();
		}		
		br.close();
	}
}
