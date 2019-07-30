package cn.goktech.utils;

public class Result {
	private int code;	//返回后状态码，一一般1是成功，-1是失败  50010  2001 200
	private String message;//返回的提示信息
	private Object data;//服务器返回给用户是数据，比如把用户的信息存储到其中
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
	public static Result success() {
		Result res = new Result();
		res.setCode(1);
		return res;
	}
	
	//请求成功返回数据给前端
	public static Result success(Object data) {
		Result res = new Result();
		res.setCode(1);
		res.setData(data);
		return res;
	}
	
	//请求失败
	public static Result fail(String message) {
		Result res = new Result();
		res.setCode(-1);
		res.setMessage(message);
		return res;
	}
	
	//请求失败
	public static Result fail(int code) {
		Result res = new Result();
		res.setCode(code);
		return res;
	}
	
}
