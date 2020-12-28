package ProtectionProxy;

import DAO.RolesDao;
import Impl.RolesImpl;
import Model.Roles;
import Model.Users;

import java.util.List;

public class RolesProxy implements RolesDao {

    private Users users;
    private RolesDao rolesDao;

    public RolesProxy(Users users) {
        this.users = users;
        this.rolesDao = new RolesImpl();
    }

    @Override
    public List<Roles> getAllRoles() {
        return rolesDao.getAllRoles();
    }

    @Override
    public Roles getByName(String name) {
        return rolesDao.getByName(name);
    }

    @Override
    public Roles getByRolesId(int id) {
        return rolesDao.getByRolesId(id);
    }

    @Override
    public void CreateRole(Roles roles) {
        if (users.getId_role() == 1) {
            rolesDao.CreateRole(roles);
            System.out.printf("You can use the function as you are the admin\n");
        } else {
            System.out.printf("Sorry, you are not an admin!\n");
        }
    }

    @Override
    public void UpdateRole(Roles roles) {
        if (users.getId_role() == 1) {
            rolesDao.UpdateRole(roles);
            System.out.printf("You can use the function as you are the admin\n");
        } else {
            System.out.printf("Sorry, you are not an admin!\n");
        }
    }

    @Override
    public void DeleteRole(Roles roles) {
        if (users.getId_role() == 1) {
            rolesDao.DeleteRole(roles);
            System.out.printf("You can use the function as you are the admin\n");
        } else {
            System.out.printf("Sorry, you are not an admin!\n");
        }
    }
}
