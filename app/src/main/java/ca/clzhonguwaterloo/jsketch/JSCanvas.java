package ca.clzhonguwaterloo.jsketch;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Vincent on 7/10/2016.
 */
public class JSCanvas extends LinearLayout implements Observer {
    private JSModel model;
    private JSCanvasView jsCanvasView;

    public JSCanvas (Context context, JSModel m){
        super(context);
        View.inflate(context,R.layout.canvas_view,this);

        model=m;
        model.addObserver(this);

        jsCanvasView = (JSCanvasView) findViewById(R.id.canvas);

        jsCanvasView.setModel(m);
    }

    public void update(Observable observable, Object data) {
        jsCanvasView.invalidate();
    }
}
