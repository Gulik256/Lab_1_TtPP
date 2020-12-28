package DAO;

import Model.Roles;

import java.util.List;

public interface RolesDao {
    List<Roles> getAllRoles();
    Roles getByName(String name);
    Roles getByRolesId(int id);
    void CreateRole(Roles roles);
    void UpdateRole(Roles roles);
    void DeleteRole(Roles roles);

//TODO create more functions
}
