package clases;

import java.util.Scanner;

public class Entradas{
	
	private static Scanner teclado = new Scanner(System.in);
	
	public static int entero(String enunciado) {
		
		System.out.print(enunciado+" ");

		do {

			try {
				
				int num = Integer.parseInt(teclado.nextLine().trim());
				return num;

			} catch (Exception e) {
				
				System.err.print("Error - Debe seleccionar un número entero: ");
				
			}
			
		} while (true);
		
	}
	
	public static String texto(String enunciado) {

		System.out.print(enunciado + " ");
		String texto = teclado.nextLine().trim();
		return texto;

	}
	
	public static double decimal(String enunciado) {
		
		System.out.print(enunciado+" ");

		do {

			try {
				
				double num = Double.parseDouble(teclado.nextLine().trim());
				return num;

			} catch (Exception e) {
				
				System.err.print("Error - Debe seleccionar un número entero: ");
				
			}
			
		} while (true);
		
	}
	
}