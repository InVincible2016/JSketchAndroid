package ca.clzhonguwaterloo.jsketch;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.GridLayout;

import java.util.Observable;
import java.util.Observer;


/**
 * Created by Vincent on 7/10/2016.
 */
public class JSToolbar extends GridLayout implements Observer {

    private JSModel model;
    private JSButton selectorB;
    private JSButton circleB;
    private JSButton fillB;
    private JSButton eraserB;
    private JSButton rectangleB;
    private JSButton lineB;

    private JSButton blueB;
    private JSButton redB;
    private JSButton blackB;
    private JSButton greenB;
    private JSButton yellowB;
    private JSButton orangeB;

    private JSButton Thickness1;
    private JSButton Thickness2;
    private JSButton Thickness3;
    private JSButton Thickness4;
    private JSButton Thickness5;


    public JSToolbar(Context context, JSModel m){
        super(context);

        model=m;
        model.addObserver(this);

        View.inflate(context, R.layout.toolbar_view, this);



        selectorB = (JSButton) findViewById(R.id.slectorIB) ;
        selectorB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                resetToolButtons();
//                selectorB.setState(true);
                model.setTool(JSTool.SELECTOR);
            }
        });

        circleB= (JSButton) findViewById(R.id.circleIB);
        circleB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                resetToolButtons();
//                circleB.setState(true);
                model.setTool(JSTool.CIRCLE);
            }
        });
        fillB= (JSButton) findViewById(R.id.fillIB);
        fillB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                resetToolButtons();
//                fillB.setState(true);
                model.setTool(JSTool.FILL);
            }
        });
        eraserB=(JSButton) findViewById(R.id.eraserIB);
        eraserB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                resetToolButtons();
//                eraserB.setState(true);
                model.setTool(JSTool.ERASER);
            }
        });
        rectangleB=(JSButton) findViewById(R.id.rectangleIB);
        rectangleB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                resetToolButtons();
//                rectangleB.setState(true);
                model.setTool(JSTool.RECTANGLE);
            }
        });


        lineB =(JSButton) findViewById(R.id.lineIB);
        lineB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                resetToolButtons();
//                lineB.setState(true);
                model.setTool(JSTool.LINE);
            }
        });


        blueB =(JSButton) findViewById(R.id.blueIB);
        blueB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                resetColorButtons();
//                blueB.setState(true);
                model.setCurrentColor(Color.BLUE);
            }
        });

        redB =(JSButton) findViewById(R.id.redIB);
        redB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                resetColorButtons();
                model.setCurrentColor(Color.RED);
            }
        });

        blackB =(JSButton) findViewById(R.id.blackIB);
        blackB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                resetColorButtons();
//                blackB.setState(true);
                model.setCurrentColor(Color.BLACK);
            }
        });

        greenB =(JSButton) findViewById(R.id.greenIB);
        greenB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                resetColorButtons();
//                greenB.setState(true);
                model.setCurrentColor(Color.GREEN);
            }
        });

        yellowB =(JSButton) findViewById(R.id.yellowIB);
        yellowB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                resetColorButtons();
//                yellowB.setState(true);
                model.setCurrentColor(Color.YELLOW);
            }
        });

        orangeB =(JSButton) findViewById(R.id.orangeIB);
        orangeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                resetColorButtons();
//                orangeB.setState(true);
                model.setCurrentColor(Color.rgb(255,165,0));
            }
        });



    }

    private void resetToolButtons(){
       selectorB.setState(false);
       circleB.setState(false);
         fillB.setState(false);
       eraserB.setState(false);
      rectangleB.setState(false);
       lineB.setState(false);

    }

    private void resetColorButtons(){
       blueB.setState(false);
       redB.setState(false);
       blackB.setState(false);
       greenB.setState(false);
      yellowB.setState(false);
       orangeB.setState(false);
    }


    @Override
    public void update(Observable observable, Object data) {
        int mc=model.CurrentColor;
        final int orange=Color.rgb(255,165,0);
        JSTool t=model.currentJSTool;
        resetToolButtons();
        resetColorButtons();
        if (mc==Color.BLACK)blackB.setState(true);
        else if (mc==Color.BLUE) blueB.setState(true);
        else if (mc==Color.RED) redB.setState(true);
        else if (mc==Color.GREEN) greenB.setState(true);
        else if (mc== Color.YELLOW) yellowB.setState(true);
        else if (mc==Color.rgb(255,165,0)) orangeB.setState(true);

        if (t==JSTool.CIRCLE) circleB.setState(true);
        else if (t==JSTool.ERASER) eraserB.setState(true);
        else if (t== JSTool.FILL) fillB.setState(true);
        else if (t==JSTool.LINE) lineB.setState(true);
        else if (t==JSTool.RECTANGLE) rectangleB.setState(true);
        else if (t==JSTool.SELECTOR) selectorB.setState(true);
    }
}
