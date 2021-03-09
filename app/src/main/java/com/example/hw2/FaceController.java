//@author Nick Hailer
package com.example.hw2;
//adds libraries for using outside methods
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.SeekBar;
import androidx.appcompat.app.AppCompatActivity;

public class FaceController extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    //allows access of Face objects
    private Face faceObj;
    Object obj = new Object();
    //checks which object is being affected
    boolean hairChecked = false;
    boolean eyesChecked = false;
    boolean skinChecked = false;
    //holds values of colors for hair, eyes, and skin
    int[] colorValues = {0,0,0,0,0,0,0,0,0};
    //constructor
    public FaceController(Face faceView) {
        this.faceObj = faceView;
    }
    //sees what is selected in spinner
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        obj = parent.getItemAtPosition(pos);
    }
    //empty method needed for AdapterView interface
    public void onNothingSelected(AdapterView<?> parent) {

    }
    //method for when user changes value on a seekbar
    public void onProgressChanged (SeekBar seekBar, int progress, boolean fromUser) {
        //changes color of hair when corresponding seekbar is changed
        if(hairChecked) {
            Log.d("FaceController","hair seekbar progress changed");
            switch(seekBar.getId()) {
                case R.id.redValue:
                    colorValues[0] = progress;
                    faceObj.hairColorR = colorValues[0];
                    break;

                case R.id.greenValue:
                    colorValues[1] = progress;
                    faceObj.hairColorG = colorValues[1];
                    break;

                case R.id.blueValue:
                    colorValues[2] = progress;
                    faceObj.hairColorB = colorValues[2];
                    break;
            }
            //updates face
            faceObj.invalidate();
        }
        //changes color of eyes when corresponding seekbar is changed
        if(eyesChecked) {
            Log.d("FaceController","eyes seekbar progress changed");
            switch(seekBar.getId()) {
                case R.id.redValue:
                    colorValues[3] = progress;
                    faceObj.eyeColorR = colorValues[3];
                    break;

                case R.id.greenValue:
                    colorValues[4] = progress;
                    faceObj.eyeColorG = colorValues[4];
                    break;

                case R.id.blueValue:
                    colorValues[5] = progress;
                    faceObj.eyeColorB = colorValues[5];
                    break;
            }
            faceObj.invalidate();
        }
        //changes color of skin when corresponding seekbar is changed
        if(skinChecked) {
            Log.d("FaceController","skin seekbar progress changed");
            switch(seekBar.getId()) {
                case R.id.redValue:
                    colorValues[6] = progress;
                    faceObj.skinColorR = colorValues[6];
                    break;

                case R.id.greenValue:
                    colorValues[7] = progress;
                    faceObj.skinColorG = colorValues[7];
                    break;

                case R.id.blueValue:
                    colorValues[8] = progress;
                    faceObj.skinColorB = colorValues[8];
                    break;
            }
            faceObj.invalidate();
        }
    }
    //empty method needed with OnSeekBarChangeListener interface
    public void onStartTrackingTouch (SeekBar seekBar){

    }
    //empty method needed with OnSeekBarChangeListener interface
    public void onStopTrackingTouch (SeekBar seekBar){

    }
    //method for when radio button is tapped on
    public void onClick(View v) {
        //variable that sees which radio button is checked
        boolean checked = ((RadioButton) v).isChecked();
        Log.d("onClick", "Radio Button Clicked");
        //tells program which radio button is tapped and which ones aren't
        switch(v.getId()) {
            case R.id.hairRadio:
                if (checked) {

                    hairChecked = true;
                    eyesChecked = false;
                    skinChecked = false;
                    break;
                }
            case R.id.eyesRadio:
                if (checked) {
                    eyesChecked = true;
                    hairChecked = false;
                    skinChecked = false;
                }

                    break;
            case R.id.skinRadio:
                if (checked)
                    skinChecked = true;
                    eyesChecked = false;
                    hairChecked = false;
                    break;
        }
    }
}
