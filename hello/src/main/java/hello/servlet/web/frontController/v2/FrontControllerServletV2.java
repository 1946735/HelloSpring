package hello.servlet.web.frontController.v2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import hello.servlet.web.frontController.MyView;
import hello.servlet.web.frontController.v2.controller.MemberFormControllerV2;
import hello.servlet.web.frontController.v2.controller.MemberListControllerV2;
import hello.servlet.web.frontController.v2.controller.MemberSaveControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet (name = "FrontControllerServletV2", urlPatterns =  "/front-controller/v2/*")//하위호출은 다 이 프론트로 온다.
public class FrontControllerServletV2 extends HttpServlet {

	
	// 주소를 넣을 수 있도록 controllerMap을 만들어둔다.
	private Map<String, ControllerV2> controllerMap = new HashMap<>();
	
	
	public FrontControllerServletV2() {

		// 생성자를 만들어서 controllerMap에 입력한다.
		 
		controllerMap.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
		controllerMap.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
		controllerMap.put("/front-controller/v2/members", new MemberListControllerV2());
		
		}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 주소를 찾을 수 있다.(/front-controller/V2/members/new-form)		
		String requestURI = request.getRequestURI();
		
		// controller < controllerMap을 담는다.
		ControllerV2 controller = controllerMap.get(requestURI);
		if(controller == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		// 정상처리되면, 각 컨트롤러의 request, response 를 보낸다.=-
		MyView myView = controller.process(request, response);
		myView.render(request, response);
		
	}
	
	

}
