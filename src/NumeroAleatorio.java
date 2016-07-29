
public class NumeroAleatorio {

	// Gera um número aleatorio de 1000000000 a 9999999999
	public static long[] geraNumeros(int quantNumeros) {

		long[] array = new long[quantNumeros];
		//String[] array = new String[quantNumeros];

		long number = 0;

		for (int i = 0; i < quantNumeros; i++) {

			array[i] = number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
			//array[i] = Long.toString(number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L);
			//System.out.println(number);
		}

		return array;
	}
}
