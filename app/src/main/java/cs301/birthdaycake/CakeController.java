package cs301.birthdaycake;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CakeController implements View.OnClickListener,
        CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener {
    private CakeView myCakeView;
    private CakeModel myCakeModel;

    public ArrayList<TextView> textViews;

    public CakeController(CakeView cv) {
        myCakeView = cv;
        myCakeModel = myCakeView.getCakeModel();
    }

    @Override
    public void onClick(View v) {
        Log.d("CakeController", "Click received");

        switch (v.getId()) {
            case R.id.blowOutButton:
                myCakeModel.candlesLit = !myCakeModel.candlesLit;
                Button blowOutButton = (Button) v;

                if (!myCakeModel.candlesLit) {
                    blowOutButton.setText("Re-Light");
                }
                else {
                    blowOutButton.setText("Blow Out");
                }

                break;

            case R.id.goodbyeButton:
                // TextView topTextView = v.findViewById(R.id.topTextView);
                // topTextView.setText("Goodbye.");

                break;
        }

        myCakeView.invalidate();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.candleSwitch:
                myCakeModel.hasCandles = isChecked;
                break;

            case R.id.frostingSwitch:
                myCakeModel.hasFrosting = isChecked;
                break;
        }

        myCakeView.invalidate();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.candleSeekBar:
                myCakeModel.numCandles = progress;
        }

        myCakeView.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // nothing
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // nothing
    }
}
