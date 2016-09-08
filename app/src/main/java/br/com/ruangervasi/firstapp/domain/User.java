package br.com.ruangervasi.firstapp.domain;

import com.activeandroid.Model;
import com.activeandroid.annotation.Table;
import com.activeandroid.annotation.Column;

/**
 * Created by Ruan on 31/08/2016.
 */
@Table(name = "User")
public class User extends Model{

    @Column(name = "Name") String name;
    @Column(name = "Email") String email;

    public User()
    {
        super();
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void changeEmail(String email){
        this.email = email;
    }

}
