import java.util.Arrays;

public class RadixSortido {

	NumeroAleatorio geraNum = new NumeroAleatorio();
	int tamanhoArray = 0;
	String[] arrayNum = new String[tamanhoArray];
	int[] aOrdenar0 = new int[tamanhoArray];
	int[] aOrdenar1 = new int[tamanhoArray];
	int[] aOrdenar2 = new int[tamanhoArray];
	int[] aOrdenar3 = new int[tamanhoArray];
	int[] aOrdenar4 = new int[tamanhoArray];
	int[] aOrdenar5 = new int[tamanhoArray];
	int[] aOrdenar6 = new int[tamanhoArray];
	int[] aOrdenar7 = new int[tamanhoArray];
	int[] aOrdenar8 = new int[tamanhoArray];
	int[] aOrdenar9 = new int[tamanhoArray];

	public int[] separaDigito(int quantNumero) {
		// 1000000000 a 9999999999
		/*
		 * 1. Realize uma análise experimental relativa a variações do algoritmo
		 * de ordenação Radix sort. Considere o TEMPO DE EXECUÇÃO (em
		 * nanosegundos) como variável dependente (variável resposta do
		 * experimento) e os seguintes aspectos como variáveis independentes
		 * (fatores do experimento):
		 * 
		 * a. ALGORITMO AUXILIAR DO RADIX SORT:
		 * 
		 * i. Bubble sort; ii. Insertion sort; iii. Merge sort; iv. Counting
		 * sort.
		 * 
		 * b. TIPO DE VETOR DE ENTRADA:
		 * 
		 * i. Vetor com elementos ordenados de maneira crescente; ii. Vetor com
		 * elementos ordenados de maneira decrescente; iii. Vetor com elementos
		 * aleatórios.
		 * 
		 * c. TAMANHO DO VETOR DE ENTRADA (n):
		 * 
		 * i. 20; ii. 200; iii. 2000.
		 * 
		 * Dados os fatores e níveis anteriormente detalhados, tem-se 36
		 * tratamentos, devendo ser realizadas 100 repetições para cada,
		 * totalizando 3.600 ensaios. Apresente os resultados (média das 100
		 * execuções para cada tratamento) de forma gráfica (sugestão: utilizar
		 * o Excel) e comente tais resultados com base na complexidade dos
		 * algoritmos auxiliares utilizados.
		 * 
		 * Observações:
		 * 
		 * O experimento deve ser executado utilizando Java (sem necessidade de
		 * interface gráfica), fazendo- se uso do método System.nanoTime(). Os
		 * elementos a serem ordenados devem ser números inteiros entre
		 * 1000000000 e 9999999999. Não se deve criar arrays aleatórios
		 * distintos como entrada para cada algoritmo. Os arrays devem ser os
		 * mesmos para realizar a comparação. Deve-se atentar para não passar
		 * como entrada de um algoritmo a saída de outro algoritmo (pois, neste
		 * caso, a entrada sempre estará ordenada).
		 */
		this.tamanhoArray = quantNumero;
		arrayNum = NumeroAleatorio.geraNumeros(quantNumero);

		for (int posicao = 9; posicao >= 0; posicao--) {
			int[] AUX = new int[quantNumero];

			for (int i = 0; i < quantNumero; i++) {

				// System.out.println(arrayNum[i].charAt(posicao));
				AUX[i] = Integer.parseInt(Character.toString(arrayNum[i].charAt(posicao)));

			}
			// Separa os digitos em arrays diferentes. A ideia é ordenar cada um
			// separadamente e depois juntar

			if (posicao == 0) {
				this.aOrdenar0 = AUX;
			}
			if (posicao == 1) {
				this.aOrdenar1 = AUX;
			}
			if (posicao == 2) {
				this.aOrdenar2 = AUX;
			}
			if (posicao == 3) {
				this.aOrdenar3 = AUX;
			}
			if (posicao == 4) {
				this.aOrdenar4 = AUX;
			}
			if (posicao == 5) {
				this.aOrdenar5 = AUX;
			}
			if (posicao == 6) {
				this.aOrdenar6 = AUX;
			}
			if (posicao == 7) {
				this.aOrdenar7 = AUX;
			}
			if (posicao == 8) {
				this.aOrdenar8 = AUX;
			}
			if (posicao == 9) {
				this.aOrdenar9 = AUX;
			}

		}

		return null;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RadixSortido ex = new RadixSortido();
		ex.separaDigito(5);

		// System.out.println("HUE1 "+ex.aOrdenar8[3]);
		// System.out.println("HUE2 "+ex.aOrdenar8[4]);
		System.out.println(Arrays.toString(ex.aOrdenar0));
		InsertionSort insertion = new InsertionSort();
		ex.aOrdenar0 = insertion.insertionSort(ex.aOrdenar0);
		System.out.println(Arrays.toString(ex.aOrdenar0));
	}

}
