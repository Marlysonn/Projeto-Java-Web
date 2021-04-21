/**
 * 
 */
package br.com.bank.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import org.hibernate.internal.build.AllowSysOut;
import br.com.bank.model.Client;
import br.com.bank.util.JPAUtil;

/**
 * @author cbgomes
 *
 */
public class ClientDaoImpl implements ClientDao {

	@Override
	public Client getClient(String name) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		try {
			
			Client client = entityManager.createNamedQuery("Client.getByName",Client.class)
					.setParameter("name", name)
					.getSingleResult();
			
			return client;
			
		}catch (PersistenceException e) {
			e.getMessage();
			entityManager.close();
		}
		
		return null;
	}

	@Override
	public List<Client> getAll() {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		try {
			List<Client> Users = entityManager.createNamedQuery("Client.getByTable", Client.class)
					.getResultList();
					System.out.println(Users);
			return Users;
		}catch(Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public void save(Client client) {
		
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		try {
			
			entityManager.persist(client);
			entityManager.getTransaction().commit();
			entityManager.close();
			
		} catch (PersistenceException e) {
			e.getMessage();
			System.out.println("ERRROO");
		}
		
	}

	@Override
	public void deleteById(Long idClient) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			Client clientToDelete = entityManager.find(Client.class, idClient);
			entityManager.getTransaction().begin();
			entityManager.remove(clientToDelete);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.getMessage();
			entityManager.close();
		}
		
	}
	public Client autentication(String email, String phone) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		try {
			Client autentication = entityManager.createNamedQuery("Client.getAutentication", Client.class)
				.setParameter("email", email)
				.setParameter("phone", phone)
				.getSingleResult();
				
			return autentication;
							
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

}
