package hello.servlet.basic;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "helloServlet",urlPatterns = "/hello")
public class helloServlet extends HttpServlet {
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
			
				System.out.println("HelloServlet.service");
				System.out.println("request : "+ request);
				System.out.println("response : "+ response);
				
				String username = request.getParameter("username");
				System.out.println("username = "+ username);
				
				//헤더정보
				response.setContentType("text/plain");
				response.setCharacterEncoding("UTF-8");
				
				//응답값 출력
				response.getWriter().write("hello "+username);
	}
	
}

	

