package com.shopping.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderDao {
    private Logger logger = Logger.getLogger(OrderDao.class.getName());

    public List<Order> getOrders(int userId) {
        Connection connection = null;
        List<Order> orders = new ArrayList<>();
        try {
            connection = H2DatabaseConnection.getConnectionToDatabase();
            PreparedStatement preparedStatement = null;

            preparedStatement = connection.prepareStatement
                    ("select * from orders where user_id=?");
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order order = Order.builder()
                        .userId(resultSet.getInt("user_id"))
                        .orderId(resultSet.getInt("order_id"))
                        .noOfItems(resultSet.getInt("no_of_items"))
                        .totalAmount(resultSet.getDouble("total_amount"))
                        .orderDate(resultSet.getDate("order_date"))
                        .build();
                orders.add(order);
            }

        } catch (SQLException exception) {
            logger.log(Level.SEVERE, "Could not execute query", exception);
        }
        return orders;
    }
}
