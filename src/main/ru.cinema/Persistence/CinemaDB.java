package Persistence;

import Model.Account;
import Model.Place;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CinemaDB implements WorkerDB {
    private BasicDataSource bd = new BasicDataSource();

    private CinemaDB() {
        bd.setDriverClassName("com.mysql.cj.jdbc.Driver");
        bd.setUrl("jdbc:mysql://localhost:3306/cinema?useUnicode=true&" +
                "useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        bd.setUsername("root");
        bd.setPassword("root");
        bd.setMaxOpenPreparedStatements(20);
    }

    private static final class Lazy {
        private static final WorkerDB INST = new CinemaDB();
    }

    public static WorkerDB getInstance() {
        return Lazy.INST;
    }


    @Override
    public List<Place> getHall() {
        List<Place> places = new ArrayList<>();
        try (Connection cn = bd.getConnection();
             PreparedStatement ps = cn.prepareStatement("SELECT  * FROM hall")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                places.add(
                        new Place(
                                rs.getInt("id"),
                                rs.getInt("x"),
                                rs.getInt("y"),
                                rs.getInt("free"),
                                rs.getString("username")
                        ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Collections.reverse(places);
        return places;
    }

    @Override
    public void busyByTicketId(int id, String username) {
        try (Connection cn = bd.getConnection();
             PreparedStatement ps = cn.prepareStatement("UPDATE hall SET free = 1, username=? where id =? ")) {
            ps.setString(1, username);
            ps.setInt(2, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Account addAccount(Account account) {
        try (Connection cn = bd.getConnection();
             PreparedStatement ps = cn.prepareStatement("INSERT INTO account(name,phone,place_id) values (?,?,?)",
                     PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, account.getName());
            ps.setInt(2, account.getPhone());
            ps.setInt(3, account.getPlace_id());
            ps.execute();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    account.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public Account getAccByName(String name) {
        Account account = null;

        try (Connection cn = bd.getConnection();
             PreparedStatement ps = cn.prepareStatement("SELECT * FROM account where name  = ? ")) {

            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                account = new Account(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("phone"),
                        rs.getInt("place_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }
}
