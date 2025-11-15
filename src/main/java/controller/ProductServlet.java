package controller;

import dao.SanPhamDAO;
import dao.TheLoaiDAO;
import model.SanPham;
import model.TheLoai;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/san-pham")
public class ProductServlet extends HttpServlet {

    private SanPhamDAO spDao = new SanPhamDAO();
    private TheLoaiDAO tlDao = new TheLoaiDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");

            List<TheLoai> dsmaloai = tlDao.getAll();
            request.setAttribute("dsmaloai", dsmaloai);

            int maloai = 1; // default Tập luyện
            String strMaloai = request.getParameter("maloai");
            if (strMaloai != null) {
                maloai = Integer.parseInt(strMaloai);
            }

            List<SanPham> dsSp = spDao.getByMaLoai(maloai);
            request.setAttribute("dsSp", dsSp);

            TheLoai tl = tlDao.getById(maloai);
            request.setAttribute("theLoaiChon", tl);

            request.getRequestDispatcher("/category.jsp").forward(request, response);

        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }
}
