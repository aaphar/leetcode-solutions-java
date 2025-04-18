/**
 * https://leetcode.com/problems/find-closest-person/description/
 */
public class FindClosestPerson {

    public int findClosestSimple(int x, int y, int z) {
        int ans=0;
        int diffx=Math.abs(z-x);
        int diffy=Math.abs(z-y);
        if(diffx<diffy){
            ans=1;
        }else if (diffy<diffx) {
            ans=2;
        }
        return ans;
    }

    public int findClosest(int x, int y, int z) {
        boolean xBigger = x > z;
        boolean yBigger = y > z;
        while (x != z && y != z) {
            if (xBigger) {
                x--;
            } else {
                x++;
            }

            if (yBigger) {
                y--;
            } else {
                y++;
            }

            if (x == z || y == z) {
                break;
            }
        }

        int result = -1;

        if (x == z && y == z) {
            result = 0;
        } else if (x == z) {
            result = 1;
        } else {
            result = 2;
        }

        return result;
    }
}
