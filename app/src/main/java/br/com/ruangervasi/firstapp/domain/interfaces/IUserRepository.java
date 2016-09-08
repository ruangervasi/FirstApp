package br.com.ruangervasi.firstapp.domain.interfaces;

import java.util.List;

import br.com.ruangervasi.firstapp.domain.User;

/**
 * Created by Ruan on 31/08/2016.
 */
public interface IUserRepository {

    List<User> get();
    User getById(int id);
    void add(User user);
    void update(User user);
    void delete(int id);

}
