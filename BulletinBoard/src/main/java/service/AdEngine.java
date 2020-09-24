package service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.container.Suspended;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import model.Ad;

@Component
public class AdEngine {

	private EntityManager entityManager = Persistence.createEntityManagerFactory("adUnit").createEntityManager();

	public boolean createAd(Ad ad) {
		ad.setDateAdding(Date.valueOf(LocalDate.now()));
		ad.setTimeAdding(Time.valueOf(LocalTime.now()));
		entityManager.getTransaction().begin();
		entityManager.merge(ad);
		entityManager.getTransaction().commit();
		return true;

	}
	
	public boolean updateAd(Ad ad) {
		entityManager.getTransaction().begin();
		entityManager.merge(ad);
		entityManager.getTransaction().commit();
		return true;

	}

	public Ad getAdById(Long id) {
		return entityManager.find(Ad.class, id);
	}


	public List<Ad> getAds() {
		Session session = (Session) entityManager.getDelegate();
		try {

			List<Ad> listAds = session
					.createQuery("SELECT ad FROM Ad ad Order by ad.dateAdding DESC, ad.timeAdding DESC, ad.idAd DESC",
							Ad.class)
					.getResultList();
			for (Ad ad : listAds) {
				if (entityManager.contains(ad)) {
					entityManager.refresh(ad);
				}
			}
			return listAds;
		} catch (NoResultException nre) {

			return null;
		}
	}

}
