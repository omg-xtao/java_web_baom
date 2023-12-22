package com.dao.impl;

import com.dao.ReginfoDao;
import com.db.ConnectionFactory;
import com.entity.Reginfo;
import com.entity.mapper.ReginfoMapper;
import com.mybatisflex.core.query.QueryWrapper;
import com.util.PageModel;

import java.util.List;

import static com.entity.table.ReginfoTableDef.REGINFO;

/**
 * @author xtaod
 */
public class ReginfoDaoImpl implements ReginfoDao {
    private static final ReginfoMapper MAPPER = ConnectionFactory.getMapper(ReginfoMapper.class);

    @Override
    public int add(Reginfo reginfo) {
        return MAPPER.insert(reginfo);
    }

    @Override
    public int update(Reginfo reginfo) {
        return MAPPER.update(reginfo);
    }

    @Override
    public Reginfo findByUser(String username) {
        QueryWrapper qw = new QueryWrapper();
        qw.select(REGINFO.ALL_COLUMNS).where(REGINFO.USERNAME.eq(username));
        return MAPPER.selectOneByQuery(qw);
    }

    @Override
    public PageModel pageByMajorName(boolean queryMajorName, String majorName, boolean queryIsConfirm, Boolean isConfirm, int pageSize, int pageNo) {
        QueryWrapper qw = new QueryWrapper();
        qw.select(REGINFO.ALL_COLUMNS);
        if (queryMajorName) {
            qw.where(REGINFO.MNAME.eq(majorName));
        }
        if (queryIsConfirm) {
            qw.where(REGINFO.ISCONFIRM.eq(isConfirm));
        }
        List<Reginfo> reginfosList = MAPPER.selectListByQuery(qw);
        return new PageModel(pageSize, pageNo, null, reginfosList);
    }
}
