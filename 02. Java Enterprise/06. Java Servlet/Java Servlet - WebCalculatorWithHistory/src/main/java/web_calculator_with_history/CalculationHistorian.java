package web_calculator_with_history;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/history")
public class CalculationHistorian extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	printHistory(request.getSession(), response.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	printHistory(request.getSession(), response.getWriter());
    }
    
    private void printHistory(final HttpSession session, final PrintWriter writer) {
    	
    	final ArrayList<String> calculations = (ArrayList<String>)session.getAttribute("calculations");
    	
    	if(calculations == null) {
    		
    		writer.println("You have 0 calculations.");
    		
    		return;
    	}
    	
		writer.println(String.format("You have %d calculations.", calculations.size()));
    	
    	for(final String calculation : calculations) {
    		
    		writer.println(calculation);
    	}
    }
}
