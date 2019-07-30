package cn.goktech.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.goktech.dao.YonghMapper;
import cn.goktech.pojo.Yongh;
import cn.goktech.pojo.YonghExample;
import cn.goktech.utils.ConstantsConfig;
import cn.goktech.vo.YonghList;

@Service
public class YongHService {
	@Autowired
	private YonghMapper yonghMapper;

	// public List<Yongh> getAll() {
	// return yonghMapper.selectByExample(null);
	// }

	/**
	 * 分页获取
	 * 
	 * @param nowpage
	 * @param size
	 * @return
	 */
	public List<Yongh> getAll(int nowpage, int size) {
		PageHelper.startPage(nowpage, size);
		List<Yongh> lists = yonghMapper.selectByExample(new YonghExample());
		PageInfo<Yongh> info = new PageInfo<Yongh>(lists);
		System.out.println(info.getTotal());
		return info.getList();
	}

	/**
	 * 用户分页
	 * 
	 * @param nowpage
	 * @param size
	 * @param zt
	 * @param zh
	 * @return
	 */
	public PageInfo getAll1(int nowpage, int size, String zh) {
		PageHelper.startPage(nowpage, size);
		// YonghExample example = new YonghExample();
		// YonghExample.Criteria ctr = example.createCriteria();
		YonghList y = new YonghList();
		if (!StringUtils.isEmpty(zh)) {
			y.setYonghzh(zh);
		}
		// List<Yongh> lists = yonghMapper.selectByExample(example);

		List<YonghList> lists = yonghMapper.getAll(y);
		PageInfo<YonghList> info = new PageInfo<YonghList>(lists);
		return info;
	}

	/**
	 * 验证账号是否存在，若存在密码是否正确
	 * 
	 * @param username
	 * @param password
	 * @param session
	 * @return 1 表示账户密码正确 0表示账号不存在，2表示密码错误
	 */
	public int login(String username, String password, HttpSession session) {
		int a = 0;
		YonghExample yonghExample = new YonghExample();
		YonghExample.Criteria criteria = yonghExample.createCriteria();
		criteria.andYonghzhEqualTo(username);
		List<Yongh> yonghLists = yonghMapper.selectByExample(yonghExample);
		if (yonghLists.size() > 0) {// 账户存在
			if (yonghLists.get(0).getYonghmm().equals(password)) {// 判断密码是否正确
				session.setAttribute(ConstantsConfig.SESSION_USER, yonghLists.get(0));
				a = 1;
			} else {
				a = 2;
			}
		}
		return a;
	}

	/**
	 * 更新用户信息
	 * 
	 * @param yongh
	 * @return 返回更新是否成功 成功true 失败 false
	 */
	public boolean update(Yongh yongh) {
		int i = yonghMapper.updateByPrimaryKeySelective(yongh);
		return i > 0 ? true : false;
	}

	/**
	 * 通过session的id获取账户的信息
	 * 
	 * @param yongh
	 * @return 一个Yongh对象
	 */
	public Yongh getInfo(Yongh yongh) {
		YonghExample yonghExample = new YonghExample();
		YonghExample.Criteria criteria = yonghExample.createCriteria();
		criteria.andIdEqualTo(yongh.getId());
		List<Yongh> yList = yonghMapper.selectByExample(yonghExample);
		yList.get(0).setYonghmm(null); // 设置密码未空
		return yList.get(0);
	}

	/**
	 * 更新账户的密码
	 * 
	 * @param yongh
	 * @param oldPassword
	 * @param newPassword
	 * @return 0代表原密码错误 1代表更新密码成功 2代表密码更新失败
	 */
	public int updatePassword(Yongh yongh, String oldPassword, String newPassword) {
		YonghExample yonghExample = new YonghExample();
		YonghExample.Criteria criteria = yonghExample.createCriteria();
		criteria.andIdEqualTo(yongh.getId());
		criteria.andYonghmmEqualTo(oldPassword);
		List<Yongh> yList = yonghMapper.selectByExample(yonghExample);
		if (yList.size() > 0) {// 原密码正确
			yList.get(0).setYonghmm(newPassword);
			int i = yonghMapper.updateByPrimaryKeySelective(yList.get(0));
			return i > 0 ? 1 : 2;
		}
		return 0;
	}

	/**
	 * 查询所有信息
	 * 
	 * @return
	 */
	public List<Yongh> getAll() {
		return yonghMapper.selectByExample(null);
	}

	/**
	 * 保存用户
	 * 
	 * @param yongh
	 * @return
	 */
	public boolean save(Yongh yongh) {
		yongh.setId(UUID.randomUUID().toString());
		Date date = new Date();
		// SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// String zhucsj = formatter.format(date);
		// yongh.setZhucsj(date);
		BigDecimal decimal = new BigDecimal(1);
		yongh.setYonghdlcs(decimal);
		yongh.setBumid("1");
		yongh.setZhanghzt("1");
		int i = yonghMapper.insertSelective(yongh);
		return i == 1 ? true : false;
	}

	/**
	 * 根据用户id获取用户信息
	 * 
	 * @param id
	 */
	public YonghList getInfoById(String id) {
		YonghList y = new YonghList();
		y.setId(id);
		List<YonghList> lists = yonghMapper.getAll(y);
		return lists.get(0);
	}

	/**
	 * 根据id修改用户信息
	 * 
	 * @param yongh
	 * @return
	 */
	public boolean modify(Yongh yongh) {
		BigDecimal decimal = new BigDecimal(1);
		yongh.setYonghdlcs(decimal);
		yongh.setBumid("1");
		yongh.setZhanghzt("1");
		YonghExample example = new YonghExample();
		example.createCriteria().andIdEqualTo(yongh.getId());
		int i = yonghMapper.updateByExampleSelective(yongh, example);
		return i == 1 ? true : false;
	}

	/**
	 * 删除用户
	 * 
	 * @param yongh
	 * @return
	 */
	public boolean delYongh(Yongh yongh) {
		YonghExample example = new YonghExample();
		example.createCriteria().andIdEqualTo(yongh.getId());
		int i = yonghMapper.deleteByExample(example);
		return i == 1 ? true : false;
	}

}
