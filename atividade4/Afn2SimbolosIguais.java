import java.util.Set;
import java.util.TreeSet;

/**
 * implementação sem backtracking & sem recursividade
 * solução especifica.
 * 
 * Palavras com sequencia de 2 simbolos iguais
 * 
 * @author keity
 *
 */
public class Afn2SimbolosIguais {

	static int[] aceitacao = {3};
	static int estadoInicial = 0;

	/*
	 *  Vou substituir o qf por q3 
	 *  δ	|   a	 |    b
	 *  q0	|{q0,q1} |	{q0,q2}
	 *  q1	| {q3}	 |	  Ø
	 *  q2	|  	Ø	 |   {q3}
	 *  q3	| {q3}	 |	 {q3}
	 */
	public static void main(String[] args) {

		String entrada = "abaa";
		
		// um array pois podemos ter mais de um estado.
		int estados[] = {estadoInicial};
		int posicao = 0;
		
		while (posicao < entrada.length()) {
			imprimeLinha(entrada, estados, posicao);

			char elemento = entrada.charAt(posicao);
//			int elemento = Integer.parseInt(entrada.substring(posicao, posicao+1));
			
			int[] novosEstados = new int[]{};
			
			for(int i: estados) {
				int[] destinoTransicao= new int[]{};
				
				if (i == 0 && elemento == 'a') {
//				if (i == 0 && elemento == 0) {
					destinoTransicao = new int[2];
					destinoTransicao[0] = 0;
					destinoTransicao[1] = 1;
				} 
				else if (i == 0 && elemento == 'b') {
//				else if (i == 0 && elemento == 1) {
					destinoTransicao = new int[2];
					destinoTransicao[0] = 0;
					destinoTransicao[1] = 2;
				} 
				else if (i == 1 && elemento == 'a') {
					destinoTransicao = new int[1];
					destinoTransicao[0] = 3;
				} 
				else if (i == 1 && elemento == 'b') {}
				else if (i == 2 && elemento == 'a') {} 
				else if (i == 2 && elemento == 'b') {
					destinoTransicao = new int[1];
					destinoTransicao[0] = 3;
				} 
				else if (i == 3 && elemento == 'a') {
					destinoTransicao = new int[1];
					destinoTransicao[0] = 3;
				} 
				else if (i == 3 && elemento == 'b') {
					destinoTransicao = new int[1];
					destinoTransicao[0] = 3;
				} 

				novosEstados = uniao(novosEstados, destinoTransicao);
			}

			estados = novosEstados;
			if (estados.length == 0) break;
			
			posicao++;
		}

		imprimeLinha(entrada, estados, posicao);

		
		if (aceita(estados)) 
			System.out.println("aceita");
		else
			System.out.println("rejeita");

	}

	private static void imprimeLinha(String entrada, int[] estados, int posicao) {
		System.out.print(entrada.substring(0,posicao)+"{");
		for (int i=0; i<estados.length; i++) {
			System.out.print("q"+estados[i]);
			if(i<estados.length-1) {
				System.out.print(",");
			}
		}
		System.out.println("}"+ entrada.substring(posicao));
	}
	
	private static int[] uniao(int[] estados, int[] novosEstados) {
		
		Set<Integer> uniao = new TreeSet<>();
		for (int i: estados) uniao.add(i);
		for (int i: novosEstados) uniao.add(i);
		
		// convertendo de conjunto para array.
		int[] ret = new int[uniao.size()];
		int j = 0;
		for(int i:uniao) ret[j++] = i;
		return ret;
		
	}
	
	private static boolean aceita(int[] estados) {
		if (estados == null) return false;
		for (int i:estados)
			for (int j:aceitacao) {
				if (i==j) {
					return true;
				}
			}
		return false;
	}// aceita
	
}