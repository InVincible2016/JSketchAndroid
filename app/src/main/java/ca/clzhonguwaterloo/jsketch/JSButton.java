package ca.clzhonguwaterloo.jsketch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageButton;

/**
 * Created by Vincent on 7/10/2016.
 */
public class JSButton extends ImageButton {
   private boolean checked =false;

    public JSButton(Context context) {
        super(context);
    }

    public JSButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public JSButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public JSButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.checked) {
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(Color.rgb(204, 102, 255));
            paint.setStrokeWidth(10);
            canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), paint);
        }
    }
    public void setState(boolean c){
        checked=c;
        this.invalidate();
    }
}
