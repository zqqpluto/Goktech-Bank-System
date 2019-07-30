package cn.goktech.dao;

import java.math.BigDecimal;
import java.util.List;

import cn.goktech.pojo.Quanxgl;
import cn.goktech.pojo.QuanxglExample;
import org.apache.ibatis.annotations.Param;

public interface QuanxglMapper {
    long countByExample(QuanxglExample example);

    int deleteByExample(QuanxglExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(Quanxgl record);

    int insertSelective(Quanxgl record);

    List<Quanxgl> selectByExample(QuanxglExample example);

    Quanxgl selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") Quanxgl record, @Param("example") QuanxglExample example);

    int updateByExample(@Param("record") Quanxgl record, @Param("example") QuanxglExample example);

    int updateByPrimaryKeySelective(Quanxgl record);

    int updateByPrimaryKey(Quanxgl record);

}