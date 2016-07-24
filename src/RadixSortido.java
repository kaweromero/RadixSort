
public class RadixSortido {

	NumeroAleatorio geraNum = new NumeroAleatorio();
	int tamanhoArray = 0;
	String[] arrayNum = new String[tamanhoArray];
	String[] aOrdenar0 = new String[tamanhoArray];
	String[] aOrdenar1 = new String[tamanhoArray];
	String[] aOrdenar2 = new String[tamanhoArray];
	String[] aOrdenar3 = new String[tamanhoArray];
	String[] aOrdenar4 = new String[tamanhoArray];
	String[] aOrdenar5 = new String[tamanhoArray];
	String[] aOrdenar6 = new String[tamanhoArray];
	String[] aOrdenar7 = new String[tamanhoArray];
	String[] aOrdenar8 = new String[tamanhoArray];
	String[] aOrdenar9 = new String[tamanhoArray];

	public int[] separaDigito(int quantNumero) {
		// 1000000000 a 9999999999
		this.tamanhoArray = quantNumero;
		arrayNum = geraNum.geraNumeros(quantNumero);
		
		
		for (int posicao= 9; posicao >= 0; posicao--) {
			String[] AUX = new String[quantNumero];

			for (int i = 0; i < quantNumero; i++) {

				System.out.println(arrayNum[i].charAt(posicao));
				AUX[i] = Character.toString(arrayNum[i].charAt(posicao));

			}
			// Armazenar os valores em um array e ordenar aqui!!!

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
		
		//System.out.println("HUE1 "+ex.aOrdenar8[3]);
		//System.out.println("HUE2 "+ex.aOrdenar8[4]);
	}

}
