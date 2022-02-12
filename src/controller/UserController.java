package controller;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import model.UserModel;

public class UserController {
    private UserDAO userDao;
    public String first_name;
    public String middle_name;
    public String last_name;
    public String contact;
    public String email;
    public String username;
    public String password;

    public UserController(String fname, String mname, String lname, String contact, String email, String pass, String username){
        this.first_name = fname;
        this.last_name = lname;
        this.middle_name = mname;
        this.contact = contact;
        this.email = email;
        this.password = pass;
        this.username = username;
        userDao = new UserDAOImpl();
    }
    
    public UserController(String username, String password){
        this.username = username;
        this.password = password;
        userDao = new UserDAOImpl();
    }
    
    public boolean create(UserController uc){
        if(userDao.register(uc)){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean login(UserController uc){
        UserModel um = new UserModel();
        um.setUsername(uc.username);
        um.setPassword(uc.password);
        if(userDao.login(um)){
            return true;
        }else{
            return false;
        }
    }
//    index - display list
//    create - return form
//    store - store data
//    edit - return form with data
//    update - update data
//    delete - delete data
//    show - show by id
}
