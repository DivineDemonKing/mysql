//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

/*package jm.task.core.jdbc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

public class UserDaoJDBCImpl implements UserDao {
    PreparedStatement preparedStatement;
    ******************************

             ДЕПРИКЕЙТЕД

    ******************************
    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS UserTable (id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT, name VARCHAR(20), lastName VARCHAR(20), age TINYINT)";

        try {
            this.preparedStatement = Util.getConnection().prepareStatement(sql);
            this.preparedStatement.execute();
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

    }

    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS UserTable";

        try {
            this.preparedStatement = Util.getConnection().prepareStatement(sql);
            this.preparedStatement.executeUpdate();
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = "INSERT UserTable(name, lastName, age) VALUES (?, ?, ?)";

        try {
            this.preparedStatement = Util.getConnection().prepareStatement(sql);
            this.preparedStatement.setString(1, name);
            this.preparedStatement.setString(2, lastName);
            this.preparedStatement.setByte(3, age);
            this.preparedStatement.executeUpdate();
        } catch (SQLException var6) {
            throw new RuntimeException(var6);
        }
    }

    public void removeUserById(long id) {
        String sql = String.format("DELETE FROM UserTable WHERE id=%d", id);

        try {
            this.preparedStatement = Util.getConnection().prepareStatement(sql);
            this.preparedStatement.executeUpdate();
        } catch (SQLException var5) {
            throw new RuntimeException(var5);
        }
    }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM UserTable";
        List<User> list = new ArrayList();

        try {
            this.preparedStatement = Util.getConnection().prepareStatement(sql);
            ResultSet resultset = this.preparedStatement.executeQuery(sql);

            while(resultset.next()) {
                list.add(new User(resultset.getString("name"), resultset.getString("lastName"), resultset.getByte("age")));
            }
        } catch (SQLException var4) {
            var4.printStackTrace();
        }

        return list;
    }

    public void cleanUsersTable() {
        String sql = "DELETE FROM UserTable";

        try {
            this.preparedStatement = Util.getConnection().prepareStatement(sql);
            this.preparedStatement.execute();
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

    }
}*/
