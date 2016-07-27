
import java.util.Random;

public class RadixSort {

    // Main function to test performance sorting 1 million integers.
    // Results in about 220 ms on a 2.3 Ghz Core i5 processor w/4GB 1333 Mhz RAM
    public static void main(String[] args){
    	
        final int SIZE = 10;

      //  Random r = new Random();
        long[] test = new long[SIZE];
        
        test = NumeroAleatorio.geraNumeros(10);

      //  for (int i = 0; i < SIZE; i++){
        //    test[i] = r.nextInt(Integer.MAX_VALUE);
       // }

        long start = System.currentTimeMillis();
        test = sort(test);
        long end = System.currentTimeMillis();

        System.out.println("Ordenado-----");
        for (long i : test){
            System.out.println(i);
        }

        System.out.println(end-start);
    }

    // Sort the numbers beginning with least-significant digit
    public static long[] sort(long[] input){

        // Largest place for a 32-bit int is the 1 billion's place
        for(int place=1; place <= 1000000000; place *= 10){
            // Use counting sort at each digit's place
            input = countingSort(input, place);
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

    private static int getDigit(long value, int digitPlace){
        return (int) ((value/digitPlace ) % 10);
    }

}