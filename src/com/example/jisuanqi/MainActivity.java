package com.example.jisuanqi;

import android.app.Activity;
import android.icu.util.DateInterval;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener{
	EditText exp;
	Button Button_0; 
	Button Button_1; 
	Button Button_2; 
	Button Button_3; 
	Button Button_4; 
	Button Button_5; 
	Button Button_6; 
	Button Button_7; 
	Button Button_8; 
	Button Button_9; 
	Button Button_plus; 
	Button Button_minus; 
	Button Button_multi; 
	Button Button_divide;
	Button Button_mod; 
	Button Button_del; 
	Button Button_clear; 
	Button Button_equal;
	Button Button_point; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button_0 = (Button) findViewById(R.id.button_0);
		Button_1 = (Button) findViewById(R.id.button_1);
		Button_2 = (Button) findViewById(R.id.button_2);
		Button_3 = (Button) findViewById(R.id.button_3);
		Button_4 = (Button) findViewById(R.id.button_4);
		Button_5 = (Button) findViewById(R.id.button_5);
		Button_6 = (Button) findViewById(R.id.button_6);
		Button_7 = (Button) findViewById(R.id.button_7);
		Button_8 = (Button) findViewById(R.id.button_8);
		Button_9 = (Button) findViewById(R.id.button_9);
		Button_point = (Button) findViewById(R.id.button_point);
		Button_clear = (Button) findViewById(R.id.button_clear);
		Button_del = (Button) findViewById(R.id.button_del);
		Button_plus = (Button) findViewById(R.id.button_plus);
		Button_minus = (Button) findViewById(R.id.button_minus);
		Button_multi = (Button) findViewById(R.id.button_multi);
		Button_divide = (Button) findViewById(R.id.button_divide);
		Button_mod =(Button) findViewById(R.id.button_mod);
		Button_equal=(Button) findViewById(R.id.button_equal);
		exp=(EditText) findViewById(R.id.et_output);
		Button_0.setOnClickListener(this);
		Button_1.setOnClickListener(this);
		Button_2.setOnClickListener(this);
		Button_3.setOnClickListener(this);
		Button_4.setOnClickListener(this);
		Button_5.setOnClickListener(this);
		Button_6.setOnClickListener(this);
		Button_7.setOnClickListener(this);
		Button_8.setOnClickListener(this);
		Button_9.setOnClickListener(this);
		Button_point.setOnClickListener(this);
		Button_clear.setOnClickListener(this);
		Button_del.setOnClickListener(this);
		Button_plus.setOnClickListener(this);
		Button_minus.setOnClickListener(this);
		Button_multi.setOnClickListener(this);
		Button_divide.setOnClickListener(this);
		Button_mod.setOnClickListener(this);
		Button_equal.setOnClickListener(this);
		};
		
		private String s1="";
		private	String s2="";
		private String op="";

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			switch(v.getId()){
			case R.id.button_0:
			case R.id.button_1:
			case R.id.button_2:
			case R.id.button_3:
			case R.id.button_4:
			case R.id.button_5:
			case R.id.button_6:
			case R.id.button_7:
			case R.id.button_8:
			case R.id.button_9:
			case R.id.button_point:
				if(op.equals("")){
					s1=s1+((Button)v).getText().toString();
					exp.setText(exp.getText().toString()+((Button)v).getText().toString());
				}else{
					s2=s2+((Button)v).getText().toString();
					exp.setText(exp.getText().toString()+((Button)v).getText().toString());
				};
				
				break;
			case R.id.button_plus:
			case R.id.button_minus:
			case R.id.button_multi:
			case R.id.button_divide:
			case R.id.button_mod:
				if(!s1.equals("")){
					if(s2.equals("")){
						if(op.equals("")){
						op=((Button)v).getText().toString();
						Log.i("tag", "进行到这了");
						exp.setText(exp.getText().toString()+" "+((Button)v).getText().toString()+" ");
						}else{
							op=((Button)v).getText().toString();
							String str =exp.getText().toString();
							exp.setText(str.substring(0, str.length()-3)+" "+((Button)v).getText().toString()+" ");
						}
					}
				}
				break;
			case R.id.button_equal:
				getAns();
				break;
			case R.id.button_clear:
				exp.setText("");
				s1="";
				s2="";
				op="";
				break;
			case R.id.button_del:
				delete();
			}
			
		}
		public void getAns(){
			String str=exp.getText().toString();
			if(str==null||str.equals(""))
				return;
			if(!str.contains(" "))
				return;
			double ans=0;
			String f1=str.substring(0,str.indexOf(" "));
			String op=str.substring(str.indexOf(" ")+1,str.indexOf(" ")+2);
			String f2=str.substring(str.indexOf(" ")+3);
			Double n1=Double.parseDouble(f1);
			Double n2=Double.parseDouble(f2);
			if(op.equals("+")){
				ans=n1+n2;
			}else if(op.equals("-")){
				ans=n1-n2;
			}else if(op.equals("*")){
				ans=n1*n2;
			}else if(op.equals("/")){
				ans=n1/n2;
			}else if(op.equals("%")){
				ans=n1%n2;
			}
			exp.setText(ans+"");
		}
		public void delete(){
			if(!s1.equals("")){
				if(!op.equals("")){
					if(!s2.equals("")){
						if(s2.length()==1){
							s2="";
							exp.setText(exp.getText().toString().substring(0,exp.getText().toString().length()-1));
						}else{
							s2=s2.substring(0,s2.length()-1);
							exp.setText(exp.getText().toString().substring(0,exp.getText().toString().length()-1));
						}
					}else{
						op="";
						exp.setText(exp.getText().toString().substring(0,exp.getText().toString().length()-3));
					}
				}else{
					if(s1.length()==1){
						s1="";
						exp.setText("");
					}else{
						s1=s1.substring(0,s1.length()-1);
						exp.setText(exp.getText().toString().substring(0,exp.getText().toString().length()-1));
					}
				}
			}
		}

}
