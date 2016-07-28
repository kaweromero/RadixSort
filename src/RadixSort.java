
import java.util.Arrays;

public class RadixSort {

    // Main function to test performance sorting 1 million integers.
    // Results in about 220 ms on a 2.3 Ghz Core i5 processor w/4GB 1333 Mhz RAM
    public static void main(String[] args){
    	
        final int SIZE = 10;

      //  Random r = new Random();
        long[] test = new long[SIZE];
        long[] teste = new long[SIZE];
        
        test = NumeroAleatorio.geraNumeros(10);

      //  for (int i = 0; i < SIZE; i++){
        //    test[i] = r.nextInt(Integer.MAX_VALUE);
       // }

        long start = System.currentTimeMillis();
        teste = sortCounting(test);
        long end = System.currentTimeMillis();

        System.out.println("Ordenado-----");
        for (long i : teste){
            System.out.println(i);
        }

        System.out.println(end-start);
        
        teste = sortInsertion(test);
        for (long i : teste){
            System.out.println(i);
        }
        
    }


    public static long[] sortCounting(long[] input){

      
        for(int place=1; place <= 1000000000; place *= 10){
        
            input = countingSort(input, place);
        }

        return input;
    }
    
    public static long[] sortInsertion(long[] input){

        // Largest place for a 32-bit int is the 1 billion's place
        for(int place=1; place <= 1000000000; place *= 10){
            // Use counting sort at each digit's place
            input = insertionSort(input, place);
        }

        return input;
    }

    private static long[] countingSort(long[] input, int place){
        long[] out = new long[input.length];
        int[] count = new int[10];
        
        for(int i=0; i < input.length; i++){
            int digit = getDigit(input[i], place);
            count[digit] += 1;
        }

        for(int i=1; i < count.length; i++){
            count[i] += count[i-1];
        }

        for(int i = input.length-1; i >= 0; i--){
            int digit = getDigit(input[i], place);

            out[count[digit]-1] = input[i];
            count[digit]--;
        }

        return out;

    }
    
	public static long[] insertionSort(long[] array, int place) {
		int x = 0;
		int y = 0;
		
		for (int i = 0; i < array.length; i++) {
			int digit = getDigit(array[i], place);
			long a = array[i];
			y++;
			for (int j = i - 1; j >= 0 && getDigit(array[j], place) > digit; j--, x++) {			
				//int digit2 = getDigit(array[j], place);
				
				array[j + 1] = array[j];
				array[j] = a;

			}
		}
		System.out.println(Arrays.toString(array));
		System.out.println("Trocas: " + x + "  Iterações: " + y);

		return array;
	}

	private static void bubbleSort(long[] array,int place) {

//FALTA AQUI
		int n = array.length;
		long temp = 0;
		//int digit = getDigit(array[i], place);
		
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {

				if (array[j - 1] > array[j]) {
					// swap the elements!
					temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}

			}
		}

	}
	
    private static int getDigit(long value, int digitPlace){
        return (int) ((value/digitPlace ) % 10);
    }

}