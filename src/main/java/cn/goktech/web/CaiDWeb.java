package cn.goktech.web;

import cn.goktech.pojo.Caid;
import cn.goktech.pojo.Yongh;
import cn.goktech.service.CaiDService;
import cn.goktech.utils.ConstantsConfig;
import cn.goktech.vo.CaiDData;
import cn.goktech.vo.CaidList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/caid")
public class CaiDWeb {
	
	@Autowired
	private CaiDService caiDService;
	
	/**获取所有菜单
	 * @return
	 */
	@RequestMapping("/getAll")
	@ResponseBody
	public List<CaiDData> getAll(){
		List<CaiDData> cList = caiDService.getAll();
		return cList;
	}
	
	/**
	 * 添加菜单
	 * @throws IOException 
	 */
	@RequestMapping("/save")
	public void save(Caid caid,HttpServletResponse response) throws IOException{
		boolean res = caiDService.save(caid);
		response.sendRedirect("/Goktech-Bank-System/page/caid_list.html");
	}
	
	/**
	 * 修改菜单名称
	 * @param caid
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/rename")
	public void rename(Caid caid,HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		System.out.println(caid.getId()+"-->"+caid.getCaidmc());
		int i = caiDService.rename(caid);
		if(i>0) {
			response.getWriter().println("<script>alert('修改成功！');location.href='/Goktech-Bank-System/page/caid_list.html'</script>");
		}else {
			response.getWriter().println("<script>alert('修改失败！');location.href='/Goktech-Bank-System/page/caid_list.html'</script>");
		}
	}
	
	/**
	 * 删除菜单
	 * @param caid
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/delete")
	public void delete(Caid caid,HttpServletResponse response) throws IOException{
		int i = caiDService.delete(caid);
		if(i>0) {
			response.getWriter().println("<script>alert('修改成功！');location.href='/Goktech-Bank-System/page/cate_list.html'</script>");
		}else {
			response.getWriter().println("<script>alert('删除失败！');location.href='/Goktech-Bank-System/page/cate_list.html'</script>");
		}
	}
	
	/**
	 * 获取菜单列表
	 * @param jiaosid
	 * @return
	 */
	@RequestMapping("/getCaid")
	@ResponseBody
	public List<CaidList> getCaid(HttpSession session) {
		Yongh yongh = (Yongh)session.getAttribute(ConstantsConfig.SESSION_USER);
		String jiaosid = (String) yongh.getJiaosid();
		List<CaidList> caidLists = new ArrayList<CaidList>();
		CaidList caidList= new CaidList();
		caidList.setId("1");
		caidList.setName("主菜单");
		caidList.setParentId("0");
		caidList.setIcon("");
		caidList.setOrder("1");
		caidList.setIsHeader("1");
		
		List<CaidList> cList = caiDService.getFirstCaid(jiaosid);
		for (CaidList caidList2 : cList) {
			List<CaidList> childMenus = caiDService.getSecondtCaid(jiaosid,caidList2.getId());
			for (CaidList caidList3 : childMenus) {
				caidList3.setParentId(caidList2.getId());
				caidList3.setIcon("");
				caidList3.setOrder("1");
				caidList3.setIsHeader("0");
			}
			caidList2.setChildMenus(childMenus);
		}
		
		caidList.setChildMenus(cList);
		caidLists.add(caidList);
		return caidLists;
	}
}
