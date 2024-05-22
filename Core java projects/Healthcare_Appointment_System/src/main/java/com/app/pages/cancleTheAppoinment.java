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

import com.app.dao.AppoinmentDaoImpl;
import com.app.dao.patientDaoImpl;
import com.app.entities.Appoinment;

/**
 * Servlet implementation class cancleTheAppoinment
 */
//@WebServlet("/cancleTheAppoinment")
public class cancleTheAppoinment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AppoinmentDaoImpl a1;
	

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		ServletConfig config = getServletConfig();
		try {
			openConnection(config.getInitParameter("Db_URL"),config.getInitParameter("user_info"),config.getInitParameter("password"));
			a1 = new AppoinmentDaoImpl();
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
			a1.cleanUP();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw = response.getWriter())
		{
//			a1.timeList().forEach(s -> System.out.println(s));
			int appNo =  Integer.parseInt(request.getParameter("em"));
			HttpSession session = request.getSession();
//			Appoinment app =(Appoinment)session.getAttribute("appoinment");			
			boolean b1 = a1.deleteAppoinment(appNo);
			if(b1) {
				response.sendRedirect("appoinment");
			}
			else
				pw.print("invalid Appoinment id");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
