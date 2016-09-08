package br.com.ruangervasi.firstapp;

import android.app.Activity;
import android.support.annotation.UiThread;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import br.com.ruangervasi.firstapp.business.UserService;
import br.com.ruangervasi.firstapp.domain.User;
import br.com.ruangervasi.firstapp.domain.interfaces.IUserService;

@EActivity(R.layout.consulta_activity)
public class ConsultaActivity extends Activity {

    @ViewById TextView info_text;

    IUserService userService;

    @AfterViews void init(){
        userService = new UserService();
        updateResults();
    }

    @UiThread void updateResults(){
        info_text.setText(getResults());
    }

    String getResults(){
        List<User> users = userService.get();
        String result = "";
        for (User u : users){
            result = result + u.getName() + " - " + u.getName() + "\n";
        }
        return result;
    }

}
