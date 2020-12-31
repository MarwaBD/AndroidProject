package com.mma.coviguide;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class AboutVirus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_virus);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.title5));

    }


    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.menu_home){
            Intent myintent = new Intent(AboutVirus.this,Settings.class);
            startActivity(myintent);

            return false;
        }
        else if (id == R.id.aboutApp){
            Intent myintent = new Intent(AboutVirus.this,AboutApp.class);
            startActivity(myintent);

            return false;
        }
        return super.onOptionsItemSelected(item);




    }
}