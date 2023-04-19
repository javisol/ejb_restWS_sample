package org.ratoncio;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;

import javax.ejb.Stateless;
import javax.ejb.SessionContext;
import javax.enterprise.context.SessionScoped;


@Stateless(mappedName="EjbBeanStateless", name = "EjbBeanStateless")
public class EjbSessionPocStatelessBean implements EjbSessionPocRemote, EjbSessionPocLocal {

	private int cont;
    private final String url = "jdbc:postgresql://postgresql/ejb-app";
    private final String user = "postgres";
    private final String password = "admin";
    private final String INSERT_SQL = "INSERT INTO datos(contador) " + "VALUES(?)";
	
    public EjbSessionPocStatelessBean() {
    	super();
    	cont = 0;
    }
    
    @Override
    public void increment(int num) {
    	cont = cont + num;
    }

    @Override
    public int result() {
    	return cont;
    }

    @Override
    public void insertDb(int contador) throws SQLException {
        // Step 1: Establishing a Connection
        try (Connection connection = DriverManager.getConnection(url, user, password);

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {
            preparedStatement.setInt(1, contador);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // print SQL exception information
            throw(e);
        }
        // Step 4: try-with-resource statement will auto close the connection.
    }
}
