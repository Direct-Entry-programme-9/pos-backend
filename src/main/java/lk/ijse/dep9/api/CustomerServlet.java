package lk.ijse.dep9.api;

import jakarta.annotation.Resource;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lk.ijse.dep9.api.util.HttpServlet2;
import lk.ijse.dep9.dto.CustomerDTO;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "CustomerServlet", value = "/customers/*", loadOnStartup = 0)
public class CustomerServlet extends HttpServlet2 {
    @Resource(lookup = "java:/comp/env/jdbc/dep9-pos")
    private DataSource pool;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.getWriter().println("customer doGet()");
        if (request.getPathInfo() == null || request.getPathInfo().equals("/")) {
            String query = request.getParameter("q");
            String size = request.getParameter("size");
            String page = request.getParameter("page");

            if (query != null && size != null && page != null){
                if (size.matches("\\d+") && page.matches("\\d+")){
                    searchPaginatedCustomers(query, Integer.parseInt(size),Integer.parseInt(page), response);
                } else {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid page or size");
                }
            } else {
                loadAllCustomers(response);
            }
        } else {
            Matcher matcher = Pattern.compile("^/([A-Fa-f0-9]{8}(-[A-Fa-f0-9]{4}){3}-[A-Fa-f0-9]{12})/?$")
                    .matcher(request.getPathInfo());
            if (matcher.matches()){
                getCustomerDetails(matcher.group(1), response);
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,"Expented valid UUID");
                response.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED, "Expected valid UUID");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("customer doPost()");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("customer doDelete()");
    }

    @Override
    protected void doPatch(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("customer doPatch()");
    }

    private void loadAllCustomers(HttpServletResponse response) throws IOException {
        try {
            Connection connection = pool.getConnection();

            Statement stm =connection.createStatement();
            ResultSet rst = stm.executeQuery("SELECT * FROM customer");

            ArrayList<CustomerDTO> customers = new ArrayList<>();

            while(rst.next()){
                String id = rst.getString("id");
                String name = rst.getString("name");
                String address = rst.getString("address");
                CustomerDTO dto = new CustomerDTO(id, name, address);
                customers.add(dto);
            }
            connection.close();

            Jsonb jsonb = JsonbBuilder.create();
            response.setContentType("application/json");
            jsonb.toJson(customers, response.getWriter());

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Fail to load customers");
        }
    }
    private void searchPaginatedCustomers(String query, int size, int page, HttpServletResponse response){
        try {
            response.getWriter().println("customer searchPaginatedCustomers()");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void getCustomerDetails(String customerId, HttpServletResponse response){
        try {
            response.getWriter().println("customer getCustomerDetails()");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
