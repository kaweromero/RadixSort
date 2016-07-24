

import java.util.Arrays;

public class MergeSort {

	// static int somatorio = 0;
	private final int INFINITO = Integer.MAX_VALUE;

	public int[] soma(int array[], int inicio, int fim) {

		if (inicio < fim) {

			int meio = ((inicio + fim) / 2);
			soma(array, inicio, meio);
			soma(array, meio + 1, fim);
			intercala(array, inicio, meio, fim);

		}

		return array;
	}

	public int[] intercala(int[] array, int inicio, int meio, int fim) {

		int n1 = meio - inicio + 1;
		int n2 = fim - meio;

		int left[] = new int[n1 + 1];
		int right[] = new int[n2 + 1];

		for (int i = 0; i < n1; i++) {
			left[i] = array[inicio + i];
		}

		for (int i = 0; i < n2; i++) {
			right[i] = array[meio + i + 1];
		}

		left[n1] = INFINITO;
		right[n2] = INFINITO;

		int i = 0;
		int j = 0;

		for (int x = inicio; x <= fim; x++) {
			if (left[i] <= right[j]) {
				array[x] = left[i];
				i++;
			} else {
				array[x] = right[j];
				j++;
			}
		}
		//System.out.println(Arrays.toString(array));
		return array;
	}

	public static void main(String[] args) {
		MergeSort somax = new MergeSort();

		int array[] = { 2, 3, 1, 5, 4 };
		somax.soma(array, 0, 4);

	}

}
