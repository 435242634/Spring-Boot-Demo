package com.example.mapper;

import com.example.domain.PersonDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by FlySheep on 17/3/25.
 */
@Mapper
public interface PersonMapper {

    PersonDO selectPersonById(Integer id);

    List<PersonDO> selectAll();

    void insert(PersonDO personDO);

    Long update(PersonDO personDO);

    Long delete(Long id);
}
