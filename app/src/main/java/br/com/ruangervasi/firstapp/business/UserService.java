package br.com.ruangervasi.firstapp.business;

import java.util.List;

import br.com.ruangervasi.firstapp.domain.User;
import br.com.ruangervasi.firstapp.domain.interfaces.IUserService;
import br.com.ruangervasi.firstapp.domain.interfaces.IUserRepository;
import br.com.ruangervasi.firstapp.repository.UserRepository;

/**
 * Created by Ruan on 31/08/2016.
 */
public class UserService implements IUserService {

    private IUserRepository _userRepository;

    public UserService() {
        _userRepository = new UserRepository();
    }

    @Override
    public List<User> get() {
        return _userRepository.get();
    }

    @Override
    public User getById(int id) {
        return _userRepository.getById(id);
    }

    @Override
    public void create(User user) {
        _userRepository.add(user);
    }

    @Override
    public void changeEmail(int id, String email) {
        User user = getById(id);
        user.changeEmail(email);
        _userRepository.update(user);
    }

    @Override
    public void remove(int id) {
        _userRepository.delete(id);
    }
}
