
package com.example.hellotoast;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.graphics.Color;
import android.content.res.ColorStateList;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hellotoast.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private int count = 0;

    public static ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Hello Constraint");

        EdgeToEdge.enable(this);

        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main), (v, insets) -> {

                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars()
                    );

                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );

                    return insets;
                }
        );
    }

    // وظيفة زر Toast
    public void show_toast(View view) {

        Toast.makeText(
                this,
                "Hello Toast",
                Toast.LENGTH_SHORT
        ).show();
    }

    // وظيفة زر Count
    public void increase_count(View view) {

        count++;

        // تحديث العدد المعروض
        mainBinding.textDisplayCount.setText(String.valueOf(count));

        // تغيير لون زر Count حسب العدد
        if (count % 2 != 0) {

            mainBinding.buttonCount.setBackgroundTintList(
                    ColorStateList.valueOf(Color.GREEN)
            );

        } else {

            mainBinding.buttonCount.setBackgroundTintList(
                    ColorStateList.valueOf(Color.BLUE)
            );
        }

        // تفعيل زر Zero وتغيير لونه إلى البرتقالي
        mainBinding.buttonZero.setBackgroundTintList(
                ColorStateList.valueOf(Color.rgb(255, 165, 0))
        );
    }

    // وظيفة زر Zero
    public void show_zero(View view) {

        // إعادة العداد إلى الصفر
        count = 0;

        mainBinding.textDisplayCount.setText("0");

        // إعادة لون زر Zero إلى الرمادي
        mainBinding.buttonZero.setBackgroundTintList(
                ColorStateList.valueOf(Color.GRAY)
        );
    }
}
