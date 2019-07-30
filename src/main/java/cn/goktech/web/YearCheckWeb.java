package cn.goktech.web;

import cn.goktech.pojo.Hexindatarepository;
import cn.goktech.service.YearCheckService;
import cn.goktech.utils.TestPoi;
import cn.goktech.vo.StateCount;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/nianjian")
public class YearCheckWeb {
	@Autowired
	private YearCheckService checkService;

	/**
	 * 分页查询年检
	 * 
	 * @param page
	 * @param rows
	 * @param zhdh
	 * @return
	 */
	@RequestMapping("/getAll")
	@ResponseBody
	public Map<String, Object> getAll(@RequestParam(defaultValue = "1", required = false) int page, int rows,
			String zhdh) {
		PageInfo<Hexindatarepository> info = checkService.getAll(page, rows, zhdh);
		Map<String, Object> map = new HashMap<String, Object>();
		if (info != null) {
			map.put("total", info.getTotal());
			map.put("rows", info.getList());
		}
		return map;
	}

	/**
	 * 下载年间失败用户数据
	 * 
	 * @param response
	 */
	@RequestMapping("downNianJianFail")
	public void downNianJianFail(HttpServletResponse response) {
		// 1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
		response.setContentType("multipart/form-data");
		// 2.设置文件头：最后一个参数是设置下载文件名(假如我们叫a.pdf)
		String fileName = "年检失败数据.xls";
		try {
			fileName = URLEncoder.encode(fileName, "UTF-8");//解决文件中文名乱码
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;fileName="+fileName);
		response.setCharacterEncoding("utf-8");

		List<Hexindatarepository> list = checkService.getAllFaild();
		
		//构建身体
		JSONArray body = new JSONArray();
		JSONArray row = null;
		for (Hexindatarepository h : list) {
			row = new JSONArray();
			row.add(h.getId());
			row.add(h.getZhdh());
			row.add(h.getKhdh());
			row.add(h.getKhmc());
			row.add(h.getKhxkzhzh());
			row.add(h.getCkrmc());
			row.add(h.getGsmc());
			row.add(h.getGsyyzz());
			row.add(h.getGsdjzh());
			row.add(h.getDsdjzh());
			row.add(h.getFrxm());
			row.add(h.getFrzjzl());
			row.add(h.getFrzjhm());
			row.add(h.getZczjzl());
			row.add(h.getZczj());
			row.add(h.getJyfw());
			row.add(h.getDz());
			row.add(h.getYzbm());
			row.add(h.getKhyhdm());
			row.add(h.getKhyhjg());
			row.add(h.getZhxz());
			row.add(h.getKhsj());
			row.add(h.getZhzt());
			row.add(h.getZhmc());
			row.add(h.getTyshxydm());
			row.add(h.getZjyxq());
			row.add(h.getDqrq());
			row.add(h.getNjbj());
			row.add(h.getZjzl());
			row.add(h.getZjhm());
			body.add(row);
		}
		
		//构建头部
		JSONArray head = new JSONArray();
		head.add("ID");
		head.add("账户代号");
		head.add("客户代号");
		head.add("客户名称");
		head.add("开户许可证核准号");
		head.add("存款人名称");
		head.add("公司名称");
		head.add("工商营业执照");
		head.add("国税登记证号");
		head.add("地税登记证号");
		head.add("法人姓名");
		head.add("法人证件种类");
		head.add("法人证件号码");
		head.add("注册资金种类");
		head.add("注册资金");
		head.add("经营范围");
		head.add("地址");
		head.add("邮政编码");
		head.add("开户银行代码");
		head.add("开户银行机构");
		head.add("账户性质");
		head.add("开户时间");
		head.add("账户状态");
		head.add("账户名称");
		head.add("统一社会信用代码");
		head.add("证件有效期");
		head.add("证件到期日期");
		head.add("年检标记");
		head.add("证件种类(公司)");
		head.add("证件号码");
		HSSFWorkbook hssfWorkbook = TestPoi.expExcel(head, body);
		try {
			hssfWorkbook.write(response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("/getStateCount")
	@ResponseBody
	public List<StateCount> getStateCount() {
		return checkService.getStateCount();
	}
	
}
