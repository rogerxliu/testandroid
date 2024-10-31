package com.example.popupmenudemo;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textView = findViewById(R.id.textView);
        registerForContextMenu(textView);


        button = findViewById(R.id.btnClick);
        button.setOnClickListener(v -> {
            PopupMenu popup = new PopupMenu(MainActivity.this, button);
            popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
            popup.setOnMenuItemClickListener(item -> {
                String s = item.getTitle().toString();
                switch (s) {
                    case "Java":
                        Toast.makeText(MainActivity.this, "Menu 1", Toast.LENGTH_SHORT).show();
                        return true;
                    case "Kotlin":
                        Toast.makeText(MainActivity.this, "Menu 2", Toast.LENGTH_SHORT).show();
                        return true;
                    case "Android":
                        Toast.makeText(MainActivity.this, "Menu 3", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return false;
                }
            });

            popup.show();
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        // you can set menu header with title icon etc
        menu.setHeaderTitle("Choose a color");
        // add menu items
        menu.add(0, v.getId(), 0, "Yellow");
        menu.add(0, v.getId(), 0, "Gray");
        menu.add(0, v.getId(), 0, "Cyan");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle() == "Yellow") {
            Toast.makeText(this, "Yellow", Toast.LENGTH_SHORT).show();
        } else if (item.getTitle() == "Gray") {
            Toast.makeText(this, "Yellow", Toast.LENGTH_SHORT).show();
        } else if (item.getTitle() == "Cyan") {
            Toast.makeText(this, "Yellow", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}