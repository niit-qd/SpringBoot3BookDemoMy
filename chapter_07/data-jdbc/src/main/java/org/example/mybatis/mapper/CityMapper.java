package org.example.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.mybatis.entity.City;

@Mapper
public interface CityMapper extends BaseMapper<City> {
}
