package model.service;

import model.dto.UserModel;

public interface ILogin {
    boolean register(String username, String password);
    boolean login(UserModel user);
}
