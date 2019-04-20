package AsteroidCollision;

import java.util.Collection;
import java.util.Stack;

public class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        int i = 0;
        while (i < asteroids.length && i >= 0) {
            if (asteroids[i] > 0) {
                s.push(asteroids[i]);
                i++;
            } else if (s.isEmpty() == true && asteroids[i] < 0) {
                s.push(asteroids[i]);
                i++;
            } else {
                int element = s.peek();
                if (element == Math.abs(asteroids[i])) {
                    asteroids[i] = 0;
                    s.pop();
                    i++;
                } else if (element < 0 && asteroids[i] < 0) {
                    s.push(asteroids[i]);
                    i++;

                } else {
                    if (Math.abs(asteroids[i]) > element) {
                        s.pop();
                    } else {
                        i++;
                    }
                }
            }
        }
        int[] astero = new int[s.size()];
        for (int ind = s.size() - 1; ind >= 0; ind--) {
            astero[ind] = s.pop();
        }
        return astero;
    }

    public static void main(String[] args) {
        AsteroidCollision a = new AsteroidCollision();
        int[] p = a.asteroidCollision(new int[]{5, 10, -5});
        /*another tests*/
        /*1. [-2,-2,-2,-2] -> [-2,-2,-2,-2]*/
        /*2. [-2,-1,1,2] -> [-2,-1,1,2]*/
        /*3. [10,2,-5] -> [10]*/
        /*3. [8,-8] -> []*/
        System.out.print("[ ");
        for (int i = 0; i < p.length; i++) {
            System.out.print(p[i] + " ");
        }
        System.out.println("]");
    }
}