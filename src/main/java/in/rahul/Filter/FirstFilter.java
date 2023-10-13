package in.rahul.Filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class FirstFilter implements Filter {

	private FilterConfig config;

	static {
		System.out.println("FirstFilter.class file is loading...");
	}

	public FirstFilter() {
		System.out.println("FirstFilter Object is instantiated...");
	}

	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		System.out.println("FirstFilter Object is initialized...");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		PrintWriter out = response.getWriter();
		out.println("<h1>This line is added by FirstFilter before processing the request...</h1>");

		ServletContext context = config.getServletContext();
		HttpServletRequest req = (HttpServletRequest) request;
		context.log("A request is coming from :: " + request.getRemoteHost() + " for URL ::" + req.getRequestURL()
				+ " at " + new Date());

		chain.doFilter(request, response);

		out.println("<h1>This line is added by FirstFilter after processing the request...</h1>");
	}

	public void destroy() {
		config = null;
		System.out.println("FirstFilter Object is DeInstantiated...");
	}

}