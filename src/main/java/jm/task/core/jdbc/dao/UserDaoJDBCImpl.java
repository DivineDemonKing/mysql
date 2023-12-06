package jm.task.core.jdbc.dao;

import com.mysql.cj.protocol.Resultset;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    PreparedStatement preparedStatement;
    Statement statement;
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS UserTable (id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT, name VARCHAR(20), lastName VARCHAR(20), age TINYINT)";
        try {
            statement = Util.getConnection().prepareStatement(sql);
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS UserTable";
        try {
            statement = Util.getConnection().prepareStatement(sql);
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = "INSERT UserTable(name, lastName, age) VALUES (?, ?, ?)";
        try {
            preparedStatement = Util.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        String sql = String.format("DELETE FROM UserTable WHERE id=%d", id);
        try {
            preparedStatement = Util.getConnection().prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM UserTable";
        List<User> list = new ArrayList<>();
        try {
            preparedStatement = Util.getConnection().prepareStatement(sql);
            ResultSet resultset = preparedStatement.executeQuery(sql);
            while (resultset.next()){
                list.add(new User(resultset.getString("name"),
                        resultset.getString("lastName"),
                        resultset.getByte("age")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void cleanUsersTable() {
        String sql = "DELETE FROM UserTable";
        try {
            preparedStatement = Util.getConnection().prepareStatement(sql);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
