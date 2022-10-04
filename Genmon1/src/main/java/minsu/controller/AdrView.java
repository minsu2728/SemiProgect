package minsu.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractController;
import minsu.model.InterPersonDAO;
import minsu.model.PersonDAO;

public class AdrView extends AbstractController {

	// 주소추가 및 기본 배송지를 보여주는 곳 
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("~~~ 확인용0 " + request.getParameter("name"));
		System.out.println("~~~ 확인용0 " + request.getParameter("postcode"));
		System.out.println("~~~ 확인용0 " + request.getParameter("address"));
		System.out.println("~~~ 확인용0 " + request.getParameter("detailAddress"));
		System.out.println("~~~ 확인용0 " + request.getParameter("userid"));
		
		if(!super.checkLogin(request)) {
				// 로그인 안했으면 
			    String message = "회원정보를 수정하려면 먼저 로그인을 하세요.!!";
	            String loc = "javascript:history.back()";
	            
	            request.setAttribute("message", message);
	            request.setAttribute("loc", loc);
	            
	      //   super.setRedirect(false);
	           super.setViewPage("/WEB-INF/common/msg.jsp");
	           return;
			}
			else {
		
				String method = request.getContextPath();
				
				if("get".equals(method)) {
					  String message = "회원정보 수정이 불가합니다.!!";
			          String loc = "javascript:history.back()";
			            
			            request.setAttribute("message", message);
			            request.setAttribute("loc", loc);
			            
			      //   super.setRedirect(false);
			           super.setViewPage("/WEB-INF/common/msg.jsp");
			           return;
				}
				else {
					
					System.out.println("~~~ 확인용1 " + request.getParameter("name"));
					System.out.println("~~~ 확인용1 " + request.getParameter("postcode"));
					System.out.println("~~~ 확인용1 " + request.getParameter("address"));
					System.out.println("~~~ 확인용1 " + request.getParameter("detailAddress"));
					System.out.println("~~~ 확인용1 " + request.getParameter("userid"));
					
					String name = request.getParameter("name");
					String postcode = request.getParameter("postcode");
					String address = request.getParameter("address");
					String detailAddress = request.getParameter("detailAddress");
					String extraAddress = request.getParameter("extraAddress");
					
					String userid = request.getParameter("userid"); // login.jsp에서 userid를 받아온다
					
					 Map<String,String> paraMap = new HashMap<>();
					 paraMap.put("name",name);
		        	 paraMap.put("postcode",postcode);
		        	 paraMap.put("address",address);
		        	 paraMap.put("detailAddress",detailAddress);
		        	 paraMap.put("extraAddress",extraAddress);
		        	 paraMap.put("userid",userid);
					
					// DB에 주소를 추가하기
					InterPersonDAO pdao =  new PersonDAO();
					int n = pdao.addAdreess(paraMap);
					
					String message = "";
					System.out.println("~~~ 확인용2 " + request.getParameter("name"));
					System.out.println("~~~ 확인용2 " + request.getParameter("postcode"));
					System.out.println("~~~ 확인용2 " + request.getParameter("address"));
					System.out.println("~~~ 확인용2 " + request.getParameter("detailAddress"));
					System.out.println("~~~ 확인용2 " + request.getParameter("userid"));
			         if(n == 1) {
			        	 
			        	 message = "주소등록 성공!!";
			        	 super.setRedirect(false);
			 			 super.setViewPage("/WEB-INF/minsu/adrView.jsp");
			        	 
			         }
			         else {
			        	 message = "주소등록 실패!!";
			        	 String loc = "javascript:history.back()"; // 이전페이지로 이동
				         
				        request.setAttribute("message", message);
						request.setAttribute("loc", loc);
							
						//	super.setRedirect(false);
							super.setViewPage("/WEB-INF/common/msg.jsp");
			         }
				
					
				}
			}
	}
}
