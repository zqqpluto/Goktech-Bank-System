package cn.goktech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.goktech.dao.JigMapper;
import cn.goktech.pojo.Jig;
import cn.goktech.pojo.JigExample;

@Service
public class JigService {
	@Autowired
	private JigMapper jigMapper;

	/**
	 * 获取所有机构
	 * @return
	 */
	public List<Jig> getAllJg() {
		return jigMapper.selectByExample(new JigExample());
	}
	
}
