/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic.Service;

import BusinessLogic.Controller.HandleDiet;
import DataAccess.DAO.DietDAO;
import DataAccess.DAO.UserDAO;
import DataAccess.Entity.Diet;
import DataAccess.Entity.Role;
import DataAccess.Entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;

/**
 *
 * @author Juanca
 */
@WebService(serviceName = "ConsultUserDietsWS")
public class ConsultUserDietsWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "ConsultUserDiets")
    public List<String[]> ConsultUserDiets(long document) {
        UserDAO daoUser = new UserDAO();
        User user = daoUser.getUserByDocument(document);
        if (user == null) {
            return null;
        }else if(user.getIdrole() != Role.UserRole.client.ordinal()){
            return null;
        }
        int id = user.getId();
        HandleDiet dietHandler = new HandleDiet();
        List<Diet> list = dietHandler.loadUserDiets(id);
        List<String[]> diets = new ArrayList<String[]>();
        String[] sDiet = new String[1];
        for (Diet diet : list) {
            sDiet[0] = diet.getId() + "";
            sDiet[1] = diet.getNsname();
            sDiet[2] = diet.getNsdescription();
            diets.add(sDiet);
            sDiet = new String[1];
        }
        System.out.println("*******************************************************************"+
                "LIST SIZE: " + diets.size());
        return diets;
    }
}
