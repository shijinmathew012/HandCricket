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


public class ScoreActivity extends Activity {

	private LinearLayout linear2;
	private LinearLayout linear3;
	private TextView textview1;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private TextView textview2;
	private TextView textview4;
	private TextView textview3;
	private TextView textview5;

	private double a = 0;
	private double b = 0;




	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.score);
		initialize();
		initializeLogic();
	}

	private void  initialize() {
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		textview1 = (TextView) findViewById(R.id.textview1);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		textview2 = (TextView) findViewById(R.id.textview2);
		textview4 = (TextView) findViewById(R.id.textview4);
		textview3 = (TextView) findViewById(R.id.textview3);
		textview5 = (TextView) findViewById(R.id.textview5);



	}

	private void  initializeLogic() {
		a = Double.parseDouble(getIntent().getStringExtra("x"));
		b = Double.parseDouble(getIntent().getStringExtra("y"));
		textview3.setText(String.valueOf((long)(a)));
		textview5.setText(String.valueOf((long)(b)));
		if (a > b) {
			textview1.setText("YOU WIN");
		}
		else {
			textview1.setText("YOU LOST");
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
