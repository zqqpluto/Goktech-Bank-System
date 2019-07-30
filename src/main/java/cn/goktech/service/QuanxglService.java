package cn.goktech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.goktech.dao.QuanxglMapper;
import cn.goktech.pojo.Quanxgl;
import cn.goktech.pojo.QuanxglExample;
import cn.goktech.vo.CaiDData;
import cn.goktech.vo.QuanxList;

@Service
public class QuanxglService {

	@Autowired
	private QuanxglMapper quanxglMapper;

	/**
	 * 插入相应用户的权限 全部插入返回true否在返回fasle
	 * 
	 * @param uuid
	 * @param list
	 * @return
	 */
	public boolean addQuanxgl(String uuid, QuanxList list) {
		Quanxgl quanxgl;
		int i = 0;
		for (CaiDData q : list.getcList()) {
			quanxgl = new Quanxgl();
			quanxgl.setGuanldxlx("1");
			quanxgl.setGuanldxbs(q.getId());
			quanxgl.setGuanldxmc(q.getText());
			quanxgl.setQuanxid(uuid);
			quanxglMapper.insert(quanxgl);
			i += 1;
		}
		return i == list.getcList().size() ? true : false;
	}

	/**
	 * 查询指定id的用户的权限菜单
	 * 
	 * @param quanxId
	 * @return
	 */
	public List<Quanxgl> getUserRights(String quanxId) {
		QuanxglExample example = new QuanxglExample();
		example.createCriteria().andQuanxidEqualTo(quanxId);
		List<Quanxgl> qList = quanxglMapper.selectByExample(example);
		return qList;
	}

	/**
	 * 删除原来的权限，再加入权限
	 * 
	 * @param id
	 * @param cList
	 * @return
	 */
	public boolean modifyQuanxgl(Object id, List<CaiDData> cList) {
		// 删除原来的权限
		QuanxglExample example = new QuanxglExample();
		example.createCriteria().andQuanxidEqualTo(id);
		quanxglMapper.deleteByExample(example);
		// 添加权限
		Quanxgl quanxgl;
		int i = 0;
		for (CaiDData q : cList) {
			quanxgl = new Quanxgl();
			quanxgl.setGuanldxlx("1");
			quanxgl.setGuanldxbs(q.getId());
			quanxgl.setGuanldxmc(q.getText());
			quanxgl.setQuanxid(id);
			quanxglMapper.insert(quanxgl);
			i += 1;
		}
		return i == cList.size() ? true : false;
	}

	/**
	 * 根据权限id删除对应的的权限
	 * 
	 * @param quanxId
	 * @return
	 */
	public boolean delQuanxgl(String quanxId) {
		QuanxglExample example = new QuanxglExample();
		example.createCriteria().andQuanxidEqualTo(quanxId);
		int i = quanxglMapper.deleteByExample(example);
		return i == 0 ? false : true;
	}

}
