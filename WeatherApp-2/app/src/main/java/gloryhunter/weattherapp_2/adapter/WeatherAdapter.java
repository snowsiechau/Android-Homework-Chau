package gloryhunter.weattherapp_2.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import gloryhunter.weattherapp_2.R;
import gloryhunter.weattherapp_2.database.WeatherModel;

/**
 * Created by SNOW on 10/16/2017.
 */

public class WeatherAdapter  extends RecyclerView.Adapter<WeatherAdapter.WeatherHolder>{
    private List<WeatherModel> weatherModels;

    public WeatherAdapter(List<WeatherModel> weatherModels) {
        this.weatherModels = weatherModels;
    }

    @Override
    public WeatherHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_weather, parent, false);

        return new WeatherHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WeatherHolder holder, int position) {
        holder.setData(weatherModels.get(position));
    }

    @Override
    public int getItemCount() {
        return weatherModels.size();
    }

    class WeatherHolder extends RecyclerView.ViewHolder{
        private TextView tvDate;
        private ImageView ivMain;
        private TextView tvTempHum;

        public WeatherHolder(View itemView) {
            super(itemView);

            tvDate = itemView.findViewById(R.id.tv_date);
            ivMain = itemView.findViewById(R.id.iv_main);
            tvTempHum = itemView.findViewById(R.id.tv_temp_hum);
        }

        public void setData(WeatherModel weatherModel){
            tvDate.setText(weatherModel.getDate());
            tvTempHum.setText(weatherModel.getTemp() + " 'C" + " "
                    + weatherModel.getHum() + " %");
            ivMain.setImageResource(weatherModel.getImageID());
        }
    }
}
