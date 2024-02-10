package seminars.third.tdd;

public class User {
    String name;
    String password;
    boolean isAuthenticate = false;
    boolean isisAdmin = false;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isisAdmin = isAdmin;
    }

    //3.6. Метод должен возвращать true, если
    //введенные логин и пароль корректны, иначе false. Протестируйте все методы
    public boolean authenticate(String name, String password) {
        if (this.name == name && this.password == password) {
            this.isAuthenticate=true;
            return true;
        }
        return false;
    }

}