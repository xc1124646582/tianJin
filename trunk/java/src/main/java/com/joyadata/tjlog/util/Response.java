package com.joyadata.tjlog.util;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 
 * @ClassName: Response
 * @Description: Response
 * @author 黄宏强 st8817@163.com
 * @date 2017年9月27日 下午6:25:37
 * 
 * @param <T>
 */
@JsonInclude(value = Include.NON_NULL)
public class Response<T> {

	private int code;
	private String message;
	private Integer page;
	private Integer pager;
	private Integer total;
	private T result;

	public Response() {
		super();
	}

	public Response(int code, String message, T result, Integer page, Integer pager, Integer total) {
		super();
		this.code = code;
		this.message = message;
		this.result = result;
		this.page = page;
		this.pager = pager;
		this.total = total;
	}

	public Response(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

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

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getPager() {
		return pager;
	}

	public void setPager(Integer pager) {
		this.pager = pager;
	}

	public static class Code {
		public static final int Success = 0;
		public static final int Info = 1;
		public static final int Warning = 2;
		public static final int Error = -1;
	}

	@Override
	public String toString() {
		return "Response [code=" + code + ", message=" + message + ", page=" + page + ", total=" + total + ", result="
				+ result + "]";
	}

}
