import java.lang.reflect.Array;
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
		1. Realize uma an�lise experimental relativa a varia��es do algoritmo de ordena��o Radix sort.
		Considere o TEMPO DE EXECU��O (em nanosegundos) como vari�vel dependente (vari�vel
		resposta do experimento) e os seguintes aspectos como vari�veis independentes (fatores do
		experimento):

		a. ALGORITMO AUXILIAR DO RADIX SORT:

		i. Bubble sort;
		ii. Insertion sort;
		iii. Merge sort;
		iv. Counting sort.
		
		b. TIPO DE VETOR DE ENTRADA:

		i. Vetor com elementos ordenados de maneira crescente;
		ii. Vetor com elementos ordenados de maneira decrescente;
		iii. Vetor com elementos aleat�rios.
		
		c. TAMANHO DO VETOR DE ENTRADA (n):

		i. 20;
		ii. 200;
		iii. 2000.

		Dados os fatores e n�veis anteriormente detalhados, tem-se 36 tratamentos, devendo ser
		realizadas 100 repeti��es para cada, totalizando 3.600 ensaios. Apresente os resultados
		(m�dia das 100 execu��es para cada tratamento) de forma gr�fica (sugest�o: utilizar o Excel)
		e comente tais resultados com base na complexidade dos algoritmos auxiliares utilizados.

		Observa��es:

		* O experimento deve ser executado utilizando Java (sem necessidade de interface gr�fica), fazendo-
		se uso do m�todo System.nanoTime().
		* Os elementos a serem ordenados devem ser n�meros inteiros entre 1000000000 e 9999999999.
		*N�o se deve criar arrays aleat�rios distintos como entrada para cada algoritmo. Os arrays devem
		ser os mesmos para realizar a compara��o.
		*Deve-se atentar para n�o passar como entrada de um algoritmo a sa�da de outro algoritmo (pois,
		neste caso, a entrada sempre estar� ordenada).
*/
		this.tamanhoArray = quantNumero;
		arrayNum = geraNum.geraNumeros(quantNumero);

		for (int posicao = 9; posicao >= 0; posicao--) {
			int[] AUX = new int[quantNumero];

			for (int i = 0; i < quantNumero; i++) {

				// System.out.println(arrayNum[i].charAt(posicao));
				AUX[i] = Integer.parseInt(Character.toString(arrayNum[i].charAt(posicao)));

			}
			//Separa os digitos em arrays diferentes. A ideia � ordenar cada um separadamente e depois juntar

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
