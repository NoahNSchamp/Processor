
public class RegisterFile {

	//This will be deleted if it gets turned into an array, but its been functioning fine
	
	//Constructor
	double R0;
	double R1;
	double R2;
	double R3;
	double R4;
	double R5;
	double R6;
	double R7;
	
	//Setter Methods (Don't really need these since everything is public, but oh well.)
	public void SetR0(double newR)
	{
		R0 = newR;
	}
	
	public void SetR1(double newR)
	{
		R1 = newR;
	}
	
	public void SetR2(double newR)
	{
		R2 = newR;
	}
	
	public void SetR3(double newR)
	{
		R3 = newR;
	}
	
	public void SetR4(double newR)
	{
		R4 = newR;
	}
	
	public void SetR5(double newR)
	{
		R5 = newR;
	}
	
	public void SetR6(double newR)
	{
		R6 = newR;
	}
	
	public void SetR7(double newR)
	{
		R7 = newR;
	}
	
	
	//Given an instruction, gets the corresponding RF that the instruction calls for from the c-Bit)
	//Returns 10 if there is an issue (miss-input)
	public double GetRFCBit(Instruction instruct)
	{
		switch(instruct.cBit)
		{
		case 0: return R0;
		case 1: return R1;
		case 2: return R2;
		case 3: return R3;
		case 4: return R4;
		case 5: return R5;
		case 6: return R6;
		case 7: return R7;
		}
		
		return 10;
	}
	
	//Given an instruction, gets the corresponding RF that the instruction calls for from the d-Bit)
	//Returns 10 if there is an issue (miss-input)
	public double GetRFDBit(Instruction instruct)
	{
		switch(instruct.dBit)
		{
		case 0: return R0;
		case 1: return R1;
		case 2: return R2;
		case 3: return R3;
		case 4: return R4;
		case 5: return R5;
		case 6: return R6;
		case 7: return R7;
		}
		
		return 10;
	}
	

	
}
