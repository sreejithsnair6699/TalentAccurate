package talentaccurate.com.talentaccurate;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by Sreejith on 2017-08-29.
 */

public class ProblemSolvedAdapter extends RecyclerView.Adapter<ProblemSolvedAdapter.ViewHolder> {

    private String[] matter = {
            "So, here’s a conundrum: You love your iPhone camera, but sometimes, you want to shoot a little more adventurously, " +
            "say, as you bike down a mountain. You think GoPros are cool enough, but they’re kind of expensive, and well, everyone’s got one. ",

            "It is very important to solve the problem manually first, so that you know what you are going to automate, otherwise you are just slinging code around.  " +
                    "Which while can be fun, will make you look like an idiot in a programming interview and will probably cause you to sweat profusely.",

            "If you didn’t break the problem down enough, try going back to the second step and being as meticulous as possible.  Write out each and " +
                    "every single step.  I know it is a pain, but do it, believe me it will be worth the effort.",

            "Many times you will find that a problem itself involves multiple large steps or is very complicated.  In those instances, you will want " +
                    "to try and find a way to cut the problem directly in half and then following the process above for each half.",};

    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView probSolved;

        public ViewHolder(View itemView) {
            super(itemView);
            probSolved = (TextView)itemView.findViewById(R.id.content);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    int position = getAdapterPosition();
                }
            });
        }
    }

    @Override
    public ProblemSolvedAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.problem_solved_card_layout, viewGroup, false);
        ProblemSolvedAdapter.ViewHolder viewHolder = new ProblemSolvedAdapter.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ProblemSolvedAdapter.ViewHolder viewHolder, int i) {
        viewHolder.probSolved.setText(matter[i]);
    }

    @Override
    public int getItemCount() {
        return matter.length;
    }
}