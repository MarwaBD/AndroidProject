package com.mma.coviguide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class AboutVirus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_virus);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch ( item.getItemId() ){
            case R.id.menu_home:
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
            default:
                return super.onOptionsItemSelected(item);

        }


    }
}