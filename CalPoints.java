package easy;
import java.util.*;

class Solution
{
	int calPoints(String[] ops)
	{
		int res = 0;
		int tmp;
		LinkedList<Integer> ll = new LinkedList<>();
		for(int i=0; i<ops.length; i++)
		{
			switch(ops[i])
			{
			case "+":
				tmp = ll.peek() + ll.get(1);
				res += tmp;
				ll.push(tmp);
				break;
			case "D":
				tmp = 2 * ll.peek();
				res += tmp;
				ll.push(tmp);
				break;
			case "C":
				res -= ll.pop();
				break;
			default:
				tmp = Integer.parseInt(ops[i]);
				res += tmp;
				ll.push(tmp);
			}
		}
		return res;
	}
}

public class CalPoints {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		String[] s = {"-60","D","-36","30","13","C","C","-33","53","79"};
		System.out.println(solution.calPoints(s));
	}

}
