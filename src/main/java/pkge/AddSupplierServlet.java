package pkge;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AddSupplierServlet")
public class AddSupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddSupplierServlet() {
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
		HttpSession session = req.getSession();
		String rollnum = (String) session.getAttribute("rollnum");
		if (rollnum != null) {
			//res.sendRedirect("login.html");
		}
		else {
			res.sendRedirect("login.html");
		}
	
		String name=req.getParameter("name");
		String contact_person=req.getParameter("contact_person");
		String email=req.getParameter("email");
		String phone_number=req.getParameter("phone_number");
		String address=req.getParameter("address");
		
		loadDriver(dbdriver);
		
		Connection con=getConnection();
		String sql="insert into supplier values(?,?,?,?,?,?)";
		String result="data entered successfully!";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,null);
			ps.setString(2,name);
			ps.setString(3,contact_person);
			ps.setString(4,email);
			ps.setString(5,phone_number);
			ps.setString(6,phone_number);
			//ps.executeUpdate();
			
			int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                // Registration successful
                res.sendRedirect("home.html");
            } else {
            	res.sendRedirect("addSupplier.jsp");
            }
			
		} catch (SQLException e) {
			e.printStackTrace();
			result="data not entered";
		}
	}

}
