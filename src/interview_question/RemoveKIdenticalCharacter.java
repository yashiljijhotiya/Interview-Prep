package interview_question;

import java.util.Stack;

public class RemoveKIdenticalCharacter {


    static String remove_k_characters(String st1, int n, int k)
    {
        if(st1.length() <= 1 || st1 == null || k <= 1){
            return st1;
        }

        Stack<Entity> st = new Stack<Entity>();

        int i = 0;
        for (i = 0; i < n; i++) {

            char val = st1.charAt(i);

            if (st.size() > 0 && st.peek().frequency == k) {

                char curr = st.peek().character;

                while (st.size() > 0 && st.peek().character == curr)
                    st.pop();
            }

            if (st.size() > 0 && st.peek().character == val) {

                Entity new_top = new Entity(val, st.peek().frequency + 1);
                st.push(new_top);
            }

            else {
                Entity new_top = new Entity(val, 1);
                st.push(new_top);
            }
        }

        if (st.size() > 0 && st.peek().frequency == k) {

            char curr = st.peek().character;

            while (st.size() > 0 && st.peek().character == curr)
                st.pop();
        }

        // Stores the string in
        // reversed fashion from stack
        String stack_string = "";
        while (st.size() > 0)
            stack_string += st.pop().character;

        String reduced_string = "";

        // reverse the stack string
        for (i = stack_string.length() - 1; i >= 0; i--)
            reduced_string += stack_string.charAt(i);

        return reduced_string;
    }

    // Driver code
    public static void main(String[] args)
    {
        int k = 3;
        String st = "aaabccccd";
        String ans = remove_k_characters(st, st.length(), k);
        System.out.println(ans);
    }

    static class Entity {
        char character;
        int frequency;
        Entity(char p, int q)
        {
            character = p;
            frequency = q;
        }
    }
}
