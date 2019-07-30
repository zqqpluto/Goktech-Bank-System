package cn.goktech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.goktech.dao.HexindatarepositoryMapper;
import cn.goktech.pojo.Hexindatarepository;
import cn.goktech.pojo.HexindatarepositoryExample;
import cn.goktech.vo.StateCount;

@Service
public class YearCheckService {
	@Autowired
	private HexindatarepositoryMapper hexindatarepositoryMapper;

	/**
	 * 获取分页数据
	 * 
	 * @param page
	 *            页数
	 * @param rows
	 *            每页显示的条数
	 * @param zhdh
	 *            查询的条件
	 * @return
	 */
	public PageInfo<Hexindatarepository> getAll(int page, int rows, String zhdh) {
		PageHelper.startPage(page, rows);
		HexindatarepositoryExample example = new HexindatarepositoryExample();
		if (!StringUtils.isEmpty(zhdh)) {
			example.createCriteria().andZhdhLike("%" + zhdh + "%");
		}
		List<Hexindatarepository> lists = hexindatarepositoryMapper.selectByExample(example);
		PageInfo<Hexindatarepository> info = new PageInfo<Hexindatarepository>(lists);
		return info;
	}

	/**查询所有年检用户失败的数据
	 * @return
	 */
	public List<Hexindatarepository> getAllFaild() {
		HexindatarepositoryExample example = new HexindatarepositoryExample();
		example.createCriteria().andZhztEqualTo("2");//年间失败用户状态为2
		return hexindatarepositoryMapper.selectByExample(example);
	}

	public List<StateCount> getStateCount() {
		return hexindatarepositoryMapper.getStateCount();
	}

}
