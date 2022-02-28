package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {
	
	public static void main(String[] args) {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();		
		
		Pessoa p = em.find(Pessoa.class, 2); 	//Primeiro busca o objeto do banco de dados
		em.getTransaction().begin();			//Operacao que não seja uma simples consulta é necessário colocar transanção
		em.remove(p);							// e depois manda remover
		em.getTransaction().commit();
		
		System.out.println("Pronto, feito!");
		em.close();
		emf.close();
		
	}

}
