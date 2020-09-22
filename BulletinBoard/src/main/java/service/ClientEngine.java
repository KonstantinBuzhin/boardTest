package service;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class ClientEngine {

	private EntityManager entityManager = Persistence.createEntityManagerFactory("userUnit").createEntityManager();
}
