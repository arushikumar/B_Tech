package serverpackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TheServlet implementation class RunServlet
 */
@WebServlet("/RunServlet")

public class RunServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 public RunServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	 }
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int result;
		
		response.setContentType("text/plain");
		
		String cardnum = request.getParameter("cardnum");
		String city = request.getParameter("city");
	    String amount = request.getParameter("amount");
	    
	    PrintWriter out = response.getWriter();
	    out.println("GOOD : servlet is accepting data from jsp");
	    System.out.println("GOOD : servlet is accepting data from jsp");
	    
		ServerClass.fetchdetails(Long.parseLong(cardnum),city,Integer.parseInt(amount));
	    
	    out.println("GOOD : userdetails Set");
	    System.out.println("GOOD : userdetails Set");
	        	     
	    String[] arg = {};
	    result = ServerClass.main(arg);
	    
	    if(result == 0)
	    	out.println("Processing Transaction");
	    else if(result == 1)
	    	out.println("Transaction Limit Exceeded");
   
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}
}
