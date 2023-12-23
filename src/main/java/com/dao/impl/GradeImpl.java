package com.dao.impl;

import com.dao.GradeDao;
import com.db.ConnectionFactory;
import com.entity.Grade;
import com.entity.GradeVo;
import com.entity.mapper.GradeMapper;
import com.mybatisflex.core.query.QueryWrapper;

import java.util.ArrayList;

import static com.entity.table.GradeTableDef.GRADE;
import static com.entity.table.ReginfoTableDef.REGINFO;

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

    @Override
    public ArrayList<Grade> findByTestcardnum(String testCardNum) {
        QueryWrapper qw = new QueryWrapper();
        qw.select(GRADE.ALL_COLUMNS).where(GRADE.TESTCARDNUM.like(testCardNum));
        return (ArrayList<Grade>) mapper.selectListByQuery(qw);
    }

    @Override
    public ArrayList<Grade> findBySname(String sname) {
        QueryWrapper qw = new QueryWrapper();
        qw.select(GRADE.ALL_COLUMNS).where(GRADE.SNAME.like(sname));
        return (ArrayList<Grade>) mapper.selectListByQuery(qw);
    }

    @Override
    public ArrayList<GradeVo> findByMName(String mName) {
        QueryWrapper qw = new QueryWrapper();
        qw.select()
                .from(GRADE)
                .leftJoin(REGINFO).on(GRADE.TESTCARDNUM.eq(REGINFO.TESTCARDNUM))
                .where(REGINFO.MNAME.eq(mName));
        return (ArrayList<GradeVo>) mapper.selectListByQueryAs(qw, GradeVo.class);
    }
}
