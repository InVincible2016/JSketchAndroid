package ca.clzhonguwaterloo.jsketch;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import java.util.ArrayList;

public class JSketch extends Activity {
    JSModel model;
    JSCanvas canvas;
    JSToolbar jsToolbar;
    Thickness_section thickness_section;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_jsketch);
        model=new JSModel();

    }
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        canvas=new JSCanvas(this,model);
        ViewGroup canvas_view=(ViewGroup) findViewById (R.id.canvas_activity);
        canvas_view.addView(canvas);


        jsToolbar=new JSToolbar(this,model);
        thickness_section=new Thickness_section(this,model);
        ViewGroup toolbar_groupd= (ViewGroup) findViewById(R.id.Toolbar_activity);
        toolbar_groupd.addView(jsToolbar);
        toolbar_groupd.addView(thickness_section);


        model.setChanged();
        model.notifyObservers();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable("DrawList", model.getDrawList());
        outState.putSerializable("Tool", model.currentJSTool);
        outState.putFloat("Thickness", model.CurrentThickness);
        outState.putInt("Color",model.CurrentColor);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        model.setDrawList((ArrayList<Drawing>) savedInstanceState.getSerializable("DrawList"));
        model.setTool((JSTool) savedInstanceState.getSerializable("Tool"));
        model.setCurrentColor(savedInstanceState.getInt("Color"));
        model.setCurrentThick(savedInstanceState.getFloat("Thickness"));
    }

}
