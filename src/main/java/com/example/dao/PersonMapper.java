package com.example.dao;

import com.example.domain.PersonDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by FlySheep on 17/3/24.
 */
@Mapper
public interface PersonMapper {

    /**
     * mybatis-spring-boot-starter的 github 源码地址为:
     * https://github.com/mybatis/spring-boot-starter
     * <p>
     * mybatis-spring-boot-stater的官方文档地址:
     * http://www.mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/
     * <p>
     * mybatis 官方中文文档：
     * http://www.mybatis.org/mybatis-3/zh/java-api.html
     */

    /**
     * 添加操作，返回新增元素的 ID
     *
     * @param personDO
     */
    @Insert("insert into person(name,age) values(#{name},#{age})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insert(PersonDO personDO);

    /**
     * 更新操作
     *
     * @param personDO
     * @return 受影响的行数
     */
    @Update("update person set name=#{name},age=#{age} where id=#{id}")
    Long update(PersonDO personDO);

    /**
     * 删除操作
     *
     * @param id
     * @return 受影响的行数
     */
    @Delete("delete from person where id=#{id}")
    Long delete(@Param("id") Long id);

    /**
     * 查询所有
     *
     * @return
     */
    @Select("select id,name,age from person")
    List<PersonDO> selectAll();

    /**
     * 根据主键查询单个
     *
     * @param id
     * @return
     */
    @Select("select id,name,age from person where id=#{id}")
    PersonDO selectById(@Param("id") Long id);
}
