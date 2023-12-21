package com;

import com.dao.impl.RecordDaoImpl;
import com.entity.Record;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author xtaod
 */
public class Main {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        RecordDaoImpl recordDao = new RecordDaoImpl();
        List<Record> r = recordDao.pageByLogname("mrwangzhe", "学生", 10, 1).getData();
        System.out.println(r.get(2).getLogtime().toString());
        System.out.println(sdf.format(r.get(2).getLogtime()));
    }
}
