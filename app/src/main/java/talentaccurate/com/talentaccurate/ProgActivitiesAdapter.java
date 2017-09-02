package talentaccurate.com.talentaccurate;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Arrays;

/**
 * Created by Sreejith on 2017-08-29.
 */

public class ProgActivitiesAdapter extends RecyclerView.Adapter<ProgActivitiesAdapter.ViewHolder> {

    private Context context;
private String[] titles = {"GitHub",
        "Linked",
        "Stack Overflow",
        "Bitbucket",
        "Personal Website"};

private String[] links = {"https://github.com/sreejithsnair6699",
        "https://www.linkedin.com/in/sreejithsnair6699/",
        "https://stackoverflow.com/users/8530473/sreejith",
        "https://bitbucket.org/sreejithsnair6699/",
        "https://www.sreejithsnair.com"};

private String[] rateVals = {"4.5",
        "5.5", "8.0",
        "7.0", "5.5"};

private boolean[] flag;

class ViewHolder extends RecyclerView.ViewHolder{

    public TextView progActiTitle;
    public TextView progActiLink;
    public TextView rateVal;
    private LinearLayout lLayout;

    public ViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
        flag = new boolean[getItemCount()];
        Arrays.fill(flag, true);
        progActiTitle = (TextView)itemView.findViewById(R.id.progActiTitle);
        progActiLink = (TextView)itemView.findViewById(R.id.progActiLink);
        rateVal = (TextView)itemView.findViewById(R.id.rateVal);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                int position = getAdapterPosition();
                String link = links[position];
                Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(link));
                context.startActivity(intent);
            }
        });
    }
}

    @Override
    public ProgActivitiesAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.prog_activities_card_layout, viewGroup, false);
        ProgActivitiesAdapter.ViewHolder viewHolder = new ProgActivitiesAdapter.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ProgActivitiesAdapter.ViewHolder viewHolder, int i) {
        viewHolder.progActiTitle.setText(titles[i]);
        viewHolder.progActiLink.setText(links[i]);
        viewHolder.rateVal.setText(rateVals[i]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}