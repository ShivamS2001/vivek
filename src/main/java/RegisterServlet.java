import java.io.IOException;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/send")
public class RegisterServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fuel=req.getParameter("fuel");
		String transmission =req.getParameter("transmission");
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String pdate = req.getParameter("pdate");
		String location = req.getParameter("location");
		String query = req.getParameter("query");
		
//		PrintWriter out= resp.getWriter();
//		out.println(fuel);
//		out.println(transmission);
//		out.println(fname);
//		out.println(lname);
//		out.println(email);
//		out.println(mobile);
//		out.println(pdate);
//		out.println(location);
//		out.println(query);
		
		
		Mymodel mm= new Mymodel(fuel, transmission, fname, lname, email, mobile, pdate, location, query);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(mm);
		em.getTransaction().commit();
		resp.sendRedirect("index.jsp");
}
		
		

}
