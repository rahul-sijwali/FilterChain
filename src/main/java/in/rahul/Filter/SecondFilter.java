package in.rahul.Filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondFilter implements Filter {

	static {
		System.out.println("SecondFilter.class file is loading...");
	}

	public SecondFilter() {
		System.out.println("SecondFilter Object is instantiated...");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("SecondFilter Object is initialized...");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		out.println("<h1>This line is added by SecondFilter before processing the request...</h1>");
		chain.doFilter(request, response);
		out.println("<h1>This line is added by SecondFilter before after the request...</h1>");
	}

	public void destroy() {
		System.out.println("SecondFilter object is deInstantiated...");
	}

}
