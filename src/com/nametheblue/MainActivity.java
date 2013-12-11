package com.nametheblue;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	TextView firstChoice;
	TextView secondChoice;
	View activityMain;
	ArrayList<Product> activeChoices;
	Boolean laoded = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		firstChoice = (TextView) findViewById(R.id.first_choice);
		secondChoice = (TextView) findViewById(R.id.second_choice);
		activityMain = findViewById(R.id.activityMain).getRootView();
		
		setupListener();
	}
	
	protected void onResume() {
		super.onResume();
		repaint();
	}
	

	private void setupListener() {
		firstChoice.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Game state = ((Game) getApplicationContext());
				if( state.checkAnswer(0) ) {
					showScore("Correct");
				} else {
					showScore("Oops, incorrect");
				}
				
				state.newChoices();
				repaint();
			}
		});
		
		secondChoice.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Game state = ((Game) getApplicationContext());
				if( state.checkAnswer(1) ) {
					showScore("Correct");
				} else {
					showScore("Oops, incorrect");
				}
				
				state.newChoices();
				repaint();
			}
		});
	}
	
	private void showScore(String message){
		try {
			System.out.println("Trying to show the score");
			firstChoice.setText("Hello World");
			secondChoice.setText("");
			Thread.sleep(5000);			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}

	private void repaint() {
		Game state = ((Game) getApplicationContext());
		firstChoice.setText(String.valueOf(state.getFirstChoice().name));
		secondChoice.setText(String.valueOf(state.getSecondChoice().name));
		activityMain.setBackgroundColor(Color.parseColor(state.getCorrectChoice().color));		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
