package dta.pizzeria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import dta.pizzeria.exception.StockageException;
import dta.pizzeria.model.CategoriePizza;
import dta.pizzeria.model.Pizza;

public class PizzaDaoJDBC implements IDao<Pizza> {
	
	private ResourceBundle bundle = ResourceBundle.getBundle("jdbc");

	public PizzaDaoJDBC() {
	}

	@Override
	public List<Pizza> findAll() {
		List<Pizza> res = new ArrayList<>();
		try (Connection connection = createNewConnection();
				Statement statement = connection.createStatement();
				ResultSet reqRes = statement.executeQuery("SELECT * FROM pizza");) {

			while (reqRes.next()) {
				res.add(new Pizza(reqRes.getString("code"), reqRes.getString("nom"), reqRes.getDouble("prix"),
						CategoriePizza.valueOf(reqRes.getString("categorie").toUpperCase())));
			}
			return res;

		} catch (SQLException e) {
			throw new StockageException("Search error", e);
		}

	}

	private Connection createNewConnection() {

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection connection = DriverManager.getConnection(bundle.getString("url"), bundle.getString("user"),
					bundle.getString("password"));
			return connection;
		} catch (SQLException | ClassNotFoundException e) {
			throw new StockageException("DriveManager error", e);
		}

	}

	@Override
	public int find(String code) {
		return 0;
	}

	@Override
	public void saveNew(Pizza pizza) {
		try (Connection connection = createNewConnection();
				PreparedStatement reqRes = connection
						.prepareStatement("INSERT INTO pizza (code,nom,prix,categorie) VALUES(?,?,?,?)");) {

			reqRes.setString(1, pizza.getCode());
			reqRes.setString(2, pizza.getNom());
			reqRes.setDouble(3, pizza.getPrix());
			reqRes.setString(4, pizza.getCategorie().toString());
			reqRes.executeUpdate();

		} catch (SQLException e) {
			throw new StockageException("Save error", e);
		}
	}

	@Override
	public void update(String codePizza, Pizza pizza) {
		try (Connection connection = createNewConnection();
				PreparedStatement reqRes = connection.prepareStatement(
						"UPDATE pizza SET code = ?, nom =?, prix = ?, categorie = ? WHERE code = ? ");) {
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
		try (Connection connection = createNewConnection();
				PreparedStatement reqRes = connection.prepareStatement("DELETE FROM pizza WHERE code = ?");) {

			reqRes.setString(1, codePizza);
			reqRes.executeUpdate();
			reqRes.close();


		} catch (SQLException e) {
			throw new StockageException("Save error", e);
		}
	}

	@Override
	public void close() {
		try {
			Connection connection = createNewConnection();
			connection.close();
		} catch (SQLException e) {
			throw new StockageException("Connexion close error", e);
		}
	}

}
