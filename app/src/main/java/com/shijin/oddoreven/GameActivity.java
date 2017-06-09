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


public class GameActivity extends Activity {

	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear6;
	private LinearLayout linear7;
	private TextView textview1;
	private TextView textview2;
	private ImageView imageview1;
	private LinearLayout linear8;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private Button button5;
	private Button button6;
	private TextView textview9;
	private ImageView imageview2;
	private TextView textview5;
	private TextView textview6;
	private TextView textview7;
	private TextView textview8;

	private double round = 0;
	private double a = 0;
	private double role = 0;
	private double random = 0;
	private double x = 0;
	private double y = 0;


	private Intent score = new Intent();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game);
		initialize();
		initializeLogic();
	}

	private void  initialize() {
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		textview1 = (TextView) findViewById(R.id.textview1);
		textview2 = (TextView) findViewById(R.id.textview2);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		button3 = (Button) findViewById(R.id.button3);
		button4 = (Button) findViewById(R.id.button4);
		button5 = (Button) findViewById(R.id.button5);
		button6 = (Button) findViewById(R.id.button6);
		textview9 = (TextView) findViewById(R.id.textview9);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		textview5 = (TextView) findViewById(R.id.textview5);
		textview6 = (TextView) findViewById(R.id.textview6);
		textview7 = (TextView) findViewById(R.id.textview7);
		textview8 = (TextView) findViewById(R.id.textview8);



		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				a = 1;
				_Calculate();
			}
		});
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				a = 2;
				_Calculate();
			}
		});
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				a = 3;
				_Calculate();
			}
		});
		button4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				a = 4;
				_Calculate();
			}
		});
		button5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				a = 5;
				_Calculate();
			}
		});
		button6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				a = 6;
				_Calculate();
			}
		});
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

	}

	private void  initializeLogic() {
		round = 1;
		x = 0;
		y = 0;
	}


	private void _Calculate () {
		role = Double.parseDouble(getIntent().getStringExtra("role"));
		random = getRandom((int)(1), (int)(6));
		_Changeimage();
		_Changeimage2();
		textview2.setText(String.valueOf((long)(random)));
		if (round == 1) {
			if (random == a) {
				if (role == 1) {
					role = 2;
					setTitle("Your bowling");
					round = 2;
					showMessage("Batting is over");
				}
				else {
					role = 1;
					setTitle("Your batting");
					round = 2;
					showMessage("Bowling is over");
				}
			}
			else {
				if (role == 1) {
					x = x + a;
					textview6.setText(String.valueOf((long)(x)));
				}
				else {
					y = y + random;
					textview8.setText(String.valueOf((long)(y)));
				}
			}
		}
		else {
			if (random == a) {
				if (role == 1) {
					if (x > y) {
						showMessage("You win");
						_ScoreActivity();
						finish();
					}
				}
				else {
					showMessage("You lost");
					_ScoreActivity();
					finish();
				}
			}
			else {
				if (role == 1) {
					y = y + random;
					textview8.setText(String.valueOf((long)(y)));
					if (y > x) {
						showMessage("You lose");
						_ScoreActivity();
						finish();
					}
				}
				else {
					x = x + a;
					textview6.setText(String.valueOf((long)(x)));
					if (x > y) {
						showMessage("You win");
						_ScoreActivity();
						finish();
					}
				}
			}
		}
	}
	private void _ScoreActivity () {
		score.setAction(Intent.ACTION_VIEW);
		score.setClass(getApplicationContext(), ScoreActivity.class);
		score.putExtra("x", String.valueOf((long)(x)));
		score.putExtra("y", String.valueOf((long)(y)));
		startActivity(score);
	}
	private void _Changeimage () {
		if (random == 1) {
			imageview1.setImageResource(R.drawable.imgb1);
		}
		if (random == 2) {
			imageview1.setImageResource(R.drawable.imgb2);
		}
		if (random == 3) {
			imageview1.setImageResource(R.drawable.imgb3);
		}
		if (random == 4) {
			imageview1.setImageResource(R.drawable.imgb4);
		}
		if (random == 5) {
			imageview1.setImageResource(R.drawable.imgb5);
		}
		if (random == 6) {
			imageview1.setImageResource(R.drawable.imgb6);
		}
	}
	private void _Changeimage2 () {
		if (a == 1) {
			imageview2.setImageResource(R.drawable.imgw1);
		}
		if (a == 2) {
			imageview2.setImageResource(R.drawable.imgw2);
		}
		if (a == 3) {
			imageview2.setImageResource(R.drawable.imgw3);
		}
		if (a == 4) {
			imageview2.setImageResource(R.drawable.imgw4);
		}
		if (a == 6) {
			imageview2.setImageResource(R.drawable.imgw6);
		}
		if (a == 5) {
			imageview2.setImageResource(R.drawable.imgw5);
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
