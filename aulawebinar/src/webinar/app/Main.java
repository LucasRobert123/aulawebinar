package webinar.app;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import webinar.dao.InstrutorDao;
import webinar.dao.JPAUtil;
import webinar.model.Aluno;
import webinar.model.Endereco;
import webinar.model.Formacao;
import webinar.model.InscricaoSeminario;
import webinar.model.Instrutor;
import webinar.model.Seminario;

public class Main {

	public static void main(String[] args) {

		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

		/*
		 * Endereco endAluno1 = new Endereco(); endAluno1.setRua("Rua Jose");
		 * endAluno1.setCidade("Alfenas");
		 * 
		 * em.getTransaction().begin(); em.persist(endAluno1);
		 * em.getTransaction().commit();
		 * 
		 * Aluno aluno1 = new Aluno(); aluno1.setNome("Lucas");
		 * aluno1.setMatricula("266616161"); aluno1.setEmail("lucas@gamil.com");
		 * aluno1.setEndereco(endAluno1);
		 * 
		 * em.getTransaction().begin(); em.persist(aluno1);
		 * em.getTransaction().commit();
		 * 
		 * 
		 * 
		 * Aluno aluno2 = new Aluno(); aluno2.setNome("Lucas");
		 * aluno2.setMatricula("266616161"); aluno2.setEmail("lucas@gamil.com");
		 * aluno2.setEndereco(new Endereco("Rua 123", "Alfenas"));
		 * 
		 * em.getTransaction().begin(); em.persist(aluno2);
		 * em.getTransaction().commit();
		 * 
		 * 
		 * Instrutor inst1 = new Instrutor("Batman", new Endereco("Rua 123",
		 * "Alfenas"),"instrutor@gmail.com",1000, Formacao.JEDI); Instrutor inst2 = new
		 * Instrutor("Tony Stark", new Endereco("Rua 123",
		 * "Alfenas"),"instrutor2@gmail.com",1000, Formacao.GRADUADO);
		 * em.getTransaction().begin(); em.persist(inst1); em.persist(inst2);
		 * em.getTransaction().commit();
		 * 
		 * List<Instrutor> instrutores = new ArrayList<Instrutor>();
		 * 
		 * instrutores.add(inst1); instrutores.add(inst2);
		 * 
		 * Seminario semi1 = new Seminario("Palestra java", 101, 50, instrutores);
		 * 
		 * em.getTransaction().begin(); em.persist(semi1); em.getTransaction().commit();
		 

		Endereco endAluno1 = new Endereco();
		endAluno1.setRua("Rua Jose");
		endAluno1.setCidade("Alfenas");

		em.getTransaction().begin();
		em.persist(endAluno1);
		em.getTransaction().commit();

		Aluno aluno1 = new Aluno();
		aluno1.setNome("Lucas");
		aluno1.setMatricula("266616161");
		aluno1.setEmail("lucas@gamil.com");
		aluno1.setEndereco(endAluno1);

		em.getTransaction().begin();
		em.persist(aluno1);
		em.getTransaction().commit();

		Instrutor inst1 = new Instrutor("Batman", new Endereco("Rua 123", "Alfenas"), "instrutor@gmail.com", 1000,
				Formacao.JEDI);
		Instrutor inst2 = new Instrutor("Tony Stark", new Endereco("Rua 123", "Alfenas"), "instrutor2@gmail.com", 1000,
				Formacao.GRADUADO);
		em.getTransaction().begin();
		em.persist(inst1);
		em.persist(inst2);
		em.getTransaction().commit();

		List<Instrutor> instrutores = new ArrayList<Instrutor>();

		instrutores.add(inst1);
		instrutores.add(inst2);
		Seminario semi1 = new Seminario("Palestra java", 101, 50, instrutores);

		em.getTransaction().begin();
		em.persist(semi1);
		em.getTransaction().commit();

		Aluno aluno = em.find(Aluno.class, 1);
		Seminario seminario = em.find(Seminario.class, 1);
		
		InscricaoSeminario inscricao = new InscricaoSeminario();
		inscricao.setAluno(aluno);
		inscricao.setSeminario(seminario);
		inscricao.setDatainscricao("20/10/2020");
		
		em.getTransaction().begin();
		em.persist(inscricao);
		em.getTransaction().commit();*/
		
		//Seminario seminario = em.find(Seminario.class, 1);
		
		List<Instrutor> instrutores = new InstrutorDao().getAllByFormacao(Formacao.JEDI);
		
		for(Instrutor instrutor: instrutores) {
			System.out.println(instrutor.getNome());
		}
		
		JPAUtil.shutdown();

	}

}
