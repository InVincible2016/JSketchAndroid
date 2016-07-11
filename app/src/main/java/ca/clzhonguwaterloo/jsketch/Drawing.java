package ca.clzhonguwaterloo.jsketch;

import android.graphics.Canvas;
/**
 * Created by Vincent on 7/9/2016.
 */
public interface Drawing {
    public void translateWidget(float deltaX, float deltaY);
    public boolean contains(float x, float y);
    public void draw(Canvas canvas);
    public void setBorderColor(int newC);
    public void setfilledColor(int newC);
    public void setThickness(float i );
    public int getBorderColor();
    public int getfilledColor();
    public float getThickness();
    public void setSelected(boolean status);
}
