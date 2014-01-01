package com.labyrinthtech.factsofmath.activities;

import com.labyrinthtech.factsofmath.fragments.PracticeFragment;

import android.app.Fragment;

public class PracticeActivity extends SingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		return new PracticeFragment();
	}

}
