package com.kh.mybatis.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.member.model.service.MemberServiceImpl;
import com.kh.mybatis.member.model.vo.Member;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login.me")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		//아이디 저장
		String saveId = request.getParameter("saveId");
		
//		System.out.println(saveId);
		//checkbox의 value를 지정하지 않았기 때문에 체크된상태로 받으면 on으로 넘어온다
		//만약 체크가 안된상태로 넘어오면 null
		
		/*
		 * 쿠키 : 키와 벨류로 이루어진 데이터 파일
		 * -로컬에 저장되어진다.
		 * -사용자가 요청하지 않아도 브라우저가 request시에 header에 추가하여 서버로 전송함
		 */
		
		//쿠키 선언 및 초기화
		Cookie cookie = null;
		
		//아이디 저장 체크박스가 체크되었는지 판별 -> 체크되었다면 쿠키 생성 후 아이디 넣어주기
		if(saveId != null && saveId.equals("on")) {
			//쿠키의 이름과 값을 넣어서 생성
			cookie = new Cookie("userId", userId);
			//쿠키의 수명 지정(초단위)
			cookie.setMaxAge(60*60*24); //하루 = 60*60*24
			
			//응답객체에 쿠키 추가하기
			response.addCookie(cookie);
		}else { //체크가 되어있지 않았다면 쿠키 삭제
			cookie = new Cookie("userId", null); //값을 null로 바꾸기
			cookie.setMaxAge(0); //수명 0으로 만들기
			response.addCookie(cookie);
		}
		
		
		Member m = new Member(userId,userPwd);
		
		Member loginUser = new MemberServiceImpl().loginMember(m);
		
		
		if(loginUser != null) {
			request.getSession().setAttribute("loginUser", loginUser);
			response.sendRedirect(request.getContextPath());
		}else {
			request.setAttribute("errorMsg", "로그인 실패!!");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
		
		
	}

}
