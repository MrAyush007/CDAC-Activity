package com.app.pages;

import static com.app.utils.Dbutils.closeConnection;
import static com.app.utils.Dbutils.openConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.AppoinmentDaoImpl;
import com.app.dao.DoctorDaoImpl;
import com.app.dao.patientDaoImpl;
import com.app.entities.Appoinment;
import com.app.entities.Patient;

/**
 * Servlet implementation class appoinment
 */
//@WebServlet("/appoinment")
public class appoinment extends HttpServlet {
	private patientDaoImpl patient;
	private AppoinmentDaoImpl apoinment;
	private DoctorDaoImpl doctor;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		ServletConfig config = getServletConfig();
		try {

			patient = new patientDaoImpl();
			apoinment = new AppoinmentDaoImpl();
			doctor = new DoctorDaoImpl();
			openConnection(config.getInitParameter("Db_URL"), config.getInitParameter("user_info"),
					config.getInitParameter("password"));
			System.out.println("opennn");

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
			apoinment.cleanUP();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		doctor.cleanUP();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw = response.getWriter()){
			HttpSession session = request.getSession();
			Patient p1 = (Patient)session.getAttribute("patient");
			List<Appoinment> list = apoinment.showPatientAppoinments(p1.getEmail());
			pw.print("<h2>Welcome " + p1.getName() + "</h2><br>");
//			list.forEach(s -> pw.print("<h4>" + s + "</h4><br>"));
			pw.print
			(
					"<table border=2>"
					+ "<tr>"
					+ "<td>Appoinment_id</td>"
					+ "<td>Doctor_id</td>"
					+ "<td>Doctor</td>"
					+ "<td>Appoinment_date</td>"
					+ "<td>Appoinment_Time</td>"
					+ "</tr>");
			
					for(Appoinment a : list) {
					    pw.print("<tr>"
						+ "<td>" + a.getAppointmentId() + "</td>" +
						"<td>" + a.getPatientId() +"</td>" +
						"<td>" + a.getName() +"</td>" +
						"<td>" + a.getAppointmentDate() +"</td>" +
						"<td>" + a.getAppointmentTime() +"</td>" +
						"</td>"
						+"</tr>");
					   }
					pw.print("</table><br>");
			
			//to delete the appoinment
			pw.print("Enter the Appoinment id to Delete:<br>");
			pw.print("<form action='cancleTheAppoinment' method='get'>");
			pw.print("<input type=\"text\" name=\"em\">");
			pw.print("<input type=\"submit\" value=\"Submit\">");
			pw.print("</form><br>");
			
			pw.print("<h3><a href =createAppoinment>Create an Appoinment</a></h3>");

			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
