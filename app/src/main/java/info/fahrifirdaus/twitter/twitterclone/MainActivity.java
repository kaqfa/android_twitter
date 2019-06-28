package info.fahrifirdaus.twitter.twitterclone;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import info.fahrifirdaus.twitter.twitterclone.fragments.DashboardFragment;
import info.fahrifirdaus.twitter.twitterclone.fragments.FriendFragment;
import info.fahrifirdaus.twitter.twitterclone.fragments.PostFormFragment;

public class MainActivity extends AppCompatActivity implements PostFormFragment.OnPostSubmitListener {

    private TextView mTextMessage;
    FragmentTransaction ft;
    BottomNavigationView navigation;
    FirebaseAuth fireAuth;
    FirebaseUser fireUser;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.fragment_area, new DashboardFragment());
                    ft.commit();
                    return true;
                case R.id.navigation_friends:
                    ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.fragment_area, new FriendFragment());
                    ft.commit();
                    return true;
                case R.id.navigation_post:
                    ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.fragment_area, new PostFormFragment());
                    ft.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Intent itLogin = getIntent();
//        fireUser = (FirebaseUser) itLogin.getSerializableExtra("user");

        fireAuth = FirebaseAuth.getInstance();
        fireUser = fireAuth.getCurrentUser();

        if(fireUser == null){
            toLogin();
        } else {
            String email = fireUser.getEmail();
            Toast.makeText(this, email, Toast.LENGTH_LONG).show();
        }

        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_area, new DashboardFragment());
        ft.commit();

        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void toLogin(){
        Intent it = new Intent(this, LoginActivity.class);
        it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(it);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.logout){
            fireAuth.signOut();
            toLogin();
        }

        return true;
    }

    @Override
    public void onPostSubmit() {
        Log.d("mbuh", "log submit");

        navigation.setSelectedItemId(R.id.navigation_home);
    }

}
