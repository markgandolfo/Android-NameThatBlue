package com.nametheblue;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends Activity {
	
	Game state;
	View resultView;
	TextView message, score;
	Boolean correct;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);
		resultView = findViewById(R.id.activityMain);
		
		state = ((Game) getApplicationContext());

		message = (TextView) findViewById(R.id.result_message);
		correct = getIntent().getBooleanExtra("correct", false);
		if(correct) {
			message.setText(getResources().getString(R.string.correct));
		} else {
			message.setText(getResources().getString(R.string.incorrect));
		}
		
		
		score = (TextView) findViewById(R.id.score);
		score.setText(state.getScore() + " Out of " + state.getTotalProductCount());
		
		new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
			state.newChoices();
            final Intent mainIntent = new Intent(ResultActivity.this, MainActivity.class);
            ResultActivity.this.startActivity(mainIntent);
            ResultActivity.this.finish();
        }
    }, 5000);
		
	}

}
