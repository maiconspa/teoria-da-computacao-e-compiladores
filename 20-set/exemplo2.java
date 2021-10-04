
/**
 * @author Maicon Araujo
 * 
 *     a      b      c
 * 0 | {0}  | {0}  | void
 * 1 | {1}  | void | {1}
 * 2 | void | {2}  | {2}
 */
public class exemplo2 {
    public static void main(String[] args) {
		String entrada = "abbbbbaaababbabbabbaaa";
		boolean estado[] = {true, true, true};
		
		for (int posicao = 0; posicao < entrada.length(); posicao++) {
		    char elemento = entrada.charAt(posicao);
		    
            if (estado[0] && estado[1] && estado[2] && elemento == 'a') { estado[2] = false; } // {0,1}
            else if (estado[0] && estado[1] && estado[2] && elemento == 'b') { estado[1] = false; } // {0,2}
            else if (estado[0] && estado[1] && estado[2] && elemento == 'c') { estado[0] = false; } // {1,2}

            else if (estado[0] && estado[1] && estado[2] && elemento == 'a') { estado[2] = false; } // {0,1}
            else if (estado[0] && estado[1] && estado[2] && elemento == 'b') { estado[1] = false; } // {0,2}
            else if (estado[0] && estado[1] && estado[2] && elemento == 'c') { estado[0] = false; } // {1,2}
		}

		System.out.printf("Estado: {%d, %d}%n", estado[0], estado[1]);
		System.out.println("Resultado: " +(estado[1] == 3 ? "aceita" : "rejeita"));
	}

    public static boolean aceitacao(int[] estado) {
        return true;
    }
}
