package Qs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Price {
	public static void main(String args[]) throws FileNotFoundException{
	    Scanner sc = new Scanner(new File("/src/price.in"));
		int times = sc.nextInt();

		for(int i = 0; i< times; i++ ){
			int siz = sc.nextInt();
			int bound = sc.nextInt();

			int[] data = new int[siz];

			for(int j = 0;j< siz;j++){
				data[j] = sc.nextInt();
			}

			int head = 0; 
			int tail = -1;
			int count = 0;
			int sum = 0;

			for(int j = 0; j< siz;j++){
				tail++;
				sum += data[tail];
				if(sum <= bound){
					count += tail-head+1;
				}
				
				else{
					while(sum > bound && head <= tail){
						
						sum -= data[head];
						head++;
					}
					if(sum>0){
						count += tail-head+1;
					}
				}
				//System.out.println(head);
			}

			System.out.println("Case #" + (i + 1) + ": " +  count);


		}

	}
}
