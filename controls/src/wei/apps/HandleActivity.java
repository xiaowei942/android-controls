package wei.apps;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

public class HandleActivity extends Activity {
	
	Button btn_back;
	
	@Override 
	public void onCreate(Bundle bd){
		super.onCreate(bd);
		setContentView(R.layout.linerlayout);
		setTitle("HandleActivity");
		
		btn_back = (Button)findViewById(R.id.button_back);
		btn_back.setOnClickListener(listener);
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
			    	break;
			    default:
			    	break;
			}
		}
	};
}