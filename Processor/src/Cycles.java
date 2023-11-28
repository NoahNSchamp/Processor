
public class Cycles {

	int Cycle;
	
	//Starts with Cycle = 0
	public void StartCycle()
	{
		Cycle = 0;
	}
	
	//Increments Cycle by 1
	public void IncCycle()
	{
		Cycle = Cycle + 1;
	}
	
	//Increments by a set amount
	public void IncCycleAmount(int amount)
	{
		Cycle = Cycle + amount;
	}
	
	
	//This should never be used, but is useful for testing
	public void SetCycleAmount(int amount)
	{
		Cycle = amount;
	}
	
	
	//Cycles for certain operations, for readability
	public void AddCycle()
	{
		Cycle = Cycle + 2;
	}
	
	public void MulCycle()
	{
		Cycle = Cycle + 10;
	}
	
	public void DivCycle()
	{
		Cycle = Cycle + 40;
	}
	
	
}
