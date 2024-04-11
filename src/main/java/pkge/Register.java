package pkge;

import java.io.IOException;
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


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Register() {
        super();
    }
    
    private String dburl="jdbc:mysql://localhost:3306/supplierdb";
	private String dbuname="root";
	private String dbpassword="Mysql@1234";
	private String dbdriver="com.mysql.jdbc.Driver";
	
	public void loadDriver(String dbDriver) {
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() {
		Connection con=null;
		try {
			con=DriverManager.getConnection(dburl,dbuname,dbpassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		
		loadDriver(dbdriver);
		
		Connection con=getConnection();
		String sql="insert into sup values(?,?)";
		String result="data entered successfully!";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2,password);
	
			//ps.executeUpdate();
			
			int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                // Registration successful
                res.sendRedirect("login.html");
            } else {
            	res.sendRedirect("Register.jsp");
            }
			
		} catch (SQLException e) {
			e.printStackTrace();
			result="data not entered";
		}
		
	}
}
