package in.silive.techtrishna16.activity;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import in.silive.techtrishna16.NewsFeed.NewsFeedFragment;
import in.silive.techtrishna16.fragment.ContactUs;
import in.silive.techtrishna16.fragment.Events;
import in.silive.techtrishna16.fragment.NoNetDialog;
import in.silive.techtrishna16.fragment.QuerryUs;
import in.silive.techtrishna16.fragment.RegisterFragment;
import in.silive.techtrishna16.fragment.Rules;
import in.silive.techtrishna16.fragment.ScheduleFragment;
import in.silive.techtrishna16.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    TypedArray icons;
    String[] items;
    ActionBar mActionBar;
    ActionBarDrawerToggle mDrawerToggle;
    Fragment fragment;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mActionBar = getSupportActionBar();
        navigationView = (NavigationView)findViewById(R.id.navigation_drawer);
        navigationView.setNavigationItemSelectedListener(this);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.drawer_open,R.string.drawer_close){ };
        mDrawerToggle.setDrawerIndicatorEnabled(true);
        drawerLayout.setDrawerListener(mDrawerToggle);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
            item.setChecked(true);
        FragmentManager fragmentManager = getSupportFragmentManager();
        switch (item.getItemId()){
            case R.id.navigation_item_news_feed:
                fragment = new NewsFeedFragment();
                break;
            case R.id.navigation_item_events:
                fragment= new Events();
                break;
            case R.id.navigation_item_schedule:
                fragment= new ScheduleFragment();
                break;
            case R.id.navigation_item_register:
                ConnectivityManager check = (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo info = check.getActiveNetworkInfo();
                if (info==null) {
                    Toast.makeText(this, "Please check your network connection", Toast.LENGTH_SHORT).show();
                    NoNetDialog dialog = new NoNetDialog();
                    dialog.show(fragmentManager.beginTransaction(),"NoNetDialog");
                }
                else
                    fragment = new RegisterFragment();
                break;
            case R.id.navigation_item_rules:
                fragment = new Rules();
                break;
            case R.id.navigation_item_contact_us:
                fragment = new ContactUs();
                break;
            case R.id.navigation_item_querry_us:
                fragment = new QuerryUs();
                break;
        }
        final FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.content_frame, fragment);
        drawerLayout.closeDrawers();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                transaction.commit();
            }
        }, 700);
        return true;
    }
}
