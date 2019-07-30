package cn.goktech.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.goktech.dao.QuanxMapper;
import cn.goktech.pojo.Quanx;
import cn.goktech.pojo.QuanxExample;
import cn.goktech.pojo.Quanxgl;
import cn.goktech.pojo.Yongh;
import cn.goktech.vo.CaiDData;
import cn.goktech.vo.QuanxList;

@Service
public class QuanxService {
	@Autowired
	private QuanxMapper quanxMapper;

	@Autowired
	private QuanxglService quanxglService;

	@Autowired
	private CaiDService caiDService;

	/**
	 * 获取所有权限（分页）
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	public PageInfo<Quanx> getAll(int page, int rows,String quanxmc) {
		QuanxExample example = new QuanxExample();
		if (!StringUtils.isEmpty(quanxmc)) {
			example.createCriteria().andQuanxmcLike("%"+quanxmc+"%");
		}
		PageHelper.startPage(page, rows);
		List<Quanx> qList = quanxMapper.selectByExample(example);
		PageInfo<Quanx> info = new PageInfo<Quanx>(qList);
		return info;
	}

	/**
	 * 获取所有菜单
	 * 
	 * @return
	 */
	public List<CaiDData> getAll() {
		List<CaiDData> cList = caiDService.getAll();
		return cList;
	}

	/**
	 * 添加用户和权限
	 * 
	 * @param list
	 * @return
	 */
	public boolean addQuanx(QuanxList list) {
		Quanx quanx = new Quanx();
		String uuid = UUID.randomUUID().toString();
		quanx.setId(uuid);
		quanx.setQuanxmc(list.getQuanxmc());
		int i = quanxMapper.insert(quanx);
		boolean boo = i == 1 ? true : false;

		boolean bool = quanxglService.addQuanxgl(uuid, list);
		return boo == true && bool == true ? true : false;
	}

	/**
	 * 查询权限用户名及用户的权限
	 * 
	 * @param quanxId
	 * @return
	 */
	public List<CaiDData> getRights(String quanxId) {
		// 1. 获取系统所有权权限
		List<CaiDData> cList = getAll();
		// 2. 查询该权限用户的权限菜单
		List<Quanxgl> qList = quanxglService.getUserRights(quanxId);
		// 3.判断用户是否有该权限
		Map<String, Object> quanxMap = new HashMap<String, Object>();
		for (Quanxgl quanxgl : qList) {
			quanxMap.put(quanxgl.getGuanldxbs().toString(), 1);
		}
		for (CaiDData caidData : cList) {
			if (quanxMap.get(caidData.getId()) != null && caidData.getChildren().size() == 0) {
				caidData.setChecked(true);
			}
			// 判断子菜单
			for (CaiDData child : caidData.getChildren()) {
				if (quanxMap.get(child.getId()) != null) {
					child.setChecked(true);
				}
			}
		}
		return cList;
	}

	/**
	 * 通过过id获取账户信息
	 * 
	 * @param quanxId
	 * @return
	 */
	public Quanx getQuanxById(String quanxId) {
		QuanxExample example = new QuanxExample();
		example.createCriteria().andIdEqualTo(quanxId);
		return quanxMapper.selectByExample(example).get(0);
	}

	/**
	 * 修改用户的权限及菜单
	 * 
	 * @param list
	 * @return
	 */
	public boolean modifyQuanx(QuanxList list) {
		Quanx quanx = new Quanx();
		quanx.setId(list.getId());
		quanx.setQuanxmc(list.getQuanxmc());
		QuanxExample quanxExample = new QuanxExample();
		quanxExample.createCriteria().andIdEqualTo(quanx.getId());
		int i = quanxMapper.updateByPrimaryKeySelective(quanx);
		boolean boo = i == 1 ? true : false;
		// 修改菜单权限
		boolean bool = quanxglService.modifyQuanxgl(quanx.getId(), list.getcList());
		return boo == true && bool == true ? true : false;
	}

	/**
	 * 根据权限id删除权限
	 * 
	 * @param quanxId
	 * @return
	 */
	public boolean delQuanxUser(String quanxId) {
		QuanxExample example = new QuanxExample();
		example.createCriteria().andIdEqualTo(quanxId);
		int i = quanxMapper.deleteByExample(example);
		boolean bool = quanxglService.delQuanxgl(quanxId);
		return i == 1 && bool == true ? true : false;
	}


}
