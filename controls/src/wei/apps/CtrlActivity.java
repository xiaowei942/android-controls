package wei.apps;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button; //引入类
import android.view.View;
import android.widget.TextView;
import java.util.Date;

public class CtrlActivity extends Activity implements View.OnClickListener
{
	Button btn_show_time; //声明对象
	TextView text_view_1;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        btn_show_time = (Button)findViewById(R.id.button_show_time); //获取按钮
        btn_show_time.setOnClickListener(this);                      //设置监听器
        
        text_view_1 = (TextView)findViewById(R.id.textview1);
    }
    
    //实现响应函数
    public void onClick(View view){
    	text_view_1.setText(new Date().toString());
    }

    //另外一种添加按钮事件响应的方法
    public void showLocalTime(View theButton){
    	text_view_1.setText(new Date().toString());
    }
}
