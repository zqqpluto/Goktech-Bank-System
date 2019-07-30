package cn.goktech.web;

import cn.goktech.pojo.Quanx;
import cn.goktech.service.QuanxService;
import cn.goktech.utils.Result;
import cn.goktech.vo.CaiDData;
import cn.goktech.vo.QuanxList;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/quanx")
public class QuanxWeb {

	@Autowired
	private QuanxService quanxService;

	/**
	 * 获取所有权限
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/easyuiGetData")
	@ResponseBody
	public Map<String, Object> getAll(@RequestParam(defaultValue = "1", required = false) int page, int rows,String quanxmc) {
		PageInfo<Quanx> pageInfo = quanxService.getAll(page, rows, quanxmc);
		if (pageInfo != null) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("total", pageInfo.getTotal());
			map.put("rows", pageInfo.getList());
			return map;
		}
		return null;
	}

	/**
	 * 添加权限和权限关联
	 * 
	 * @param list
	 * @return
	 */
	@RequestMapping("/addQuanx")
	@ResponseBody
	public Result addQuanx(@RequestBody QuanxList list) {
		boolean boo = quanxService.addQuanx(list);
		return boo == true ? Result.success(1) : Result.fail(-1);
	}

	/**
	 * 查询相应的权限用户的权限
	 * 
	 * @param quanxId
	 * @return
	 */
	@RequestMapping("/getAllCaidAndUserRights")
	@ResponseBody
	public List<CaiDData> getUserRights(@RequestParam("id") String quanxId) {
		List<CaiDData> cList = quanxService.getRights(quanxId);
		return cList;
	}

	/**
	 * 修改权限
	 * 
	 * @param list
	 * @return
	 */
	@RequestMapping("/modifyQuanx")
	@ResponseBody
	public Result modifyQuanx(@RequestBody QuanxList list) {
		boolean boo = quanxService.modifyQuanx(list);
		return boo == true ? Result.success(1) : Result.fail(-1);
	}

	/**
	 * 根据权限id删除权限
	 * 
	 * @param quanxId
	 * @return
	 */
	@RequestMapping("/delQuanx")
	@ResponseBody
	public Result delQuanx(@RequestParam("id") String quanxId) {
		boolean bool = quanxService.delQuanxUser(quanxId);
		return bool == true ? Result.success(1) : Result.fail(-1);
	}
	
	
	

}
