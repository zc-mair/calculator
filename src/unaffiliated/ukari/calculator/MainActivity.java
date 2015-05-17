package unaffiliated.ukari.calculator;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	//String
	String equation;
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
    Button buttonDelete;
    Button buttonClear;
    Button buttonRun;
    
    //UI - TextView
    TextView textViewScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        equation = "";
        result = "";
        initButton();
        registerButtonListener();
        textViewScreen = (TextView) findViewById(R.id.screen);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
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
        buttonDelete = (Button) findViewById(R.id.delete);
        buttonClear = (Button) findViewById(R.id.clear);
        buttonRun = (Button) findViewById(R.id.run);		
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
	
	public void refreshResultModeScreen(){
		textViewScreen.setTextAppearance(getApplicationContext(),android.R.style.TextAppearance_Large);
		if(equation.length() == 0||equation.equals("")){
			result = "input error";
		}else{
			result = quoteProcess(equation);
		}
		if (result == null){
			result = "input error";
		}else{
			equation = result;
		}
		textViewScreen.setText(result);
		if(result.equals("input error")){
			equation = "";
		}
	}
	
	public String quoteProcess(String expression){
		int rightQuote;
		int leftQuote;
		String result;
		
		Pattern quotePattern = Pattern.compile("\\d\\(|\\)\\d");
		Matcher quoteMatcher = quotePattern.matcher(expression);
		if(quoteMatcher.find()) {
			result = null;
			return result;
		}
		
		rightQuote = expression.indexOf(')');
		leftQuote = expression.lastIndexOf('(',rightQuote);
		if(rightQuote >- 1&&leftQuote >- 1){
			String quoteRemove = expression.substring(leftQuote+1, rightQuote);
			if(quoteRemove == null){
				return null;
			}
			if(quoteRemove.length() == 0){
				return null;
			}
			quoteRemove = calculate(quoteRemove);
			expression = expression.substring(0,leftQuote)+quoteRemove+expression.substring(rightQuote+1);
			
			expression = quoteProcess(expression);
			if(expression == null){
				result = null;
				return result;
			}
			rightQuote = expression.indexOf(')');
			leftQuote = expression.lastIndexOf('(',rightQuote);
		}
		
		if(leftQuote == -1&&rightQuote == -1&&expression.indexOf('(') == -1&&expression.indexOf(')') == -1){
			result = calculate(expression);
		}else{
			result = null;
		}
		return result;
		
	}
	
	public String calculate(String equation){
		if (equation.charAt(0) == '-'){
			equation = "0" + equation;
		}
		
		String equationResult = null;
		Scanner numberScanner = new Scanner(equation);
		Stack<Double> number = new Stack<Double>();
		numberScanner.useDelimiter("\\+|\\-|\\*|\\/|\\%");
		Scanner operaterScanner = new Scanner(equation);
		operaterScanner.useDelimiter("\\d+(\\.\\d+)?");
		Stack<Character> operator = new Stack<Character>();
		
		if (equation.equals(null)) {
			return "0";
		}
		while(numberScanner.hasNextDouble()||operaterScanner.hasNext()){
			if (numberScanner.hasNextDouble()){
				number.push(numberScanner.nextDouble());
			}

			if (operaterScanner.hasNext()) {
				char tmpOperator = operaterScanner.next().toCharArray()[0];
				if(isOperator(tmpOperator)){
					char previousOperator = 0;
					if(!operator.empty()){
						previousOperator = operator.pop();
						operator.push(previousOperator);
					}
					
					if (number.size()>1&&(!operator.empty())&&operatorPriority(previousOperator) == 3) {	
						number.push(baseCalculate(number.pop(),operator.pop(),number.pop()));
						if(!operator.empty()){
							previousOperator = operator.pop();
							operator.push(previousOperator);
						}
					}
					
					if ((!operator.empty())&&operatorPriority(previousOperator) == 4&&operatorPriority(tmpOperator) >= operatorPriority(previousOperator)) {
						number.push(baseCalculate(number.pop(),operator.pop(),number.pop()));
					}
					operator.push(tmpOperator);
				}
			}			
		}
		numberScanner.close();
		operaterScanner.close();
		if(number.size()-operator.size() != 1){
			equationResult = null;
			return equationResult;
		}
		while (!operator.empty()) {
			number.push(baseCalculate(number.pop(), operator.pop(), number.pop()));
		}

		equationResult = number.pop().toString();
		return equationResult;
	}
	
	private boolean isOperator(int input){
		switch(input){
			case '+':
			case '-':
			case '*':
			case '/':
			case '%':
				return true;
		}
		return false;
	}
	
	private int operatorPriority(char operator){
		switch (operator) {
			case '*':
			case '/':
			case '%':
				return 3;
			case '+':
			case '-':
				return 4;
			default:
				break;
		}
		return 0;
	}
	
	private double baseCalculate(double numberB,char operator,double numberA){
		double result = 0;
		switch (operator) {
			case '+':
				result = numberA + numberB;
				break;
			case '-':
				result = numberA - numberB;
				break;
			case '*':
				result = numberA * numberB;
				break;
			case '/':
				result = numberA / numberB;
				break;
			case '%':
				result = numberA % numberB;
			default:
				break;
		}
		return result;
	}
}

