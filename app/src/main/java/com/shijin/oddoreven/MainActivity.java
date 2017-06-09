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


public class MainActivity extends Activity {

	private LinearLayout linear1;
	private LinearLayout linear2;
	private Button button3;
	private Button button4;

	private double chooser = 0;


	private Intent game = new Intent();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initialize();
		initializeLogic();
	}

	private void  initialize() {
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		button3 = (Button) findViewById(R.id.button3);
		button4 = (Button) findViewById(R.id.button4);



		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				chooser = 1;
				_NextActivity();
			}
		});
		button4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				chooser = 2;
				_NextActivity();
			}
		});

	}

	private void  initializeLogic() {

	}


	private void _NextActivity () {
		game.setAction(Intent.ACTION_VIEW);
		game.setClass(getApplicationContext(), GameActivity.class);
		game.putExtra("role", String.valueOf((long)(chooser)));
		startActivity(game);
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
