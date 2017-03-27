package com.lk.twentyOne;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * 保证编码方式
 * filter-0-character命名保证此为第一个执行的filter
 * @author lk
 *
 */
@WebFilter(filterName="filter-0-character", urlPatterns= {"/*"})
public class CharsetEncodingFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}
}