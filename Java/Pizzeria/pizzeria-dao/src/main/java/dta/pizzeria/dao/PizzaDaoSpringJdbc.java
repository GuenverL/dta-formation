package dta.pizzeria.dao;

import java.util.*;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import dta.pizzeria.model.*;

@Repository
public class PizzaDaoSpringJdbc implements IDao<Pizza> {

	private JdbcTemplate temp;
	private RowMapper<Pizza> map = (rs, i) -> new Pizza(rs.getString(2), rs.getString(3), rs.getDouble(4), CategoriePizza.valueOf(rs.getString(5).toUpperCase()));

	public PizzaDaoSpringJdbc(DataSource data) {
		this.temp = new JdbcTemplate(data);
	}


	@Override
	public List<Pizza> findAll() {
		return this.temp.query("SELECT * FROM Pizza", this.map);
	}

	public Pizza findPizza(String code) {
		String sql = "SELECT * FROM Pizza WHERE Pizza.code=?";
		return this.temp.queryForObject(sql, this.map, code);
	}

	@Override
	public void saveNew(Pizza pizza) {
		String sql = "INSERT INTO Pizza (code,nom,prix,categorie) VALUES(?,?,?,?)";
		this.temp.update(sql, pizza.getCode(), pizza.getNom(), pizza.getPrix(), pizza.getCategorie().toString());
	}

	@Override
	public void update(String codePizza, Pizza pizza) {
		String sql = "UPDATE Pizza SET code=?, nom=?, prix=?, categorie=? WHERE Pizza.code= ?";
		this.temp.update(sql, pizza.getCode(), pizza.getNom(), pizza.getPrix(), pizza.getCategorie().toString(), codePizza);
	}

	@Override
	public void delete(String code) {
		String sql = "DELETE FROM Pizza WHERE Pizza.code=?";
		this.temp.update(sql, code);
	}
}