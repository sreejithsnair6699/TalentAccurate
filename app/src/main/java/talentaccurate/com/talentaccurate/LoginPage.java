package talentaccurate.com.talentaccurate;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends Activity {

    Button loginButton;
    EditText username;
    EditText userPassword;

    StartScreen instance = new StartScreen();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login_page);

        loginButton = (Button) findViewById(R.id.btnLogin);
        username = (EditText) findViewById(R.id.txtUsername);
        userPassword = (EditText) findViewById(R.id.txtPassword);

    }

    public void btnLoginClicked(View view){

        login();;

    }

    public void login() {
        if (!validate()) {
            onLoginFailed();
            return;
        }

        loginButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(LoginPage.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        String email = username.getText().toString();
        String password = userPassword.getText().toString();

        // TODO: Implement your own authentication logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        onLoginSuccess();
                        progressDialog.dismiss();
                    }
                }, 2000);
    }


    public void onLoginSuccess() {
        loginButton.setEnabled(true);

        Intent intent = new Intent(this, MenuPage.class);
        startActivity(intent);

        finishAffinity();
    }

    public void onLoginFailed() {
        loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String email = username.getText().toString();
        String password = userPassword.getText().toString();

        //if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
        //    username.setError("enter a valid email address");
        //    valid = false;
        //} else {
        //    username.setError(null);
        //}

        //if (password.isEmpty() || password.length() < 4 || password.length() > 16) {
        //    userPassword.setError("between 4 and 16 alphanumeric characters");
        //    valid = false;
        //} else {
        //    userPassword.setError(null);
        // }

        return valid;
    }
}

