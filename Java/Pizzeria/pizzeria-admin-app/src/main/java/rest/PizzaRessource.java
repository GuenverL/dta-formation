package rest;

import java.util.*;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import dta.pizzeria.model.*;
import metier.PizzaServiceEJB;

@Path("/rest/pizzas")
public class PizzaRessource {

	@EJB
	private PizzaServiceEJB ejb;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pizza> list() {
		return this.ejb.findAll();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void add(Pizza pizza) {
		this.ejb.saveNew(pizza);
	}

	@PUT
	@Path("/{code}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(@PathParam("code") String code, Pizza pizza) {
		this.ejb.update(code, pizza);
	}

	@DELETE
	@Path("/{code}")
	public void update(@PathParam("code") String code) {
		this.ejb.delete(code);
	}
}
