package hello.servlet.basic.request;

import java.io.IOException;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
	
	@Override //태우기.
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Enumeration<String> parameterNames = request.getParameterNames();
		
		System.out.println("[전체 파라미터 조회] - start ");
		
		request.getParameterNames().asIterator()
					.forEachRemaining(paramName -> System.out.println(paramName + " = " + request.getParameter(paramName)));
		
		System.out.println("[전체 파라미터 조회] - end");
		System.out.println();
		
		System.out.println("[단일 파라미터 조회] - start");
		
		String userName = request.getParameter("username");
		String age = request.getParameter("age");
		
		
		
		System.out.println("username = "+ userName);
		System.out.println("age = "+ age);
		

		System.out.println("[단일 파라미터 조회] - end");
		
		System.out.println();		
		System.out.println("[이름이 같은 복수 파라미터 조회] - start");
		
		String[] userNames = request.getParameterValues("username");
		
		for(String name : userNames) {
			System.out.println("username = "+ name);
		}
		
		System.out.println("[이름이 같은 복수 파라미터 조회] - end");
		
		
		response.getWriter().write("ok");
		
		
		
	}
	

}
