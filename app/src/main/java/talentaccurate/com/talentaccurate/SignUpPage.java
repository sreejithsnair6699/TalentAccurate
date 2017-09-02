package talentaccurate.com.talentaccurate;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpPage extends AppCompatActivity {

    Button loginButton;
    EditText username;
    EditText userPassword;
    EditText confirmPassword;

    String email;
    String password;
    String confirmPass;

    StartScreen instance = new StartScreen();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up_page);

        loginButton = (Button) findViewById(R.id.btnLogin);
        username = (EditText) findViewById(R.id.txtUsername);
        userPassword = (EditText) findViewById(R.id.txtPassword);
        confirmPassword = (EditText) findViewById(R.id.txtConfirmPassword);
    }

    public void btnSignUpClicked(View view){
        signUp();
    }

    public void signUp() {
        if (!validate()) {
            onSignUpFailed();
            return;
        }

        loginButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(SignUpPage.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        email = username.getText().toString();
        password = userPassword.getText().toString();
        confirmPass = confirmPassword.getText().toString();

        // TODO: Implement your own authentication logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        onSignUpSuccess();
                        progressDialog.dismiss();
                    }
                }, 2000);
    }


    public void onSignUpSuccess() {
        loginButton.setEnabled(true);


        Intent intent = new Intent(this, MenuPage.class);
        startActivity(intent);

        finishAffinity();
    }

    public void onSignUpFailed() {
        loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String email = username.getText().toString();
        String password = userPassword.getText().toString();
        String confirmPass = confirmPassword.getText().toString();

        //if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
        // username.setError("enter a valid email address");
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

        //if(!password.equals(confirmPass)){
        //    confirmPassword.setError("Passwords don't match");
        //    valid = false;
        //}

        return valid;
    }
}
