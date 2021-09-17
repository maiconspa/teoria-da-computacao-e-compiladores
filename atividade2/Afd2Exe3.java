/*
 * numero impar de a
 *
 *          a  b
 * estado0  q1 q0
 * estado1  q0 q1
 * */
public class Afd2Exe3 {
	public static void main(String[] args) {
		String entrada = "abbbbbbbbbbbbbbbaa";
		int estado = 0;
		
		for (int posicao = 0; posicao < entrada.length(); posicao++) {
		    char elemento = entrada.charAt(posicao);
		    
		    System.out.printf("%s |q %d| %s\n", entrada.substring(0, posicao), estado, entrada.substring(posicao));
		    
		    if (estado == 0 && elemento == 'a') {estado = 1;}
		    else if (estado == 1 && elemento == 'a') {estado = 0;}
		}

		System.out.println("Estado: " +estado);
		System.out.println("Resultado: " +(estado == 1 ? "aceita" : "rejeita"));
	}
}