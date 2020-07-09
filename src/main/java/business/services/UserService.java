package business.services;

import model.dto.UserModel;
import model.service.GenericService;
import model.service.ILogin;

import java.util.List;

public class UserService implements ILogin {
    private GenericService<UserModel> userGenericService = new GenericService<>();


    @Override
    public boolean register(String username, String password) {
        UserModel user = new UserModel();
        List<UserModel> list = userGenericService.getAll(user);
        boolean isRegistered = list.stream().anyMatch(u -> u.getUsername().equalsIgnoreCase(username));
        if (isRegistered) {
            return true;
        } else {
            user.setUsername(username);
            user.setPassword(password);
            userGenericService.add(user);
            return false;
        }
    }

    @Override
    public boolean login(UserModel user) {
        List<UserModel> list = userGenericService.getAll(user);
        return list.stream().anyMatch(u -> u.getUsername().equals(user.getUsername())
                && u.getPassword().equals(user.getPassword()));
    }
}
