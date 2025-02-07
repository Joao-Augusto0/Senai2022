package modelo;

import java.util.Scanner;

public class ListaLacos {
	//O Scanner est� declarado como atributo
	//para que possa ser utilizado em todos os m�todos
	public static Scanner scan;
	
	//M�todo principal
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int opcao = 0;
		while (opcao != 3) {
			System.out.println("7-Programa7");
			System.out.println("9-Programa9");
			System.out.println("3-Programa3");
			opcao = scan.nextInt();
			switch (opcao) {
			case 7:
				ex7(); //O exerc�cio em forma de m�todo
				break;
			case 9:
				ex9(); //O exerc�cio em forma de m�todo
				break;
			case 3:
				System.out.println("At� mais");
				break;
			default:
				System.out.println("Op��o inv�lida");
				break;
			}
		}
	}
	
	//M�todo do exerc�cio 7
	public static void ex7() {
		scan = new Scanner(System.in);
		System.out.println("Soma dos valores que voc� quiser:");
		System.out.println("*************************************");
		System.out.print("Digite o inicio do intervalo:");
		int inicio = scan.nextInt();
		System.out.print("Digite o fim do intervalo:");
		int fim = scan.nextInt();
		int acumulador = 0;
		for (int i = inicio; i <= fim; i++) {
			acumulador += i;
		}
		System.out.println("A soma dos valores do intervalo digitado � =  " + acumulador);
	}

	//M�todo do exerc�cio 7
	public static void ex9() {
		scan = new Scanner(System.in);
		int acumulador = 0;
		System.out.println("Soma de 15 valores digitados:");
		System.out.println("*************************************");
		for(int i = 1; i <= 15; i++ ){
			System.out.printf("Digite o %d� valor:",i);
			acumulador += scan.nextInt();
		}
		System.out.println("O total digitado � = "+acumulador);
	}

}
