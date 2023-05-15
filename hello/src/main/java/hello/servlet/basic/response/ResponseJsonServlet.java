package hello.servlet.basic.response;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import hello.servlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="ResponseJsonServlet",urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

	private ObjectMapper objectMapper =new ObjectMapper();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		HelloData helloData = new HelloData();
		helloData.setUsername("kim");
		helloData.setAge(20);
		
		//json 형식으로 바꾸기
		// {"username" : "kim" , "age" : 20 }
		String result = objectMapper.writeValueAsString(helloData);
		response.getWriter().write(result);	
		
		
	}
	
	
	

}