package Model;

public class Roles {
    public static final String ROLES_ID = "Roles_id";
    public static final String NAME = "Name";

    private static int Roles_id;
    private static String Name;

    public Roles() {}

    public Roles(String name){
        this.Name = name;
    }

    public Roles(int roles_id, String name){
        this.Roles_id = roles_id;
        this.Name = name;
    }

    public static int getRoles_id() {
        return Roles_id;
    }

    public static void setRoles_id(int roles_id) {
        Roles_id = roles_id;
    }

    public static String getName() {
        return Name;
    }

    public static void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Roles{ Roles_id: " + Roles_id + "\n" +
                "Name: " + Name + "\n" +
                "}";
    }
}
