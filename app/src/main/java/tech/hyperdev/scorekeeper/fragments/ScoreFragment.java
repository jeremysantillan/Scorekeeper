package tech.hyperdev.scorekeeper.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import tech.hyperdev.scorekeeper.R;

import static android.R.attr.name;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScoreFragment extends Fragment {

    private TextView mTvTeamName;
    private String team_name;



    public ScoreFragment() {
        // Required empty public constructor
    }

    public static ScoreFragment newInstance(String team_name) {
       Bundle bundle = new Bundle();
        bundle.putString("team_name", team_name);

        ScoreFragment scoreFragment = new ScoreFragment();
        scoreFragment.setArguments(bundle);

        return scoreFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_score, container, false);
        mTvTeamName = (TextView) view.findViewById(R.id.tvTeamName);

        getBundle(getArguments());
        return view;
    }

    public void getBundle(Bundle bundle){
if(bundle!=null){
    team_name = bundle.getString("team_name");
    changeName(team_name);
}
    }

    public void changeName(String name){
        mTvTeamName.setText(name);
    }


}
