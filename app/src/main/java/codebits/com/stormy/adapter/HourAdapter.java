package codebits.com.stormy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import codebits.com.stormy.R;
import codebits.com.stormy.weather.Hour;

/**
 * Created by Tjah on 12/06/2017.
 */

public class HourAdapter extends RecyclerView.Adapter<HourAdapter.HourViewHolder> {

    //methods and constructor needed for the RecyclerView Adapter
    private Hour[] hours;
    private Context context;

    public HourAdapter(Context context, Hour[] hours) {
        this.hours = hours;
        this.context = context;
    }

    public HourViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hourly_list_item, parent, false);
        HourViewHolder viewHolder = new HourViewHolder(view);
        return viewHolder;
    }


    public void onBindViewHolder(HourViewHolder holder, int position) {
        holder.bindHour(hours[position]);
    }

    public int getItemCount() {
        return hours.length;
    }

    //set and get
    public class HourViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView timeLabel;
        public TextView summaryLabel;
        public TextView temperatureLabel;
        public ImageView iconImageView;

        public HourViewHolder(View itemView) {
            super(itemView);

            timeLabel =  itemView.findViewById(R.id.timeLabel);
            summaryLabel =  itemView.findViewById(R.id.summaryLabel);
            temperatureLabel = itemView.findViewById(R.id.temperatureLabel);
            iconImageView = itemView.findViewById(R.id.iconImageView);

            itemView.setOnClickListener(this);

        }

        public void bindHour(Hour hour) {
            timeLabel.setText(hour.getHour() + "");
            summaryLabel.setText(hour.getSummary());
            temperatureLabel.setText(hour.getTemperature()+ "");
            iconImageView.setImageResource(hour.getIconId());

        }

        @Override
        public void onClick(View v) {
            String time = timeLabel.getText().toString();
            String temperature = temperatureLabel.getText().toString();
            String summary = summaryLabel.getText().toString();
            String message = String.format("At %s it will be %s and %s",
                   time,
                   temperature,
                   summary);
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        }
    }

}
