/**
 * @author Maicon Araujo
 * created on: 2021/09/16
 */
public class exemplo36 {
    public static void main(String[] args) {
		String entrada = "abbbbbaaababbabbabbaaa";
		int estado[] = {0, 0};
		
		for (int posicao = 0; posicao < entrada.length(); posicao++) {
		    char elemento = entrada.charAt(posicao);
		    
		    if (estado[0] == 0 && (elemento == 'a' || elemento == 'b')) {estado[0] = 0;}
            if ((estado[1] == 1 || estado[1] == 2 || estado[1] == 3) && elemento == 'b') {estado[1] = 0;}
            else if (estado[1] == 0 && elemento == 'a') {estado[1] = 1;}
		    else if (estado[1] == 1 && elemento == 'a') {estado[1] = 2;}
		    else if (estado[1] == 2 && elemento == 'a') {estado[1] = 3;}
		}

		System.out.printf("Estado: {%d, %d}%n", estado[0], estado[1]);
		System.out.println("Resultado: " +(estado[1] == 3 ? "aceita" : "rejeita"));
	}
}