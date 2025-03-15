package org.example.service;

import org.example.dao.ActorDao;
import org.example.dao.ActorDaoImpl;
import org.example.mybatis.entity.Actor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

//@Service
public class ActorService {
    Logger logger = LoggerFactory.getLogger(ActorDaoImpl.class);

    private final ActorDao actorDao;

    public ActorService(ActorDao actorDao) {
        this.actorDao = actorDao;
    }

    public Actor findById(int id) {
        return actorDao.findById(id);
    }

    public List<Actor> findAll() {
        return actorDao.findAll();
    }

    public int updateFirstNameById(int id, String firstName) throws Exception {
        return actorDao.updateFirstNameById(id, firstName);
    }
}
