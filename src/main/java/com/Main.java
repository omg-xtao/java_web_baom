package com;

import com.dao.StuDao;
import com.dao.impl.StuDaoImpl;
import com.entity.Stu;
import com.util.Encrypt;

/**
 * @author xtaod
 */
public class Main {
    public static void main(String[] args) {
        StuDao stuDao = new StuDaoImpl();
        String username = "1";
        String password = "1";
        String regip = "1";
        Stu stu = new Stu();
        stu.setUsername(username);
        stu.setPassword(Encrypt.SHA(password));
        stu.setRegip(regip);
        if (stuDao.findByUsername(username) != null) {
            System.out.println("用户名已存在");
        } else {
            stuDao.add(stu);
        }
    }
}
