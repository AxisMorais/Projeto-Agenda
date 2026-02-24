package model;

import javax.persistence.*;

public class DAO {

	private static final EntityManagerFactory emFactory;
	
	static {
		emFactory = Persistence.createEntityManagerFactory("agendaPersist");
	}
	
	public static EntityManager getEntityManager() {
		return emFactory.createEntityManager();
	}
	
	public static void fecharFactory() {
		emFactory.close();
	} 

}