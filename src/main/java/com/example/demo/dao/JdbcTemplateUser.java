package com.example.demo.dao;

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcTemplateUser implements IUserDao {

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public User getOne(String login) {
        return jdbc.queryForObject("SELECT * FROM Users WHERE login=?", new Object[]{login}, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setName( resultSet.getString(1) );
                user.setSurname( resultSet.getString(2) );
                user.setLogin( resultSet.getString(3) );
                user.setPassword( resultSet.getString(4) );
                user.setEmail( resultSet.getString(5) );
                user.setInfo( resultSet.getString(6) );
                user.setCreateAt( resultSet.getDate(7) );

                return user;
            }
        });
    }

    @Override
    public List<User> getAll() {
        return jdbc.query("SELECT * FROM Users", new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet resultSet, int i) throws SQLException {
                        User user = new User();
                        user.setName( resultSet.getString(1) );
                        user.setSurname( resultSet.getString(2) );
                        user.setLogin( resultSet.getString(3) );
                        user.setPassword( resultSet.getString(4) );
                        user.setEmail( resultSet.getString(5) );
                        user.setInfo( resultSet.getString(6) );
                        user.setCreateAt( resultSet.getDate(7) );

                        return user;
                    }
                }
        );
    }

    @Override
    public User save(User user) {
        jdbc.update("INSERT INTO Users(name, surname, login, password, email, info, createdAt) VALUES (?, ?, ?, ?, ?, ?, ?)",
                user.getName(), user.getSurname(), user.getLogin(), user.getPassword(), user.getEmail(), user.getInfo(), user.getCreateAt());

        return user;
    }

    @Override
    public User remove(User user) {
        jdbc.update("DELETE FROM Users WHERE login=?", user.getLogin());

        return user;
    }
}
