package talentaccurate.com.talentaccurate;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CreditsPage extends Fragment implements View.OnClickListener{

    TextView link, detailedView;
    View v;

    public CreditsPage() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_credits_page, container, false);
        detailedView = (TextView) v.findViewById(R.id.detailView);
        link = (TextView)v.findViewById(R.id.textLink);
        link.setOnClickListener(this);
        return v;

    }


    @Override
    public void onClick(View v) {
        if(link.isPressed()){
            detailedView.setVisibility(View.VISIBLE);
            link.setVisibility(View.GONE);
        }
    }
}
