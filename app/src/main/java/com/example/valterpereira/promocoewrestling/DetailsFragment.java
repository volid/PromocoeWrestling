package com.example.valterpereira.promocoewrestling;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.valterpereira.promocoewrestling.model.Promocao;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {


    private View view;
    static Promocao promocao;

    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_details, container, false);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        Bundle args = getArguments();
        if (args != null) {
            int position = args.getInt("position");
            promocao = TitlesFragment.customAdapter.getItem(position);

            getActivity().setTitle(promocao.getName());

            ImageView image = (ImageView) getActivity().findViewById(R.id.imagedet);
            Glide.with(getActivity().getBaseContext()).load(promocao.getImage()).into(image);

            TextView description = (TextView) getActivity().findViewById(R.id.details_id);
            description.setText(promocao.getDescription());


        }
    }

}
