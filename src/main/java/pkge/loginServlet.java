package pkge;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginserv")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String rollnum=req.getParameter("rollnum");
		String password=req.getParameter("password");
		
		if(validate(rollnum, password)) {
            //HttpSession session = res.getSession();
            //session.setAttribute("teacherId", rollnum);
			HttpSession session = req.getSession();
	        session.setAttribute("rollnum", rollnum);
			
            res.sendRedirect("home.html");
        } else {
            res.sendRedirect("login.html");
        }
	}
	public void loadDriver(String dbDriver) {
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection(String dburl,String dbuname,String dbpassword) {
		Connection con=null;
		try {
			con=DriverManager.getConnection(dburl,dbuname,dbpassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
		private boolean validate(String id, String password) {
	        // Database connection parameters
	        String url = "jdbc:mysql://localhost:3306/supplierdb";
	        String username = "root";
	        String dbPassword = "Mysql@1234";
	        String dbdriver="com.mysql.jdbc.Driver";
	        
	        loadDriver(dbdriver);
			
			//Connection con=getConnection();
	        
	        // SQL query to validate teacher's credentials
	        String sql = "SELECT * FROM sup WHERE supplier_id=? AND password=?";
	        
	        try (Connection con=getConnection(url,username,dbPassword);) {
	        	PreparedStatement ps=con.prepareStatement(sql);
	        	ps.setString(1, id);
	        	ps.setString(2, password);
	            ResultSet resultSet = ps.executeQuery();
	            // If the result set has at least one row, it means the credentials are valid
	            return resultSet.next();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false; // In case of any SQL error, return false
	        }
		
	}

}
