package com.timeline.spring.dao.admin;

import com.timeline.spring.model.Admin;
import org.springframework.stereotype.Service;

/**
 * Created by damma on 19.11.2016.
 */

@Service
public class AdminService {

    //@Autowired
    AdminDAO adminDao;

    public AdminService() {
        adminDao = new AdminDAOImplement();
    }

    public Admin findAdminByMail(String mail) {
        return adminDao.findAdmin(mail);
    }

    public Admin loginAdmin(String mail, String password) {
        Admin admin = this.findAdminByMail(mail);
        if (admin != null && admin.getPassword().equals(password)) {
            return admin;
        }
        return null;
    }


}
