package lk.ijse.dep9.api;

import jakarta.annotation.Resource;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lk.ijse.dep9.api.util.HttpServlet2;

import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(name = "ItemServlet", value = "/items/*", loadOnStartup = 0)




public class ItemServlet extends HttpServlet2 {
    @Resource(lookup = "java:/comp/env/jdbc/dep9-lms")
    private DataSource pool;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("items doGet()");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("items doPost()");
    }

    @Override
    protected void doPatch(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("items doPatch()");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        }
    }
}
