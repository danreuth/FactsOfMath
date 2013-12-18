package com.labyrinthtech.factsofmath;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.os.Build;

public class PracticeActivity extends Activity {
	private FactGenerator factGenerator;
	private MathFact fact;
	private TextView topOperand;
	private TextView bottomOperand;
	private TextView operator;
	private TextView solution;
	private TextView answerMessage;
	private Button submitButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		factGenerator = new FactGenerator();
		setContentView(R.layout.activity_practice);
		// Show the Up button in the action bar.
		setupActionBar();
		
		topOperand = (TextView) findViewById(R.id.topOpTextView);
		bottomOperand = (TextView) findViewById(R.id.bottomOpTextView);
		operator = (TextView) findViewById(R.id.operationTextView);
		answerMessage = (TextView) findViewById(R.id.answerResultTextView);
		answerMessage.setVisibility(TextView.INVISIBLE);
		solution = (TextView) findViewById(R.id.solutionEditText);
		submitButton = (Button) findViewById(R.id.submitButton);
		fact = factGenerator.generateNewFact();
		topOperand.setText(fact.firstOperand);
		bottomOperand.setText(fact.secondOperand);
		operator.setText(fact.operator);
	}

	// Set listener for number buttons
	// Set listener for erase button
	// Refactor submitAnswer
	public void submitAnswer(View view) {
		if (submitButton.getText().equals(getString(R.string.submit_button_text))) {
			String input = solution.getText().toString();
			if (input.equals(fact.solution)) {
				answerMessage.setText(getString(R.string.correct_answer_text));
				answerMessage.setVisibility(TextView.VISIBLE);
				submitButton.setText(getString(R.string.go_again_button_text));
			} else {
				answerMessage.setText(getString(R.string.wrong_answer_text));
				answerMessage.setVisibility(TextView.VISIBLE);
				solution.setText("");
			}
		} else {
			fact = factGenerator.generateNewFact();
			answerMessage.setVisibility(TextView.INVISIBLE);
			topOperand.setText(fact.firstOperand);
			bottomOperand.setText(fact.secondOperand);
			operator.setText(fact.operator);
			submitButton.setText(getString(R.string.submit_button_text));
			solution.setText("");
		}
	}
	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practice, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
