
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

	public int[] separaDigito(int quantNumero, int posicao) {
		// 1000000000 a 9999999999
		this.tamanhoArray = quantNumero;
		arrayNum = geraNum.geraNumeros(quantNumero);
		String[] AUX = new String[quantNumero];

		// for (int j = 9; j >= 0 ;j--){
		// }

		for (int i = 0; i < quantNumero; i++) {

			System.out.println(arrayNum[i].charAt(posicao));
			AUX[i] = Character.toString(arrayNum[i].charAt(posicao));

		}
		// Armazenar os valores em um array e ordenar aqui!!!

		if (posicao == 0) {
			this.aOrdenar0 = AUX;
		}
		if (posicao == 1) {
			this.aOrdenar0 = AUX;
		}
		if (posicao == 2) {
			this.aOrdenar0 = AUX;
		}
		if (posicao == 3) {
			this.aOrdenar0 = AUX;
		}
		if (posicao == 4) {
			this.aOrdenar0 = AUX;
		}
		if (posicao == 5) {
			this.aOrdenar0 = AUX;
		}
		if (posicao == 6) {
			this.aOrdenar0 = AUX;
		}
		if (posicao == 7) {
			this.aOrdenar0 = AUX;
		}
		if (posicao == 8) {
			this.aOrdenar0 = AUX;
		}
		if (posicao == 9) {
			this.aOrdenar0 = AUX;
		}

		return null;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RadixSortido ex = new RadixSortido();
		ex.separaDigito(20, 9);
		// System.out.println(ex.aOrdenar[0]);
	}

}
