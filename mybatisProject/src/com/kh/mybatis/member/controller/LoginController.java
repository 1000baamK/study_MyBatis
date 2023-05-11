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
		
		//���̵� ����
		String saveId = request.getParameter("saveId");
		
//		System.out.println(saveId);
		//checkbox�� value�� �������� �ʾұ� ������ üũ�Ȼ��·� ������ on���� �Ѿ�´�
		//���� üũ�� �ȵȻ��·� �Ѿ���� null
		
		/*
		 * ��Ű : Ű�� ������ �̷���� ������ ����
		 * -���ÿ� ����Ǿ�����.
		 * -����ڰ� ��û���� �ʾƵ� �������� request�ÿ� header�� �߰��Ͽ� ������ ������
		 */
		
		//��Ű ���� �� �ʱ�ȭ
		Cookie cookie = null;
		
		//���̵� ���� üũ�ڽ��� üũ�Ǿ����� �Ǻ� -> üũ�Ǿ��ٸ� ��Ű ���� �� ���̵� �־��ֱ�
		if(saveId != null && saveId.equals("on")) {
			//��Ű�� �̸��� ���� �־ ����
			cookie = new Cookie("userId", userId);
			//��Ű�� ���� ����(�ʴ���)
			cookie.setMaxAge(60*60*24); //�Ϸ� = 60*60*24
			
			//���䰴ü�� ��Ű �߰��ϱ�
			response.addCookie(cookie);
		}else { //üũ�� �Ǿ����� �ʾҴٸ� ��Ű ����
			cookie = new Cookie("userId", null); //���� null�� �ٲٱ�
			cookie.setMaxAge(0); //���� 0���� �����
			response.addCookie(cookie);
		}
		
		
		Member m = new Member(userId,userPwd);
		
		Member loginUser = new MemberServiceImpl().loginMember(m);
		
		
		if(loginUser != null) {
			request.getSession().setAttribute("loginUser", loginUser);
			response.sendRedirect(request.getContextPath());
		}else {
			request.setAttribute("errorMsg", "�α��� ����!!");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
		
		
	}

}
