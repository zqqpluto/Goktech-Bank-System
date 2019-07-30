package cn.goktech.dao;

import cn.goktech.pojo.Hexindatarepository;
import cn.goktech.pojo.HexindatarepositoryExample;
import cn.goktech.vo.StateCount;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HexindatarepositoryMapper {
    long countByExample(HexindatarepositoryExample example);

    int deleteByExample(HexindatarepositoryExample example);

    int insert(Hexindatarepository record);

    int insertSelective(Hexindatarepository record);

    List<Hexindatarepository> selectByExample(HexindatarepositoryExample example);

    int updateByExampleSelective(@Param("record") Hexindatarepository record, @Param("example") HexindatarepositoryExample example);

    int updateByExample(@Param("record") Hexindatarepository record, @Param("example") HexindatarepositoryExample example);

	List<StateCount> getStateCount();
}