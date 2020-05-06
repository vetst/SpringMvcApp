package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public boolean addUser(User user) {
        if (user.getName() == null && user.getSurName() == null) {
            return false;
        } else {
            userDao.addUser(user);
            return true;
        }
    }

    @Transactional
    @Override
    public boolean updateUser(Long id, String name, String surName) {
        if (id != null && name != null && surName != null) {
            userDao.updateUser(id, name, surName);
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    @Override
    public boolean deleteUser(Long id) {
        if (id != null) {
            userDao.deleteUser(id);
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }
}
