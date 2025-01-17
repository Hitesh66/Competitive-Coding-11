//Time Complexity O(N)
//Space Complexity O(N)
//Leetcode tested

import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int size = num.length();
        if(k == size) return "0";

        java.util.Stack<Character> stack = new Stack<>();

        int counter = 0;
        while(counter < size){
            while(k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(counter)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(counter));
            counter++;
            //System.out.print(k);
        }

        while(k>0){
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            char current_char = stack.pop();
            sb.append(current_char);
        }
        sb.reverse();
        while(sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
