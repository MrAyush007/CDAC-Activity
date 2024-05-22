package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;

import static com.app.utils.Dbutils.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

import com.app.dao.AppoinmentDaoImpl;
import com.app.dao.DoctorDaoImpl;
import com.app.dao.patientDaoImpl;
import com.app.entities.Appoinment;
import com.app.entities.Doctor;
import com.app.entities.Patient;
import com.mysql.cj.Session;

/**
 * Servlet implementation class submissionOfAppoinment
 */
//@WebServlet("/submissionOfAppoinment")
public class submissionOfAppoinment extends HttpServlet {
	private static final long serialVersionUID = 1L;
		AppoinmentDaoImpl app_dao;
		patientDaoImpl patient_dao;
		DoctorDaoImpl doc_dao;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		ServletConfig config = getServletConfig();
		try {
			doc_dao = new DoctorDaoImpl();
			app_dao = new AppoinmentDaoImpl();
			patient_dao = new patientDaoImpl();
			openConnection(config.getInitParameter("Db_URL"),config.getInitParameter("user_info"),config.getInitParameter("password"));
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
			app_dao.cleanUP();
			patient_dao.cleanUP();
			app_dao.cleanUP();
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
			HttpSession session = request.getSession();
			Patient p1 = (Patient)session.getAttribute("patient");
			String date = request.getParameter("date");
			String time = request.getParameter("time");
			LocalTime tt  = LocalTime.parse(time);
			app_dao.timeList().forEach(s->System.out.println(s));
			System.out.println(tt);
			System.out.println(time);
			
			String doc = request.getParameter("Doc_id");
			String newDoc = doc_dao.findDoctor(Integer.parseInt(doc));
			Appoinment app = new Appoinment(Integer.parseInt(doc), p1.getId(),Date.valueOf(date),Time.valueOf(tt),newDoc);
			boolean check = app_dao.addAppoinment(app);
			if(check){
				response.sendRedirect("appoinment");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
