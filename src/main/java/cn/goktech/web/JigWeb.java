package cn.goktech.web;

import cn.goktech.pojo.Jig;
import cn.goktech.service.JigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("Jig")
public class JigWeb {
	@Autowired 
	private JigService jigService;
	
	/**
	 * 获取所有机构
	 * @return
	 */
	@RequestMapping("/getJg")
	@ResponseBody
	public List<Jig> getJg() {
		List<Jig> jList = jigService.getAllJg();
		return jList;
	}
}
