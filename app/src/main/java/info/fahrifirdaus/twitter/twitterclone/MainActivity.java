package info.fahrifirdaus.twitter.twitterclone;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import info.fahrifirdaus.twitter.twitterclone.fragments.DashboardFragment;
import info.fahrifirdaus.twitter.twitterclone.fragments.FriendFragment;
import info.fahrifirdaus.twitter.twitterclone.fragments.PostFormFragment;

public class MainActivity extends AppCompatActivity implements PostFormFragment.OnPostSubmitListener {

    private TextView mTextMessage;
    FragmentTransaction ft;
    BottomNavigationView navigation;
    FirebaseAuth fireAuth;

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

        fireAuth = FirebaseAuth.getInstance();

        if(fireAuth.getCurrentUser() == null){
            Intent it = new Intent(this, LoginActivity.class);
            it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(it);
            finish();
        }

        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_area, new DashboardFragment());
        ft.commit();

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onPostSubmit() {
        Log.d("mbuh", "log submit");

        navigation.setSelectedItemId(R.id.navigation_home);
    }

}
