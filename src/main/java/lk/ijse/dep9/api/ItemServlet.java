package lk.ijse.dep9.api;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lk.ijse.dep9.api.util.HttpServlet2;

import java.io.IOException;

@WebServlet(name = "ItemServlet", value = "/items/*")
public class ItemServlet extends HttpServlet2 {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.getWriter().println("item doGet()");
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
        response.getWriter().println("items doDelete()");
    }
}
