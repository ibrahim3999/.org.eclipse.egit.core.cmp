package ex4;

import java.util.Scanner;

public class MyEx4 {

	public static void main(String[] input) {
		Scanner s = new Scanner(System.in);
		input = new String[2];
		Ex4 win = new Ex4();
		GUI_Shape_Collection sc = win.getShape_Collection();
		System.out.println("Enter your link file : ");
		input[0] = s.next();
		sc.load(input[0]);
		System.out.println("Enter flag number[0-5] : ");
		input[1] = s.next();
		int flag = Integer.parseInt(input[1]);
		sc.sort(new Shape_Comp(flag));
		System.out.println(sc);
		win.show();
		s.close();
	}

}
