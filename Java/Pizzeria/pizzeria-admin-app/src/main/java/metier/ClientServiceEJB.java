package metier;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

import dta.pizzeria.model.Client;

@Stateless
public class ClientServiceEJB {

	@PersistenceContext(unitName = "pizzeria-admin-app")
	private EntityManager em;

	public List<Client> findAll() {
		return this.em.createNamedQuery("client.findAll", Client.class).getResultList();
	}

	public void saveNew(Client client) {
		this.em.persist(client);
	}

	public void update(String codeClient, Client client) {
		Client oldClient = this.em.createNamedQuery("pizza.findByCode", Client.class).setParameter("nom", codeClient).getSingleResult();
		if (oldClient != null) {
			client.setId(oldClient.getId());
			this.em.merge(client);
		}
	}

	public void delete(String codeClient) {
		Client client = this.em.createNamedQuery("pizza.findByCode", Client.class).setParameter("nom", codeClient).getSingleResult();
		if (client != null) {
			this.em.remove(client);
		}
	}


	public Client findPizza(String codeClient) {
		return this.em.createNamedQuery("client.findByCode", Client.class).setParameter("nom", codeClient).getSingleResult();
	}

}
