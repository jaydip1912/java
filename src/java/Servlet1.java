
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Servlet1 extends HttpServlet
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
            
        String n=request.getParameter("uname");
        String p=request.getParameter("upass");
        String m=request.getParameter("umail");
        String g=request.getParameter("gender");
        String c=request.getParameter("course");
        String ck=request.getParameter("checked");
        if(ck!=null)
        {
            if(ck.equals("ckd"))
            {        
                try
                {        
                    Class.forName("com.mysql.jdbc.Driver");
                    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "");
                    ps=con.prepareStatement("insert into tdata values(?,?,?,?,?)");
                    ps.setString(1, n);
                    ps.setString(2, p);
                    ps.setString(3, m);
                    ps.setString(4, g);
                    ps.setString(5, c);
                
                    ps.execute();
                    out.println("<script>alert('inserted')</script>");
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            else
            {
                out.println("<script>alert('check rems & Condition')</script>");
            }   
        }
        else
        {
            out.println("<script>alert('your are not  Accepted terms & condition')</script>");  
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
