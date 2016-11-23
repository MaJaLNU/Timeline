package com.timeline.utils.admin;

import com.timeline.interfaces.AdminDAO;
import com.timeline.model.Admin;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by damma on 19.11.2016.
 */

@Service
public class AdminDAOImplement implements AdminDAO {

    private JdbcTemplate jdbcTemplateObject;

    public AdminDAOImplement() {
    }

    public AdminDAOImplement(DataSource dataSource) {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public Admin findAdmin(int id) {
        String SQL = "select * from admin where id = " + id;

        return jdbcTemplateObject.query(SQL, new ResultSetExtractor<Admin>() {
            public Admin extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    Admin admin = new Admin();
                    admin.setId(rs.getInt("id"));
                    admin.setMail(rs.getString("mail"));
                    admin.setPassword(rs.getString("password"));
                    return admin;
                }
                return null;
            }

        });
    }
}
