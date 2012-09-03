package wei.apps;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button; //引入类
import android.view.View;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.CompoundButton;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.EditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import java.util.Date;
import android.content.Intent;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;

public class CtrlActivity extends Activity implements View.OnClickListener
{
	NotificationManager nmanager;
    public static boolean NEWVERSION = false;
    public static int NOTIFICATION_ID = 21321;
    
	Button btn_show_time; //声明对象
	TextView text_view_1;
	EditText edit_text_1;
	EditText edit_text_2;
	
	RadioGroup  radiogroup;
	RadioButton radio0;
	RadioButton radio1;
	RadioButton radio2;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        btn_show_time = (Button)findViewById(R.id.button_show_time); //获取按钮
        btn_show_time.setOnClickListener(this);                      //设置监听器
        
        text_view_1 = (TextView)findViewById(R.id.textview1);
        edit_text_1 = (EditText)findViewById(R.id.edittext1);
        edit_text_2 = (EditText)findViewById(R.id.edittext2);
        
        edit_text_1.addTextChangedListener(new TextWatcher(){

			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				setTitle(edit_text_1.getText());
			}

			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub
				
			}

			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
				
			}
        	
        });
        

        radiogroup = (RadioGroup)findViewById(R.id.radioGroup);
        radio0 = (RadioButton)findViewById(R.id.radio0);
        radio1 = (RadioButton)findViewById(R.id.radio1);
        radio2 = (RadioButton)findViewById(R.id.radio2);
        
        radio2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				// TODO Auto-generated method stub
				setTitle("Radio2 Checked");
			}
		});
        
        radiogroup.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				int id = arg0.getCheckedRadioButtonId();
				RadioButton rbtn = (RadioButton)CtrlActivity.this.findViewById(id);
				edit_text_2.setText("Radio"+rbtn.getText()+" Checked");
				
				if(id == radio0.getId())
					setTitle("Radio0 Checked");
			}
        	
        });
        
        ShowNotification();
    }
    
    //实现响应函数
    public void onClick(View view){
    	text_view_1.setText(new Date().toString());
    }

    //另外一种添加按钮事件响应的方法
    public void showLocalTime(View theButton){
    	text_view_1.setText(new Date().toString());
    }
    
    public void onClickHandleActivity(View view){
    	switchto();
    }
    
    private void switchto(){
    	Intent intent = new Intent();
    	intent.setClass(this,HandleActivity.class);
    	startActivity(intent);
    	System.exit(0);
    }
    
    private void ShowNotification(){
    	if(NEWVERSION){
			nmanager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
			RemoteViews rviews = new RemoteViews("wei.apps",R.layout.main);
			PendingIntent pintent = PendingIntent.getActivity(this, 0, this.getIntent(), 0);
			
			Notification.Builder builder = new Notification.Builder(this);
			builder.setContentText("常用组件测试程序")
			.setContentTitle("CtrlActivity")
			.setSmallIcon(R.drawable.p1)
			.setTicker("CtrlActivity", rviews)
			.setContentIntent(pintent)
			.setWhen(System.currentTimeMillis());
			
			Notification notification = builder.getNotification();
			nmanager.notify(NOTIFICATION_ID, notification);
    	}else{
	        /* 创建通知栏图标 */
	        nmanager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
	        Notification notification = new Notification();
	        
	        PendingIntent pintent = PendingIntent.getActivity(this, 0, this.getIntent(), 0);
	        notification.icon = R.drawable.p1;
	        notification.when = System.currentTimeMillis();
	        notification.tickerText = "Starting CtrlActivity!";
	        notification.defaults = Notification.DEFAULT_SOUND;
	        notification.setLatestEventInfo(this, "CtrlActivity", "常用组件测试程序", pintent);
	        nmanager.notify(NOTIFICATION_ID, notification);
    	}
    }
    
    public void onDeleteNotifition(View view){
    	nmanager.cancel(NOTIFICATION_ID);
    }
}
