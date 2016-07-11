package ca.clzhonguwaterloo.jsketch;

import android.graphics.*;
import android.graphics.Canvas;


/**
 * Created by Vincent on 7/10/2016.
 */
public class JSLine implements Drawing {
    int x1;
    int y1;
    int x2;
    int y2;
    float thickness;
    int JS_color;
    boolean selected;



    public JSLine(int x1,int y1,int x2,int y2,float thickness, int C){
        this.x1=x1;
        this.x2=x2;
        this.y1=y1;
        this.y2=y2;
        this.thickness=thickness;
        this.JS_color=C;
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
        double d1 = (Math.abs((((x-x1)*(y2-y1)) - ((y-y1)*(x2-x1))))/(Math.sqrt(((x2 - x1)*(x2-x1)) + ((y2 - y1)*(y2-y1)))));

        return d1 <=thickness;
    }

    @Override
    public void draw(Canvas canvas) {
//        Graphics2D g2 = (Graphics2D) gc;
//        g2.setColor(Color.BLACK);
//        g2.setColor(this.JS_color);
//        g2.setStroke(new BasicStroke(thickness));
//        g2.drawLine(x1, y1, x2, y2);
        Paint paint =new Paint();
        paint.setColor(JS_color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(thickness);
        if (selected){
            paint.setColor(Color.rgb(255,217,204));

        }
        canvas.drawLine(x1,y1,x2,y2,paint);

    }

    @Override
    public void setBorderColor(int newC) {
        JS_color=newC;
    }

    @Override
    public int getBorderColor() {
        return this.JS_color;
    }

    @Override
    public int getfilledColor() {
        return this.JS_color;
    }

    @Override
    public void setfilledColor(int newC) {
        this.JS_color=newC;

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
