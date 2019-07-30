package cn.goktech.dao;

import cn.goktech.pojo.Jig;
import cn.goktech.pojo.JigExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JigMapper {
    long countByExample(JigExample example);

    int deleteByExample(JigExample example);

    int deleteByPrimaryKey(String id);

    int insert(Jig record);

    int insertSelective(Jig record);

    List<Jig> selectByExample(JigExample example);

    Jig selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Jig record, @Param("example") JigExample example);

    int updateByExample(@Param("record") Jig record, @Param("example") JigExample example);

    int updateByPrimaryKeySelective(Jig record);

    int updateByPrimaryKey(Jig record);
}