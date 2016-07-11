package ca.clzhonguwaterloo.jsketch;

import android.graphics.*;
import android.graphics.Canvas;

/**
 * Created by Vincent on 7/10/2016.
 */
public class JSRectangle implements Drawing {
    int x1;
    int y1;
    int x2;
    int y2;
    float thickness;
    boolean filled;
    boolean selected;
    int bordercolor;
    int filledcolor;


    public JSRectangle(int x1,int y1,int x2,int y2,float thickness,boolean filled, int BC,int FC){
        this.x1=Math.min(x1,x2);
        this.x2=Math.max(x1, x2);
        this.y1=Math.min(y1, y2);
        this.y2=Math.max(y1, y2);
        this.thickness=thickness;
        this.filled=filled;
        this.bordercolor=BC;
        this.filledcolor=FC;
        selected=false;
    }


    @Override
    public void translateWidget(float deltaX, float deltaY) {
        this.x1+=deltaX;
        this.y1+=deltaY;
        this.x2+=deltaX;
        this.y2+=deltaY;
    }

    @Override
    public boolean contains(float x, float y) {
        return  ((x>this.x1) && (x<this.x2) && (y>this.y1) && (y<(this.y2)));
    }


    @Override
    public void draw(Canvas canvas) {

        Paint paint=new Paint();

        if (selected){
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.rgb(255, 217, 204));
            canvas.drawRect(x1,y1,x2,y2,paint);
            return;
        }
        if (filled){
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(this.filledcolor);
            canvas.drawRect(x1, y1, x2, y2, paint);
        }

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.thickness);
        paint.setColor(this.bordercolor);
        canvas.drawRect(x1,y1,x2,y2,paint);
    }

    @Override
    public void setBorderColor(int newC) {

        bordercolor=newC;
    }

    @Override
    public int getBorderColor() {

        return this.bordercolor;
    }

    @Override
    public int getfilledColor() {

        return this.filledcolor;
    }

    @Override
    public void setfilledColor(int newC) {
        this.filled=true;
        this.filledcolor=newC;

    }

    @Override
    public void setThickness(float i) {
        this.thickness=i;

    }

    @Override
    public float getThickness() {
        return this.thickness;
    }

    @Override
    public void setSelected(boolean status) {
        selected=status;
    }

}