package br.com.ruangervasi.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import br.com.ruangervasi.firstapp.business.UserService;
import br.com.ruangervasi.firstapp.domain.User;
import br.com.ruangervasi.firstapp.domain.interfaces.IUserService;

@EActivity(R.layout.main_activity)
public class MainActivity extends Activity{

    @ViewById EditText name;
    @ViewById EditText email;
    @ViewById Button add;
    @ViewById Button consult;
    @ViewById TextView results;

    IUserService userService;

    @AfterViews void init(){
        userService = new UserService();
        updateResults();
    }

    @Click void consult(View view){
        Intent it = new Intent(getBaseContext(), ConsultaActivity.class);
        startActivity(it);
    }

    @Click void add(){
        String nameUser = name.getText().toString();
        String emailUser = email.getText().toString();

        User user = new User(nameUser, emailUser);
        userService.create(user);
        Toast.makeText(this, "Criado com sucesso!", Toast.LENGTH_SHORT).show();
        updateResults();
    }

    @UiThread void updateResults(){
        results.setText(getResults());
    }

    String getResults(){
        List<User> users = userService.get();
        String result = "";
        for (User u : users){
            result = result + u.getName() + "\n";
        }
        return result;
    }

}
