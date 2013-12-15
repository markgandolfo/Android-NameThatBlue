package com.nametheblue;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	TextView firstChoice;
	TextView secondChoice;
	View activityMain;
	ArrayList<Product> activeChoices;
	
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
				Boolean correct;
				Game state = ((Game) getApplicationContext());
				correct = state.checkAnswer(0);
				Intent i = new Intent(MainActivity.this, ResultActivity.class);
				i.putExtra("correct", correct);
				startActivity(i);
			}
		});
		
		secondChoice.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Boolean correct;
				Game state = ((Game) getApplicationContext());
				correct = state.checkAnswer(1);

				Intent i = new Intent(MainActivity.this, ResultActivity.class);
				i.putExtra("correct", correct);
				startActivity(i);
			}
		});
	}
	
	private void repaint() {
		Game state = ((Game) getApplicationContext());
		firstChoice.setText(String.valueOf(state.getFirstChoice().name));
		secondChoice.setText(String.valueOf(state.getSecondChoice().name));
		activityMain.setBackgroundColor(Color.parseColor(state.getCorrectChoice().color));
		Log.d("CorrectAnswer", state.getCorrectChoice().name);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
