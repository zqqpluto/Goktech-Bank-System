package cn.goktech.vo;

import java.util.List;

public class QuanxList {
	private String id;
	private String quanxmc;
	private List<CaiDData> cList;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<CaiDData> getcList() {
		return cList;
	}

	public void setcList(List<CaiDData> cList) {
		this.cList = cList;
	}

	public String getQuanxmc() {
		return quanxmc;
	}

	public void setQuanxmc(String quanxmc) {
		this.quanxmc = quanxmc;
	}


}
