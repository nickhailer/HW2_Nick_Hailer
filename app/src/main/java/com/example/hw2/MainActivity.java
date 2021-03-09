//@author Nick Hailer
package com.example.hw2;
//adds libraries for using outside methods
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //creates objects to access other classes
        Face faceView = findViewById(R.id.face);
        FaceController faceController = new FaceController(faceView);
        //accesses spinner and helps set values for it
        Spinner spinner = (Spinner) findViewById(R.id.hairStyle);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.type_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(faceController);
        //radio button objects that connects to radio buttons
        RadioButton radioButton1 = (RadioButton) findViewById(R.id.hairRadio);
        radioButton1.setOnClickListener(faceController);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.eyesRadio);
        radioButton2.setOnClickListener(faceController);
        RadioButton radioButton3 = (RadioButton) findViewById(R.id.skinRadio);
        radioButton3.setOnClickListener(faceController);
        //connects seekbar objects to seekbars
        SeekBar seekBar1 = findViewById(R.id.redValue);
        SeekBar seekBar2 = findViewById(R.id.greenValue);
        SeekBar seekBar3 = findViewById(R.id.blueValue);
        //connects seekbars to code in FaceController class
        seekBar1.setOnSeekBarChangeListener(faceController);
        seekBar2.setOnSeekBarChangeListener(faceController);
        seekBar3.setOnSeekBarChangeListener(faceController);
        //supposed to change seekbar values to color when certain radio button is tapped
        if(faceController.hairChecked) {
            seekBar1.setProgress(faceController.colorValues[0]);
            seekBar2.setProgress(faceController.colorValues[1]);
            seekBar3.setProgress(faceController.colorValues[2]);
        }
        if(faceController.eyesChecked) {
            seekBar1.setProgress(faceController.colorValues[3]);
            seekBar2.setProgress(faceController.colorValues[4]);
            seekBar3.setProgress(faceController.colorValues[5]);
        }
        if(faceController.skinChecked) {
            seekBar1.setProgress(faceController.colorValues[6]);
            seekBar2.setProgress(faceController.colorValues[7]);
            seekBar3.setProgress(faceController.colorValues[8]);
        }


    }
}