package dao;

import controller.UserController;
import model.UserModel;

//DAO - data access object
// this class is a DAO class for USER
public interface UserDAO {
    /**
     * @param UserModel object
     * @return boolean
     * this method is used to check user login credentials
     */
    boolean login(String username, String password);
    
    /**
     * @param UserModel object
     * @return boolean
     * this method is used to register new user
     */
    boolean register(UserController uc);
    
    /**
     * @param UserModel object - 
     * @return boolean
     * this method is used to check existing user 
     */
    boolean check_user(UserModel um);
    
    /**
     * @param UserModel object - username/email and new password
     * @return boolean
     * this method is used to change change password of forgot password
     */
    boolean forgot_password(UserModel um);
    
    /**
     * @param UserModel object - existing password, new password, user_id
     * @return boolean
     * this method is used to change change password of forgot password
     */
    boolean update_password(UserModel um);
    
    /**
     * @param UserModel object - user_id
     * @return boolean
     * this method is used to show user details as profile
     */
    boolean profile(UserModel um);
}
