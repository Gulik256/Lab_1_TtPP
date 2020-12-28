package Model;

public class Users {
    public static final String USER_ID = "Users_id";
    public static final String LOGIN = "Login";
    public static final String PASS = "Pass";
    public static final String ID_ROLE = "id_role";

    private static int Users_id;
    private static String Login;
    private static String Pass;
    private static int id_role;

    public Users() {
    }

    public Users(String login, String pass) {
        this.Login = login;
        this.Pass = pass;
    }

    public Users(int users_id, String login, String pass) {
        this.Users_id = users_id;
        this.Login = login;
        this.Pass = pass;
    }

    public Users(int users_id, String login, String pass, int Id_role) {
        this.Users_id = users_id;
        this.Login = login;
        this.Pass = pass;
        this.id_role = Id_role;
    }

    public static int getUsers_id() {
        return Users_id;
    }

    public static void setUsers_id(int users_id) {
        Users_id = users_id;
    }

    public static String getLogin() {
        return Login;
    }

    public static void setLogin(String login) {
        Login = login;
    }

    public static String getPass() {
        return Pass;
    }

    public static void setPass(String pass) {
        Pass = pass;
    }

    public static int getId_role() {
        return id_role;
    }

    public static void setId_role(int id_role) {
        Users.id_role = id_role;
    }

    @Override
    public String toString() {
        return "Users{ Users_id: " + Users_id + "\n" +
                "Login: " + Login + "\n" +
                "Pass: " + Pass + "\n" +
                "Id_role: " + id_role + "\n" +
                "}";
    }
}
