package cn.goktech.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.goktech.dao.DazyhkhMapper;
import cn.goktech.pojo.Dazyhkh;
import cn.goktech.pojo.DazyhkhExample;

@Service
public class KaiHuService {
	@Autowired
	private DazyhkhMapper dazyhkhMapper;
	int i = 100;

	/**
	 * 账户分页
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	public PageInfo<Dazyhkh> getAll(int page, int rows,String cunkrmc) {
		PageHelper.startPage(page, rows);
		DazyhkhExample dazyhkhExample = new DazyhkhExample();
		if (!StringUtils.isEmpty(cunkrmc)) {
			dazyhkhExample.createCriteria().andCunkrmcLike("%"+cunkrmc+"%");
		}
		List<Dazyhkh> lists = dazyhkhMapper.selectByExample(dazyhkhExample);
		PageInfo<Dazyhkh> info = new PageInfo<Dazyhkh>(lists);
		return info;
	}

	/**
	 * 保存开户
	 * 
	 * @param dazyhkh
	 * @return
	 */
	public boolean save(Dazyhkh dazyhkh) {
		System.out.println(dazyhkh.getJigid());
		dazyhkh.setId(UUID.randomUUID().toString());
		// 生成流水号
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHH");
		String dateStr = dateTimeFormatter.format(dateTime);
		dateStr = dateStr + ++i;
		dazyhkh.setLiush(dateStr);
		if (i == 1000) {
			i = 100;
		}
		int i = dazyhkhMapper.insertSelective(dazyhkh);
		return i == 1 ? true : false;
	}

}
