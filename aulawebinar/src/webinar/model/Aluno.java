package webinar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String matricula;
	private String nome;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;
	
	private String email;
	
	@OneToMany(mappedBy = "aluno")
	Set<InscricaoSeminario> incricoes = new HashSet<InscricaoSeminario>();

	public Aluno() {
	}

	public Aluno(String matricula, String nome, Endereco endereco, String email) {
		this.matricula = matricula;
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<InscricaoSeminario> getIncricoes() {
		return incricoes;
	}

	public void setIncricoes(Set<InscricaoSeminario> incricoes) {
		this.incricoes = incricoes;
	}
  
}
