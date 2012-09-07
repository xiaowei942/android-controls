package wei.apps;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;
import android.os.Bundle;
import android.widget.Spinner;

public class HandleActivity extends Activity {
	
	private ArrayAdapter<String> adapter;
	private static final String[] DAYS = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
	Button btn_back;
	Button btn_exit;
	Spinner spin;
	
	@Override 
	public void onCreate(Bundle bd){
		super.onCreate(bd);
		setContentView(R.layout.linerlayout);
		setTitle("HandleActivity");
		
		btn_back = (Button)findViewById(R.id.button_back);
		btn_back.setOnClickListener(listener);		
		btn_exit = (Button)findViewById(R.id.button_exit);
		btn_exit.setOnClickListener(listener);
	
		adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,DAYS);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		spin = (Spinner)findViewById(R.id.spinner1);
		spin.setAdapter(adapter);
		spin.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				HandleActivity.this.setTitle(DAYS[arg2]);
				arg0.setVisibility(View.VISIBLE);
			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
			
		}
		);
	}


	Button.OnClickListener listener = new Button.OnClickListener(){

		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch (arg0.getId())
			{
				case R.id.button_back:
					Intent intent = new Intent();
			    	intent.setClass(HandleActivity.this,CtrlActivity.class);
			    	startActivity(intent);
			    	HandleActivity.this.finish();
			    	break;
				case R.id.button_exit:
					System.exit(0);
			    default:
			    	break;
			}
		}
	};
	

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Toast.makeText(this, "HandleActivity---->onDestroy()", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Toast.makeText(this, "HandleActivity---->onRestart()", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Toast.makeText(this, "HandleActivity---->onResume()", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Toast.makeText(this, "HandleActivity---->onPause()", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Toast.makeText(this, "HandleActivity---->onStart()", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Toast.makeText(this, "HandleActivity---->onStop()", Toast.LENGTH_SHORT).show();
	}
}
