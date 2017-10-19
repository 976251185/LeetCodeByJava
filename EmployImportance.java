package easy;

import java.util.*;

// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};

class Solution {
	// Version 1
    public int getImportance1(List<Employee> employees, int id) {
        int res = 0;
        for(Employee e : employees)
        {
        	if(e.id == id)
        	{
        		res += e.importance;
        		if(e.subordinates.size() == 0)
        			return res;
        		else
        		{
        			for(int subId : e.subordinates)
        				res += getImportance1(employees, subId);
        		}
        		break;
        	}
        }
        return res;
    }
    //Version 2
    public int getImportance2(List<Employee> employees, int id)
    {
    	int total = 0;
    	Map<Integer, Employee> map = new HashMap<>();
    	for (Employee e : employees)
    	{
    		map.put(e.id, e);
    	}
    	Queue<Employee> queue = new LinkedList<>();
    	queue.offer(map.get(id));
    	while(!queue.isEmpty())
    	{
    		Employee current = queue.poll();
    		total += current.importance;
    		for (int sub : current.subordinates)
    		{
    			queue.offer(map.get(sub));
    		}
    	}
    	return total;
    }
}
public class EmployImportance {

}
