package dta.pizzeria.dao;

import java.io.IOException;
import java.nio.file.*;
import java.sql.*;
import java.util.*;
import org.apache.commons.collections4.ListUtils;

import dta.pizzeria.exception.StockageException;
import dta.pizzeria.model.CategoriePizza;
import dta.pizzeria.model.Pizza;

public class PizzaDaoJDBC implements IDao<Pizza> {

	private Connection createNewConnection() {
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		try {
			Class.forName(bundle.getString("driver"));
			return DriverManager.getConnection(bundle.getString("url"), bundle.getString("user"),
					bundle.getString("password"));
		} catch (SQLException | ClassNotFoundException e) {
			throw new StockageException("DriveManager error", e);
		}

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

	public void importPizzas() {
		List<Pizza> pizzas = new ArrayList<>();

		try {
			Files.list(Paths.get("data")).forEach(path -> pizzas.add(traitement(path)));
		} catch (IOException e) {
			throw new StockageException("Search error", e);
		}

		List<List<Pizza>> parts = ListUtils.partition(pizzas, 3);

		try (Connection connection = createNewConnection();
				PreparedStatement reqRes = connection
						.prepareStatement("INSERT INTO pizza (code,nom,prix,categorie) VALUES(?,?,?,?)");) {
			connection.setAutoCommit(false);
			for (List<Pizza> part : parts) {
				for (Pizza pizza : part) {
					reqRes.setString(1, pizza.getCode());
					reqRes.setString(2, pizza.getNom());
					reqRes.setDouble(3, pizza.getPrix());
					reqRes.setString(4, pizza.getCategorie().toString());
					if (reqRes.executeUpdate() == 0)
						connection.rollback();
				}
				connection.commit();
			}

		} catch (SQLException e) {
			throw new StockageException("Import error", e);
		}

	}

	private Pizza traitement(Path path) {
		String[] pizzaStr;
		try {
			pizzaStr = Files.readAllLines(path).get(0).split(" ");
			return new Pizza(pizzaStr[0], pizzaStr[1], Double.parseDouble(pizzaStr[2]),
					CategoriePizza.valueOf(pizzaStr[3].toUpperCase()));
		} catch (IOException e) {
			throw new StockageException("error", e);
		}
	}

}
