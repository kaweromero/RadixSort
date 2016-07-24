

import java.util.Arrays;

public class InsertionSort {

	public static void insertionSort(int [] array) {  
		int x =0;
		int y = 0;
		for (int i = 0; i < array.length; i++)  {  
			
			int a = array[i];  
			y++;
			for (int j = i - 1; j >= 0 && array[j] > a; j--,x++) {  
				array[j + 1] = array[j];  
				array[j] = a; 
				
			}                         
		}  
		System.out.println(Arrays.toString(array));
		System.out.println("Trocas: "+x+ "  Iterações: "+y);
	} 
	
	
}
