/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic.Controller;

import DataAccess.DAO.DietDAO;
import DataAccess.DAO.ProductDAO;
import DataAccess.Entity.Diet;
import DataAccess.Entity.Product;

public class HandleDiet {

    public boolean createDiet(Diet diet) {

//        if (!DietDAO.dietExists(diet.getName())) {
//            return DietDAO.persist(diet) != null;
//        }
        DietDAO dao = new DietDAO();

        return dao.persist(diet) != null;
    }

    public boolean createDiet(String name, String desc) {
        Diet diet = new Diet();
        diet.setNsname(name);
        diet.setNsdescription(desc);
        DietDAO dao = new DietDAO();
      
        
        return dao.persist(diet) != null;
    }

}
