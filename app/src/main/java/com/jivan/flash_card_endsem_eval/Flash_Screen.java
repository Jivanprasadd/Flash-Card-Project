package com.jivan.flash_card_endsem_eval;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class Flash_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flash); // This is your splash screen layout

        // Delay for 2 seconds, then move to MainActivity
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(Flash_Screen.this, MainActivity.class);
            startActivity(intent);
            finish(); // Close the splash screen activity
        }, 2000);
    }
}
