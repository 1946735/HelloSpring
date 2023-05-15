package hello.servlet.web.frontController.v1.controller;

import java.io.IOException;

import hello.servlet.web.frontController.v1.ControllerV1;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberFormControllerV1 implements ControllerV1 {
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				//1.jsp 파일 경로 설정 
				// WEB-INF 란?
				// 컨트롤러를 거쳐서 가야하는 것 : 외부에서 호출이 안돼요. 
				String viewPath = "/WEB-INF/views/new-form.jsp";

				//2. 컨트롤러에서 view로 이동할 때 사용 하는 것
				RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
				// dispatcher.forward(); 다른 서블릿이나 JSP로 가는 것이 아니라 서버내부에ㅓ 호출이 발생한다.
				dispatcher.forward(request, response);
		
	}

}
