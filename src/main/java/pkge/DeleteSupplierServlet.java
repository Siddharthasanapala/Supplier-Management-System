package pkge;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/DeleteSupplierServlet")
public class DeleteSupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteSupplierServlet() {
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
		if (rollnum == null) {
			res.sendRedirect("login.html");
		}
		
		String supplier_id=req.getParameter("supplier_id");
		
		loadDriver(dbdriver);
		PrintWriter out= res.getWriter();
				
		Connection con=getConnection();
		String sql="delete from supplier where supplier_id=?";
		String result="data Deleated successfully!";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,supplier_id);
	
			//ps.executeUpdate();
			
			int rowsDeleated = ps.executeUpdate();
            if (rowsDeleated > 0) {
                // Registration successful
            	//out.println("<h2>Supplier details Deleted successfully!</h2>");
                res.sendRedirect("home.html");
            } else {
            	//out.println("<h2>Supplier details Not deleted.!</h2>");
            	res.sendRedirect("deleteSupplier.jsp");
            }
			
		} catch (SQLException e) {
			e.printStackTrace();
			result="data not entered";
			out.println(result);
		}
	}
}
