import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        // Size of the array
        int n = asteroids.length;

        // List implementation of stack
       Stack<Integer> s=new Stack<>();

        // Traverse all the asteroids
        for(int i = 0; i < n; i++) {

            /* Push the asteroid in stack if a
            right moving asteroid is seen */
            if(asteroids[i] > 0) {
                s.push(asteroids[i]);
            }

            /* Else if the asteroid is moving
            left, perform the collisions */
            else {

                /* Until the right moving asteroids are
                smaller in size, keep on destroying them */
                while(!s.isEmpty() && s.peek() > 0 &&
                        s.peek() < Math.abs(asteroids[i])) {

                    // Destroy the asteroid
                    s.pop();
                }

                /* If there is right moving asteroid
                which is of same size */
                if(!s.isEmpty() &&
                        s.peek() == Math.abs(asteroids[i])) {

                    // Destroy both the asteroids
                    s.pop();
                }

                /* Otherwise, if there is no left
                moving asteroid, the right moving
                asteroid will not be destroyed */
                else if(s.isEmpty() ||
                        s.peek() < 0){

                    // Storing the array in final state
                    s.push(asteroids[i]);
                }
            }
        }

        int size = s.size();
        int[] ans = new int[size];
        for (int j = size - 1; j >= 0; j--)
            ans[j] = s.pop();
        return ans;

    }

}

class AsteroidCollisionMain {
    public static void main(String[] args) {
        AsteroidCollision as = new AsteroidCollision();
        int[] arr = {-2,-2,1,-2};
        as.asteroidCollision(arr);
    }
}
