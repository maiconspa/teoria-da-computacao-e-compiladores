/*
 * Eis um autômato que reconhece o conjunto das palavras w sobre {a, b} tais que
 * ab é um sufixo de w:
 *
 *     a  b
 * q0  q1 q0
 * q1  q1 q2
 * q2  q1 q0
 * */
public class Afd2Exe5 {
	public static void main(String[] args) {
		String entrada = "abbab";
		int estado = 0;

		for (int posicao = 0; posicao < entrada.length(); posicao++) {
			char elemento = entrada.charAt(posicao);

			if (estado == 0 && elemento == 'a') {estado = 1;}
			else if (estado == 1 && elemento == 'b') {estado = 2;}
			else if (estado == 2 && elemento == 'a') {estado = 1;}
			else if (estado == 2 && elemento == 'b') {estado = 0;}
		}

		System.out.println("Estado: " +estado);
		System.out.println("Resultado: " +(estado == 2 ? "aceita" : "rejeita"));
	}
}