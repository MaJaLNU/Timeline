package com.timeline.utils;

import com.timeline.interfaces.AdminDAO;
import com.timeline.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by damma on 19.11.2016.
 */

public class AdminService {

    @Autowired
    AdminDAO adminDao;

    public AdminService() {
        adminDao = new AdminDAOImplement();
    }

    public Admin findAdminById(int id) {
        return adminDao.findAdmin(id);
    }

    public Admin loginAdmin(int id, String password) {
        Admin admin = this.findAdminById(id);
        if (admin != null && admin.getPassword().equals(password)) {
            return admin;
        }
        return null;
    }


}
