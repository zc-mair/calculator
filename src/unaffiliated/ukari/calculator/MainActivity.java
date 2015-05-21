package unaffiliated.ukari.calculator;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;;

public class MainActivity extends Activity {
	//String
	String equation;
	String previousEquation;
	String result;
	
	//UI - Button
	Button buttonOne;
    Button buttonTwo;
    Button buttonThree;
    Button buttonFour;
    Button buttonFive;
    Button buttonSix;
    Button buttonSeven;
    Button buttonEight;
    Button buttonNine;
    Button buttonZero;
    Button buttonDot;
    Button buttonLeftParenthesis;
    Button buttonRightParenthesis;
    Button buttonPlus;
    Button buttonMinus;
    Button buttonMultiply;
    Button buttonDivide;
    Button buttonMod;
    Button buttonPower;
    Button buttonDelete;
    Button buttonClear;
    Button buttonRun;
    Button buttonPrevious;
    
    //UI - TextView
    TextView textViewScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        equation = "";
        result = "";
        previousEquation = "";
        initButton();
        registerButtonListener();
        textViewScreen = (TextView) findViewById(R.id.screen);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        menu.add(0, Menu.FIRST, 0, "Information");
        menu.add(0, Menu.FIRST+1, 1, "Exit");
    	return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem item) {  
        switch (item.getItemId()) {  
        case Menu.FIRST:  
        	new AlertDialog.Builder(MainActivity.this).setTitle("Information").setMessage("Sourcecode:\nhttps://github.com/ukari/calculator\nEmail:\nchendianbuji@gmail.com\nDate:\n2015-05-21 23:29").show(); 
            break;  
        case Menu.FIRST + 1:  
        	android.os.Process.killProcess(android.os.Process.myPid());
        	System.exit(0);
            break;  
        default:  
            break;  
        }  
        return super.onOptionsItemSelected(item);  
    }  
    
	public void initButton(){
		buttonOne = (Button) findViewById(R.id.one);
        buttonTwo = (Button) findViewById(R.id.two);
        buttonThree = (Button) findViewById(R.id.three);
        buttonFour = (Button) findViewById(R.id.four);
        buttonFive = (Button) findViewById(R.id.five);
        buttonSix = (Button) findViewById(R.id.six);
        buttonSeven = (Button) findViewById(R.id.seven);
        buttonEight = (Button) findViewById(R.id.eight);
        buttonNine = (Button) findViewById(R.id.nine);
        buttonZero = (Button) findViewById(R.id.zero);
        buttonDot = (Button) findViewById(R.id.dot);
        buttonLeftParenthesis = (Button) findViewById(R.id.leftParenthesis);
        buttonRightParenthesis = (Button) findViewById(R.id.rightParenthesis);
        buttonPlus = (Button) findViewById(R.id.plus);
        buttonMinus = (Button) findViewById(R.id.minus);
        buttonMultiply = (Button) findViewById(R.id.multiply);
        buttonDivide = (Button) findViewById(R.id.divide);
        buttonMod = (Button) findViewById(R.id.mod);
        buttonPower = (Button) findViewById(R.id.power);
        buttonDelete = (Button) findViewById(R.id.delete);
        buttonClear = (Button) findViewById(R.id.clear);
        buttonRun = (Button) findViewById(R.id.run);
        buttonPrevious = (Button) findViewById(R.id.previous);
	}
    
	public void registerButtonListener(){
		buttonOne.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		equation = equation + "1";
        		refreshEquationModeScreen();
        	}
        });
        buttonTwo.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		equation = equation + "2";
        		refreshEquationModeScreen();
        	}
        });
        buttonThree.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		equation = equation + "3";
        		refreshEquationModeScreen();
        	}
        });
        buttonFour.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		equation = equation + "4";
        		refreshEquationModeScreen();
        	}
        });
        buttonFive.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		equation = equation + "5";
        		refreshEquationModeScreen();
        	}
        });
        buttonSix.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		equation = equation + "6";
        		refreshEquationModeScreen();
        	}
        });
        buttonSeven.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		equation = equation + "7";
        		refreshEquationModeScreen();
        	}
        });
        buttonEight.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		equation = equation + "8";
        		refreshEquationModeScreen();
        	}
        });
        buttonNine.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		equation = equation + "9";
        		refreshEquationModeScreen();
        	}
        });
        buttonZero.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		equation = equation + "0";
        		refreshEquationModeScreen();
        	}
        });	
        buttonDot.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		equation = equation + ".";
        		refreshEquationModeScreen();
        	}
        });	
        buttonLeftParenthesis.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		equation = equation + "(";
        		refreshEquationModeScreen();
        	}
        });	
        buttonRightParenthesis.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		equation = equation + ")";
        		refreshEquationModeScreen();
        	}
        });	
        buttonPlus.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		equation = equation + "+";
        		refreshEquationModeScreen();
        	}
        });	
        buttonMinus.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		equation = equation + "-";
        		refreshEquationModeScreen();
        	}
        });	
        buttonMultiply.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		equation = equation + "*";
        		refreshEquationModeScreen();
        	}
        });	
        buttonDivide.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		equation = equation + "/";
        		refreshEquationModeScreen();
        	}
        });	
        buttonMod.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		equation = equation + "%";
        		refreshEquationModeScreen();
        	}
        });	
        buttonPower.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		equation = equation + "^";
        		refreshEquationModeScreen();
        	}
        });	
        buttonDelete.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		if(equation.length()>0){
        			equation = equation.substring(0,equation.length()-1);
        		}
        		refreshEquationModeScreen();
        	}
        });	
        buttonClear.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		equation = "";
        		refreshEquationModeScreen();
        	}
        });	
        buttonRun.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		refreshResultModeScreen();
        	}
        });	
        buttonPrevious.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		refreshPreviousEquationModeScreen();
        	}
        });	
	}
	
	public void refreshEquationModeScreen(){
		while(equation.length()>98){
			equation = equation.substring(0,equation.length()-1);//删掉最后一个字符
		}
		if(equation.length()<40){			
			textViewScreen.setTextAppearance(getApplicationContext(),android.R.style.TextAppearance_Large);
		}else{
			textViewScreen.setTextAppearance(getApplicationContext(),android.R.style.TextAppearance_Small);
		}
		textViewScreen.setText(equation);
	}
	
	public void refreshPreviousEquationModeScreen(){
		equation = previousEquation;
		textViewScreen.setText(equation);
	}
	
	public void refreshResultModeScreen(){
		textViewScreen.setTextAppearance(getApplicationContext(),android.R.style.TextAppearance_Large);
		if (equation.equals(result)&&!equation.equals("")) {
			return;
		}else if (!(result.equals("input error")||result.equals("Uncalculateable"))||equation.length()>0) {
			previousEquation = equation;
		}
		
		result = Calculate.quoteProcess(equation);
		if (result == null){
			result = "input error";
			equation = "";
		}else if(result.equals("Uncalculateable")){
			equation = "";
		}else{
			equation = result;
		}
		textViewScreen.setText(result);
	}
}

