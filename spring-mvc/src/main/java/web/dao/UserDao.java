package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUser();

    public void addUser(User user);

    public void updateUser(Long id, String name, String surname);

    public void deleteUser(Long id);
}
