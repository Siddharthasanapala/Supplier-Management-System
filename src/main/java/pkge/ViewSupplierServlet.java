package pkge;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import java.util.function.Supplier;

import pkge.Supplier;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ViewSupplierServlet")
public class ViewSupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
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
		else {
		List<Supplier> supplierList = new ArrayList<>();
		ResultSet rs;
		loadDriver(dbdriver);
		
		Connection con=getConnection();
		String sql="select * from supplier";
		//String result="data retrieved successfully!";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			rs = ps.executeQuery(sql);
			while (rs.next()) {
                int supplier_Id = rs.getInt("supplier_id");
                String name = rs.getString("name");
                String contact_person = rs.getString("contact_person");
                String email = rs.getString("email");
                String phone_number = rs.getString("phone_number");
                String address = rs.getString("address");

                Supplier supplier = new Supplier(supplier_Id, name, contact_person, email, phone_number, address);
                supplierList.add(supplier);
                
            }
			try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
        // Set supplier list as an attribute in request object
        //req.setAttribute("supplierList", supplierList);
		session.setAttribute("supplierList", supplierList);
        // Forward the request to view.jsp
        //req.getRequestDispatcher("viewSupplier.jsp").forward(req, res);
//      RequestDispatcher dispatcher = req.getRequestDispatcher("/viewSupplier.jsp");
//		dispatcher.forward(req, res);
        res.sendRedirect(req.getContextPath() + "/viewSupplier.jsp");
		}
    }

}
