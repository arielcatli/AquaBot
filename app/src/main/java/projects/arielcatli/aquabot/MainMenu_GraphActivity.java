package projects.arielcatli.aquabot;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;


import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainMenu_GraphActivity extends AppCompatActivity {


    private LineChart mMain_chart;
    private CheckBox cBox_temp;
    private CheckBox cBox_pH;
    private CheckBox cBox_sal;
    List<ILineDataSet> dataSets;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graph_layout);

        //These are user defined functions
        assignWidgets();

        customizeChart();

        //List<Entry> data = new ArrayList<>();

        dataSets = new ArrayList<>();


        LineDataSet temperature = newSampleDataSet("Temperature", R.color.red);
        LineDataSet pH = newSampleDataSet("pH", R.color.orange);
        LineDataSet salinity = newSampleDataSet("Salinity", R.color.blue);

        dataSets.add(temperature);
        dataSets.add(pH);
        dataSets.add(salinity);

        LineData d = new LineData(dataSets);

        mMain_chart.setData(d);
        mMain_chart.invalidate();

        setCheckedDataListener(cBox_temp, d, 0);
        setCheckedDataListener(cBox_pH, d, 1);
        setCheckedDataListener(cBox_sal, d, 2);



    }

    private void customizeChart()
    {
        mMain_chart.getXAxis().setDrawGridLines(false);
        mMain_chart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        mMain_chart.getXAxis().setDrawLabels(false);
        mMain_chart.getAxisRight().setDrawGridLines(false);
        mMain_chart.getAxisRight().setEnabled(false);
        mMain_chart.getAxisRight().setDrawGridLines(false);
        mMain_chart.getAxisLeft().setDrawGridLines(false);
        mMain_chart.getDescription().setEnabled(false);
        mMain_chart.getLegend().setPosition(Legend.LegendPosition.ABOVE_CHART_CENTER);
        mMain_chart.invalidate();
        cBox_pH.setChecked(true);
        cBox_temp.setChecked(true);
        cBox_sal.setChecked(true);
        mMain_chart.zoom(10f, 1, 0,0);

    }

    private LineDataSet newSampleDataSet(String dataLabel, int color)
    {
        color = getColorFromId(color);
        List<Entry> dataPoints = new ArrayList<>();

        Random r = new Random();
        float u = r.nextFloat();
        for(int x=0; x<100; x++)
        {
            dataPoints.add(new Entry(x, r.nextFloat()));
        }


        LineDataSet dataSet = new LineDataSet(dataPoints, dataLabel);
        dataSet.setColor(color);
        dataSet.setFillColor(color);
        dataSet.setValueTextColor(color);
        dataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        dataSet.setDrawCircles(false);





        return dataSet;
    }

    //to remove the complexity of using the ContextCompat.getColor() again
    private int getColorFromId(int resourceId)
    {
        return ContextCompat.getColor(this, resourceId);
    }

    private void assignWidgets()
    {
        mMain_chart = (LineChart) findViewById(R.id.graph_main_chart);
        cBox_temp = (CheckBox) findViewById(R.id.cbox_temp);
        cBox_pH = (CheckBox) findViewById(R.id.cbox_pH);
        cBox_sal = (CheckBox) findViewById(R.id.cbox_sal);
    }

    private void setCheckedDataListener(CheckBox cbox, final LineData data, final int data_index)
    {
        cbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked)
                    mMain_chart.getData().getDataSetByIndex(data_index).setVisible(true);
                else
                    mMain_chart.getData().getDataSetByIndex(data_index).setVisible(false);

                data.notifyDataChanged();
                mMain_chart.notifyDataSetChanged();
                mMain_chart.invalidate();
            }
        });
    }

}
