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


public class TossActivity extends Activity {

	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private TextView textview1;
	private ImageView imageview1;
	private TextView textview2;
	private ImageView imageview2;
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private Button button5;
	private Button button6;
	private TextView textview3;
	private TextView textview4;

	private double x = 0;
	private double y = 0;
	private double z = 0;
	private double num = 0;


	private Timer _timer = new Timer();
	private Intent toss2 = new Intent();
	private TimerTask countdown;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.toss);
		initialize();
		initializeLogic();
	}

	private void  initialize() {
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		textview1 = (TextView) findViewById(R.id.textview1);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview2 = (TextView) findViewById(R.id.textview2);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		button3 = (Button) findViewById(R.id.button3);
		button4 = (Button) findViewById(R.id.button4);
		button5 = (Button) findViewById(R.id.button5);
		button6 = (Button) findViewById(R.id.button6);
		textview3 = (TextView) findViewById(R.id.textview3);
		textview4 = (TextView) findViewById(R.id.textview4);




		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 

			}
		});
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 

			}
		});
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				x = 1;
				y = getRandom((int)(1), (int)(6));
				_ChangeImage2();
				_ChangeImage();
				_NextActivity();
			}
		});
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				x = 2;
				y = getRandom((int)(1), (int)(6));
				_ChangeImage2();
				_ChangeImage();
				_NextActivity();
			}
		});
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				x = 3;
				y = getRandom((int)(1), (int)(6));
				_ChangeImage();
				_ChangeImage2();
				_NextActivity();
			}
		});
		button4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				x = 4;
				y = getRandom((int)(1), (int)(6));
				_ChangeImage();
				_ChangeImage2();
				_NextActivity();
			}
		});
		button5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				x = 5;
				y = getRandom((int)(1), (int)(6));
				_ChangeImage();
				_ChangeImage2();
				_NextActivity();
			}
		});
		button6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				x = 6;
				y = getRandom((int)(1), (int)(6));
				_ChangeImage();
				_ChangeImage2();
				_NextActivity();
			}
		});

	}

	private void  initializeLogic() {
		num = 1;
	}


	private void _ChangeImage () {

if (x == 1) {
			imageview2.setImageResource(R.drawable.imgw1);
		}
		if (x == 2) {
			imageview2.setImageResource(R.drawable.imgw2);
		}
		if (x == 3) {
			imageview2.setImageResource(R.drawable.imgw3);
		}
		if (x == 4) {
			imageview2.setImageResource(R.drawable.imgw4);
		}
		if (x == 6) {
			imageview2.setImageResource(R.drawable.imgw6);
		}
		if (x == 5) {
			imageview2.setImageResource(R.drawable.imgw5);
		}
	}
	private void _NextActivity () {
		if (num == 1) {
			num = num + 1;
			z = Double.parseDouble(getIntent().getStringExtra("r"));
			textview3.setText("Sum is");
			textview4.setText(String.valueOf((long)(x + y)));
			if (((x + y) % 2) == z) {
				showMessage("You got the toss");
				countdown = new TimerTask() {
							@Override
								public void run() {
									runOnUiThread(new Runnable() {
									@Override
										public void run() {
														_Selectrole();
										finish();
										}
									});
								}
							};
							_timer.schedule(countdown, (int)(2000));
			}
			else {
				showMessage("Android got the tose");
				countdown = new TimerTask() {
							@Override
								public void run() {
									runOnUiThread(new Runnable() {
									@Override
										public void run() {
														_Main();
										finish();
										}
									});
								}
							};
							_timer.schedule(countdown, (int)(2000));
			}
		}
		else {

		}
	}
	private void _ChangeImage2 () {

if (y == 1) {
			imageview1.setImageResource(R.drawable.imgb1);
		}
		if (y == 2) {
			imageview1.setImageResource(R.drawable.imgb2);
		}
		if (y == 3) {
			imageview1.setImageResource(R.drawable.imgb3);
		}
		if (y == 4) {
			imageview1.setImageResource(R.drawable.imgb4);
		}
		if (y == 5) {
			imageview1.setImageResource(R.drawable.imgb5);
		}
		if (y == 6) {
			imageview1.setImageResource(R.drawable.imgb6);
		}
	}
	private void _Selectrole () {
		toss2.setAction(Intent.ACTION_VIEW);
		toss2.setClass(getApplicationContext(), Toss2Activity.class);
		startActivity(toss2);
	}
	private void _Main () {
		toss2.setAction(Intent.ACTION_VIEW);
		toss2.setClass(getApplicationContext(), GameActivity.class);
		toss2.putExtra("role", "2");
		startActivity(toss2);
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
