package web.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by guilherme on 23/12/15.
 */
public class LoginServlet extends HttpServlet {

    public LoginServlet() {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String userName = req.getParameter("j_username");
        String password = req.getParameter("j_password");
        String j_userid = req.getParameter("j_userid");


    }
}
