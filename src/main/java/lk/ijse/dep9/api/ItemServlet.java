package lk.ijse.dep9.api;

import jakarta.annotation.Resource;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lk.ijse.dep9.api.util.HttpServlet2;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "ItemServlet", value = "/items/*", loadOnStartup = 0)
public class ItemServlet extends HttpServlet2 {

    @Resource(lookup = "java:/comp/env/jdbc/dep9_pos")
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
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getPathInfo() == null || request.getPathInfo().equals("/")){
            response.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED, "Expected valid UUID");
            return;
        }

        Matcher matcher = Pattern.compile("^/([A-Fa-f0-9]{8}(-[A-Fa-f0-9]{4}){3}-[A-Fa-f0-9]{12})/?$")
                .matcher(request.getPathInfo());
        if (matcher.matches()){
            deleteItem(matcher.group(1), response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED, "Expected valid UUID");
        }
    }

    private void deleteItem(String itemCode, HttpServletResponse response) throws IOException {
        try (Connection connection = pool.getConnection()){
            PreparedStatement stm = connection.prepareStatement("DELETE FROM item WHERE code = ?");
            stm.setString(1, itemCode);
            int affectedRows = stm.executeUpdate();
            System.out.println(affectedRows);
            if (affectedRows == 0){
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Invalid member Id");
            } else {
                response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }


        } catch (SQLException | IOException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error while loading the database");
        }
    }
}

