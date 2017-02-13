package com.stk.academy.batch.jdbc.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stk.academy.batch.jdbc.data.domain.CartEntity;
import com.stk.academy.batch.jdbc.data.domain.ShipToEntity;
import com.stk.academy.batch.jdbc.data.domain.StatusEntity;

@Repository
public class CartRepository {
	
	@Autowired
	private DataSource datasource;

	public List<CartEntity> list() {
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT c.*, st.name ship_to, s.description status");
		query.append("  FROM cart c");
		query.append("  JOIN ship_to st ON st.ship_to_id = c.ship_to_id");
		query.append("  JOIN status s ON s.status_id = c.status_id");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		final List<CartEntity> carts = new ArrayList<CartEntity>();
		
		try {
			connection = datasource.getConnection();
			preparedStatement = connection.prepareStatement(query.toString());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
	            carts.add(this.buildCart(resultSet));
            }
		} catch (SQLException exception) {
			throw new RuntimeException(exception);
		} finally {
			this.close(resultSet, preparedStatement, connection);
		}
        
		
		return carts; 
	}
	
	public CartEntity findOne(final Long cartId) {
		
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        CartEntity cart = null;
        
        try {
        	connection = datasource.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM cart WHERE cart_id = ?");
            preparedStatement.setLong(1, cartId);
            resultSet = preparedStatement.executeQuery();
            
            resultSet.next();
            cart = this.buildCart(resultSet);

        } catch (SQLException exception) {
        	throw new RuntimeException(exception);
        } finally {
			this.close(resultSet, preparedStatement, connection);
		}
		
		return cart;
	}
	
	private CartEntity buildCart(final ResultSet rs) throws SQLException {
		
		CartEntity cart = new CartEntity();
		final int columnCount = rs.getMetaData().getColumnCount();
		
		cart.setId(rs.getLong("cart_id"));
        cart.setLinesAmount(rs.getDouble("lines_amount"));
        cart.setShippingAmount(rs.getDouble("shipping_amount"));
        cart.setCartAmount(rs.getDouble("cart_amount"));
        cart.setShipTo(new ShipToEntity(rs.getLong("ship_to_id"), columnCount>10 ? rs.getString("ship_to") : ""));
        cart.setStatus(new StatusEntity(rs.getLong("status_id"), columnCount>10 ? rs.getString("status") : "",  ""));
        cart.setCreateUser(rs.getString("create_user"));
        cart.setCreateDate(rs.getDate("create_date"));
        cart.setUpdateUser(rs.getString("update_user"));
        cart.setUpdateDate(rs.getDate("update_date"));
        
		return cart;
	}
	
	private void close(ResultSet resultSet,
	        PreparedStatement preparedStatement,
	        Connection connection) {
		
	        if (resultSet != null && preparedStatement != null
	            && connection != null) {

	            try {
	                if (!resultSet.isClosed()) {
	                    resultSet.close();
	                }

	                if (!preparedStatement.isClosed()) {
	                    preparedStatement.close();
	                }

	                if (!connection.isClosed()) {
	                    connection.close();
	                }
	            } catch (SQLException exception) {
	            	throw new RuntimeException(exception);
	            }
	        }
	    }

}
