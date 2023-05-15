package hello.servlet.basic.request;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.util.StreamUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name ="RequestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 메세지 바디에 있는 것 꺼내기
		 * ServletInputStream inputStream = request.getInputStream();
		 * 이렇게 사용하면 메세지 바디에 있는 것을 바이트코드로 바로 얻을 수 있다. 
		 */
		ServletInputStream inputStream = request.getInputStream();
		
		/* Spring 에서 제공하는 Utility 를사용한다. 
		 *  StreamUtils.를 꺼낼때 인코딩 정보가 뭔지 알려줘야 한다. UTF-8
		 *  inputStream.으로 문자를 꺼냄. 
		 *  
		 */		 
		String messageBody = StreamUtils.copyToString(inputStream,StandardCharsets.UTF_8);
		
		response.getWriter().write("GOOD");
		
	
	}
	
	

}
