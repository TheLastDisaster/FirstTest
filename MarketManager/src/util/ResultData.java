package util;

import java.io.Serializable;

public class ResultData implements Serializable{
	private static final long serialVersionUID = 4144739726803459152L;
	private String msg;
	private int flag;
	private Object data;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
