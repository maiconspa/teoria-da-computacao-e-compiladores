/*
 * numero impar de a
 *
 *     a  b
 * q0  q1 q0
 * q1  q0 q1
 * */
public class Afd2Exe3 {
	public static void main(String[] args) {
		String entrada = "aba";
		int estado = 0;
		
		for (int posicao = 0; posicao < entrada.length(); posicao++) {
		    char elemento = entrada.charAt(posicao);
		    
		    System.out.println(entrada.substring(0, posicao)+ " |q"+ estado+ "|"+ entrada.substring(posicao));
		    
		    if (estado == 0 && elemento == 'a') {estado = 1;}
		    else if (estado == 1 && elemento == 'a') {estado = 0;}
		}

		System.out.println("Estado: " +estado);
		System.out.println("Resultado: " +(estado == 1 ? "aceita" : "rejeita"));
	}
}