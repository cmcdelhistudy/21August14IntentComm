package com.example.intentcommstudy;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {

	TextView tv2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		tv2 = (TextView) findViewById(R.id.textView2);

		Intent obtainedIntent = getIntent();
		String obtainedName = obtainedIntent.getStringExtra("NAME");

		tv2.setText("Hello " + obtainedName);

		int obtainedAge = obtainedIntent.getIntExtra("AGE", -1);
		double obtainedWeight = obtainedIntent.getDoubleExtra("WEIGHT", -1.0);
		boolean maritalStatus = obtainedIntent.getBooleanExtra("IS_MARRIED",
				false);

		Toast.makeText(getApplicationContext(), "Age " + obtainedAge,
				Toast.LENGTH_LONG).show();

		Toast.makeText(getApplicationContext(), "Weight " + obtainedWeight,
				Toast.LENGTH_LONG).show();

		Toast.makeText(getApplicationContext(), "IS Married " + maritalStatus,
				Toast.LENGTH_LONG).show();

		Bundle obtainedBag1 = obtainedIntent.getBundleExtra("BAG_ONE");
		String obtainedComics = obtainedBag1.getString("COMICS");

		Toast.makeText(getApplicationContext(), "Comics  " + obtainedComics,
				Toast.LENGTH_LONG).show();

		Bundle obtainedBag2 = obtainedIntent.getBundleExtra("BAG_TWO");
		ArrayList<String> obtainedFavList = obtainedBag2
				.getStringArrayList("FAV_WORDS");

		for (String s : obtainedFavList) {
			Toast.makeText(getApplicationContext(), "FAV_WORD " + s,
					Toast.LENGTH_LONG).show();

		}

	}

	public void workDone(View v) {
		Intent i = new Intent();
		i.putExtra("MSG", "User data saved");

		setResult(RESULT_OK, i);
		
		finish();
		

	}

}
