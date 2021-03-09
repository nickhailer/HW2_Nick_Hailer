//@author Nick Hailer
package com.example.hw2;
//adds libraries for using outside methods
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;
import java.util.Random;

public class Face extends SurfaceView {
    //creates objects for painting parts of the face
    Paint facePaint = new Paint();
    Paint eyePaint = new Paint();
    Paint pupilPaint = new Paint();
    Paint irisPaint = new Paint();
    Paint mouthPaint = new Paint();
    Paint hairPaint = new Paint();
    //variables for setting colors and styles of face objects
    int skinColorR;
    int skinColorG;
    int skinColorB;
    int eyeColorR;
    int eyeColorG;
    int eyeColorB;
    int hairColorR;
    int hairColorG;
    int hairColorB;
    int hairStyle;
    //object for setting random values
    Random rand = new Random();
    //constuctor for face
    public Face(Context context, AttributeSet attrs) {
        super(context, attrs);
        //sets default style and color for painted objects
        facePaint.setStyle(Paint.Style.FILL);
        eyePaint.setColor(0xFFFFFFFF);
        eyePaint.setStyle(Paint.Style.FILL);
        pupilPaint.setColor(0xFF000000);
        pupilPaint.setStyle(Paint.Style.FILL);
        irisPaint.setStyle(Paint.Style.FILL);
        mouthPaint.setColor(0xFFFF0000);
        mouthPaint.setStyle(Paint.Style.FILL);
        hairPaint.setStyle(Paint.Style.FILL);
        setBackgroundColor(Color.WHITE);
    }
    //method that randomly selects values for style and color
    public void randomize(){
        skinColorR = rand.nextInt(255);
        skinColorG = rand.nextInt(255);
        skinColorB = rand.nextInt(255);

        eyeColorR = rand.nextInt(255);
        eyeColorG = rand.nextInt(255);
        eyeColorB = rand.nextInt(255);

        hairColorR = rand.nextInt(255);
        hairColorG = rand.nextInt(255);
        hairColorB = rand.nextInt(255);

        hairStyle =rand.nextInt(3);
    }
    //draws head
    @Override
    public void onDraw(Canvas canvas){
        randomize();
        facePaint.setARGB(255,skinColorR,skinColorG,skinColorB);
        drawHeadShape(canvas);
        irisPaint.setARGB(255,eyeColorR,eyeColorG,eyeColorB);
        drawFace(canvas);
        hairPaint.setARGB(255,hairColorR,hairColorG,hairColorB);
        drawHair(canvas);


    }
    //draws objects on face
    public void drawFace(Canvas canvas) {
        //draw eye outline
        canvas.drawOval(875,150,975,250, eyePaint);
        canvas.drawOval(1025,150,1125,250,eyePaint);
        //draw iris
        canvas.drawOval(900,175,950,225, irisPaint);
        canvas.drawOval(1050,175,1100,225,irisPaint);
        //draw pupil
        canvas.drawOval(910,185,940,215, pupilPaint);
        canvas.drawOval(1060,185,1090,215,pupilPaint);
        //draw mouth
        canvas.drawOval(925,300,1075,400,mouthPaint);
    }
    //draws shape of the head
    public void drawHeadShape(Canvas canvas) {
        canvas.drawOval(800,50,1200,500, facePaint);
        canvas.drawOval(700,150,850,400,facePaint);
        canvas.drawOval(1150,150,1300,400,facePaint);
    }
    //draws hair
    public void drawHair(Canvas canvas) {
        canvas.drawOval(850,0,1150,100,hairPaint);
    }
}