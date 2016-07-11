package ca.clzhonguwaterloo.jsketch;
import android.graphics.Color;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class JSModel extends Observable {
    public JSTool currentJSTool;
    public float CurrentThickness;
    public int CurrentColor;
    public int CanvosBGC;


    public ArrayList<Drawing> DrawList = new ArrayList<Drawing>();

    public JSModel() {
        this.CurrentColor=Color.BLACK;
        this.currentJSTool = JSTool.SELECTOR;
        this.CanvosBGC= Color.WHITE;
        this.CurrentThickness = 3;

    }

    public void setCanvosBGC(int c) {
        CanvosBGC = c;
        this.setChanged();
        super.notifyObservers();
    }

    public void setCurrentColor(int NewColor) {
        this.CurrentColor=NewColor;
        this.setChanged();
        super.notifyObservers();
    }

    public void setTool(JSTool newJSTool) {
        this.currentJSTool = newJSTool;
        this.setChanged();
        super.notifyObservers();
    }

    public void setCurrentThick(float NewThickness) {
        this.CurrentThickness = NewThickness;
        this.setChanged();
        super.notifyObservers();
    }

    public void setDrawList(ArrayList<Drawing> dlist){
        this.DrawList=dlist;
    }


    public void addDrawing(Drawing d) {
        this.DrawList.add(d);
        this.setChanged();
        super.notifyObservers();
    }

    public void reflectSelected(Drawing d){

        this.setCurrentThick(d.getThickness());
        this.setCurrentColor(d.getBorderColor());
    }


    public ArrayList<Drawing> getDrawList(){
        return DrawList;
    }

    @Override
    protected void setChanged() {
        super.setChanged();
    }


    @Override
    public void addObserver(Observer observer) {
        super.addObserver(observer);
    }

    @Override
    public synchronized void deleteObservers() {
        super.deleteObservers();
    }

    @Override
    public void notifyObservers() {
        super.notifyObservers();
    }
}