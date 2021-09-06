/*
 * Eis um autômato que reconhece o conjunto das palavras w
 * sobre {a,b} tais que |w|a é par e |w|b é ímpar:
 *
 *         a      b
 * q[0,0]  q[1,0] q[0,1]
 * q[1,0]  q[0,0] q[1,1]
 * q[0,1]  q[1,1] q[0,0]
 * q[1,1]  q[0,1] q[1,0]
 * */
public class Afd2Exe6 {
	public static void main(String[] args) {
		String entrada = "abaa";
		int[] estado = new int[]{0,0};

		for (int posicao = 0; posicao < entrada.length(); posicao++) {
			char elemento = entrada.charAt(posicao);

			if ((estado[0] == 0 && estado[1] == 0) && elemento == 'a') {estado[0] = 1;}
			else if ((estado[0] == 0 && estado[1] == 0) && elemento == 'b') {estado[1] = 1;}

			else if ((estado[0] == 1 && estado[1] == 0) && elemento == 'a') {estado[0] = 0;}
			else if ((estado[0] == 1 && estado[1] == 0) && elemento == 'b') {estado[1] = 1;}

			else if ((estado[0] == 0 && estado[1] == 1) && elemento == 'a') {estado[0] = 1;}
			else if ((estado[0] == 0 && estado[1] == 1) && elemento == 'b') {estado[1] = 0;}

			else if ((estado[0] == 1 && estado[1] == 1) && elemento == 'a') {estado[0] = 0;}
			else if ((estado[0] == 1 && estado[1] == 1) && elemento == 'b') {estado[1] = 0;}
		}

		System.out.println("Estado: [" +estado[0] +"," +estado[1] +"]");
		System.out.println("Resultado: " +(estado[0] == 0 && estado[1] == 1 ? "aceita" : "rejeita"));
	}
}