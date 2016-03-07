/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic.Controller;

import DataAccess.DAO.DietDAO;
import DataAccess.DAO.UserDAO;
import DataAccess.Entity.Diet;
import DataAccess.Entity.Role;
import DataAccess.Entity.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HandleDiet {

    public boolean createDiet(Diet diet) {

//        if (!DietDAO.dietExists(diet.getName())) {
//            return DietDAO.persist(diet) != null;
//        }
        DietDAO dao = new DietDAO();

        return dao.persist(diet) != null;
    }

    public String createDiet(String name, String desc, List<Integer> productList) {
        DietDAO dao = new DietDAO();
        if (dao.dietExists(name)) {
            return "Ya existe una dieta con ese nombre.";
        }
        Diet diet = new Diet();
        diet.setNsname(name);
        diet.setNsdescription(desc);
        if (dao.persist(diet) != null) {
            return "La dieta ha sido creada con éxito.";
        }
        return "Ha ocurrido un problema al guardar.";
    }

    public List<Diet> loadDiets() {
        DietDAO dao = new DietDAO();
        return dao.fetchDiets();
    }

    public void mapDiets(Map<Integer, String> dietsMap) {
        List<Diet> list = loadDiets();
        for (Diet diet : list) {
            dietsMap.put(diet.getId(), diet.getNsname());
        }
    }

    public String assignDiet(String username, int dietId) {
        DietDAO daoDiet = new DietDAO();
        UserDAO daoUser = new UserDAO();

        User user = daoUser.getUserByUserName(username);
        if (user == null) {
            return "No existe tal usuario.";
        }
        if (user.getIdrole() == Role.UserRole.client.ordinal()) {
            List<Integer> list = daoDiet.getUserDiets(user.getId());
            if (list.contains(dietId)) {
                return "El usuario ya tiene esa dieta asignada.";
            }
            return daoDiet.assignDiet(user.getId(), dietId) ? "Dieta asignada correctamente."
                    : "Ocurrió un error al asignar la dieta.";
        }
        return "A este tipo de usuario no se le pueden asignar dietas.";
    }

    public List<Diet> loadUserDiets(int userid) {
        DietDAO daoDiet = new DietDAO();
        List<Integer> list = daoDiet.getUserDiets(userid);
        List<Diet> diets = new ArrayList<>();
        Diet current = new Diet();
        if (!list.isEmpty()) {
            List<Diet> all = daoDiet.fetchDiets();
            for (Integer dietid : list) {
                current.setId(dietid);
                diets.add(all.get(all.indexOf(current)));
            }
        }
        return diets;
    }

}
