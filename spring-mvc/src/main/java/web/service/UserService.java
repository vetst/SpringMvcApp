package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    public boolean addUser(User user) ;

    public boolean updateUser(Long id, String name, String surName);

    public boolean deleteUser(Long id);

    public List<User> getAllUser();
}
