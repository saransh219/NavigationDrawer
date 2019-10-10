package com.example.navigationdrawer;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
    {
        int id;
        id = menuItem.getItemId();
         switch (id)
         {
             case R.id.inbox_id:
                 Toast.makeText(this, "This is inbox", Toast.LENGTH_SHORT).show();
                break;

             case R.id.starred_id:
                 Toast.makeText(this, "These are Starred messages", Toast.LENGTH_SHORT).show();
                 break;
             case R.id.sent_id:
                 Toast.makeText(this, "These are sent items", Toast.LENGTH_SHORT).show();
                break;

             case R.id.drafts_id:
                 Toast.makeText(this, "Drafts", Toast.LENGTH_SHORT).show();
                 break;

             case R.id.allmail_id:
                 Toast.makeText(this, "All mails", Toast.LENGTH_SHORT).show();
                 break;
             case R.id.trash_id:
                 Toast.makeText(this, "Deleted Junk", Toast.LENGTH_SHORT).show();
                 break;
             case R.id.spam_id:
                 Toast.makeText(this, "Spam Spam Spam", Toast.LENGTH_SHORT).show();
                 break;


         }
         //after a conditional code is exectuted it will close the Drawer in this particular direction
         drawerLayout.closeDrawer(Gravity.LEFT);
        return true;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);

        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        //Doubt
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
            super.onBackPressed();
    }
}
