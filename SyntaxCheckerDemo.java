import java.util.*;

class SyntaxChecker {

	private HashMap<String, String> mapping;

	public SyntaxChecker() {
		mapping = new HashMap<String, String>();
		mapping.put("(", ")");
		mapping.put("[", "]");
		mapping.put("{", "}");
	}

	public void check(String input) {
		Stack<String> stack = new Stack<String>();

		for (int i = 0 ; i < input.length() ; i++ ) {
			String currentString = input.substring(i, i+ 1)	;
			//opener
			if ( mapping.keySet().contains(currentString) ) {
				stack.add(currentString);
			} 
			//closer
			else if (mapping.containsValue(currentString)) {
				//get last stack element
				String lastElement = stack.peek();
				if (mapping.get(lastElement).equals(currentString) ) {
					stack.pop();
				}
			}
		}

		if (stack.empty()) {
			System.out.println("input : " + input + " is valid.");
		} else {
			System.out.println("input : " + input + " is not valid.");			
		}
	}
}

class SyntaxCheckerDemo {
	public static void main(String[] args) {

		String input = "{[]()}";

		SyntaxChecker tester = new SyntaxChecker();
		if (args.length > 0) {
			tester.check(args[0]);	
		} else {
			tester.check(input);
		}

	}
}