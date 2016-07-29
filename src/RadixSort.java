
import java.util.Arrays;

import javax.swing.JOptionPane;

public class RadixSort {

	public static void main(String[] args) {
		
		int SIZE = 0;
		try{
		SIZE=Integer.parseInt(JOptionPane.showInputDialog("Insira o tamanho da entrada com 20,200 ou 2000!"));
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Insira os valores corretamente");
		}
		long[] arrayNumeros = new long[SIZE];
		long[] auxiliar = new long[SIZE];
		long[] arrayParametro = new long[SIZE];

		arrayNumeros = NumeroAleatorio.geraNumeros(SIZE);
		
		///////////////////////////////////////
		arrayParametro = arrayNumeros.clone();
		 System.out.println("Array antes counting: "+Arrays.toString(arrayParametro));
		//
		 auxiliar =sortCounting(arrayParametro);
		//
		System.out.println("Array depois counting: "+Arrays.toString(auxiliar));

		System.out.println();
		////////////////////////////////////////
		arrayParametro = arrayNumeros.clone();
		System.out.println("Array antes insertion: "+Arrays.toString(arrayParametro));
		//
		auxiliar = sortInsertion(arrayParametro);
		//
		System.out.println("Array depois insertion: "+Arrays.toString(auxiliar));

		System.out.println();
		/////////////////////////////////////////
		arrayParametro = arrayNumeros.clone();
		System.out.println("Array antes Bubble: "+Arrays.toString(arrayParametro));
		//
		auxiliar = sortBubble(arrayParametro);
		//
		System.out.println("Array depois bubble:"+Arrays.toString(arrayParametro));

		System.out.println();
		////////////////////////////////////////////
		arrayParametro = arrayNumeros.clone();
		System.out.println("Array antes merge: "+Arrays.toString(arrayParametro));
		//
		auxiliar = sortMerge(arrayParametro);
		//
		System.out.println("Array depois merge: "+Arrays.toString(arrayParametro));

		
	}

	public static long[] sortCounting(long[] input) {
		long tempoTotal=0;
		
		for (int i = 0; i < 100; i++) {//100 ensaios
			long startCounting = System.nanoTime();
			for (int place = 1; place <= 1000000000; place *= 10) {
				input = countingSort(input, place);
			}
			long endCounting = System.nanoTime();
			tempoTotal= tempoTotal + (endCounting - startCounting);//Vai somando o tempo
		}
		System.out.println("Tempo m�dio Counting: "+ tempoTotal/100 );//Calcula a m�dia dos 100 ensaios
		return input;
	}

	public static long[] sortInsertion(long[] input) {
		long tempoTotal=0;
		
		for (int i = 0; i < 100; i++) {
			long startCounting = System.nanoTime();
			for (int place = 1; place <= 1000000000; place *= 10) {
				input = insertionSort(input, place);
			}
			long endCounting = System.nanoTime();
			tempoTotal= tempoTotal + (endCounting - startCounting);
		}
		System.out.println("Tempo m�dio Insertion: "+ tempoTotal/100 );
		return input;
	}

	public static long[] sortBubble(long[] input) {
		long tempoTotal=0;
		
		for(int i=0;i<100;i++){
			long startCounting = System.nanoTime();
			for (int place = 1; place <= 1000000000; place *= 10) {
				input = bubbleSort(input, place);
			}
			long endCounting = System.nanoTime();
			tempoTotal= tempoTotal + (endCounting - startCounting);
		}
		System.out.println("Tempo m�dio Bubble: "+ tempoTotal/100 );
		return input;
	}

	public static long[] sortMerge(long[] input) {
		long tempoTotal=0;
		
		for(int i=0;i<100;i++){
			long startCounting = System.nanoTime();
			for (int place = 1; place <= 1000000000; place *= 10) {
				input = mergeSort(input, 0, input.length - 1, place);
			}
			long endCounting = System.nanoTime();
			tempoTotal= tempoTotal + (endCounting - startCounting);
		}
		System.out.println("Tempo m�dio Merge: "+ tempoTotal/100 );
		return input;
	}

	private static long[] countingSort(long[] input, int place) {
		long[] out = new long[input.length];
		int[] count = new int[10];

		for (int i = 0; i < input.length; i++) {
			int digit = getDigit(input[i], place);
			count[digit] += 1;
		}

		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		for (int i = input.length - 1; i >= 0; i--) {
			int digit = getDigit(input[i], place);

			out[count[digit] - 1] = input[i];
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

				array[j + 1] = array[j];
				array[j] = a;

			}
		}
		// System.out.println(Arrays.toString(array));
		// System.out.println("Trocas: " + x + " Itera��es: " + y);

		return array;
	}

	private static long[] bubbleSort(long[] array, int place) {

		int n = array.length;
		long temp = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {

				if (getDigit(array[j - 1], place) > getDigit(array[j], place)) {
					temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}

			}
		}
		return array;
	}

	public static long[] mergeSort(long array[], int inicio, int fim, int place) {

		if (inicio < fim) {

			int meio = ((inicio + fim) / 2);
			mergeSort(array, inicio, meio, place);
			mergeSort(array, meio + 1, fim, place);
			merge(array, inicio, meio, fim, place);

		}

		return array;
	}

	public static long[] merge(long[] array, int inicio, int meio, int fim, int place) {

		int n1 = meio - inicio + 1;
		int n2 = fim - meio;

		long left[] = new long[n1];
		long right[] = new long[n2];

		for (int i = 0; i < n1; i++) {
			left[i] = array[inicio + i];
		}

		for (int i = 0; i < n2; i++) {
			right[i] = array[meio + i + 1];
		}

		// left[n1] = INFINITO;
		// right[n2] = INFINITO;

		int i = 0;
		int j = 0;
		int x = inicio;

		// for (int x = inicio; x <= fim; x++) {
		while (i < n1 && j < n2) {

			// System.out.println("Array left> "+Arrays.toString(left));
			if (getDigit(left[i], place) <= (getDigit(right[j], place))) {
				array[x] = left[i];
				i++;
			} else {
				array[x] = right[j];
				j++;
			}
			x++;
		}

		while (i < n1) {
			array[x] = left[i];
			i++;
			x++;
		}

		while (j < n2) {
			array[x] = right[j];
			j++;
			x++;
		}

		// System.out.println(Arrays.toString(array));
		return array;
	}

	private static int getDigit(long value, int digitPlace) {
		return (int) ((value / digitPlace) % 10);
	}

}