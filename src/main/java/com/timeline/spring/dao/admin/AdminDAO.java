package com.timeline.spring.dao.admin;

import java.sql.SQLException;

/**
 * Created by damma on 19.11.2016.
 */
public interface AdminDAO {
    boolean login(String mail, String password) throws SQLException;
}
