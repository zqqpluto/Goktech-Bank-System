package cn.goktech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.goktech.dao.CaidMapper;
import cn.goktech.pojo.Caid;
import cn.goktech.pojo.CaidExample;
import cn.goktech.vo.CaiDData;
import cn.goktech.vo.CaidList;

@Service
public class CaiDService {

	@Autowired
	private CaidMapper caidMapper;

	/**查询所有菜单
	 * @return
	 */
	public List<CaiDData> getAll() {
		// 查询一级菜单
		List<CaiDData> onecate = caidMapper.selectGet1Cate();
		CaidExample caidExample;
		for (CaiDData caiDData : onecate) {
			caidExample = new CaidExample();
			caidExample.createCriteria().andIdLike(caiDData.getId()+"__");
			List<Caid> child = caidMapper.selectByExample(caidExample);
			//
			List<CaiDData> cList = changeListCaid2CaiDData(child);
			caiDData.setChildren(cList);
		}
		return onecate;
	}

	/**将List<Caid>转换List<CaiDData>
	 * @param child
	 * @return
	 */
	private List<CaiDData> changeListCaid2CaiDData(List<Caid> child) {
		List<CaiDData> cList = new ArrayList<CaiDData>();
		CaiDData data ;
		for (Caid caid : child) {
			data = new CaiDData();
			data.setId(caid.getId());
			data.setText(caid.getCaidmc());
			cList.add(data);
		}
		return cList;
	}

	/**
	 * 添加菜单
	 * @param caid
	 * @return
	 */
	public boolean save(Caid caid) {
		CaidExample example = new CaidExample();
		example.setOrderByClause("id desc");//设置排序
		example.createCriteria().andIdLike(caid.getId()+"__");
		
		List<Caid> list = caidMapper.selectByExample(example);
		Caid maxCaid = null;
		String finalId = "";
		if(list.size()>0) {
			maxCaid = list.get(0);
			String id = maxCaid.getId();
			String childid = id.substring(2);
			if(childid.charAt(0)=='0') {
				char last = childid.charAt(1);
				finalId = Integer.parseInt(last+"")+1+"";
				if(finalId.length()==1) {
					finalId = "0"+finalId;
				}
			}else {
				finalId = Integer.parseInt(childid)+1+"";
			}
		}else {
			finalId = "01";
		}
		caid.setId(caid.getId()+finalId);
		int i = caidMapper.insertSelective(caid);
		return i > 0 ? true : false;
	}

	/**
	 * 删除菜单
	 * @param caid
	 * @return
	 */
	public int delete(Caid caid) {
		CaidExample example = new CaidExample();
		example.createCriteria().andIdEqualTo(caid.getId());
		return caidMapper.deleteByExample(example);
	}

	/**
	 * 修改菜单名称
	 * @param caid
	 * @return
	 */
	public int rename(Caid caid) {
		CaidExample example = new CaidExample();
		example.createCriteria().andIdEqualTo(caid.getId());
		return caidMapper.updateByExampleSelective(caid, example);
	}

	/**
	 * 获取一级菜单
	 * @param jiaosid
	 * @return
	 */
	public List<CaidList> getFirstCaid(String jiaosid) {
		List<CaidList> cList = caidMapper.getFirstCaid(jiaosid);
		for (CaidList caidList : cList) {
			caidList.setParentId("1");
			caidList.setUrl("");
			caidList.setIcon("&#xe604;");
			caidList.setOrder("1");
			caidList.setIsHeader("0");
		}
		return cList;
	}

	/**
	 * 获取二级菜单
	 * @param id
	 * @return
	 */
	public List<CaidList> getSecondtCaid(String jiaosid,String id) {
		List<CaidList> cList = caidMapper.getSecondtCaid(jiaosid,id);
		return cList;
	}
	
	
	
}
