package lk.ijse.dep9.api;

import jakarta.annotation.Resource;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lk.ijse.dep9.dto.CustomerDTO;
import lk.ijse.dep9.dto.OrderDTO;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "OrderServlet", value = "/orders/*")
public class OrderServlet extends HttpServlet {
    @Resource(lookup = "java:/comp/env/jdbc/dep9-pos")
    private DataSource pool;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            if (!request.getContentType().startsWith("application/json")) {
                throw new JsonbException("Invalid JSON");
            }
            Jsonb jsonb = JsonbBuilder.create();
            OrderDTO order = jsonb.fromJson(request.getReader(), OrderDTO.class);
        }
        catch (JsonbException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid JSON");
        }
    }
}
