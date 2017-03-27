package rest;

import java.util.*;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import dta.pizzeria.model.*;
import metier.ClientServiceEJB;

@Path("/rest/clients")
public class ClientRessource {

	@EJB
	private ClientServiceEJB ejb;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Client> list() {
		return this.ejb.findAll();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void add(Client client) {
		this.ejb.saveNew(client);
	}

	@PUT
	@Path("/{code}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(@PathParam("nom") String nom, Client client) {
		this.ejb.update(nom, client);
	}

	@DELETE
	@Path("/{code}")
	public void update(@PathParam("nom") String nom) {
		this.ejb.delete(nom);
	}
}
