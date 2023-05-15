package hello.servlet.basic.request;

import java.io.IOException;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * @author 19467
 * 1. 파라미터전송기능
 * http://localhost:8080/request-param?username=hello&age=20
 *
 */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		System.out.println("[전체파라미터 조회] START");
		
		request.getParameterNames().asIterator().
		forEachRemaining(paramName -> System.out.println( paramName + " = " + request.getParameter(paramName)));
				
		System.out.println("[전체파라미터 조회] FINISH");
		
		System.out.println("************************************************************");
		System.out.println("************************************************************");
		
		System.out.println("[단일 파라미터 조회] START");		
		
		String username = request.getParameter("username");
		String age= request.getParameter("age");		
		System.out.println("username = " + username );
		System.out.println("age = " + age );
		
		System.out.println("[단일 파라미터 조회] FINISH");
		
		System.out.println("************************************************************");
		System.out.println("************************************************************");
		
		System.out.println("[username이 같은 파라미터 조회] START");		
		
		String[] usernames = request.getParameterValues("username");
		
		for (String name : usernames) {
			System.out.println("username = "+ name);
		}
		
		System.out.println("[username이 같은 파라미터 조회] FINISH");
		
		response.getWriter().write("GOOD");
		response.getWriter().write("get방식 URL에 Form 형식도 지원 함.");
	}
	
}
