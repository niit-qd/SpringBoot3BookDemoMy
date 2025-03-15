package org.example.dao;

import org.example.mybatis.entity.Actor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public abstract class ActorDao {

    @Transactional
    public abstract Actor findById(int id);

    @Transactional
    public abstract List<Actor> findAll();

    @Transactional(rollbackFor = {Exception.class})
    public abstract int updateFirstNameById(int id, String firstName) throws Exception;
}
