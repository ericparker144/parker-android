package com.engineeringeric.parkerapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SpotsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SpotsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SpotsFragment extends Fragment {

    public SpotsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_spots, container, false);
    }
}
