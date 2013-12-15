package com.nametheblue;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
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
				Intent i = new Intent(MainActivity.this, ResultActivity.class);
				startActivity(i);
			}
		});
		
		secondChoice.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent i = new Intent(MainActivity.this, ResultActivity.class);
				startActivity(i);
			}
		});
	}
	
	private void repaint() {
		Game state = ((Game) getApplicationContext());
		firstChoice.setText(String.valueOf(state.getFirstChoice().name));
		secondChoice.setText(String.valueOf(state.getSecondChoice().name));
		activityMain.setBackgroundColor(Color.parseColor(state.getCorrectChoice().color));
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
