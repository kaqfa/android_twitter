package info.fahrifirdaus.twitter.twitterclone;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserProfileChangeRequest;

public class RegisterActivity extends AppCompatActivity {

    String email, password, confirm, name;
    EditText edtEmail, edtPassword, edtConfirm, edtName;
    FirebaseAuth fireAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fireAuth = FirebaseAuth.getInstance();

        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        edtConfirm = findViewById(R.id.edt_confirm);
        edtName = findViewById(R.id.edt_name);
    }

    public void toLogin(View view) {
        finish();
    }

    public void registerUser(View view) {
        email = edtEmail.getText().toString();
        password = edtPassword.getText().toString();
        confirm = edtConfirm.getText().toString();
        name = edtName.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Email tidak boleh kosong", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
            return;
        } else if (!password.equals(confirm)) {
            Toast.makeText(this, "Password dan konfirmasi harus sama", Toast.LENGTH_SHORT).show();
            return;
        }

        fireAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    UserProfileChangeRequest profileUpdate = new UserProfileChangeRequest.Builder().setDisplayName(name).build();
                    task.getResult().getUser().updateProfile(profileUpdate).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            finish();
                        }
                    });
                } else {
                    Toast.makeText(getBaseContext(), "Ada kesalahan", Toast.LENGTH_LONG).show();
                    Log.e("error", task.getException().getMessage());
                }
            }
        });
    }
}
