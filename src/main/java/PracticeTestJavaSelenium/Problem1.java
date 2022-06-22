package PracticeTestJavaSelenium;

public class Problem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Print all the numbers between 1 to 100 where if number is divivsible by 3
		 * write fizz, if number is divisible by 5 write buzz, if number is divisible by
		 * both 3 and 5 then print fizz buzz
		 */
		Boolean flag = false;
		String val = null;
		for (int i = 1; i <= 50; i++) {
			if (i % 3 == 0) {
				System.out.println(val = "fizz" + i);
				flag = true;
			}

			if (i % 5 == 0) {
				System.out.println(val = "Buzz" + i);
				flag = true;
			}

			if (i % 3 == 0 && i % 5 == 0) {
				System.out.println(val = "fizzBuzz" + i);
				flag = true;
			}

			if (i % 15 == 0) {
				System.out.println(val = "fizzBuzz" + i);
				flag = true;
			}

			if (flag == false) {
				System.out.println(i);
			} else {
				flag = false;
			}

		}

	}

}
