package com.example.intentcommstudy;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText ed;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ed = (EditText) findViewById(R.id.edName);
	}

	public void openSecond(View v) {

		String strName = ed.getText().toString();

		Intent i = new Intent(getBaseContext(), SecondActivity.class);

		i.putExtra("NAME", strName);
		i.putExtra("AGE", 23);
		i.putExtra("WEIGHT", 68.56);
		i.putExtra("IS_MARRIED", false);

		Bundle bag1 = new Bundle();
		bag1.putString("COMICS", "Tintin");

		Bundle bag2 = new Bundle();
		ArrayList<String> favWords = new ArrayList<String>();
		favWords.add("Bazinga");
		favWords.add("Mogambo");
		favWords.add("Batista");
		bag2.putStringArrayList("FAV_WORDS", favWords);

		i.putExtra("BAG_ONE", bag1);
		i.putExtra("BAG_TWO", bag2);

		// startActivity(i);
		startActivityForResult(i, 17);

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode,
			Intent obtainedIntent) {

		if (requestCode == 17) {
			if (resultCode == RESULT_OK) {

				String msg = obtainedIntent.getStringExtra("MSG");

				Toast.makeText(getApplicationContext(),
						"Data Recieved : " + msg, Toast.LENGTH_LONG).show();

			}

		}

	}
}
