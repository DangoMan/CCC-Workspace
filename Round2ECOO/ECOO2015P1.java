import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ECOO2015P1 {
	static void encode(String str){
		String[] sArray=str.split(" ");
		int n=sArray.length;
		int[] sLength=new int[n];
		for(int i=0;i<n;i++){
			sLength[i]=sArray[i].length();
		}
		String anstmp="";
		boolean empty=false;
		while(!empty){
			empty=true;
			for(int i=0;i<n;i++){
				if (!sArray[i].isEmpty()){
					empty=false;
					anstmp+=sArray[i].charAt(0);
					sArray[i]=sArray[i].substring(1);
				}
			}
		}
		for(int i=0,k=0;i<n;i++){
			for(int j=0;j<sLength[i];j++){
				System.out.print(anstmp.charAt(k));
				k++;
			}
			System.out.print(" ");
		}
		System.out.println();
	}
	static void decode(String str){
		String[] sArray=str.split(" ");
		int n=sArray.length;
		int[] sLength=new int[n];
		int[] sLtmp=new int [n];
		String stmp="";
		for(int i=0;i<n;i++){
			sLength[i]=sArray[i].length();
			sLtmp[i]=0;
			stmp+=sArray[i];
			sArray[i]="";
		}
		//System.out.println(stmp);
		boolean full=false;
		int k=0;
		while(!full){
			full=true;
			for(int i=0;i<n;i++){
				if (sLtmp[i]<sLength[i]){
					full=false;
					sArray[i]+=stmp.charAt(k);
					k++;sLtmp[i]++;
				}
			}
		}
		for(int i=0;i<n;i++){
			System.out.print(sArray[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("DATA11.txt"));
		while(scan.hasNext()){
			String stmp=scan.nextLine();
			if(stmp.equals("encode")){
				encode(scan.nextLine());
			}else if(stmp.equals("decode")){
				decode(scan.nextLine());
			}
		}
	}
}
