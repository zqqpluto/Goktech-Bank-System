package cn.goktech.web;

import cn.goktech.pojo.Dazyhkh;
import cn.goktech.service.KaiHuService;
import cn.goktech.utils.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping("/kaihu")
public class KaiHuWeb {
	@Autowired
	private KaiHuService kaiHuService;

	/**
	 * 获取所有账户数据
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/easyuiGetData")
	@ResponseBody
	public Map<String, Object> easyuiGetData(@RequestParam(defaultValue = "1", required = false) int page, int rows,String cunkrmc) {
		PageInfo<Dazyhkh> info = kaiHuService.getAll(page, rows,cunkrmc);
		Map<String, Object> maps = new HashMap<String, Object>();
		if (info != null) {
			maps.put("total", info.getTotal());
			maps.put("rows", info.getList());
		}
		return maps;
	}

	/**
	 * 在业务层调用httpClient接口进行信息比较
	 * @param companyCode
	 * @return
	 */
	@RequestMapping("/checkData")
	@ResponseBody
	public Result checkData(String companyCode) {
//		return new Random().nextBoolean() == true ? Result.success() : Result.fail(-1);
		return new Random().nextBoolean() == true ? Result.success() : Result.success();
	}
	
	/**
	 * 保存开户
	 * @param dazyhkh
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Result save(@RequestBody Dazyhkh dazyhkh) {
		boolean boo = kaiHuService.save(dazyhkh);
		return boo?Result.success():Result.fail(-1);
		
	}
	
}
