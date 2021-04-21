/**
 * 
 */
package br.com.bank.service;

import java.util.List;
import java.util.Objects;

import br.com.bank.dao.ClientDaoImpl;
import br.com.bank.model.Client;

/**
 * @author cbgomes
 *
 */
public class ClientServiceImpl implements ClientService {
	
	private ClientDaoImpl dao;
	
	public ClientServiceImpl() {
		this.dao = new ClientDaoImpl();
	}
	

	@Override
	public Client getClient(String name) {
		
		return this.dao.getClient(name);
	}

	@Override
	public List<Client> getAll() {
		return this.dao.getAll();
	}

	@Override
	public void save(Client client) {
		this.dao.save(client);
	}

	@Override
	public void deleteById(Long idClient) {
		 this.dao.deleteById(1L);
		
	}
	public boolean autentication(String email, String phone) {
		return Objects.isNull(this.dao.autentication(email, phone));
	}

	
}
