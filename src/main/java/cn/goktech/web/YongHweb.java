package cn.goktech.web;

import cn.goktech.Exception.YonghException;
import cn.goktech.pojo.Yongh;
import cn.goktech.service.YongHService;
import cn.goktech.utils.ConstantsConfig;
import cn.goktech.utils.Result;
import cn.goktech.vo.YonghList;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/yongh")
public class YongHweb {
	
	@Autowired
	private YongHService yongHService;

	Logger log = LoggerFactory.getLogger(YongHweb.class);
	
	@Deprecated
	@RequestMapping("/getAll")
	@ResponseBody
	public List<Yongh> getAll(int nowpage, int size) {

		return yongHService.getAll(nowpage, size);
	}

	/**
	 * 登录操作
	 * 
	 * @param username
	 * @param password
	 * @param session
	 * @return 一个包含状态，提示信息，和对象的json文件
	 */
	@RequestMapping("/login")
	@ResponseBody // 返回前端请求的方式：返回一个对象，包括code=1，messsag="提示信息"，data对象
	public Result login(String username, String password, HttpSession session) {
		
		
		if (StringUtils.isEmpty(username)) {
			Result.fail("用户名不能为空");
		}
		if (StringUtils.isEmpty(password)) {
			Result.fail("密码不能为空");
		}
		int res = yongHService.login(username, password, session);
		if (res == 1) {
			
			//登录日志
			log.info("{} 登录成功",username.toString());
			
			return Result.success();
		} else if (res == 2) {
			log.info("{} 密码错误",username.toString());
			return Result.fail("密码错误");
		}
		return Result.fail("账户不存在");
	}

	/**
	 * 退出功能
	 * 
	 * @param session
	 * @return 退出成功
	 */
	@RequestMapping("/out")
	@ResponseBody
	public Result out(HttpSession session) {
		log.info("{} 退出系统",((Yongh)session.getAttribute(ConstantsConfig.SESSION_USER)).getId());//退出系统
		session.removeAttribute(ConstantsConfig.SESSION_USER);
		return Result.success();
	}

	/**
	 * 获取账户信息，从数据库获取，防止在更新用户自身数据的时候出现session未更新
	 * 
	 * @param session
	 * @return Result对象
	 */
	@RequestMapping("/getinfo")
	@ResponseBody
	public Result getInfo(HttpSession session) {
		Yongh yongh = (Yongh) session.getAttribute(ConstantsConfig.SESSION_USER);
		yongh = yongHService.getInfo(yongh);
		return Result.success(yongh);
	}

	/**
	 * 更新用户数据
	 * 
	 * @param session
	 * @param yongh
	 * @param response
	 * @return 返回信息更新
	 */
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	@ResponseBody
	public Result updateUser(HttpSession session, @RequestBody Yongh yongh, HttpServletResponse response) {
		Yongh yonghSession = (Yongh) session.getAttribute(ConstantsConfig.SESSION_USER);
		// 更新数据
		yongh.setId(yonghSession.getId());
		boolean res = yongHService.update(yongh);
		if (res == true) {
			return Result.success();
		} else {
			return Result.fail("信息更新失败");
		}
	}

	/**
	 * 更新用户密码
	 * 
	 * @param session
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */
	@RequestMapping("/updatePassword")
	@ResponseBody
	public Result updatePassword(HttpSession session, String oldPassword, String newPassword) {
		Yongh yongh = (Yongh) session.getAttribute(ConstantsConfig.SESSION_USER);
		int res = yongHService.updatePassword(yongh, oldPassword, newPassword);
		if (res == 0) {
			return Result.fail(0);// 原密码错误
		} else if (res == 1) {
			return Result.success();
		} else {
			return Result.fail(2);// 密码更新失败
		}
	}

	/**
	 * 查询所有用户
	 * 
	 * @param page
	 * @param rows
	 * @param zh
	 * @return
	 * @throws YonghException 
	 */
	@RequestMapping("/easyuiGetData")
	@ResponseBody
	public Map<String, Object> easyuiGetData(@RequestParam(defaultValue = "1", required = false) int page, int rows,
			String zh) throws YonghException {
		if (rows == 0) {
			throw new YonghException("rows 的值不合法");
		}
		PageInfo<YonghList> info = yongHService.getAll1(page, rows, zh);
		Map<String, Object> map = new HashMap<String, Object>();
		if (info != null) {
			map.put("total", info.getTotal());
			map.put("rows", info.getList());
		}
		return map;
	}

	/**
	 * 保存用户
	 * 
	 * @param yongh
	 * @return
	 */
	@RequestMapping("/save")
	public void save(Yongh yongh, HttpServletResponse response) {
		boolean boo = yongHService.save(yongh);
		try {
			response.setCharacterEncoding("utf-8");
			if (boo) {
				response.getWriter().append("<script>alert('保存成功')</script>");

			} else {
				response.getWriter().append("<script>alert('保存失败')</script>");
			}
			response.sendRedirect("/Goktech-Bank-System/page/yonghu_list.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 根据用户id获取账户信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/getInfoById")
	@ResponseBody
	public YonghList getInfoById(String id) {
		YonghList lists = yongHService.getInfoById(id);
		
		return lists;
	}

	/**
	 * 修改用户
	 * 
	 * @param yongh
	 * @return
	 */
	@RequestMapping("/modify")
	public void modify(Yongh yongh, HttpServletResponse response) {
		System.out.println(yongh.getId());
		boolean boo = yongHService.modify(yongh);
		try {
			response.setCharacterEncoding("utf-8");
			if (boo) {
				response.getWriter().append("<script>alert('修改成功')</script>");

			} else {
				response.getWriter().append("<script>alert('修改失败')</script>");
			}
			response.sendRedirect("/Goktech-Bank-System/page/yonghu_list.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("/delYongh")
	@ResponseBody
	public Result delYongh(String id) {
		Yongh yongh = new Yongh();
		yongh.setId(id);
		boolean boo = yongHService.delYongh(yongh);
		return boo == true ? Result.success() : Result.fail(-1);
	}

}
