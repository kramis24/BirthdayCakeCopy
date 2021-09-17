package cs301.birthdaycake;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        CakeView cakeView = findViewById(R.id.cakeview);
        CakeController controller = new CakeController(cakeView);

        Button blowOutButton = findViewById(R.id.blowOutButton);
        blowOutButton.setOnClickListener(controller);

        Button goodbyeButton = findViewById((R.id.goodbyeButton));
        goodbyeButton.setOnClickListener(controller);

        Switch candleSwitch = findViewById(R.id.candleSwitch);
        candleSwitch.setOnCheckedChangeListener(controller);

        Switch frostingSwitch = findViewById(R.id.frostingSwitch);
        frostingSwitch.setOnCheckedChangeListener(controller);

        SeekBar candleSeekBar = findViewById(R.id.candleSeekBar);
        candleSeekBar.setOnSeekBarChangeListener(controller);

        // TextView topTextView = findViewById(R.id.topTextView);
        // controller.textViews.add(topTextView);
    }

    public void goodbye(View button) {
        System.out.println("Goodbye");
    }
}
