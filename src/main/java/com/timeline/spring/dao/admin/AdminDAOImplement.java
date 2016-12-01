package com.timeline.spring.dao.admin;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by damma on 19.11.2016.
 */

public class AdminDAOImplement implements AdminDAO {

    private JdbcTemplate jdbcTemplateObject;

    public AdminDAOImplement(DataSource dataSource) {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }


    public boolean login(String mail, String password) throws SQLException {
        String sql = "Select count(1) from user where email = ? and password = ?";
        boolean result = false;

        int count = jdbcTemplateObject.queryForObject(
                sql, new Object[]{mail, password}, Integer.class);

        if (count > 0) {
            result = true;
        }

        return result;
    }
}
