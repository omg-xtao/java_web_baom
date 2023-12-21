package com.dao;

import com.entity.Stage;

import java.util.ArrayList;

/**
 * @author xtaod
 */
public interface StageDao {
    int add(Stage stage);
    int deleteByStagenum(int stagenum);
    ArrayList<Stage> findAll();
    Stage findByStagenum(int stagenum);
}
