package com.jivan.flash_card_endsem_eval;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;


public class Flash_Screen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flash);

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Intent intent = new Intent(Flash_Screen.this, MainActivity.class); // Replace MainActivity with your homepage activity
            startActivity(intent);
            finish();
        }, 2000);
    }
}
