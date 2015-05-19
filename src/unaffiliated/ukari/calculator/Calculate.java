package unaffiliated.ukari.calculator;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Calculate {
	
	
	public static String quoteProcess(String expression){
		int rightQuote;
		int leftQuote;
		String result;
		if (expression == null||expression.equals("")) {
			result = Double.valueOf("0").toString();
			return result;
		}
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
			if(quoteRemove == null||quoteRemove.length() == 0){
				result = Double.valueOf("0").toString();
				return result;
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
	
	public static String calculate(String equation){
		String equationResult = null;
		if (equation==null) {
			equationResult = Double.valueOf("0").toString();
			return equationResult;
		}
		
		if (equation.length()>1 && equation.charAt(1) == '-' && isOperator(equation.charAt(0))) {
			equation = "0" + equation;
		}
		
		if (equation.charAt(0) == '-'){
			equation = "0+" + equation;
		}

		if (equation.equals(".")) {
			equationResult = Double.valueOf("0").toString();
			return equationResult;
		}
		
		Scanner numberScanner = new Scanner(equation);
		Stack<String> number = new Stack<String>();
		numberScanner.useDelimiter("\\+|(?<=\\d)\\-|\\*|\\/|\\%|\\^");
		Scanner operaterScanner = new Scanner(equation);
		operaterScanner.useDelimiter("\\d+(\\.\\d+)?");
		Stack<Character> operator = new Stack<Character>();
		
		while(numberScanner.hasNext()||operaterScanner.hasNext()){
			if (numberScanner.hasNext()){
				String numberScanString = numberScanner.next();
				//System.out.println("n:"+numberScanString);
				if (numberScanString.endsWith("Uncalculateable")) {
					equationResult = "Uncalculateable";
					return equationResult;
				}
				if (!numberScanString.matches("(\\-?\\d+)?(\\.\\d*)?([Ee][+-]?\\d+)?")){
					//System.out.println("fuck:"+numberScanString);
					equationResult = null;
					return equationResult;
				}
				
				number.push(numberScanString);
			}
			if (operaterScanner.hasNext()) {
				String operatorScanString = operaterScanner.next();
				//System.out.println("o:"+operatorScanString);
				char tmpOperator = operatorScanString.charAt(0);
				if ((operatorScanString.length() == 2&&operatorScanString.charAt(1) != '-')||operatorScanString.length() > 2) {
					//System.out.println("baka");
					equationResult = null;
					return equationResult;
				}
				if(isOperator(tmpOperator)){
					char previousOperator = 0;
					if(!operator.empty()){
						previousOperator = operator.pop();
						operator.push(previousOperator);
					}
					
					if (number.size()>1&&(!operator.empty())&&operatorPriority(tmpOperator) >= operatorPriority(previousOperator)) {
						String baseCalculateResult = baseCalculate(number.pop(), operator.pop(), number.pop());
						if (baseCalculateResult.endsWith("Infinity")||baseCalculateResult.endsWith("NaN")) {
							equationResult = "Uncalculateable";
							return equationResult;
						}else{
							number.push(baseCalculateResult);
						}
						if(!operator.empty()){
							previousOperator = operator.pop();
							operator.push(previousOperator);
						}
					}
					
					operator.push(tmpOperator);
				}
			}	
		}
		numberScanner.close();
		operaterScanner.close();
		//System.out.println(number.size()-operator.size()+" "+number.size()+" "+operator.size());
		//System.out.println(number.toString());
		//System.out.println(operator.toString());
		if(number.size()-operator.size() != 1){
			equationResult = null;
			return equationResult;
		}
		while (!operator.empty()) {
			String baseCalculateResult = baseCalculate(number.pop(), operator.pop(), number.pop());
			if (baseCalculateResult.endsWith("Infinity")||baseCalculateResult.endsWith("NaN")) {
				equationResult = "Uncalculateable";
				return equationResult;
			}else{
				number.push(baseCalculateResult);
			}
		}
		
		equationResult = Double.valueOf(number.pop()).toString();
		return equationResult;
	}
	
	private static boolean isOperator(int input){
		switch(input){
			case '+':
			case '-':
			case '*':
			case '/':
			case '%':
			case '^':
				return true;
		}
		return false;
	}
	
	private static int operatorPriority(char operator){
		switch (operator) {
			case '^':
				return 2;
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
	
	private static String baseCalculate(String numberBString,char operator,String numberAString){
		String result = new BigDecimal(0).toString();
		BigDecimal numberB = new BigDecimal(numberBString);
		BigDecimal numberA = new BigDecimal(numberAString);
		switch (operator) {
			case '+':
				result = numberA.add(numberB).toString();
				break;
			case '-':
				result = numberA.subtract(numberB).toString();
				break;
			case '*':
				result = numberA.multiply(numberB).toString();
				break;
			case '/':
				if (numberB.doubleValue() == 0) {
					result = String.valueOf(numberA.doubleValue()/0);
				}else{
					result = numberA.divide(numberB,8,BigDecimal.ROUND_HALF_UP).toString();
				}
				break;
			case '%':
				result = numberA.divideAndRemainder(numberB)[1].toString();
				break;
			case '^':
				if (Double.compare(numberA.doubleValue(),3) == 0&&Double.compare(numberB.doubleValue(),3) == 0) {//a patch for android's dalvik
					result = String.valueOf(3.0*3.0*3.0);
				}else{
					result = String.valueOf(Math.pow(numberA.doubleValue(), numberB.doubleValue()));
				}
				break;
			default:
				break;
		}
		return result;
	}
}
