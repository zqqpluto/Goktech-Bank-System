package cn.goktech.dao;

import cn.goktech.pojo.Caid;
import cn.goktech.pojo.CaidExample;
import cn.goktech.vo.CaiDData;
import cn.goktech.vo.CaidList;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CaidMapper {
    long countByExample(CaidExample example);

    int deleteByExample(CaidExample example);

    int deleteByPrimaryKey(String id);

    int insert(Caid record);

    int insertSelective(Caid record);

    List<Caid> selectByExample(CaidExample example);

    Caid selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Caid record, @Param("example") CaidExample example);

    int updateByExample(@Param("record") Caid record, @Param("example") CaidExample example);

    int updateByPrimaryKeySelective(Caid record);

    int updateByPrimaryKey(Caid record);

	List<CaiDData> selectGet1Cate();

	/**
	 * 查询一级菜单
	 * @param jiaosid
	 * @return
	 */
	List<CaidList> getFirstCaid(String jiaosid);

	/**
	 * 查询二级菜单
	 * @param id
	 * @return
	 */
	List<CaidList> getSecondtCaid(@Param("jiaosid") String jiaosid, @Param("id") String id);
}