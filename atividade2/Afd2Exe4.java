/*
 * Eis um desenho de um afd que reconhece o conjunto das
 * palavras w sobre {a, b} tais que ab é um prefixo de w:
 *
 *     a  b
 * q0  q1 q2
 * q1  q2 q3
 * q2  q2 q2
 * q3  q3 q3
 */
public class Afd2Exe4 {
	public static void main(String[] args) {
		String entrada = "ababababababa";
		int estado = 0;

		for (int posicao = 0; posicao < entrada.length(); posicao++) {
		    char elemento = entrada.charAt(posicao);

		    if (estado == 0 && elemento == 'a') {estado = 1;}
			else if (estado == 0 && elemento == 'b') {estado = 2;}
			else if (estado == 1 && elemento == 'b') {estado = 3;}
			else if (estado == 1 && elemento == 'a') {estado = 2;}
		}

		System.out.println("Estado: " +estado);
		System.out.println("Resultado: " +(estado == 3 ? "aceita" : "rejeita"));
	}
}