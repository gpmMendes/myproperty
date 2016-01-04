package web;

import business.UserBO;
import entity.User;
import web.helper.Constants;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Gui on 30/11/15.
 */

@ManagedBean(name = "loginMBean")
@SessionScoped
public class LoginMBean {
    @EJB
    private UserBO userController;

    private User user;


    public LoginMBean() {

    }

    public User getUser() {
        Long test = 1L;
        return userController.getById(test);
    }

    public void setUser(User user) {
        this.user = user;
    }


    /**
     * This method opens a contact for edit purpose from the current member
     * @return String success and go to the contacts.xhtml
     **/
    public String showView_EditItemPage() {
        return Constants.OLS_CUSTOMER_CUSTMAINTENANCE_XHTML;
    }
}
