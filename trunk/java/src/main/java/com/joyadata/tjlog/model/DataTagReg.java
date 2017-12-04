package com.joyadata.tjlog.model;

/**
 * 数据匹配标签规则
 * 
 * @ClassName: DataTagReg
 * @Description: DataTagReg
 * @author 黄宏强 st8817@163.com
 * @date 2017年11月21日 上午10:11:38
 *
 */
public class DataTagReg {

	private String id;
	private String tagName;
	private String tagId;
	private String regStr;
	private String status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getTagId() {
		return tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId;
	}

	public String getRegStr() {
		return regStr;
	}

	public void setRegStr(String regStr) {
		this.regStr = regStr;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
