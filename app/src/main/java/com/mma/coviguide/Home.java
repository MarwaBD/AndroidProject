package com.mma.coviguide;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

import java.net.URI;


public class Home extends AppCompatActivity {
    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));
        mainGrid = (GridLayout) findViewById(R.id.mainGrid);
        setSingleEvent(mainGrid);
    }
    //menu de navigation

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    //item selection
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.settings){
            Intent myintent = new Intent(Home.this,Settings.class);
            startActivity(myintent);

            return false;
        }

        else if (id == R.id.aboutApp){
            Intent myintent = new Intent(Home.this,AboutApp.class);
            startActivity(myintent);

            return false;
        }
        return super.onOptionsItemSelected(item);




    }
    //intent to a browser

    public void open(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.worldometers.info/coronavirus/country/tunisia/"));
        startActivity(browserIntent);
    }

    //intents to other activities

    private void setSingleEvent(GridLayout mainGrid) {
        for (int i=0;i<mainGrid.getChildCount();i++){
            CardView cardView = (CardView)mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (finalI == 0){
                        Intent intent = new Intent(Home.this,AboutVirus.class);
                        startActivity(intent);
                        Toast.makeText(Home.this,"About Virus",Toast.LENGTH_SHORT).show();
                    }
                    else if (finalI == 1){
                        Intent intent = new Intent(Home.this,Symptoms.class);
                        startActivity(intent);
                        Toast.makeText(Home.this,"Symptoms",Toast.LENGTH_SHORT).show();
                    }
                    else if (finalI == 2){
                        Intent intent = new Intent(Home.this,HowToProtect.class);
                        startActivity(intent);
                        Toast.makeText(Home.this,"How To Protect",Toast.LENGTH_SHORT).show();
                    }
                    else if (finalI == 3){
                        Intent intent = new Intent(Home.this,HomeIsolation.class);
                        startActivity(intent);
                        Toast.makeText(Home.this,"HomeIsolation",Toast.LENGTH_SHORT).show();
                    }
                    else if (finalI == 4){
                        Intent intent = new Intent(Home.this,ThingsToDo.class);
                        startActivity(intent);
                        Toast.makeText(Home.this,"Things To Do",Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }
}