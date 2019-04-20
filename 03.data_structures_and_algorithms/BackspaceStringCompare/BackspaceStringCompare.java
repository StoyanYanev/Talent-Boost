package BackspaceStringCompare;

import java.util.Stack;

public class BackspaceStringCompare {
    private Stack<Character> getStack(String S) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != '#') {
                s.push(S.charAt(i));
            } else if (s.isEmpty() == false) {
                s.pop();
            }
        }
        return s;
    }

    public boolean backspaceCompare(String S, String T) {
        Stack<Character> firstString = (getStack(S));
        Stack<Character> secondString = (getStack(T));
        if (firstString.equals(secondString) == true) {
            return true;
        }
        return false;
    }
}