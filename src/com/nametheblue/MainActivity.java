package com.nametheblue;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	TextView firstChoice;
	TextView secondChoice;
	View activityMain;
	ArrayList<Product> activeChoices;
	Game game;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		firstChoice = (TextView) findViewById(R.id.first_choice);
		secondChoice = (TextView) findViewById(R.id.second_choice);
		
		game = new Game();
		activeChoices = game.getchoices();
		
		firstChoice.setText(activeChoices.get(0).name);
		secondChoice.setText(activeChoices.get(1).name);
				
		activityMain = findViewById(R.id.activityMain).getRootView();
		activityMain.setBackgroundColor(Color.parseColor(game.getCorrectChoice().color));
		
		setupListener();
	}
	
	
	private void setupListener() {
		firstChoice.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				game.checkAnswer(0);
			}
		});
		
		secondChoice.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				game.checkAnswer(1);
			}
		});
		
	}
	
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}	
}
