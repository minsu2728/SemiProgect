<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <% String ctxPath = request.getContextPath(); %>
     
<jsp:include page="../common/myinfo_mainMenu.jsp" />

<style>


	form#frm_setting {
	/* 	border: solid 1px blue;  */
		line-height: 40px;
		display: inline-block;
		margin-right: 20px;
		position: absolute;
		
	}
	
	form#frm_setting > ul{
		font-size: 13px;
		list-style: none;
	}

	

	form#frm_setting > ul > li > a{  
		  color: #000;
		  display:inline-block; 
		  text-transform:uppercase; 
		  text-decoration: none;
		  line-height: 55px;
	  }
	
	form#frm_setting > ul > li > a:after {
		  display:block;
		  content: '';
		  margin-top:-7px;
		  border-bottom: solid 1px black;  
		  transform: scaleX(0);  
		  transition: transform 250ms ease-in-out;
	}
	
	form#frm_setting > ul > li > a:hover:after { 
		transform: scaleX(1); 
	}

	button:hover {
		cursor: pointer;
	}
	

</style>



<form name="frm_setting" id="frm_setting">

		<h4 style="margin-left:35px;font-size: 15px; font-weight: bold;">계정설정</h4>
		<ul>
			<li><a href="<%= ctxPath%>/myinfo/infoUpdate.sun">회원정보</a></li>
			<li><a href="<%= ctxPath%>/myinfo/adrView.sun">주소록</a></li>
			<li><a href="<%= ctxPath%>/myinfo/pwdInput.sun">비밀번호 변경</a></li>
		</ul>
</form>		


