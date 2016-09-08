package br.com.ruangervasi.firstapp.domain.interfaces;

import java.util.List;
import br.com.ruangervasi.firstapp.domain.User;

/**
 * Created by Ruan on 31/08/2016.
 */
public interface IUserService {
    List<User> get();
    User getById(int id);
    void create(User user);
    void changeEmail(int id, String email);
    void remove(int id);
}
