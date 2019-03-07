package com.byzx.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.byzx.web.service.UserService;
import com.byzx.web.vo.User;

/**
 * Servlet implementation class InsertUserServlet
 */
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 接收insert.jsp传递过来的参数
		String uidstr = request.getParameter("uid");
		int uid = 0;
		if(null != uidstr) {
			uid = Integer.parseInt(uidstr);
		}
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		User user = new User();
		user.setUid(uid);
		user.setUname(uname);
		user.setPassword(password);
		user.setSex(sex);
		user.setPhone(phone);
		user.setAddress(address);
		UserService us = new UserService();
		us.updateUser(user);
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
