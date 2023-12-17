package com;

import com.dao.StuDao;
import com.dao.impl.RecordDaoImpl;
import com.dao.impl.StuDaoImpl;
import com.entity.Record;
import com.entity.Stu;
import com.util.Encrypt;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author xtaod
 */
public class Main {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        RecordDaoImpl recordDao = new RecordDaoImpl();
        List<Record> r = recordDao.pageByLogname("mrwangzhe", 10, 1).getData();
        System.out.println(r.get(2).getLogtime().toString());
    }
}
