package com.joyadata.tjlog.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

/**
 * 
 * @ClassName: CORSFilter
 * @Description: CORSFilter 跨域处理
 * @author 黄宏强 st8817@163.com
 * @date 2017年7月3日 上午10:14:05
 *
 */
@Component
public class CORSFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletResponse resp = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;
		String origin = req.getHeader("Origin");
		req.setCharacterEncoding("UTF-8");
		String method = req.getMethod();
		if (!"OPTIONS".equals(method)) {
			resp.setHeader("Origin", "*");
			resp.setHeader("Access-Control-Allow-Credentials", "true");
			resp.setHeader("Access-Control-Allow-Origin", origin);
			resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
			resp.setHeader("Access-Control-Allow-Headers",
					"X-Custom-Header,Origin, x-requested-with, Content-Type, Accept,cache-control,content-type,token");

		} else {
			resp.setHeader("Origin", origin);
			resp.setHeader("Access-Control-Allow-Credentials", "true");
			resp.setHeader("Access-Control-Allow-Origin", origin);
			resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
			resp.setHeader("Access-Control-Allow-Headers",
					"X-Custom-Header,Origin, x-requested-with, Content-Type, Accept,cache-control,content-type,token");
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// Auto-generated method stub

	}

}