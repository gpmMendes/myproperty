package web;

import entity.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Gui on 30/11/15.
 */

@ManagedBean(name = "loginMBean")
@SessionScoped
public class LoginMBean {

    private User user;

    public LoginMBean() {
        user = new User();
        user.setName("Joao");

    }

    public User getUser() {

        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
