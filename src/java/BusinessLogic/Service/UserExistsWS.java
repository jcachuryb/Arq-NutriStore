/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic.Service;

import DataAccess.DAO.UserDAO;
import DataAccess.Entity.Role;
import DataAccess.Entity.User;
import javax.jws.WebService;
import javax.jws.WebMethod;

/**
 *
 * @author Juanca
 */
@WebService(serviceName = "UserExistsWS")
public class UserExistsWS {

    /**
     * This is a sample web service operation
     * @return 
     */
    @WebMethod(operationName = "UserExists")
    public boolean UserExists(long document) {
        UserDAO daoUser = new UserDAO();
        User user = daoUser.getUserByDocument(document);
        
        if (user == null) return false;
        
        return user.getIdrole() == Role.UserRole.client.ordinal();
    }
}
