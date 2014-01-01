package com.labyrinthtech.factsofmath.activities;


import android.app.Fragment;

import com.labyrinthtech.factsofmath.fragments.FactsOfMathFragment;



public class FactsOfMathActivity extends SingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		return new FactsOfMathFragment();
	}

}
