package com.timeline.interfaces;

import com.timeline.model.Admin;

import java.util.List;

/**
 * Created by damma on 19.11.2016.
 */
public interface AdminDAO {
    Admin findAdmin(int id);
    List<Admin> getAllAdmins();
}
