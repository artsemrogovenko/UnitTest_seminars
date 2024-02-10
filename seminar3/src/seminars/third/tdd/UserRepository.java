package seminars.third.tdd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserRepository {

    // Тут можно хранить аутентифицированных пользователей
    List<User> data = new ArrayList<>();

    public void addUser(User user) {
        if (user.isAuthenticate) {
            data.add(user);
        }
    }

    //Добавьте функцию в класс UserRepository, которая разлогинивает всех пользователей, кроме администраторов. Протестируйте данную функцию.
    public void logout() {
        for (User user : data) {
            if (!user.isisAdmin) {//если не админ, разлогинить
                user.isAuthenticate = false;
            }
        }
    }

    //удаляет не залогиненых
    public void clean() {
        List<User> temp = new ArrayList<>();
        for (User user : data) {
            if (user.isAuthenticate) {
                temp.add(user);
            }
        }
       data=temp;
    }

}


