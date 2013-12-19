package com.labyrinthtech.factsofmath;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
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
		
		solution = (TextView) findViewById(R.id.solutionEditText);
		submitButton = (Button) findViewById(R.id.submitButton);
		fact = factGenerator.generateNewFact();
		topOperand.setText(fact.firstOperand + " ");
		bottomOperand.setText(fact.secondOperand + " = ");
		operator.setText(fact.operator + " ");
	}

	// Set listener for number buttons
	// Set listener for erase button
	// Refactor submitAnswer
	public void submitAnswer(View view) {
		if (submitButton.getText().equals(getString(R.string.submit_button_text))) {
			String input = solution.getText().toString();
			if (input.equals(fact.solution)) {
				Toast.makeText(this, R.string.correct_answer_text, Toast.LENGTH_SHORT).show();
				
				submitButton.setText(getString(R.string.go_again_button_text));
			} else {
				Toast.makeText(this, R.string.wrong_answer_text, Toast.LENGTH_SHORT).show();
				
				solution.setText("");
			}
		} else {
			fact = factGenerator.generateNewFact();
			
			topOperand.setText(fact.firstOperand + " ");
			bottomOperand.setText(fact.secondOperand + " = ");
			operator.setText(fact.operator + " ");
			submitButton.setText(getString(R.string.submit_button_text));
			solution.setText("");
		}
	}
	
	public void numberEntry(View view) {
		int viewId = view.getId();
		if(solution.getText().length() < 6 || viewId == R.id.eraseButton) {
			switch(viewId) {
				case R.id.zeroButton: 
					solution.setText(solution.getText() + "0");
					break;
				case R.id.oneButton:
					solution.setText(solution.getText() + "1");
					break;
				case R.id.twoButton:
					solution.setText(solution.getText() + "2");
					break;
				case R.id.threeButton:
					solution.setText(solution.getText() + "3");
					break;
				case R.id.fourButton:
					solution.setText(solution.getText() + "4");
					break;
				case R.id.fiveButton:
					solution.setText(solution.getText() + "5");
					break;
				case R.id.sixButton:
					solution.setText(solution.getText() + "6");
					break;
				case R.id.sevenButton:
					solution.setText(solution.getText() + "7");
					break;
				case R.id.eightButton:
					solution.setText(solution.getText() + "8");
					break;
				case R.id.nineButton:
					solution.setText(solution.getText() + "9");
					break;
				case R.id.eraseButton: 
					String text = solution.getText().toString();
					if(text != null && text.length() > 0) {
						solution.setText(text.substring(0, text.length()-1));
					}
					break;
			}
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
