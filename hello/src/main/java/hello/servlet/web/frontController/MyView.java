package hello.servlet.web.frontController;

import java.io.IOException;

import org.springframework.web.client.HttpServerErrorException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyView {

	private String viewPath;

	public MyView(String viewPath) {
		this.viewPath = viewPath;
	}
	
	// JSP를 보여주는 것
	public void render(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
		
	}
	
}// class
