package com.dao.impl;

import com.dao.CurrStageDao;
import com.db.ConnectionFactory;
import com.entity.CurrStage;
import com.entity.mapper.CurrStageMapper;
import com.mybatisflex.core.query.QueryWrapper;

import static com.entity.table.CurrStageTableDef.CURR_STAGE;

/**
 * @author xtaod
 */
public class CurrStageDaoImpl implements CurrStageDao {
    private CurrStageMapper mapper = null;

    public CurrStageDaoImpl() {
        mapper = ConnectionFactory.getMapper(CurrStageMapper.class);
    }

    @Override
    public int set(String adminname, String currstage) {
        CurrStage stage = new CurrStage();
        stage.setAdminname(adminname);
        stage.setStagename(currstage);
        return mapper.insert(stage);
    }

    @Override
    public CurrStage findCurrent() {
        QueryWrapper qw = new QueryWrapper();
        qw.select(CURR_STAGE.ALL_COLUMNS).orderBy(CURR_STAGE.CONFIGID.desc()).limit(1);
        return mapper.selectOneByQuery(qw);
    }
}
