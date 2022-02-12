package dao.impl;

import controller.UserController;
import dao.UserDAO;
import dbconfig.DbConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.UserModel;

public class UserDAOImpl implements UserDAO{
    private final DbConnection dbConnect;
//    constructor with DbConnection class object
    public UserDAOImpl(){
        dbConnect = DbConnection.getInstance();
    }
    
    @Override
    public boolean login(UserModel um) {
        try {
            String sql = "SELECT username, passcode FROM tbl_user WHERE username ='" + um.getUsername() + "' AND passcode ='" + um.getPassword() + "';";
            ResultSet rs = dbConnect.selectQueryBuilder(sql);
            if(rs.next()){
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean register(UserController uc) {
        UserModel um = new UserModel();
        um.setFirst_name(uc.first_name);
        um.setMiddle_name(uc.middle_name);
        um.setLast_name(uc.last_name);
        um.setContact(uc.contact);
        um.setEmail(uc.email);
        um.setUsername(uc.username);
        um.setPassword(uc.password);
        try {   
            String sql_query = "INSERT INTO tbl_user(first_name, middle_name, last_name, contact, email, username, passcode)" +
                    " VALUES ('"+ um.getFirst_name() + "','" + um.getMiddle_name() + "','" 
                    + um.getLast_name() + "', '" + um.getContact() +"','"+um.getEmail() +"', '"
                    + um.getUsername()+"','" + um.getPassword() + "')";
            System.out.println(sql_query);
            return dbConnect.iudQueryBuilder(sql_query) > 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean check_user(UserModel um) {
        return true;
    }

    @Override
    public boolean forgot_password(UserModel um) {
        return true;
    }

    @Override
    public boolean update_password(UserModel um) {
        return true;
    }

    @Override
    public boolean profile(UserModel um) {
        return true;
    }
    
}
