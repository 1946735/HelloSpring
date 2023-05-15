package hello.servlet.web.frontController.v1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import hello.servlet.web.frontController.v1.controller.MemberFormControllerV1;
import hello.servlet.web.frontController.v1.controller.MemberListControllerV1;
import hello.servlet.web.frontController.v1.controller.MemberSaveControllerV1;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet (name = "FrontControllerServletV1", urlPatterns =  "/front-controller/v1/*")//하위호출은 다 이 프론트로 온다.
public class FrontControllerServletV1 extends HttpServlet {

	
	// 주소를 넣을 수 있도록 controllerMap을 만들어둔다.
	private Map<String, ControllerV1> controllerMap = new HashMap<>();
	
	
	public FrontControllerServletV1() {

		// 생성자를 만들어서 controllerMap에 입력한다.
		 
		controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
		controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
		controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());
		
		}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("FrontControllerServletV1_Services Success");
		
		// 주소를 찾을 수 있다.(/front-controller/v1/members/new-form)		
		String requestURI = request.getRequestURI();
		
		// controller < controllerMap을 담는다.
		ControllerV1 controller = controllerMap.get(requestURI);
		if(controller == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		// 정상처리되면, 각 컨트롤러의 request, response 를 보낸다.
		controller.process(request, response);
		
	}
	
	

}
