package com.timeline.spring.dao.admin;

import com.timeline.spring.model.Admin;

/**
 * Created by damma on 19.11.2016.
 */
public interface AdminDAO {
    Admin findAdmin(String mail);
}
