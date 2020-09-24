package service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import model.User;

@Component
public class UserEngine {

	private EntityManager entityManager = Persistence.createEntityManagerFactory("userUnit").createEntityManager();

	private static final String SALT = "Inmost";

	public boolean saveUser(User user) {
		User checkUser = getUserByLogin(user.getEmail());
		if (checkUser.getIdUser() == new User().getIdUser()) {
			user.setPassword(toHexString(hashSHA(user.getPassword())));
			entityManager.getTransaction().begin();
			entityManager.merge(user);
			entityManager.getTransaction().commit();
			return true;
		} else {
			return false;
		}
	}

	public User getUserById(Long id) {
		return entityManager.find(User.class, id);
	}

	public User getUserByLogin(String login) {
		try {
			User user = entityManager
					.createQuery("SELECT user FROM User user where user.email = '" + login + "'", User.class)
					.getSingleResult();
			return user;
		} catch (NoResultException nre) {
			return new User();
		}
	}

	public String getRegistration(User user) {

		return saveUser(user) ? "success" : "fault";
	}

	public boolean getCheckEmail(User user) {
		return (getUserByLogin(user.getEmail()).getIdUser() != new User().getIdUser()) ? true : false;
	}

	public boolean updateClient(User user, String firstName, String email, String password) {
		User currentUser = getUserById(user.getIdUser());

		currentUser.setFirstName(firstName);

		currentUser.setEmail(email);

		currentUser.setPassword(toHexString(hashSHA(password)));

		entityManager.getTransaction().begin();
		entityManager.merge(currentUser);
		entityManager.getTransaction().commit();
		return true;
	}

	public boolean isShow(User user) {
		try {

			User currentUser = entityManager
					.createQuery("SELECT user FROM User user where user.email = '" + user.getEmail()
							+ "' AND password='" + toHexString(hashSHA(user.getPassword())) + "'", User.class)
					.getSingleResult();

			return false;
		} catch (NoResultException nre) {

			return true;
		}
	}

	public String getAccess(User user) {
		return isShow(user) ? "Incorrect email or password" : "Successfully logged";
	}

	public static byte[] hashSHA(String strToHash) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return md.digest((strToHash + SALT).getBytes(StandardCharsets.UTF_8));

	}

	public static String toHexString(byte[] hash) {
		BigInteger number = new BigInteger(1, hash);

		StringBuilder hexString = new StringBuilder(number.toString(16));

		while (hexString.length() < 32) {
			hexString.insert(0, '0');
		}

		return hexString.toString();
	}
}
