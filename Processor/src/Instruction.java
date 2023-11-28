
public class Instruction {

	int aBit;
	int bBit;
	int cBit;
	int dBit;
	
	//Constructor
	Instruction(int aBit, int bBit, int cBit, int dBit)
	{
		this.aBit = aBit;
		this.bBit = bBit;
		this.cBit = cBit;
		this.dBit = dBit;
	} 
	
	//Setters (Public, so not necessary, but helps with readability.)
	public void setABit(int newABit)
	{
		aBit = newABit;
	}
	
	public void setBBit(int newBBit)
	{
		bBit = newBBit;
	}
	
	public void setCBit(int newCBit)
	{
		cBit = newCBit;
	}
	
	public void setDBit(int newDBit)
	{
		dBit = newDBit;
	}
	
}
