package com.dao.impl;

import com.dao.GradeDao;
import com.db.ConnectionFactory;
import com.entity.Grade;
import com.entity.mapper.GradeMapper;
import com.mybatisflex.core.query.QueryWrapper;

import java.util.ArrayList;

import static com.entity.table.GradeTableDef.GRADE;

/**
 * @author xtaod
 */
public class GradeImpl implements GradeDao {
    private final GradeMapper mapper = ConnectionFactory.getMapper(GradeMapper.class);

    @Override
    public int add(Grade grade) {
        return mapper.insert(grade);
    }

    @Override
    public int update(Grade grade) {
        return mapper.update(grade);
    }

    @Override
    public ArrayList<Grade> queryAll() {
        return (ArrayList<Grade>) mapper.selectAll();
    }

    @Override
    public Grade findByTestcardnumAndCname(String testCardNum, String cName) {
        QueryWrapper qw = new QueryWrapper();
        qw.select(GRADE.ALL_COLUMNS).where(GRADE.TESTCARDNUM.eq(testCardNum).and(GRADE.CNAME.eq(cName)));
        return mapper.selectOneByQuery(qw);
    }
}
