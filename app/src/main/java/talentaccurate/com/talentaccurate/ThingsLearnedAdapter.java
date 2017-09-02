package talentaccurate.com.talentaccurate;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Sreejith on 2017-08-29.
 */

public class ThingsLearnedAdapter extends RecyclerView.Adapter<ThingsLearnedAdapter.ViewHolder> {

    private String[] matter = {
            "Building Apps with Graphics & Animation",

            "Building Apps with Content Sharing in Android",

            "Save selections and alpha channel masks using Photoshop",

            "Web development using .Net",

            "Game Development using Unreal Engine 4"};

    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView thingsLearned;

        public ViewHolder(View itemView) {
            super(itemView);
            thingsLearned = (TextView)itemView.findViewById(R.id.content);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    int position = getAdapterPosition();
                }
            });
        }
    }

    @Override
    public ThingsLearnedAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.things_learned_card_layout, viewGroup, false);
        ThingsLearnedAdapter.ViewHolder viewHolder = new ThingsLearnedAdapter.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ThingsLearnedAdapter.ViewHolder viewHolder, int i) {
        viewHolder.thingsLearned.setText(matter[i]);
    }

    @Override
    public int getItemCount() {
        return matter.length;
    }
}