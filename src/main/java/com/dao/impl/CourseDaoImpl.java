package com.dao.impl;

import com.dao.CourseDao;
import com.db.ConnectionFactory;
import com.entity.Course;
import com.entity.mapper.CourseMapper;
import com.mybatisflex.core.query.QueryWrapper;

import java.util.ArrayList;

import static com.entity.table.CourseTableDef.COURSE;

/**
 * @author xtaod
 */
public class CourseDaoImpl implements CourseDao {
    private static final CourseMapper mapper = ConnectionFactory.getMapper(CourseMapper.class);

    @Override
    public int add(Course course) {
        return mapper.insert(course);
    }

    @Override
    public int deleteByCcode(String ccode) {
        QueryWrapper qw = new QueryWrapper();
        qw.where(COURSE.CCODE.eq(ccode));
        return mapper.deleteByQuery(qw);
    }

    @Override
    public ArrayList<Course> findAll() {
        return (ArrayList<Course>) mapper.selectAll();
    }

    @Override
    public Course findByCcode(String ccode) {
        QueryWrapper qw = new QueryWrapper();
        qw.where(COURSE.CCODE.eq(ccode));
        return mapper.selectOneByQuery(qw);
    }

    @Override
    public ArrayList<Course> findByCmname(String cmname) {
        QueryWrapper qw = new QueryWrapper();
        qw.where(COURSE.CMNAME.eq(cmname));
        return (ArrayList<Course>) mapper.selectListByQuery(qw);
    }
}
