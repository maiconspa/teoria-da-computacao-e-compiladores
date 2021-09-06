/*
 * Eis um autômato que reconhece o conjunto das palavras w
 * sobre os dígitos 0 e 1 tais que Pj iw=1 j 2jwj−iwi mod 3 = 1.
 * ou seja, w, quando interpretado como um número na base 2,
 * tem resto 1 se dividido por 3.
 *
 *     0  1
 * q0  q0 q1
 * q1  q2 q0
 * q2  q1 q2
 * */
public class Afd2Exe7 {
	public static void main(String[] args) {
		int entrada = 1;
		int estado = 0;
		String binario = convertToBinary(entrada);

		for (int posicao = 0; posicao < binario.length(); posicao++) {
			char elemento = binario.charAt(posicao);

			if (estado == 0 && elemento == '1') {estado = 1;}

			else if (estado == 1 && elemento == '0') {estado = 2;}
			else if (estado == 1 && elemento == '1') {estado = 0;}

			else if (estado == 2 && elemento == '0') {estado = 1;}
		}

		System.out.println(
				"Entrada: " +entrada+
				"\nBinário: " +binario+
				"\nEstado: " +estado+
				"\nResultado: " +(estado == 1 ? "aceita" : "rejeita")
		);
	}

	public static String convertToBinary(int number) {
		StringBuffer string = new StringBuffer();

		while (number > 0) {
			int b = number % 2;
			string.append(b);
			number = number >> 1;
		}

		return string.reverse().toString();
	}
}