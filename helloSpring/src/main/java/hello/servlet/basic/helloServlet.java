package hello.servlet.basic;

import java.io.IOException;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name="helloServlet",urlPatterns = "/hello")
public class helloServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		System.out.println("helloServlet.service");
		System.out.println("req = "+ req);
		System.out.println("resp = "+ resp);
		
		String username = req.getParameter("username"); // username 가져오기
		System.out.println("username = "+ username); // 출력
		
		resp.setContentType("text/plain"); // 문자를 띄워주기위한 세팅
		resp.setCharacterEncoding("utf-8"); // 문자 세팅
		resp.getWriter().write("username "+username); // username 띄워주기위해 IOException 을 셋팅해줘야 한다. 
		
	}
	
	
}
