package cn.goktech.vo;

import java.util.List;

public class CaidList {
	private String id;
	private String name;
	private String parentId;
	private String url;
	private String icon;
	private String order;
	private String isHeader;
	private List<CaidList> childMenus;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getIsHeader() {
		return isHeader;
	}

	public void setIsHeader(String isHeader) {
		this.isHeader = isHeader;
	}

	public List<CaidList> getChildMenus() {
		return childMenus;
	}

	public void setChildMenus(List<CaidList> childMenus) {
		this.childMenus = childMenus;
	}

}
