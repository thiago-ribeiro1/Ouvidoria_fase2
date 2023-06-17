package entities;

import java.util.Scanner;

public class Manifestacao {

	private String texto;
	private String tipo;
	Pessoa pessoa;

	private static Manifestacao[] manifestacoes = new Manifestacao[5];
	private static int numManifestacoes = 0;

	public Manifestacao(String texto, String tipo, Pessoa pessoa) {

		this.texto = texto;
		this.tipo = tipo;
		this.pessoa = pessoa;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public static void adicionarManifestacao() {

		Scanner sc = new Scanner(System.in);

		if (numManifestacoes < manifestacoes.length) {
			System.out.println();
			System.out.println("Digite a sua manifestação: ");
			String manifestacao = sc.nextLine();

			System.out.println("Digite seu nome: ");
			String name = sc.nextLine();
			System.out.println("Digite seu CPF: ");
			String cpf = sc.nextLine();
			Pessoa pessoa = new Pessoa(name, cpf);

			System.out.println();
			System.out.println("Qual o tipo da manifestação: ");
			System.out.println();
			System.out.println("1) Reclamação");
			System.out.println("2) Sugestão");
			System.out.println("3) Elogio");
			System.out.println();

			int manifestacaoTipo = 0;

			while (manifestacaoTipo < 1 || manifestacaoTipo > 3) {
				System.out.println("Digite o número da opção: ");
				manifestacaoTipo = sc.nextInt();
				sc.nextLine();

				if (manifestacaoTipo < 1 || manifestacaoTipo > 3) {
					System.out.println("Opção inválida, tente novamente \n");
				}
			}

			Manifestacao y = new Manifestacao(manifestacao, name, pessoa);

			switch (manifestacaoTipo) {
			case 1:
				y = new Reclamacao(manifestacao, name, pessoa);
				y.setTipo("Reclamação");
				break;
			case 2:
				y = new Sugestao(manifestacao, name, pessoa);
				y.setTipo("Sugestão");
				break;
			case 3:
				y = new Elogio(manifestacao, name, pessoa);
				y.setTipo("Elogio");
				break;

			}

			manifestacoes[numManifestacoes] = y;
			numManifestacoes++;

			System.out.println();
			System.out.printf("Manifestação cadastrada com sucesso! (%s) %n", manifestacao);
			System.out.println();
		} else {
			System.out.println();
			System.out.println("Chegou ao limite de manifestações \n");
		}

	}

	public static void listarManifestacoes() {

		if (numManifestacoes == 0) {
			System.out.println();
			System.out.println("Não existem manifestações cadastradas \n");
		} else
			System.out.println();
		System.out.println("Lista de manifestações:  \n");
		for (int x = 0; x < numManifestacoes; x++) {
			Manifestacao z = manifestacoes[x];
			System.out.println((x + 1) + ") Tipo: " + z.getTipo());
			System.out.println("   Descrição: " + z.getTexto());
			System.out.println("   Pessoa: " + z.getPessoa().getNome());
			System.out.println("   CPF: " + z.getPessoa().getCpf());
			System.out.println();

		}
	}
}
