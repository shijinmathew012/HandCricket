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


public class Toss2Activity extends Activity {

	private LinearLayout linear3;
	private Button button5;
	private Button button6;

	private double role = 0;
	private double r = 0;


	private Intent main = new Intent();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.toss2);
		initialize();
		initializeLogic();
	}

	private void  initialize() {
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		button5 = (Button) findViewById(R.id.button5);
		button6 = (Button) findViewById(R.id.button6);



		button5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				role = 1;
				_next();
			}
		});
		button6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				role = 2;
				_next();
			}
		});

	}

	private void  initializeLogic() {

	}


	private void _next () {
		r = role;
		main.setAction(Intent.ACTION_VIEW);
		main.setClass(getApplicationContext(), GameActivity.class);
		main.putExtra("role", String.valueOf((long)(r)));
		startActivity(main);
		finish();
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
