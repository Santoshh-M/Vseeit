package com.santosh.vseeit;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private static final int HOME_FRAGMENT = 0;
    private static final int CART_FRAGMENT = 1;
    private FrameLayout frameLayout;
    private ImageView actionBarlogo;
    private static int currentFragment;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        actionBarlogo = findViewById(R.id.actionbar_logo);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);

        frameLayout = findViewById(R.id.main_framelayout);
        setFragment(new Homefragment(),HOME_FRAGMENT);
    }

    boolean doubleBackToExitPressedOnce = false;
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please hit BACK button again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if (currentFragment == HOME_FRAGMENT){
            getMenuInflater().inflate(R.menu.main, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (@NonNull MenuItem item){

            int id = item.getItemId();
            if (id == R.id.main_search_icon) {
                return true;
            } else if (id == R.id.main_notification_icon) {
                return true;
            } else if (id == R.id.main_cart_icon) {
               mycart();
                return true;
            }
            return super.onOptionsItemSelected(item);
        }

        private void mycart(){
        actionBarlogo.setVisibility(View.GONE);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setTitle("My Cart");
        invalidateOptionsMenu();
        setFragment(new MyCart(),CART_FRAGMENT);
            navigationView.getMenu().getItem(4).setChecked(true);
        }
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_my_home) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            actionBarlogo.setVisibility(View.VISIBLE);
            invalidateOptionsMenu();
           setFragment(new Homefragment(),HOME_FRAGMENT);
        } else if (id == R.id.nav_my_order) {
            Intent loged = new Intent(getApplicationContext(), register.class);
            startActivity(loged);
        } else if (id == R.id.nav_my_account) {
            Toast.makeText(this, "Account", Toast.LENGTH_SHORT).show();
        }else if (id == R.id.nav_my_rewards) {
                Intent favo = new Intent(getApplicationContext(), Login.class);
                startActivity(favo);
        } else if (id == R.id.nav_my_cart) {
            mycart();
        } else if (id == R.id.nav_my_wishlist) {
            Intent sare = new Intent(getApplicationContext(), Login.class);
            startActivity(sare);
        } else if (id == R.id.nav_my_logout) {
            finish();
    }
        DrawerLayout  drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
        }

    private void setFragment(Fragment fragment,int fragmentNo) {
        if (fragmentNo != currentFragment) {

            currentFragment = fragmentNo;
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            fragmentTransaction.replace(frameLayout.getId(), fragment);
            fragmentTransaction.commit();
        }
    }
}