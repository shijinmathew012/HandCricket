package com.shijin.oddoreven;

import android.app.*;
import android.content.*;
import android.os.*;
import android.net.*;
import android.util.*;
import android.view.*;
import android.widget.*;
import java.util.*;
import org.json.*;


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

private SharedPreferences name;
private Button button1;
	private Button button2;
	private double a = 0;
	private double b = 0;
	private String score;


ArrayList<Team> teams = new ArrayList<Team>();
    ListView listview;

private String user = "";



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
    listview = (ListView) findViewById(R.id.listview);

name = getSharedPreferences("value", Activity.MODE_PRIVATE);

user = name.getString("name", "");
button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);

button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
				NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
				if (networkInfo != null && networkInfo.isConnected()) {
					_submit();
				} else {
					showMessage("please connect to internet");
				}
			
			
				
			}
});
button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
			
				ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
				NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
				if (networkInfo != null && networkInfo.isConnected()) {
					_leader();
				} else {
					showMessage("please connect to internet");
				}
				
				
			}

	});
	}

	private void  initializeLogic() {
		a = Double.parseDouble(getIntent().getStringExtra("x"));
		b = Double.parseDouble(getIntent().getStringExtra("y"));
		score=getIntent().getStringExtra("x");
		textview3.setText(String.valueOf((long)(a)));
		textview5.setText(String.valueOf((long)(b)));
		if (a > b) {
			textview1.setText("YOU WIN");
		}
		else {
			textview1.setText("YOU LOST");
		}
	}

private void  _submit() {
	
String key="key";
     send(user,score,key);
	

}

private void send(String user, String score,String key)
{
	// TODO: Implement this method
	class RegisterUser extends AsyncTask<String, Void, String> {
		ProgressDialog loading;
		RegisterUserClass ruc = new RegisterUserClass ( );



		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			loading = ProgressDialog.show(ScoreActivity.this, "Please Wait..",null, true, true);
		}

		@Override
		protected void onPostExecute(String s) {
			super.onPostExecute(s);
			loading.dismiss();
			if (s != null && !s.isEmpty()) { 

showMessage("Submitted");
 }
		
			
		}

		@Override
		protected String doInBackground(String... params) {

			HashMap<String, String> data = new HashMap<String,String>();
			data.put("name", params[0]);
			data.put("score",params[1]);
			data.put("key",params[2]);

			String Url = "https://www.shijinmathew012.000webhost.com/submit.php";
			String result = ruc.sendPostRequest(Url,data);
			return  result;


		}



	}

	RegisterUser ru = new RegisterUser();
	ru.execute(user,score,key);

	
}
	

private void _leader() {
showMessage("Please wait..");
showMessage("Please wait..");
	new DownloadWebpageTask(new AsyncResult() {
            @Override
            public void onResult(JSONObject object) {
                processJson(object);
            }
        }).execute("https://shijinmathew012.000webhost.com/get.php");
	}
	private void processJson(JSONObject object) {

        try {
            JSONArray rows = object.getJSONArray("rows");

            for (int r = 0; r < rows.length(); ++r) {
                JSONObject row = rows.getJSONObject(r);
                JSONArray columns = row.getJSONArray("c");

                int position = columns.getJSONObject(0).getInt("v");
                String name = columns.getJSONObject(1).getString("v");
                int wins = columns.getJSONObject(2).getInt("v");

                Team team = new Team(position, name, wins);
                teams.add(team);
            }

            final TeamsAdapter adapter = new TeamsAdapter(this, R.layout.team, teams);
            listview.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
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