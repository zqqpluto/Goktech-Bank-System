package cn.goktech.vo;

import java.util.List;

public class CaiDData {
	private String id;
	private String text;
	private boolean checked;
	private List<CaiDData> children;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public List<CaiDData> getChildren() {
		return children;
	}

	public void setChildren(List<CaiDData> children) {
		this.children = children;
	}
}
