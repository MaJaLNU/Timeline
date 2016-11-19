package com.timeline.utils;

import com.timeline.interfaces.AdminDAO;
import com.timeline.model.Admin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damma on 19.11.2016.
 */
public class AdminDAOImplement implements AdminDAO {

    private List<Admin> allAdmins;

    public AdminDAOImplement() {
        this.allAdmins = new ArrayList<Admin>();
        Admin test = new Admin(0, "test", "test");
    }

    public Admin findAdmin(int id) {
        return allAdmins.get(id);
    }

    public List<Admin> getAllAdmins() {
        return allAdmins;
    }


}
