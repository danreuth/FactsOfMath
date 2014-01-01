package com.labyrinthtech.factsofmath.fragments;

import com.labyrinthtech.factsofmath.R;
import com.labyrinthtech.factsofmath.activities.PracticeActivity;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FactsOfMathFragment extends Fragment {

	private Button mSubmitButton;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_facts_of_math, container, false);
		mSubmitButton = (Button)view.findViewById(R.id.submitButton);
		mSubmitButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), PracticeActivity.class);
				startActivity(intent);
				
			}
		});
		return view;
	}
}
