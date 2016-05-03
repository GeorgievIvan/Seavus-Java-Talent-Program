package web_calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/calculator")
public class WebCalculator extends HttpServlet {
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	processRequest(request, response);
    }
    
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String result;
    	
    	try {
    	
    		result = calculate(request.getParameter("number1"), request.getParameter("number2"), request.getParameter("operation"));
    	}
    	catch(NumberFormatException numberFormatException) {
    		
    		response.getWriter().println(numberFormatException.getMessage());
    		
    		return;
    	}
    	catch(IllegalArgumentException illegalArgumentException) {
    		
    		response.getWriter().println(illegalArgumentException.getMessage());
    		
    		return;
    	}
    	
		response.getWriter().println(result);
    }
    
    private String calculate(final String operand1, final String operand2, final String operation) {
    	
    	Integer integer1;
    	Integer integer2;
    	
    	try {
    		
    		integer1 = Integer.parseInt(operand1);
    	}
    	catch(NumberFormatException numberFormatException) {
    		
    		throw new NumberFormatException(String.format("'%s' is not a valid integer.", operand1));
    	}
    	
    	try {
    		
    		integer2 = Integer.parseInt(operand2);
    	}
    	catch(NumberFormatException numberFormatException) {
    		
    		throw new NumberFormatException(String.format("'%s' is not a valid integer.", operand2));
    	}
    	
    	switch(operation) {
    	
    		case "addition":
    			return String.format("%s + %s = %d", integer1, integer2, integer1 + integer2);
    	
    		case "subtraction":
    			return String.format("%s - %s = %d", integer1, integer2, integer1 - integer2);
    		
    		default:
    			throw new IllegalArgumentException(String.format("'%s' is not a valid operation.", operation));
    	}
    }
}