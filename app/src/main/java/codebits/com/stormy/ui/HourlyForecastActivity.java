package codebits.com.stormy.ui;

import android.content.Intent;
import android.os.Parcelable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import codebits.com.stormy.R;
import codebits.com.stormy.adapter.HourAdapter;
import codebits.com.stormy.weather.Hour;

public class HourlyForecastActivity extends AppCompatActivity {

    //get recyclerview from the layout using Butterknife
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;


    private Hour[] hours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hourly_forecast);
        ButterKnife.bind(this);

        Intent intent = getIntent();

        Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.HOURLY_FORECAST);
        hours = Arrays.copyOf(parcelables, parcelables.length, Hour[].class);

        HourAdapter hourAdapter = new HourAdapter(this,hours);
        mRecyclerView.setAdapter(hourAdapter);

       RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
       mRecyclerView.setLayoutManager(layoutManager);

       //when list of data has fixed size like our hourly data

        mRecyclerView.setHasFixedSize(true);
//
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL) {
//            @Override
//            public void onDraw(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
//                // Do not draw the divider
//            }
//        });
    }


}
