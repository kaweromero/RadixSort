import java.util.Random;

public class NumeroAleatorio {

	/*public static void main(String[] args) {

		String[] array = null;
		array = geraNumeros(10);

		for (int i = 0; i < 10; i++) {

			System.out.println(array[i]);
		}
	}*/

	public static String[] geraNumeros(int quantNumeros) {

		String[] array = new String[quantNumeros];

		long number = 0;

		for (int i = 0; i < quantNumeros; i++) {

			array[i] = Long.toString(number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L);
			 System.out.println(number);
		}

		return array;
	}
}
