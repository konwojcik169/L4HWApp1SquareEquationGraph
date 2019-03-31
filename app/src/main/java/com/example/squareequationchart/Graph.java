package com.example.squareequationchart;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class Graph extends Activity {

    LineGraphSeries<DataPoint> series;
    float a,b,c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        //EditText tv1 = findViewById(R.id.editText);
        a = getIntent().getFloatExtra("a",0);
        b = getIntent().getFloatExtra("b",0);
        c = getIntent().getFloatExtra("c",0);

        double x,y;
        x = -5.0;



        GraphView graph = findViewById(R.id.graph);
        series = new LineGraphSeries<DataPoint>();
        for(int i = 0; i<100; i++) {
            x = x + 0.1;
            y = a*x*x + b*x + c;
            series.appendData(new DataPoint(x,y), true, 100, true);
        }

        graph.addSeries(series);


       /* LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {

                new DataPoint(-2, 0),
                new DataPoint(-1.25, -1.125),
                new DataPoint(-0.5, 0)}
                );
        */
        /*LineGraphSeries series = new LineGraphSeries();
        graph.addSeries(series);

        series.setColor(Color.RED);
        series.setDrawDataPoints(true);
        series.setDataPointsRadius(20);
        series.setThickness(10);
        //series.appendData(new DataPoint(-3.5, 1.5), true, 100, true);
        */

        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(-5);
        graph.getViewport().setMaxX(5);

        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(-7);
        graph.getViewport().setMaxY(7);

    }
}
