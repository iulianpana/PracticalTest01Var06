package ro.pub.cs.systems.eim.practicaltest01var06;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var06MainActivity extends Activity {
	private EditText topEditText = null, lowEditText = null;
	private Button details = null, passButton = null, naviButton = null;
	private PassListener passListener = new PassListener();
	private ButtonListener buttonListener = new ButtonListener();
	private static final int SECONDARY_ACTIVITY_REQUEST_CODE = 0;

	private class ButtonListener implements View.OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub

			switch (arg0.getId()) {
			case R.id.details:
				if (details.getText().toString().contains("More details")) {
					details.setText("Less details");
					passButton.setVisibility(View.VISIBLE);
					lowEditText.setVisibility(View.VISIBLE);
				} else if (details.getText().toString()
						.contains("Less details")) {
					details.setText("More details");
					passButton.setVisibility(View.INVISIBLE);
					lowEditText.setVisibility(View.INVISIBLE);
				} else
					break;

				break;

			case R.id.navigate_to_secondary_activity:
				Intent intent = new Intent(getApplicationContext(),
						PracticalTest01Var06SecondaryActivity.class);
				intent.putExtra("toptext", topEditText.getText());
				intent.putExtra("lowertext", lowEditText.getText());

				startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
			default:
				break;
			}

		}

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode,
			Intent intent) {
		if (requestCode == SECONDARY_ACTIVITY_REQUEST_CODE) {
			Toast.makeText(this,
					"The activity returned with result " + resultCode,
					Toast.LENGTH_LONG).show();
		}
	}

	private class PassListener implements TextWatcher {

		@Override
		public void afterTextChanged(Editable arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
				int arg3) {
			// TODO Auto-generated method stub
			passButton.setText("Failed");
			passButton.setBackground(getApplicationContext().getResources()
					.getDrawable(R.color.red));
		}

		@Override
		public void onTextChanged(CharSequence arg0, int arg1, int arg2,
				int arg3) {
			// TODO Auto-generated method stub

			if (arg0.toString().startsWith("http")) {
				passButton.setText("Pass");
				passButton.setBackground(getApplicationContext().getResources()
						.getDrawable(R.color.green));
				
				Intent service = new Intent(getApplicationContext(),PracticalTest01Var06SecondaryActivity.class);
				getApplication().startService(service);
				
				
				
			} else {
				passButton.setText("Failed");
				passButton.setBackground(getApplicationContext().getResources()
						.getDrawable(R.color.red));
			}
		}

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var06_main);

		topEditText = (EditText) findViewById(R.id.top_edit_text);
		lowEditText = (EditText) findViewById(R.id.lower_edit_text);
		details = (Button) findViewById(R.id.details);
		passButton = (Button) findViewById(R.id.pass_button);
		naviButton = (Button) findViewById(R.id.navigate_to_secondary_activity);

		// B.1
		details.setOnClickListener(buttonListener);
		lowEditText.addTextChangedListener(passListener);
		naviButton.setOnClickListener(buttonListener);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_var06_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onSaveInstanceState(Bundle savedInstanceState) {
		savedInstanceState.putString("toptext", topEditText.getText()
				.toString());
		savedInstanceState.putString("lowertext", lowEditText.getText()
				.toString());

	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		if (savedInstanceState.containsKey("toptext")) {
			topEditText.setText(savedInstanceState.getString("toptext"));

		}

		if (savedInstanceState.containsKey("lowertext")) {
			lowEditText.setText(savedInstanceState.getString("lowertext"));

		}
	}
}