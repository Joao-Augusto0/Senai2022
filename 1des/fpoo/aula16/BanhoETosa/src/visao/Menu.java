package visao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.Pet;
import modelo.Servico;

public class Menu {

	// Atributos uteis de entrada e sa�da
	private static Scanner read = new Scanner(System.in);
	private static int opcao = 0;
	private static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	private static String funcionalidades[] = { "Cadastrar Animal/Pet", "Cadastrar Servico   ", "Listar todos os Pets",
			"Listar Servi�os", "Sair                " };
	// Atributos da l�gica de programa Orientado a Objeto
	private static Pet[] pets = new Pet[10];
	private static Servico[] servicos = new Servico[100];
	private static int id = 0; // O id ser� auto_increment
	private static int contPets = 0; // indice para saber quantos pets foram cadastrados
	private static int contServicos = 0; // indice para saber quantos pets foram cadastrados

	// M�todo principal "Men�" ou "Cama"
	public static void main(String[] args) throws IOException, ParseException {
		boolean sucesso = false;
		System.out.println("[ [ Gest�o de Servi�os de Banho e Tosa ] ]");
		while (opcao != 5) {
			System.out.print("Op��o: ");
			opcao = menu(funcionalidades);
			switch (opcao) {
			case 1:
				sucesso = cadastrarAnimal();
				if (sucesso) {
					System.out.println("Animal/Pet cadastrado com sucesso.");
					contPets++;
				} else
					System.out.println("Erro ao cadastrar animal.");
				break;
			case 2:
				sucesso = cadastrarServico();
				if (sucesso) {
					System.out.println("Servi�o registrado com sucesso.");
					contServicos++;
				} else
					System.out.println("Erro ao registrar servi�o.");
				break;
			case 3:
				listarPets();
				break;
			case 4:
				listarServicos();
				break;
			case 5:
				System.out.println("At� logo e volte sempre.");
				break;
			default:
				System.out.println("Op��o inv�lida");
				break;
			}
		}
	}

	// M�todo que escreve o men�
	private static int menu(String[] itens) {
		System.out.println("\t._______________________.");
		for (int i = 0; i < itens.length; i++) {
			System.out.println("\t|" + (i + 1) + "." + itens[i] + "\t|");
		}
		System.out.println("\t:___Escolha uma op��o___:");
		return read.nextInt();
	}

	// M�dodo que cadastra um animal/objeto no vetor
	private static boolean cadastrarAnimal() {
		id++; // Incrementa o id para iniciar em 1 e n�o em 0 como o �ndice
		System.out.println("Tipo\tNome do Pet\tNome Dono\tPeso");
		pets[contPets] = new Pet(id, read.next(), read.next(), read.next(), read.nextFloat());
		return true;
	}

	// M�dodo que cadastra um servi�o/objeto no vetor
	private static boolean cadastrarServico() throws ParseException {
		System.out.println("Para registrar um servi�o, primeiro o pet deve estar cadastrado");
		System.out.println("Digite qual o id do pet/animal?");
		Pet animal = buscarAnimal(read.nextInt());
		if (animal != null) {
			System.out.println(animal.paraString());
			System.out.println("Funcion�rio\tDescri��o\tData(dd/mm/aaaa)\tHora(hh:mm)");
			servicos[contServicos] = new Servico(animal, read.next(), read.next(), read.next(), read.next());
			return true;
		} else {
			System.out.println("Pet n�o encontrado.");
			return false;
		}
	}

	// M�todo que busca o animal pelo Id
	private static Pet buscarAnimal(int idAnimal) {
		for (int i = 0; i < contPets; i++) {
			if (pets[i].idPet == idAnimal) {
				return pets[i];
			}
		}
		return null;
	}

	// M�todo que Lista todos os pets cadastrados
	private static void listarPets() {
		System.out.println("Id\tTipo\tNomePet\tNome dono\tPeso");
		for (int i = 0; i < contPets; i++) {
			System.out.println(pets[i].paraString());
		}
	}

	// Metodo que lista todos os Servi�os e Cria um subMenu com filtros
	private static void listarServicos() throws ParseException {
		System.out.println("Animal/Pet(id, tipo, nome, dono, peso)\tfuncionario\tDescri��o\tData\tHora");
		for (int i = 0; i < contServicos; i++) {
			System.out.println(servicos[i].tabularString());
		}
		String[] subItens = { "Filtrar Servi�os    ", "Filtrar Por data    " };
		opcao = menu(subItens);
		if (opcao == 1) {
			System.out.print("Digite o nome do animal ou do dono, ou funcion�rio, ou a descri��o do servi�o:");
			listarServicos(read.next());
		} else if (opcao == 2) {
			System.out.print("Digite a data em que o servi�o foi realizado dd/mm/aaaa:");
			Date data = df.parse(read.next());
			listarServicos(data);
		} else {
			System.out.println("Filtro inv�lido.");
		}
	}

	// Listar os Servi�os + filtrar por Strings
	private static void listarServicos(String filtro) {
		System.out.println("Animal/Pet(id, tipo, nome, dono, peso)\tfuncionario\tDescri��o\tData\tHora");
		for (int i = 0; i < contServicos; i++) {
			if (servicos[i].nomeFuncionario.equals(filtro) || servicos[i].descricao.equals(filtro)
					|| servicos[i].pet.nomePet.equals(filtro) || servicos[i].pet.nomeDono.equals(filtro)
					|| servicos[i].pet.tipoPet.equals(filtro))
				System.out.println(servicos[i].tabularString());
		}
	}

	// Listar os Servi�os + filtrar por Data
	private static void listarServicos(Date filtro) {
		System.out.println("Animal/Pet(id, tipo, nome, dono, peso)\tfuncionario\tDescri��o\tData\tHora");
		for (int i = 0; i < contServicos; i++) {
			if (servicos[i].data.equals(filtro))
				System.out.println(servicos[i].tabularString());
		}
	}

}