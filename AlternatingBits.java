package easy;

public class AlternatingBits {
	public boolean hasAlternatingBits1(int n)
	{
		if(n==1) return true;
		int curBit = n%2;
		n /= 2;
		while(n >= 2)
		{
			 int tmp = n%2;
			 if(curBit == tmp)
				 return false;
			 else
				 curBit = tmp;
			 n /= 2;
		}
		return curBit != n;
	}
	//Other version
	public boolean hasAlternatingBits2(int n)
	{
		return ((n + (n >> 1) + 1) & (n + (n >> 1))) == 0;
	}
}
