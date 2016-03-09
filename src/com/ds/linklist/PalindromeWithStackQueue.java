package com.ds.linklist;

import java.util.Scanner;

class Palindrome {
	class Node {
		char data;
		Node next;

		Node(char data) {
			this.data = data;
		}
	}

	Node first, last;
	Node top;

	void pushCharacter(char ch) {
		Node tmp = new Node(ch);
		tmp.next = top;
		top = tmp;
	}

	char popCharacter() {
		if (top == null) {
			return '\0';
		}
		Node tmp = new Node(top.data);
		top = top.next;
		return tmp.data;
	}

	void enqueueCharacter(char ch) {
		Node tmp = new Node(ch);
		if (first == null) {
			first = tmp;
			last = first;
		} else {
			last.next = tmp;
			last = last.next;
		}
	}

	char dequeueCharacter() {
		if (first == null) {
			return '\0';
		} else {
			Node tmp = new Node(first.data);
			first = first.next;
			return tmp.data;
		}
	}
}

public class PalindromeWithStackQueue {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// read the string s.
		// String s = sc.nextLine();

		String s = "racecar";

		// create the Palindrome class object p.
		Palindrome p = new Palindrome();
		char arr[] = s.toCharArray();// Converting string to a character array
		// push all the characters of string s to stack.
		for (char c : arr) {
			p.pushCharacter(c);
		}

		// enqueue all the characters of string s to queue.
		for (char c : arr) {
			p.enqueueCharacter(c);
		}

		boolean f = true;

		// pop the top character from stack.
		// dequeue the first character from queue.
		// compare both the characters.
		for (int i = 0; i < s.length(); i++) {
			if (p.popCharacter() != p.dequeueCharacter()) {
				f = false;
				break;
			}
		}

		// finally print whether string s is palindrome or not.
		if (f) {
			System.out.println("The word, " + s + ", is a palindrome.");
		} else {
			System.out.println("The word, " + s + ", is not a palindrome.");
		}
	}
}