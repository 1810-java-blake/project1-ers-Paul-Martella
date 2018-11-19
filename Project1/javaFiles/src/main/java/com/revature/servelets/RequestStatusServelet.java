package com.revature.servelets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Reimb;
import com.revature.services.ReimbService;


/**
 * Servlet implementation class RequestStatusServelet
 */
public class RequestStatusServelet extends HttpServlet {
	
	private ReimbService fr = ReimbService.currentImplementation;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestStatusServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("retreiving all the stuff");
		List<Reimb> reimb = fr.findAll();
		
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(reimb);
		response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ObjectMapper om = new ObjectMapper();
		Reimb r = om.readValue(request.getReader(), Reimb.class);
		int id = fr.addRiemb(r);
		System.out.println("post sent");
		response.setStatus(201);
		PrintWriter pw = response.getWriter();
		pw.write("" + id);
		pw.flush();
		
		doGet(request, response);
	}

}
