package unb.cic.poo.game2d.parse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.game2d.R;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends Activity {
	//---------------------------------------------
    // VARIABLES
    //---------------------------------------------

	Button signup;
	Button back;
	String emailtxt;
	String usernametxt;
	String passwordtxt;
	EditText email;
	EditText password;
	EditText username;
	private Boolean sign = false;
	
	//---------------------------------------------
    // CLASS LOGIC
    //---------------------------------------------

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Determina o xml
		setContentView(R.layout.signup);
		// Localiza as caixas de texto
		email = (EditText) findViewById(R.id.email);
		username = (EditText) findViewById(R.id.username);
		password = (EditText) findViewById(R.id.password);

		// Localzia os bot�es
		signup = (Button) findViewById(R.id.signup);
		back = (Button) findViewById(R.id.back);

		// Sign up Button Click Listener
		signup.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				// Retorna as informa��es das caixas de texto
				emailtxt = email.getText().toString();
				usernametxt = username.getText().toString();
				passwordtxt = password.getText().toString();
				
				// For�a a completar as caixas de texto
				if (usernametxt.equals("") && passwordtxt.equals("") && emailtxt.equals("")) {
					Toast.makeText(getApplicationContext(),	"Please complete the sign up form.", Toast.LENGTH_LONG).show();

				} else {
					// Salva o novo usu�rio no Parse
					final ParseUser user = new ParseUser();
					user.setUsername(usernametxt);
					user.setPassword(passwordtxt);
					user.setEmail(emailtxt);
					
					// Ver adi��o de verifica��o de email ou facebook
					user.signUpInBackground(new SignUpCallback() {
						public void done(ParseException e) {
							if (e == null) {
								HighScore.getInstance().setUser(user);
								sign = true;
							} else {
								Toast.makeText(getApplicationContext(), "Sign Up Error.", Toast.LENGTH_LONG).show();
							}
						}
					});
					
					if (sign == true){
						// Envia informa��o para verifica��o no Parse
						ParseUser.logInInBackground(usernametxt, passwordtxt, new LogInCallback() {
							public void done(ParseUser user, ParseException e) {
								if (user != null) {
									// Se o usu�rio existe e � autenticado, envia ao ScoreTableActivity.class
									Intent intent = new Intent(SignUpActivity.this, ScoreTableActivity.class);
									startActivity(intent);
									Toast.makeText(getApplicationContext(), "Successfully Logged in.", Toast.LENGTH_LONG).show();
									finish();
								} else {
									Intent intent = new Intent(SignUpActivity.this, LoginSignupActivity.class);
									startActivity(intent);
									Toast.makeText(getApplicationContext(),	"Log In Error. Please create a new user or try again.", Toast.LENGTH_LONG).show();
									finish();
								}
							}
						});
					}
				}

			}
		});
		
		// Back Button Click Listener
		back.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Intent intent = new Intent(SignUpActivity.this, LoginSignupActivity.class);
				startActivity(intent);
				finish();
			}
		});

	}
	
	@Override
	public void onBackPressed() {
		Intent intent = new Intent(SignUpActivity.this, LoginSignupActivity.class);
		startActivity(intent);
		finish();
	}
	
}
