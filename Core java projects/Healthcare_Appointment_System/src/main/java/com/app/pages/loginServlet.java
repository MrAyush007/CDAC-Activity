package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import static com.app.utils.Dbutils.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.entities.*;
import com.app.dao.AppoinmentDaoImpl;
import com.app.dao.DoctorDaoImpl;
import com.app.dao.patientDaoImpl;

/**
 * Servlet implementation class loginServlet
 */
//@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private patientDaoImpl p1;
	private DoctorDaoImpl d1;
	private AppoinmentDaoImpl a1;
	
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		ServletConfig config = getServletConfig();
		try {
//			a1.timeList().forEach(System.out::println);
			openConnection(config.getInitParameter("Db_URL"),config.getInitParameter("user_info"),config.getInitParameter("password"));
			p1 = new patientDaoImpl();
			System.out.println("in init of " + getClass() +" cofig "+config);//not null
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
			p1.cleanUP();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch blockW
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
			String email=request.getParameter("em");
			String pass=request.getParameter("pass");
			Patient pat = p1.signIn(email, pass);
			
			if(pat!=null){
				HttpSession session = request.getSession();
				
				session.setAttribute("patient",pat);
				session.setAttribute("doctor",d1);
				session.setAttribute("appoinment",a1);
				if(pat.getRole().equals("patient")){
					System.out.println("redirect");
					response.sendRedirect("appoinment");
				}
				pw.write("<h3>WELCOME     " + pat.getName() +"</h3>" );
				return ;
			}
			pw.write("<h3> Invalid login plz! try again</h3><br>" + "<a href='login.html'>Login Here</a>");	
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
