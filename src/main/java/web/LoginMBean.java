package web;

import business.UserBO;
import entity.User;

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


}
