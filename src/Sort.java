import java.util.Arrays;
import java.util.Random;
import java.io.*;

/**
 * 
 * @author Franklin
 *
 */

public class Sort {
	
	/**
	 * BubleSort
	 * 
	 * @param array
	 */
	
	public static void BubbleSort (int[]array) {
		
		int temp;
		boolean swapped = false;
		
		do {
			
			swapped = false;
			
			for(int i= 0; i < array.length - 1; i++) {
			
				if(array[i] > array[i+1]) {
				
					temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
					swapped = true;
				
				}
			}
		}while (swapped);
	}
	
	/**
	 * InsertionSort
	 * 
	 * @param array
	 */
	
	public static void InsertionSort (int[]array) {
		
		int index, temp;
		
		for(int i= 1; i < array.length; i++) {
			
			index = i;
			temp = array[i];
			
			while(index > 0 && temp < array [index - 1]) {
				
				array[index] = array[index - 1];
				index -= 1;
				
			}
			array[index] = temp;
		}
	}
	
	/**
	 * MergeSort
	 * 
	 * @param array
	 * @return
	 */
	
	public static int[] MergeSort (int[]array) {
		
		int size = array.length;
		
		if(size > 1) {
			
			int size_par = size / 2;
			int[]a_1 = new int [size_par];
			int[]a_2 = new int [size - size_par];
			
			for(int i = 0; i < size_par; i++) 
				a_1[i] = array[i];
			for(int i = size_par; i < size; i++) 
				a_2[i - size_par] = array[i];
			
			a_1 = MergeSort(a_1);
			a_2 = MergeSort(a_2);
			
			array = Merge_1(a_1, a_2);
		}
		
		return array;
			
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
	
	/**
	 * QuickSort
	 * 
	 * @param array
	 * @param index
	 * @return
	 */
	
	public static int[] QuickSort(int[] array, int index){
		
		if(index > 0)
		{	
			int pivot = array[0];

			int index_less = 0, index_greater = 0, index_result = 0;
			int[] less_array = new int[array.length];
			int[] greater_array = new int[array.length];
			int[] result = new int[array.length];
			
			for(int i = 1; i < index; i++) {
				
				if(array[i] < pivot) {
					
					less_array[index_less] = array[i];
					index_less += 1;
					
				}else {
					
					greater_array[index_greater] = array[i];
					index_greater += 1;
			
				}
			}
			
			less_array = QuickSort(less_array, index_less);
			greater_array = QuickSort(greater_array, index_greater);
			
			result[0] = pivot;
			index_result += 1;
			System.out.println(">> " + Arrays.toString(result));
			for(int i = 0; i < index_less; i++)
			{
				result[index_result] = less_array[i];
				index_result += 1;
			}

			for(int i = 0; i < index_greater; i++)
			{
				result[index_result] = greater_array[i];
				index_result += 1;
			}
			System.out.println(Arrays.toString(result));
			System.out.println();
			return result;
		}
		else 
			
			return array;
	}
	
	/**
	 * BinarySearch
	 * 
	 * @param array
	 * @param value
	 * @param lowerBound
	 * @param upperBound
	 * @return
	 */
	public static int BinarySearch(int[] array, int value, int lowerBound, int upperBound)
	{
		int middle = (lowerBound + upperBound) / 2;
		
		Arrays.sort(array);
		
		if(lowerBound > upperBound)
			return -1;
		else	
			if(array[middle] == value)
				return middle;
			else
				if(value < array[middle])
					return BinarySearch(array, value, lowerBound, middle - 1);
				else
					return BinarySearch(array, value, middle + 1, upperBound);
	}

	/**
	 * 
	 * @param array
	 */
	public static void printArray(int[] array) {
		
		try
		{
			BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );

			for(int i = 0; i < array.length; i++)
				bw.write(array[i] + ",");

			bw.write("\n");
			bw.flush();
			bw.close();
		}
		catch(Exception ex) {}		
	}
	
	public static void printArray(double[] array)
	{
		try
		{
			BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );

			for(int i = 0; i < array.length; i++)
				//bw.write(array[i] + ",");
				//bw.write(array[i] +"");
				System.out.println((int) array[i] + "");

			bw.write("\n");
			bw.flush();
			bw.close();
		}
		catch(Exception ex) {}
	}
	
	/**
	 * 
	 * @param experiments
	 * @param array_sizes
	 */
	public static void run_experiments(int experiments, int[] array_sizes)
	{
		int[] array_data = null;

		double time_start = 0.0, time_end = 0.0;
		double[] time_results = new double[experiments];

		for(int m = 0; m < array_sizes.length; m++)
		{
			array_data = GenerateArrays( array_sizes[m] );
			for(int i = 0; i < experiments; i++)
			{
				time_start = System.nanoTime();
				//QuickSort(array_data, array_data.length);
				MergeSort(array_data);
				time_end = System.nanoTime();

				time_results[i] = ((time_end - time_start));
			}

			printArray(time_results);
		}
	}
	
	/**
	 * 
	 * @param Size
	 * @return
	 */
	public static int[] GenerateArrays(int Size) {
		
		int Array[] = new int [Size];
		
		Random rd = new Random();
		for(int i = 0; i < Size; i++)
			Array[i] = rd.nextInt(Size);
		
		return Array;
		
	}
	
	public static void main(String[] args) {
		
		System.gc();

		try
		{
			BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
			BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
			
			//int[] array = GenerateArrays(20);
			//printArray(array);
			int[] array = {5,2,7,3,1,8,2,6,9};
			
			//BubbleSort(array);
			//InsertionSort(array);
			//System.out.print(">> ");
			//printArray(MergeSort(array));
			printArray(QuickSort(array,array.length));
			//printArray(array);
			
			
			//bw.write(BinarySearch(array, 9, 0, array.length - 1) + "\n" );
			//bw.flush();
			
			/**int experiments = 0;
			int[] array_sizes = null;
			String[] sizes = null;

			bw.write("Defina la cantidad de experimentos: ");
			bw.flush();
			experiments = Integer.parseInt( br.readLine() );

			bw.write("Ingrese los tamanios de los arreglos (separados por coma y sin espacio): ");
			bw.flush();
			sizes = br.readLine().split(",");
			
			array_sizes = new int[sizes.length];
			for(int i = 0; i < sizes.length; i++)
				array_sizes[i] = Integer.parseInt( sizes[i] );

			run_experiments(experiments, array_sizes);
			**/
		}
		catch(Exception ex) {}

	}

}
