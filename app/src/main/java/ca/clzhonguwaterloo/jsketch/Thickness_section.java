package ca.clzhonguwaterloo.jsketch;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Vincent on 7/10/2016.
 */
public class Thickness_section extends LinearLayout implements Observer {
    private JSModel model;

    private JSButton Thickness1;
    private JSButton Thickness2;
    private JSButton Thickness3;
    private JSButton Thickness4;
    private JSButton Thickness5;


    public Thickness_section(Context context) {
        super(context);
    }

    public Thickness_section(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Thickness_section(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Thickness_section(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public Thickness_section(Context context, JSModel m){
        super(context);

        model=m;
        model.addObserver(this);

        View.inflate(context, R.layout.thickness_view, this);

        Thickness1 =(JSButton) findViewById(R.id.Thickness1IB);
        Thickness1.setBackgroundColor(Color.BLACK);
        Thickness1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                resetThicknessButtons();
//                Thickness1.setState(true);
                model.setCurrentThick(3);
            }
        });


        Thickness2 =(JSButton) findViewById(R.id.Thickness2IB);
        Thickness2.setBackgroundColor(Color.BLACK);
        Thickness2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                resetThicknessButtons();
//                Thickness2.setState(true);
                model.setCurrentThick(8);
            }
        });
        Thickness3 =(JSButton) findViewById(R.id.Thickness3IB);
        Thickness3.setBackgroundColor(Color.BLACK);
        Thickness3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                resetThicknessButtons();
//                Thickness3.setState(true);
                model.setCurrentThick(13);
            }
        });
        Thickness4 =(JSButton) findViewById(R.id.Thickness4IB);
        Thickness4.setBackgroundColor(Color.BLACK);
        Thickness4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                resetThicknessButtons();
//                Thickness4.setState(true);
                model.setCurrentThick(18);
            }
        });
        Thickness5 =(JSButton) findViewById(R.id.Thickness5IB);
        Thickness5.setBackgroundColor(Color.BLACK);
        Thickness5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                resetThicknessButtons();
//                Thickness5.setState(true);
                model.setCurrentThick(23);
            }
        });





    }
    private void resetThicknessButtons() {
        Thickness1.setState(false);
        Thickness2.setState(false);
        Thickness3.setState(false);
        Thickness4.setState(false);
        Thickness5.setState(false);

    }


        @Override
    public void update(Observable observable, Object data) {
            resetThicknessButtons();
            float tk=model.CurrentThickness;
            if (tk==3) Thickness1.setState(true);
            else if (tk==8) Thickness2.setState(true);
            else if (tk==13) Thickness3.setState(true);
            else if (tk==18) Thickness4.setState(true);
            else if (tk==23) Thickness5.setState(true);
        }
}
