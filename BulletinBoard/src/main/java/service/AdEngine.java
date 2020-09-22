package service;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class AdEngine {

	private EntityManager entityManager = Persistence.createEntityManagerFactory("adUnit").createEntityManager();
}
