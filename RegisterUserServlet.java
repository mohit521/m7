package p1;

import java.io.IOException;
import java.util.regex.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/registerUser")
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RegisterUserServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String city = request.getParameter("city");
		String emailId = request.getParameter("emailId");
		/*System.out.println(name);
		System.out.println(phone);
		System.out.println(city);
		System.out.println(emailId);*/
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/web_app_demo_3","root" ,"mohit@007M@#$");
		Statement stmnt=connection.createStatement();
		//these term are from the string variable like name phone city and emailId...
		stmnt.executeUpdate("insert into register values('"+name+"','"+phone+"','"+city+"','"+emailId+"')");
		connection.close();
		
	         }
		catch(Exception e) {
		      System.out.println(e);
		
	            }
		
	}
}
		
