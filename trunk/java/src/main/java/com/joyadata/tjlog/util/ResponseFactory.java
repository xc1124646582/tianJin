package com.joyadata.tjlog.util;

/**
 * 
 * @ClassName: ResponseFactory
 * @Description: ResponseFactory
 * @author 黄宏强 st8817@163.com
 * @date 2017年9月27日 下午6:25:44
 *
 */
public class ResponseFactory {

	public static <T> Response<T> makeResponse(Integer code, T t, Integer page, Integer pager, Integer total) {
		String msg = null;
		switch (code) {
		case Response.Code.Success:
			msg = "success";
			break;
		case Response.Code.Info:
			msg = "info";
			break;
		case Response.Code.Warning:
			msg = "warning";
			break;
		case Response.Code.Error:
			msg = "error";
			break;
		// no default
		}

		return new Response<T>(code, msg, t, page, pager, total);
	}

	public static <T> Response<T> makeResponse(int code, String msg, T t) {
		return new Response<T>(code, msg, t, null, null, null);
	}

	public static <T> Response<T> makeResponse(int code, String msg, T t, Integer page, Integer pager, Integer total) {
		return new Response<T>(code, msg, t, page, pager, total);
	}

	/**
	 * 
	 * @Description: 成功
	 * @param t
	 * @return
	 * @author 黄宏强 st8817@163.com
	 * @date 2017年7月3日 上午10:40:06
	 * @version V1.0
	 */
	public static <T> Response<T> makeResponse(T t) {
		return makeResponse(Response.Code.Success, t, null, null, null);
	}

	/**
	 * 
	 * @Description: 成功
	 * @param t
	 * @return
	 * @author 黄宏强 st8817@163.com
	 * @date 2017年7月3日 上午10:40:06
	 * @version V1.0
	 */
	public static <T> Response<T> makeResponse(T t, Integer page, Integer pager, Integer total) {
		return makeResponse(Response.Code.Success, t, page, pager, total);
	}
}
