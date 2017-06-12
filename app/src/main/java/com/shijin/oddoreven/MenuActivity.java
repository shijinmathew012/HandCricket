package com.shijin.oddoreven;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.webkit.*;
import java.util.*;
import java.text.*;




public class MenuActivity extends Activity {

	private LinearLayout linear1;
	private TextView textview1;
	private Button button1;
	private TextView textview2;
	private Button button2;


private String value = "";

	private SharedPreferences name;


	private Intent toss = new Intent();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);



		initialize();
		initializeLogic();
	}

	private void  initialize() {
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		textview1 = (TextView) findViewById(R.id.textview1);
		button1 = (Button) findViewById(R.id.button1);
		textview2 = (TextView) findViewById(R.id.textview2);
		button2 = (Button) findViewById(R.id.button2);


name = getSharedPreferences("value", Activity.MODE_PRIVATE);

_checklogin();


		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				toss.setAction(Intent.ACTION_VIEW);
				toss.setClass(getApplicationContext(), TossActivity.class);
				toss.putExtra("r", "1");
				startActivity(toss);
			}
		});
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				toss.setAction(Intent.ACTION_VIEW);
				toss.setClass(getApplicationContext(), TossActivity.class);
				toss.putExtra("r", "0");
				startActivity(toss);
			}
		});

	}

	private void  initializeLogic() {

	}

private void _checklogin () {
		

if (name.getString("name", "").equals("")) {

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Enter your name");


		final EditText input = new EditText(this);

		input.setInputType(InputType.TYPE_CLASS_TEXT );
		builder.setView(input);
	builder.setCancelable(false);

		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

				private String m_Text; 
				@Override
				public void onClick(DialogInterface dialog, int which) {
					m_Text = input.getText().toString();
					if(m_Text.equals("")){
						_checklogin();
					}
					else{
name.edit().putString("name", m_Text).commit();
						showMessage("Hi "+m_Text);
					}
					
					
					
					
				}
			});
		

		builder.show();
			
			
		}
		else {
			     //showMessage("Welcome".concat(name.getString("name", "")));
		}
		
	}



	// created automatically
	private void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}

	private int getRandom(int _minValue ,int _maxValue){
		Random random = new Random();
		return random.nextInt(_maxValue - _minValue + 1) + _minValue;
	}

	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
				_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}

}
