package talentaccurate.com.talentaccurate;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Arrays;

/**
 * Created by Sreejith on 2017-08-28.
 */

public class ProgExpAdapter extends RecyclerView.Adapter<ProgExpAdapter.ViewHolder> {

    private String[] titles = {"Java",
            "C# .Net",
            "Photoshop",
            "HTML 5"};

    private String[] expVals = {"1 Yr 4 Months",
            "2 Yrs 3 Months", "2 Yrs 9 Months",
            "3 Yrs 10 Months"};

    private String[] verVals = {"1.2.5",
            "16.4.12", "5.16.8",
            "14.16.8"};

    private String[] selfRateVals = {"5.0",
            "6.0", "10.0",
            "8.0"};

    private String[] expRateVals = {"4.5",
            "5.5", "8.0",
            "7.0"};

    private boolean[] flag;

    class ViewHolder extends RecyclerView.ViewHolder{

        public int currentItem = 0;
        public TextView progExpTitle;
        public TextView expVal;
        public TextView verVal;
        public TextView selfRate;
        public TextView expRate;
        private LinearLayout lLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            flag = new boolean[getItemCount()];
            Arrays.fill(flag, true);
            progExpTitle = (TextView)itemView.findViewById(R.id.progExpTitle);
            expVal = (TextView)itemView.findViewById(R.id.expVal);
            verVal = (TextView)itemView.findViewById(R.id.verVal);
            selfRate = (TextView)itemView.findViewById(R.id.selfRateVal);
            expRate = (TextView)itemView.findViewById(R.id.expRateVal);
            lLayout = (LinearLayout)itemView.findViewById(R.id.segmentRatings);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(flag[position]){
                        lLayout.setVisibility(View.VISIBLE);
                        flag[position]=!flag[position];
                    }
                    else{
                        lLayout.setVisibility(View.GONE);
                        flag[position]=!flag[position];
                    }

                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.prog_exp_card_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.progExpTitle.setText(titles[i]);
        viewHolder.expVal.setText(expVals[i]);
        viewHolder.verVal.setText(verVals[i]);
        viewHolder.selfRate.setText(selfRateVals[i]);
        viewHolder.expRate.setText(expRateVals[i]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
