package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.app.utils.DBUtils.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.CandidateDao;
import com.app.dao.CandidateDaoImpl;
import com.app.dao.UserDaoImpl;
import com.app.entities.Candidate;
import com.app.entities.User;

/**
 * Servlet implementation class admin
 */
//@WebServlet("/admin")
public class admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CandidateDaoImpl candidateDao;
	

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		ServletConfig config = getServletConfig();
		try{
			candidateDao=new CandidateDaoImpl();
			openConnection(config.getInitParameter("db_url"), config.getInitParameter("user_name"), config.getInitParameter("password"));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			candidateDao.cleanUp();
			closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		try(PrintWriter pw = response.getWriter()){
			HttpSession session = request.getSession();
			User user=(User)session.getAttribute("user_info");
			pw.print("<h3>hello admin:- " + user.getFirstName() + "</h3>"+"<br>");
			pw.println("");
			candidateDao = (CandidateDaoImpl)session.getAttribute("candidate_dao");
			List<Candidate> list = candidateDao.showTopCandidates();
			list.forEach(s -> pw.println("<h3>" + s + "<br>"+ "</h3>"));
			
			Map<String, Integer> mapp = candidateDao.getPartyWiseVotes();
			
			mapp.forEach((k,v) -> pw.write("<h3>" + k + "-----------------------" +v+"<br>"+ "</h3>"));
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
