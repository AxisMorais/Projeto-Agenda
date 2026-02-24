package model;

import java.util.List;

import javax.persistence.*;



public class CRUD {
		public static void inserir(Contato c1) {
		
			try {
				EntityManager entityManager = DAO.getEntityManager();
				
				entityManager.getTransaction().begin();
				entityManager.persist(c1);
				entityManager.getTransaction().commit();
				entityManager.close();
				System.out.println("conectado Salvo!");
			} catch(Exception ex) {
				ex.printStackTrace();
			} 
		} 
	
		// NOVO MÉTODO PARA LISTAR TODOS
	    public static List<Contato> listarTodos() {
	        List<Contato> contatos = null;
	        try {
	            EntityManager entityManager = DAO.getEntityManager();
	            entityManager.getTransaction().begin();
	            
	            // Query JPQL para buscar todos os contatos
	            contatos = entityManager.createQuery("FROM Contato", Contato.class).getResultList();
	            
	            entityManager.getTransaction().commit();
	            entityManager.close();
	        } catch(Exception ex) {
	            ex.printStackTrace();
	        }
	        return contatos;
	    }

}
