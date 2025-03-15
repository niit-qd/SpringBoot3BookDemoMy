package org.example.dao;

import org.example.mybatis.entity.Actor;
import org.example.mybatis.mapper.ActorMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public class ActorDaoImpl extends ActorDao {

    Logger logger = LoggerFactory.getLogger(ActorDaoImpl.class);

    private final ActorMapper actorMapper;

    public ActorDaoImpl(ActorMapper actorMapper) {
        this.actorMapper = actorMapper;
    }

    @Override
    public Actor findById(int id) {
        logger.info("id = {}, mapper = {}", id, actorMapper);
        return actorMapper.findById(id);
    }

    @Override
    public List<Actor> findAll() {
        return actorMapper.findAll();
    }

    @Override
    public int updateFirstNameById(int id, String firstName) throws Exception {
        int rows = actorMapper.updateFirstNameById(id, firstName);
        logger.info("rows = {}", rows);
        throw new Exception("哈哈，出错了吧");
        // return rows;
    }
}
