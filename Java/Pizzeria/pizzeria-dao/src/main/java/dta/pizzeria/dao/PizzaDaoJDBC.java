package dta.pizzeria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dta.pizzeria.exception.StockageException;
import dta.pizzeria.model.CategoriePizza;
import dta.pizzeria.model.Pizza;

public class PizzaDaoJDBC implements IDao<Pizza> {
	
	private Connection connection;

	public PizzaDaoJDBC() {

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new StockageException("Driver error", e);
		}

		try {
			this.connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/pizzadb", "root", "");
		} catch (SQLException e) {
			throw new StockageException("DriveManager error", e);
		}
	}

	@Override
	public List<Pizza> findAll() {
		List<Pizza> res = new ArrayList<>();
		ResultSet reqRes;
		try {
			reqRes = connection.prepareStatement("SELECT * FROM pizza").executeQuery();

			while (reqRes.next()) {
				res.add(new Pizza(reqRes.getString("code"), reqRes.getString("nom"), reqRes.getDouble("prix"),
						CategoriePizza.valueOf(reqRes.getString("categorie").toUpperCase())));
			}
			reqRes.close();

		} catch (SQLException e) {
			throw new StockageException("Search error", e);
		}
		return res;

	}

	@Override
	public int find(String code) {
		return 0;
	}

	@Override
	public void saveNew(Pizza pizza) {
		PreparedStatement reqRes;
		try {
			reqRes = connection.prepareStatement("INSERT INTO pizza (code,nom,prix,categorie) VALUES(?,?,?,?)");
			reqRes.setString(1, pizza.getCode());
			reqRes.setString(2, pizza.getNom());
			reqRes.setDouble(3, pizza.getPrix());
			reqRes.setString(4, pizza.getCategorie().toString());
			reqRes.executeUpdate();
			reqRes.close();

		} catch (SQLException e) {
			throw new StockageException("Save error", e);
		}
	}

	@Override
	public void update(String codePizza, Pizza pizza) {
		PreparedStatement reqRes;
		try {
			reqRes = connection
					.prepareStatement("UPDATE pizza SET code = ?, nom =?, prix = ?, categorie = ? WHERE code = ? ");
			reqRes.setString(1, pizza.getCode());
			reqRes.setString(2, pizza.getNom());
			reqRes.setDouble(3, pizza.getPrix());
			reqRes.setString(4, pizza.getCategorie().toString());
			reqRes.setString(5, codePizza);
			reqRes.executeUpdate();
			reqRes.close();


		} catch (SQLException e) {
			throw new StockageException("Update error", e);
		}
	}

	@Override
	public void delete(String codePizza) {
		PreparedStatement reqRes;
		try {
			reqRes = connection.prepareStatement("DELETE FROM pizza WHERE code = ?");
			reqRes.setString(1, codePizza);
			reqRes.executeUpdate();
			reqRes.close();


		} catch (SQLException e) {
			throw new StockageException("Save error", e);
		}
	}

	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			throw new StockageException("Connexion close error", e);
		}
	}

}
