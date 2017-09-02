package talentaccurate.com.talentaccurate;

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

public class SecretAdmirersAdapter extends RecyclerView.Adapter<SecretAdmirersAdapter.ViewHolder> {

    private boolean[] flag;
    private String[] matter = {
            "\"Work joyfully and peacefully, knowing that right thoughts and right efforts will inevitably bring about right results.\"",

            "\"If you put all your strength and faith and vigor into a job and try to do the best you can, the money will come.\"",

            "\"Your purpose in relationships is simply to be your best self, regardless of the circumstances.\"",

            "\"All motivation is self-motivation. Your family, your boss, or your co-workers can try to get your engine going, but until you decide what to accomplish, nothing will happen.\""};

    private String[] hints = {"Your Bestie.", "We have been working together for years now.",
                                "Cousin", "You used to call me BOSS!"};

    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView AdmirerMessages;
        public TextView hint;
        private LinearLayout lLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            flag = new boolean[getItemCount()];
            Arrays.fill(flag, true);
            AdmirerMessages = (TextView)itemView.findViewById(R.id.content);
            hint = (TextView)itemView.findViewById(R.id.hintDetails);
            lLayout = (LinearLayout)itemView.findViewById(R.id.segmentHints);

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
    public SecretAdmirersAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.secret_admirers_card_layout, viewGroup, false);
        SecretAdmirersAdapter.ViewHolder viewHolder = new SecretAdmirersAdapter.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SecretAdmirersAdapter.ViewHolder viewHolder, int i) {
        viewHolder.AdmirerMessages.setText(matter[i]);
        viewHolder.hint.setText(hints[i]);
    }

    @Override
    public int getItemCount() {
        return matter.length;
    }
}