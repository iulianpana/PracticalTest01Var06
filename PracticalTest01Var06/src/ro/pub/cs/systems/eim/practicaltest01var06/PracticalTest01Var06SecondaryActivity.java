package ro.pub.cs.systems.eim.practicaltest01var06;


import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PracticalTest01Var06SecondaryActivity extends Activity {

	
	TextView top =null,lower =null;
	Button ok =null,cancel=null;
	private ButtonListener buttonListener = new ButtonListener();
	IntentFilter intentFiter = new IntentFilter();
	

	private class ButtonListener implements View.OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch (arg0.getId()) {
			case R.id.ok:
				setResult(RESULT_OK, null);
				break;
			case R.id.cancel:
				setResult(RESULT_CANCELED, null);
				break;
			default:
				break;
			}
			
		}
		
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var06_secondary);
		
		top = (TextView)findViewById(R.id.top);
		lower = (TextView)findViewById(R.id.lower);
		
		ok = (Button)findViewById(R.id.ok);
		cancel = (Button) findViewById(R.id.cancel);
		
		ok.setOnClickListener(buttonListener);
		cancel.setOnClickListener(buttonListener);
		
		Intent intent = getIntent();
		if(intent!=null )
			if (intent.getExtras().containsKey("toptext")) {
				top.setText(intent.getStringExtra("toptext"));
				
			}
			else
				if (intent.getExtras().containsKey("lowertext")) {
					lower.setText(intent.getCharSequenceExtra("lowertext"));
				}
		
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater()
				.inflate(R.menu.practical_test01_var06_secondary, menu);
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
}
