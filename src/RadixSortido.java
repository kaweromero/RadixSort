
public class RadixSortido {

	
	NumeroAleatorio geraNum = new NumeroAleatorio();
	String[] arrayNum = new String[10];
	
	
	public int[] separaDigito(int quantNumero){
		//1000000000 a 9999999999
		
		arrayNum = geraNum.geraNumeros(quantNumero);
		
		for (int j = 0; j<= quantNumero;j++){
			
				
			for(int i = 0; i<10;i++){
					
				arrayNum[i].charAt(i);
				
			}
			
			
		}
		
	
		
		
		
		/*public void split(String expressao) {

			for (int i = 0; i < expressao.length(); i++) {
				if (expressao.charAt(i) == '(') {
					fila1.adicionarFila(1);
					//String abre = "(";
					//inserir(fila1, abre);
					//stack.addElement(abre);
				}*/
				
		return null;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
