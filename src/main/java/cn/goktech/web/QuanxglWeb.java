package cn.goktech.web;

import cn.goktech.service.QuanxglService;
import cn.goktech.vo.QuanxList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class QuanxglWeb {
	
	@Autowired
	private QuanxglService quanxglService;

	/**添加对对应的菜单
	 * @param uuid
	 * @param list
	 * @return
	 */
	public boolean addQuanxgl(String uuid, QuanxList list) {
		quanxglService.addQuanxgl(uuid, list);
		return false;
	}

}
