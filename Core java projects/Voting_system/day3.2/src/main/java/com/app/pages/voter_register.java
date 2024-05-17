package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static com.app.validate.Validateclass.validate;
import static com.app.utils.DBUtils.*;
//import static com.app.utils.Validateclass.validate;

import com.app.dao.UserDaoImpl;
import com.app.entities.User;

/**
 * Servlet implementation class voter_register
 */
//@WebServlet("/voter_register")
public class voter_register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDaoImpl userdao;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		ServletConfig config = getServletConfig();
		try {
			openConnection(config.getInitParameter("db_url"), config.getInitParameter("user_name"), config.getInitParameter("password"));
			
			userdao=new UserDaoImpl();
		} catch (SQLException e) {
			throw new ServletException("nhi huaa"); 
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			userdao.cleanUp();
			closeConnection();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw = response.getWriter())
		{
			//get http sessionht
			HttpSession session = request.getSession();
			//get request parapeter
			String fname = request.getParameter("fn");
			String lname = request.getParameter("ln");
			String email = request.getParameter("em");
			String pass = request.getParameter("pass");
			LocalDate dob = LocalDate.parse(request.getParameter("dob"));
			LocalDate newdb = validate(dob);
			
			
			if (newdb == null) {
				pw.print("<h4>age is < 21 not allowed <a href= \"voter_registration.html\" >RETRY</a></h4>");
			}
			User newUser = new User(fname, lname, email, pass, Date.valueOf(newdb));
			String status =  userdao.voterRegistration(newUser);
			pw.write(status);
			//discard the session
			session.invalidate();
			pw.print("<h4>Successfully registered <a href= \"login.html\" >Login here </a> </h4>");
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
