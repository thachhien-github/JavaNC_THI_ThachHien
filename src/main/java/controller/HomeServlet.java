package controller;

import dao.SanPhamDAO;
import model.SanPham;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/trang-chu")
public class HomeServlet extends HttpServlet {

    private SanPhamDAO dao = new SanPhamDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");

            List<SanPham> spkm = dao.get6KhuyenMai();
            request.setAttribute("spkm", spkm);
            request.getRequestDispatcher("/home.jsp").forward(request, response);
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }
}
