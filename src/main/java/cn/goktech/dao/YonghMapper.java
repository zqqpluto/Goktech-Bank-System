package cn.goktech.dao;

import cn.goktech.pojo.Yongh;
import cn.goktech.pojo.YonghExample;
import cn.goktech.vo.YonghList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface YonghMapper {
    long countByExample(YonghExample example);

    int deleteByExample(YonghExample example);

    int deleteByPrimaryKey(Object id);

    int insert(Yongh record);

    int insertSelective(Yongh record);

    List<Yongh> selectByExample(YonghExample example);

    Yongh selectByPrimaryKey(Object id);

    int updateByExampleSelective(@Param("record") Yongh record, @Param("example") YonghExample example);

    int updateByExample(@Param("record") Yongh record, @Param("example") YonghExample example);

    int updateByPrimaryKeySelective(Yongh record);

    int updateByPrimaryKey(Yongh record);
    
	/**
	 * 带用户权限的列表
	 * @return
	 */
	List<YonghList> getAll(YonghList y);
}