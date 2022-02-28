package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {
	
	public static void main(String[] args) {
		
		Pessoa p1 = new Pessoa(null, "Day Ferreira", "exemple@gmail.com");
		Pessoa p2 = new Pessoa(null, "Katemary Rosa", "katemary@gmail.com");
		Pessoa p3 = new Pessoa(null, "Thiala Souza", "thiala@gmail.com");
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();		//Com essa instancia automaticamente vai ter uma conexã com o banco de dados e toda persistence implementada.
		
		em.getTransaction().begin(); //Inicia transação com o banco de dados
		em.persist(p1); //Persiste pega o o objeto e salva no banco de dados
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit(); //confirma as alterações feitas
		
		System.out.println("Pronto!");
		em.close();
		emf.close();
		
	}

}
