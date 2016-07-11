package ca.clzhonguwaterloo.jsketch;

import android.graphics.*;
import android.graphics.Canvas;

/**
 * Created by Vincent on 7/10/2016.
 */
public class JSCircle implements Drawing {
    int x1,y1,x2,y2;
    float thickness;
    boolean filled;
    boolean selected;
    int bordercolor;
    int filledcolor;

    public JSCircle (int x1,int y1,int x2,int y2,float thickness,boolean filled, int BC,int FC){
        this.x1=Math.min(x1,x2);
        this.x2=Math.max(x1, x2);
        this.y1=Math.min(y1, y2);
        this.y2=Math.max(y1, y2);
        this.thickness=thickness;
        this.filled=filled;
        this.bordercolor=BC;
        this.filledcolor=FC;
        this.selected=false;
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
        double Radius_X=(x2-x1)/2;
        double Radius_Y=(y2-y1)/2;
        double Center_X=x1+Radius_X;
        double Center_Y=y1+Radius_Y;
        double Nor_X=x-Center_X;
        double Nor_Y= y-Center_Y;
        return ((double)((Nor_X * Nor_X) / (Radius_X * Radius_X))) + (((double)(Nor_Y * Nor_Y) / (Radius_Y * Radius_Y)))<= 1.0;
    }


    @Override
    public void draw(Canvas canvas) {
        Paint paint=new Paint();
        int Rx=Math.abs(x1-x2);
        int Ry=Math.abs(y1-y2);
        if (selected){
            paint.setColor(Color.rgb(255,217,204));
            paint.setStyle(Paint.Style.FILL);
            canvas.drawOval(x1,y1,x2,y2,paint);
            return;
        }
        if (this.filled){
            paint.setColor(this.filledcolor);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawOval(x1,y1,x2,y2,paint);
        }
        paint.setColor(this.bordercolor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.thickness);
        canvas.drawOval(x1,y1,x2,y2,paint);
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