package com.labyrinthtech.factsofmath;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class FactsOfMath extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_facts_of_math);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.facts_of_math, menu);
		return true;
	}
	
	public void beginPractice(View view){
		Intent intent = new Intent(this, PracticeActivity.class);
		startActivity(intent);
	}

}
