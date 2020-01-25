package com.example.dice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final Random RANDOM = new Random();
    public static int randomDiceValue() {
        return RANDOM.nextInt(6) + 1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button rollDice = findViewById(R.id.rollDice);
        final ImageView dice = findViewById(R.id.dice);

        rollDice.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.effect);

                        final Animation.AnimationListener animationListener = new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {
                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                int value = randomDiceValue();
                                int res = getResources().getIdentifier("dice" + value, "drawable", "com.example.dice");
                                dice.setImageResource(res);
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {
                            }
                        };

                        anim.setAnimationListener(animationListener);
                        dice.startAnimation(anim);
                    }
                }
        );
    }
}
