package com.labyrinthtech.factsofmath.fragments;

import com.labyrinthtech.factsofmath.R;
import com.labyrinthtech.factsofmath.models.MathFact;
import com.labyrinthtech.factsofmath.services.FactGenerator;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PracticeFragment extends Fragment implements OnClickListener {

	private FactGenerator factGenerator;
	private MathFact fact;
	private TextView topOperand;
	private TextView bottomOperand;
	private TextView operator;
	private TextView solution;
	private Button submitButton;
	private Button[] keyBoardButtons;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_practice, container, false);
		keyBoardButtons = new Button[11];
		factGenerator = new FactGenerator();
		topOperand = (TextView) view.findViewById(R.id.topOpTextView);
		bottomOperand = (TextView) view.findViewById(R.id.bottomOpTextView);
		operator = (TextView) view.findViewById(R.id.operationTextView);
		
		solution = (TextView) view.findViewById(R.id.solutionEditText);
		submitButton = (Button) view.findViewById(R.id.submitButton);
		submitButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (submitButton.getText().equals(getString(R.string.submit_button_text))) {
					String input = solution.getText().toString();
					if (input.equals(fact.solution)) {
						Toast.makeText(getActivity(), R.string.correct_answer_text, Toast.LENGTH_SHORT).show();
						
						submitButton.setText(getString(R.string.go_again_button_text));
					} else {
						Toast.makeText(getActivity(), R.string.wrong_answer_text, Toast.LENGTH_SHORT).show();
						
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
		});
		fact = factGenerator.generateNewFact();
		topOperand.setText(fact.firstOperand + " ");
		bottomOperand.setText(fact.secondOperand + " = ");
		operator.setText(fact.operator + " ");
		
		keyBoardButtons[0] = (Button)view.findViewById(R.id.zeroButton);
		keyBoardButtons[1] = (Button)view.findViewById(R.id.oneButton);
		keyBoardButtons[2] = (Button)view.findViewById(R.id.twoButton);
		keyBoardButtons[3] = (Button)view.findViewById(R.id.threeButton);
		keyBoardButtons[4] = (Button)view.findViewById(R.id.fourButton);
		keyBoardButtons[5] = (Button)view.findViewById(R.id.fiveButton);
		keyBoardButtons[6] = (Button)view.findViewById(R.id.sixButton);
		keyBoardButtons[7] = (Button)view.findViewById(R.id.sevenButton);
		keyBoardButtons[8] = (Button)view.findViewById(R.id.eightButton);
		keyBoardButtons[9] = (Button)view.findViewById(R.id.nineButton);
		keyBoardButtons[10] = (Button)view.findViewById(R.id.eraseButton);
		
		for(int i = 0; i < keyBoardButtons.length; i++) {
			keyBoardButtons[i].setOnClickListener(this);
		}
		
		return view;
	}

	@Override
	public void onClick(View v) {
		int viewId = v.getId();
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
	

	

	
}

