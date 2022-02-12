package controller;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import model.UserModel;

public class LoginController {
    private final UserDAO userDao;
    
    public LoginController(){
        userDao = new UserDAOImpl();
    }
    
    public boolean checkLogin(String uname, String pass) {
        if(userDao.login(uname, pass)){
            return true;
        }else{
            return false;
        }
    }

}
