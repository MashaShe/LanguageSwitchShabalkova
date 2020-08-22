package com.example.languageswitch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    String selectedItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button ok = findViewById(R.id.button_ok);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.lang_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent,
//                                       View itemSelected, int selectedItemPosition, long selectedId) {
//                String[] choose = getResources().getStringArray(R.array.lang_array);
//                selectedItem = choose[selectedItemPosition];
//            }
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });


    ok.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String item = spinner.getSelectedItem().toString();
            String lang ="ru";
            if (item.equals("Русский") || item.equals("Russian")) {
                lang = "ru";
            }
            if (item.equals("Английский") || item.equals("English")) {
                lang = "en";
            }

            Locale locale = new Locale(lang);
            Configuration config = new Configuration();
            config.setLocale(locale);
            getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
            recreate();
        }
    });

    }
}


