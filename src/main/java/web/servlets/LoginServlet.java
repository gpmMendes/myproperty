package web.servlets;

import web.helper.Constants;
import web.helper.WebUtils;

import javax.security.auth.login.FailedLoginException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

        boolean isSuperUser = !WebUtils.isNullOrEmpty(j_userid);

        boolean isLogged = false;

        try {

            // we need create a session if don't exist before call the login module
            req.getSession(true);

            // using JBoss web authentication programmatic propagation
            //WebAuthentication webAuthentication = new WebAuthentication();

            isLogged = WebUtils.login();//webAuthentication.login(userName, password);

            if(isLogged) {
                // if the login was successful we redirect to the landing page
                resp.sendRedirect(WebUtils.getRequestURL(req, resp) + Constants.HOME_HOMEPAGE_XHTML);
            }else{
                // if the login fail we try get the exception that the LoginModule did throw.
                FailedLoginException loginException = new FailedLoginException("error");
                // if something it's wrong with the login module and we can't get any exception
                if (loginException == null) {
                    loginException = new FailedLoginException("error");
                }

                throw loginException;
            }
        }catch (Exception e){
            String errorRedirection = setErrorRedirection(req, resp, isSuperUser, e);
            // URL to redirect the user with the error message
            resp.sendRedirect(errorRedirection);
        }finally {
            if (!isLogged) {
                HttpSession session = req.getSession(false);
                if (session != null) {
                    session.invalidate();
                }
            }
        }
    }

    /**
     * set the error redirection to redirect the page to Login page with an error message
     * @param req
     * @param resp
     * @param isSuperUser
     * @param jaasException
     * @return
     */
    protected String setErrorRedirection(HttpServletRequest req, HttpServletResponse resp, boolean isSuperUser,
                                         Exception jaasException) {

        // creating the error message to be add in to the URL request
        StringBuilder errorRedirection = new StringBuilder();
        // trying get the configured OLS main login URL from the settings
        if (errorRedirection.length() == 0) {

            errorRedirection.append(WebUtils.getRequestURL(req, resp))
                    .append(Constants.HOME_HOMEPAGE_XHTML);
        }


        return errorRedirection.toString();
    }
}
