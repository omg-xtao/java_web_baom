package com.dao.impl;

import com.dao.StageDao;
import com.db.ConnectionFactory;
import com.entity.Stage;
import com.entity.mapper.StageMapper;
import com.mybatisflex.core.query.QueryWrapper;

import java.util.ArrayList;

import static com.entity.table.StageTableDef.STAGE;

/**
 * @author xtaod
 */
public class StageDaoImpl implements StageDao {
    private static final StageMapper mapper = ConnectionFactory.getMapper(StageMapper.class);

    @Override
    public int add(Stage stage) {
        return mapper.insert(stage);
    }

    @Override
    public int deleteByStagenum(int stagenum) {
        QueryWrapper qw = new QueryWrapper();
        qw.where(STAGE.STAGENUM.eq(stagenum));
        return mapper.deleteByQuery(qw);
    }

    @Override
    public ArrayList<Stage> findAll() {
        return (ArrayList<Stage>) mapper.selectAll();
    }

    @Override
    public Stage findByStagenum(int stagenum) {
        QueryWrapper qw = new QueryWrapper();
        qw.select(STAGE.ALL_COLUMNS).where(STAGE.STAGENUM.eq(stagenum));
        return mapper.selectOneByQuery(qw);
    }
}
