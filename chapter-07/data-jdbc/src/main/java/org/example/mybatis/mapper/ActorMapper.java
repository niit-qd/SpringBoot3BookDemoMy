package org.example.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.mybatis.entity.Actor;

import java.util.List;

//@Mapper
public interface ActorMapper {
    Actor findById(@Param(value = "actor_id") int id);

    List<Actor> findAll();

    int updateFirstNameById(@Param(value = "actor_id") int id, @Param(value = "first_name") String firstName);
}
