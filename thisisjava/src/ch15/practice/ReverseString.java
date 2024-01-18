package ch15.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseString {

	public static void main(String[] args) {
		String str = "ABCDE";
		StringBuilder sb = new StringBuilder();
		String[] str_arr = str.split("");
		List<String> list = Arrays.asList(str_arr);
		List<String> list_reverse = new ArrayList<>();
		
		for(String s : list) {
			list_reverse.add(s);
		}
		
	}

}
