package com.drvkdclinic.db.dao;

import com.drvkdclinic.db.conn.DBConnectionManager;
import com.drvkdclinic.entity.Person;
import com.drvkdclinic.daoitf.IPersonDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DBPersonDAO implements IPersonDAO{

    public DBPersonDAO(Connection connection) throws SQLException {
        this.mConnection = DBConnectionManager.getConnection();
    }

    @Override
    public Optional<Person> findPersonById(int id) {
        String sql = "SELECT id, first_name, middle_name, sur_name FROM person WHERE id=?";
        try (PreparedStatement ps = mConnection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Person person = new Person();
                person.setId(rs.getInt("id"));
                person.setFirstName(rs.getString("first_name"));
                person.setMiddleName(rs.getString("middle_name"));
                person.setSurName(rs.getString("sur_name"));
                return Optional.of(person);
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find person.", e);
        }
    }

    @Override
    public List<Person> getAllPersons() {
        List<Person> allPersons = new ArrayList<>();
        String sql = "SELECT * FROM persons";
        try (PreparedStatement stmt = mConnection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Person person = new Person();
                person.setId(rs.getInt("id"));
                person.setFirstName(rs.getString("first_name"));
                person.setMiddleName(rs.getString("middle_name"));
                person.setSurName(rs.getString("sur_name"));
                allPersons.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find all persons.", e);
        }

        return allPersons;
    }

    @Override
    public void registerPerson(Person person) {
        String sql = "INSERT INTO person (id, first_name, middle_name, sur_name) VALUES (?, ?, ?, ?) " +
                "ON CONFLICT (id) DO UPDATE SET first_name=?, last_name=?, dob=?";
        try (PreparedStatement ps = mConnection.prepareStatement(sql)) {
            ps.setInt(1, person.getId());
            ps.setString(2, person.getFirstName());
            ps.setString(3, person.getMiddleName());
            ps.setString(4, person.getSurName());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to register person", e);
        }
    }

    private final Connection mConnection;
}
