
import java.awt.Color;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RadixSort extends JFrame {
	private JPanel contentPane;
	static long tempoMedioInsertion=0;
	static long tempoMedioCounting=0;
	static long tempoMedioBubble=0;
	static long tempoMedioMerge=0;
	private JTextField entradaTamanho;
	JPanel panel = new JPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JLabel labelAguarde = new JLabel("SELECIONE A OPÇÃO...");
	
	
	public RadixSort(){
		
		super("GRÁFICOS!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOi = new JLabel("Tamanho da entrada do vetor");
		lblOi.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblOi.setBounds(850, 93, 224, 14);
		contentPane.add(lblOi);
		
		entradaTamanho = new JTextField();
		entradaTamanho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				labelAguarde.setText("SELECIONE A OPÇÃO...");
			}
		});
		entradaTamanho.setBounds(907, 128, 86, 20);
		contentPane.add(entradaTamanho);
		entradaTamanho.setColumns(10);
			
		final JRadioButton botaoOrdenado = new JRadioButton("ORDENADO");
		botaoOrdenado.setBackground(new Color(255, 255, 204));
		buttonGroup.add(botaoOrdenado);
		botaoOrdenado.setFont(new Font("Segoe UI", Font.BOLD, 12));
		botaoOrdenado.setBounds(850, 212, 109, 23);
		contentPane.add(botaoOrdenado);
		
		final JRadioButton botaoDecrescente = new JRadioButton("DECRESCENTE");
		botaoDecrescente.setBackground(new Color(255, 255, 204));
		buttonGroup.add(botaoDecrescente);
		botaoDecrescente.setFont(new Font("Segoe UI", Font.BOLD, 12));
		botaoDecrescente.setBounds(850, 253, 120, 23);
		contentPane.add(botaoDecrescente);
		
		final JRadioButton botaoAleatorio = new JRadioButton("ALE\u00C1TORIO");
		botaoAleatorio.setBackground(new Color(255, 255, 204));
		buttonGroup.add(botaoAleatorio);
		botaoAleatorio.setFont(new Font("Segoe UI", Font.BOLD, 12));
		botaoAleatorio.setBounds(850, 295, 109, 23);
		contentPane.add(botaoAleatorio);
		
		JButton btnGo = new JButton("GO!");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				repaint();
				
				try{
					if(botaoOrdenado.isSelected()){
					
					metodoSupremo(1);
				}
				if(botaoDecrescente.isSelected()){
					
					metodoSupremo(2);
				}
				if(botaoAleatorio.isSelected()){
					
					metodoSupremo(0);
				}
				repaint();
				validate();
				}catch(Exception e){
					JOptionPane.showMessageDialog(null,"Selecione uma opção de entrada. ");
				}
							
			}
		});
		btnGo.setBounds(907, 171, 89, 23);
		contentPane.add(btnGo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(new Color(255, 255, 204));
		panel_1.setBounds(826, 29, 248, 503);
		contentPane.add(panel_1);
		labelAguarde.setForeground(new Color(255, 51, 0));
		
		
		labelAguarde.setFont(new Font("Segoe UI", Font.BOLD, 27));
		labelAguarde.setBounds(282, 526, 534, 36);
		contentPane.add(labelAguarde);
	
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(69, 44, 751, 469);
		
	}
	
	
	public static void main(String[] args) {
		
		RadixSort frame = new RadixSort();
		frame.setVisible(true);
		frame.setResizable(false);
		//frame.metodoSupremo();
		
	}
	
	public void metodoSupremo(int metodoDovetor){
		
		
		int SIZE = 0;
		try{
			SIZE=Integer.parseInt(entradaTamanho.getText());
		//SIZE=Integer.parseInt(JOptionPane.showInputDialog("Insira o tamanho da entrada com 20,200 ou 2000!"));
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Insira os valores corretamente");
			System.exit(0);
		}
		long[] arrayNumeros = new long[SIZE];
		long[] auxiliar = new long[SIZE];
		long[] arrayParametro = new long[SIZE];
		

		arrayNumeros = NumeroAleatorio.geraNumeros(SIZE);
		System.out.println("na hora de criado"+Arrays.toString(arrayNumeros));
		
		if(metodoDovetor == 1){
			
			arrayNumeros=ordenarCounting(arrayNumeros);
			System.out.println("Depois do ordenarCounting"+Arrays.toString(arrayNumeros));
			
		}else{
			if(metodoDovetor == 2){
				arrayNumeros=ordenarInsertionDecrescente(arrayNumeros);
				System.out.println("Depois do Insertion"+Arrays.toString(arrayNumeros));
			}
		}
			
		/*
		 * Para ver os arrays antes e depois de ordenar
		 * Só remover os comentários dos prints
		 * NAO RECOMENDO COM ENTRADAS DE 2000 DE TAMANHO!
		*/
		
		arrayParametro = arrayNumeros.clone();
		// System.out.println("Array antes counting: "+Arrays.toString(arrayParametro));
		//
		 auxiliar =sortCounting(arrayParametro);
		//
		//System.out.println("Array depois counting: "+Arrays.toString(auxiliar));

		System.out.println();
		////////////////////////////////////////
		arrayParametro = arrayNumeros.clone();
		//System.out.println("Array antes insertion: "+Arrays.toString(arrayParametro));
		//
		auxiliar = sortInsertion(arrayParametro);
		//
		//System.out.println("Array depois insertion: "+Arrays.toString(auxiliar));

		System.out.println();
		/////////////////////////////////////////
		arrayParametro = arrayNumeros.clone();
		//System.out.println("Array antes Bubble: "+Arrays.toString(arrayParametro));
		//
		auxiliar = sortBubble(arrayParametro);
		//
		//System.out.println("Array depois bubble:"+Arrays.toString(arrayParametro));

		System.out.println();
		////////////////////////////////////////////
		arrayParametro = arrayNumeros.clone();
		//System.out.println("Array antes merge: "+Arrays.toString(arrayParametro));
		//
		auxiliar = sortMerge(arrayParametro);
		//
		//System.out.println("Array depois merge: "+Arrays.toString(arrayParametro));
		
		//JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(69, 44, 751, 469);
		
		
		DefaultCategoryDataset dpd = new DefaultCategoryDataset();
		dpd.setValue(tempoMedioCounting,"CountingSort","Counting");
		dpd.setValue(tempoMedioInsertion,"InsertionSort","Insertion");
		dpd.setValue(tempoMedioBubble,"BubbleSort","Bubble");
		dpd.setValue(tempoMedioMerge,"MergeSort","Merge");
		
		JFreeChart grafico = ChartFactory.createBarChart3D("GRÁFICO EM BARRA", "Algoritmos de ordenação", "Tempo em nanosegundos", dpd);
				
		ChartPanel chartPanel = new ChartPanel(grafico);
		
		panel.removeAll();
		panel.add(chartPanel);
		contentPane.add(panel);
		panel.repaint();
		contentPane.repaint();
		contentPane.validate();
		labelAguarde.setText("PROCESSO CONCLUIDO!");
		repaint();
		
		
		//frame.setVisible(true);
		
		
	}
	//Só pra ordenar o array inicial
	public static long[] ordenarCounting(long[] array){
		
		for (int place = 1; place <= 1000000000; place *= 10) {
			array = countingSort(array, place);
		}
		
		return array;
	}

	public static long[] ordenarInsertionDecrescente(long[] array){
		
		for (int place = 1; place <= 1000000000; place *= 10) {
			array = insertionDecreSort(array, place);
		}
		
		return array;
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
		tempoMedioCounting= tempoTotal/100;
		
		System.out.println("Tempo médio Counting: "+ tempoTotal/100 );//Calcula a média dos 100 ensaios
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
		tempoMedioInsertion= tempoTotal/100;
		System.out.println("Tempo médio Insertion: "+ tempoTotal/100 );
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
		tempoMedioBubble= tempoTotal/100;
		System.out.println("Tempo médio Bubble: "+ tempoTotal/100 );
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
		tempoMedioMerge= tempoTotal/100;
		System.out.println("Tempo médio Merge: "+ tempoTotal/100 );
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
		// System.out.println("Trocas: " + x + " Iterações: " + y);

		return array;
	}
	
	public static long[] insertionDecreSort(long[] array, int place) {
		int x = 0;
		int y = 0;

		for (int i = 0; i < array.length; i++) {
			int digit = getDigit(array[i], place);
			long a = array[i];
			y++;
			for (int j = i - 1; j >= 0 && getDigit(array[j], place) < digit; j--, x++) {

				array[j + 1] = array[j];
				array[j] = a;

			}
		}

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