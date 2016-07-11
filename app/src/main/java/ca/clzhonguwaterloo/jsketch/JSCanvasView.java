package ca.clzhonguwaterloo.jsketch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Vincent on 7/10/2016.
 */
public class JSCanvasView extends View {
    private JSModel model;
    private  Drawing bufferDrawing;
    private float startX=0;
    private float startY = 0;
    private float endX=0;
    private float endY=0;
    private  Drawing selectedDrawing = null;
    public JSCanvasView(Context context) {
       super(context);
    }

    public JSCanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public JSCanvasView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    public void setModel(JSModel m){

        bufferDrawing=null;

        model=m;

        setController();

    }

    private void setController(){
        this.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                int action = event.getAction();

                if (model != null) {
                    switch (action) {
                        case (MotionEvent.ACTION_DOWN): {

                            startX = event.getX();
                            startY = event.getY();
                            if (model.currentJSTool == JSTool.SELECTOR || model.currentJSTool == JSTool.ERASER
                                    || model.currentJSTool == JSTool.FILL) {

                                selectedDrawing = getDrawingAtLocation(event.getX(), event.getY());

                                if (selectedDrawing != null && model.currentJSTool == JSTool.SELECTOR) {

                                    model.reflectSelected(selectedDrawing);
                                    selectedDrawing.setSelected(true);

                                }
                            }
                            invalidate();
                            break;
                        }
                        case (MotionEvent.ACTION_MOVE): {

                            endX = event.getX();
                            endY = event.getY();
                            if (model.currentJSTool == JSTool.SELECTOR && selectedDrawing != null) {
                                selectedDrawing.translateWidget(endX - startX, endY - startY);
                                startX = event.getX();
                                startY = event.getY();
                            } else if (model.currentJSTool == JSTool.RECTANGLE) {

                                bufferDrawing = new JSRectangle((int) startX, (int) startY, (int) endX, (int) endY, model.CurrentThickness, false,
                                        model.CurrentColor, model.CurrentColor);
                            } else if (model.currentJSTool == JSTool.CIRCLE) {
                                bufferDrawing = new JSCircle((int) startX, (int) startY, (int) endX, (int) endY, model.CurrentThickness, false,
                                        model.CurrentColor, model.CurrentColor);
                            } else if (model.currentJSTool == JSTool.LINE) {
                                bufferDrawing = new JSLine((int) startX, (int) startY, (int) endX, (int) endY, model.CurrentThickness,
                                        model.CurrentColor);
                            }
                            invalidate();
                            break;
                        }
                        case (MotionEvent.ACTION_UP): {
                            endX = event.getX();
                            endY = event.getY();

                            bufferDrawing = null;
                            if (model.currentJSTool == JSTool.RECTANGLE) {

                                model.DrawList.add(new JSRectangle((int) startX, (int) startY, (int) endX, (int) endY, model.CurrentThickness, false,
                                        model.CurrentColor, model.CurrentColor));
                            } else if (model.currentJSTool == JSTool.CIRCLE) {
                                model.DrawList.add(new JSCircle((int) startX, (int) startY, (int) endX, (int) endY, model.CurrentThickness, false,
                                        model.CurrentColor, model.CurrentColor));
                            } else if (model.currentJSTool == JSTool.LINE) {
                                model.DrawList.add(
                                        new JSLine((int) startX, (int) startY, (int) endX, (int) endY, model.CurrentThickness, model.CurrentColor));
                            } else if (selectedDrawing != null) {
                                if (model.currentJSTool == JSTool.ERASER) {
                                    model.DrawList.remove(selectedDrawing);
                                } else if (model.currentJSTool == JSTool.FILL) {
                                    selectedDrawing.setfilledColor(model.CurrentColor);
                                } else if (model.currentJSTool == JSTool.SELECTOR){
                                    selectedDrawing.setSelected(false);
                                }
                            }

                            invalidate();
                            break;
                        }
                    }
                }
                return true;
            }

        });
    }
    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        if (model==null){
            return;
        }
        for (Drawing d : model.DrawList){
            d.draw(canvas);
            int x=model.DrawList.size();



        }
        if (bufferDrawing!=null){
            bufferDrawing.draw(canvas);
        }
    }
    public Drawing getDrawingAtLocation(float x, float y) {
        if (model==null){
            return null;
        }
        for (int i = model.DrawList.size() - 1; i >= 0; --i) {
            if (model.DrawList.get(i).contains(x, y)) {
                return model.DrawList.get(i);
            }
        }
        return null;
    }

}
