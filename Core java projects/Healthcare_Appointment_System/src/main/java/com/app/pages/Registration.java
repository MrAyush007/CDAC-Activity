package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import static com.app.utils.Dbutils.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.patientDaoImpl;
import com.app.entities.Patient;

/**
 * Servlet implementation class Registration
 */
//@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	patientDaoImpl patient;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		ServletConfig config = getServletConfig();
		try {
			System.out.println("in init " + getClass());
			openConnection(config.getInitParameter("Db_URL"),config.getInitParameter("user_info"),config.getInitParameter("password"));
			patient = new patientDaoImpl();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			closeConnection();
			patient.cleanUP();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String name = request.getParameter("fname");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		Date dob= Date.valueOf(request.getParameter("dob"));
		
		try (PrintWriter pw = response.getWriter()){
			boolean flag;
			flag = patient.emailDuplicate(email);
			if(flag){
//				pw.print("<h4>hello</h4>");
				pw.print("<h2>Invalid Login , Please  <a href='login.html'>Retry</a></h2>");
				pw.print("<h3>Email already registered!!</h3><br>");
				pw.print("<h3>Try with another id</h3><br>");
				pw.print("<h3><a href ='Registration.html'>Try again!!</a></h3>");
				return ;
			}
			Patient p1 = new Patient(name, email, pass, dob);
			String s1 = patient.patientRegister(p1);
			pw.print("<h3> successfully registered      " + s1   + "</h3>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
