import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author general
 *
 */

public class MergeSort {
	
	public static int[] Merge (int[]a) {
		
		int size = a.length;
		
		if(size > 1) {
			
			int size_par = size / 2;
			int[]a_1 = new int [size_par];
			int[]a_2 = new int [size - size_par];
			
			for(int i = 0; i < size_par; i++) 
				a_1[i] = a[i];
			for(int i = size_par; i < size; i++) 
				a_2[i - size_par] = a[i];
			
			a_1 = Merge(a_1);
			a_2 = Merge(a_2);
			
			a = Merge_1(a_1, a_2);
		}
		
		return a;
			
	}
	public static int[] Merge_1(int[] a_1, int[] a_2) {
		
		int[] resp = new int[a_1.length + a_2.length];
		int index_a_1 = 0, index_a_2 = 0, index = 0;
		
		while(index_a_1 < a_1.length || index_a_2 < a_2.length) {
			
			if(a_1[index_a_1] < a_2[index_a_2]) {
				
				resp[index] = a_1[index_a_1];
				index += 1; index_a_1 +=1;
			
			}else {
				
				resp[index] = a_2[index_a_2];
				index += 1; index_a_2 +=1;
				
			}
			if((index_a_1 + 1 == a_1.length && index_a_2 == a_2.length) || index_a_2 == a_2.length) {
				
				for(int i = index_a_1; i < a_1.length; i++) {
					
					resp[index] = a_1[i];
					index += 1; index_a_1 +=1;
				}
			}else if ((index_a_2 + 1 == a_2.length && index_a_1 == a_1.length) || index_a_1 == a_1.length)  {
				
				for(int i = index_a_2; i < a_2.length; i++) {
					
					resp[index] = a_2[i];
					index += 1; index_a_2 +=1;
				}
			}	
		}
		return resp;
	}
	public static void print(int[]a) {
		
		System.out.println(Arrays.toString(a));		
		
	}
	
	public static int[] Random(int Cant) {
		
		int caden[] = new int [Cant];
		
		for(int i = 0; i < Cant; i++)
			caden[i] = (int) (Math.random() * 100000) + 1;
		
		print(caden);
		return caden;
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		int a[] = Random(sc.nextInt());
		
		int b = 0;
		print(Merge(a));

	}

}
