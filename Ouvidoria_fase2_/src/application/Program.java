package application;

import java.util.Scanner;
import entities.Manifestacao;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int opcao = 0;
		while (opcao != 3) {
			System.out.println("============= MENU =============");
			System.out.println();
			System.out.println("1) Inserir nova manifestação");
			System.out.println("2) Listar manifestações");
			System.out.println("3) Sair");
			System.out.println();
			System.out.println("=========== OUVIDORIA ===========");
			System.out.println();
			System.out.println("Digite a sua opção: ");
			opcao = sc.nextInt();

			switch (opcao) {
			case 1:
				Manifestacao.adicionarManifestacao();
				break;

			case 2:
				Manifestacao.listarManifestacoes();
				break;

			case 3:
				System.out.println();
				System.out.println("Até logo. Obrigado pelo seu feedback!");
				System.out.println();
				break;

			default:
				System.out.println();
				System.out.println("Opção inválida, tente novamente \n");
				break;
			}
		}
		sc.close();
	}
}
