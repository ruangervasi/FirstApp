package br.com.ruangervasi.firstapp.repository;

import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import java.util.List;
import br.com.ruangervasi.firstapp.domain.User;
import br.com.ruangervasi.firstapp.domain.interfaces.IUserRepository;

/**
 * Created by Ruan on 31/08/2016.
 */
public class UserRepository implements IUserRepository{

    @Override public List<User> get() {
        return new Select().from(User.class).execute();
    }

    @Override public User getById(int id) {
        return new Select().from(User.class).where("Id = ?", id).executeSingle();
    }

    @Override public void add(User user) {
        user.save();
    }

    @Override public void update(User user) {
        user.save();
    }

    @Override public void delete(int id) {
        new Delete().from(User.class).where("Id = ?", id).executeSingle();
    }
}
