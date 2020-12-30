package com.mma.coviguide;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button changeLang = findViewById(R.id.ChangeMyLang);
        changeLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //show alert dialog to display list of languages one can be selected
                showChangeLanguageDialog();
            }
        });
    }

    private void showChangeLanguageDialog() {
        //array of languages
        final String[] listItems = {"Francais","العربية"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(Settings.this);
        mBuilder.setTitle("Choose language...");
        mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    //French
                    setLocale("fr");
                    recreate();
                }
                else if (i == 1) {
                    //Arabic
                    setLocale("ar");
                    recreate();
                }
                else if (i == 2) {
                    //English
                    setLocale("en");
                    recreate();
                }
                //dismiss alert dialog whene language selected
                dialogInterface.dismiss();

            }
        });


    }

    private void setLocale(String en) {
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.menu_home){
            Intent myintent = new Intent(Settings.this,Home.class);
            startActivity(myintent);

            return false;
        }
        return super.onOptionsItemSelected(item);




    }
}