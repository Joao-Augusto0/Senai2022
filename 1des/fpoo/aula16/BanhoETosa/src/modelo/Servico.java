package modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Servico {

	// Atributos b�sico
	public Pet pet;
	public String nomeFuncionario;
	public Date data;
	public Date hora;
	// Atributos para formatar a data
	private SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat hf = new SimpleDateFormat("dd/MM/yyyy");

	// M�todos
	// Construtor vazio
	Servico() {
	}

	// Construtor completo
	public Servico(Pet pet, String nomeFuncionario, String data, String hora) throws ParseException {
		super();
		this.pet = pet;
		this.nomeFuncionario = nomeFuncionario;
		this.data = df.parse(data);
		this.hora = hf.parse(hora);
	}

	// toString (Concatena todos os atributos em uma s� String)
	public String tabulaString() {
		return pet + "\t" + nomeFuncionario + "\t" + df.format(data) + "\t" + hf.format(hora) + "\t" + pet.paraString();
	}

}
