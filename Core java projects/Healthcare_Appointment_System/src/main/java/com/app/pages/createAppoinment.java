package com.app.pages;

import static com.app.utils.Dbutils.*;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.AppoinmentDaoImpl;
import com.app.dao.DoctorDaoImpl;
import com.app.dao.Doctor_dao;
import com.app.dao.patientDaoImpl;
import com.app.entities.Doctor;
import com.app.entities.Patient;

/**
 * Servlet implementation class createAppoinment
 */
//@WebServlet("/createAppoinment")
public class createAppoinment extends HttpServlet {
	private static final long serialVersionUID = 1L;
		patientDaoImpl pat_dao;
		DoctorDaoImpl doc_dao;
		AppoinmentDaoImpl app_dao;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		ServletConfig config = getServletConfig();
		try {
			openConnection(config.getInitParameter("Db_URL"),config.getInitParameter("user_info"),config.getInitParameter("password"));
			pat_dao = new patientDaoImpl();
			doc_dao = new DoctorDaoImpl();
			app_dao = new AppoinmentDaoImpl();
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
			pat_dao.cleanUP();
			app_dao.cleanUP();
			doc_dao.cleanUP();
			closeConnection();
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
		{	HttpSession session = request.getSession();
			Patient p1 = (Patient)session.getAttribute("patient");
			pw.print("<h2>hello" + p1.getName()+"</h2>");
			List<Doctor> list = doc_dao.showDoctor();
			pw.print("<form action='submissionOfAppoinment' method='post'>");
			pw.print("<table border=2 cellpadding=10px>");
			pw.print("<tr>"
					+"<td>"
					+ "Date</td>"
					+ "<td>"
					+ "<input type='Date' name='date'>"
					+ "</td>"
					);
			pw.print("<tr>"
					+"<td>"
					+ "Time</td>"
					+ "<td>"
					+ "<input type='Time' name='time'>"
					+ "</td>"
					+ "<tr><td>Select Doctor</td>"
//					+ "<select name=\"doctor\" id=\"doctor\"> "
					);
			
			pw.print("<td><select name='Doc_id'>");
			for (Doctor c : list) {
			    pw.print("<option value='" + c.getId() + "'>"
			            + c.getName() + " (" + c.getSpecialization() + ")</option>");
			}
			pw.print("</select></td>");
//			for (Doctor c : list) {
//				pw.print("<td><input type='radio' name='Doc_id' value='" + c.getId() + "'/>"
//						+ c.getName() + " " + c.getSpecialization() + "</td>");
////				pw.print("<td> <option value=\"c.getId()\">"
////						+ c.getName() + " " + c.getSpecialization() + "</option></td>");
//			}
			
			pw.print("</tr>");
//			pw.print("")");
			pw.print("<tr><td colspan=\"2\"><h6><input type='submit' align='center' value='select'/></h6></td></tr>");
			
			pw.print("</table>");
			pw.print("</form>");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
