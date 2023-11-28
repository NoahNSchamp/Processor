
public class Main {

	public static void main(String[] args) {
		
		//Test Change
		
		//Test Instructions
		//TO-DO: Implement text read and insert.
		Instruction first = new Instruction(0,2,4,6);
		Instruction second = new Instruction(2,4,3,5);
		Instruction third = new Instruction(2,5,2,4);
		Instruction forth = new Instruction(1,1,2,3);
		Instruction fifth = new Instruction(0,0,0,0);
		Instruction sixth = new Instruction(3,2,3,4);
		Instruction seventh = new Instruction(2,7,6,0);
		Instruction eight = new Instruction(1,2,3,4);
		Instruction ninth = new Instruction(0,2,2,3);
		Instruction tenth = new Instruction(0,2,4,3);
		
		//Initializing Instruction Que
		//TO-DO: Most likely turn this into an array / Read-up on arrays
		InstructionQue Que = new InstructionQue();
		Que.SetInstructionA(first);
		Que.SetInstructionB(second);
		Que.SetInstructionC(third);
		Que.SetInstructionD(forth);
		Que.SetInstructionE(fifth);
		Que.SetInstructionF(sixth);
		Que.SetInstructionG(seventh);
		Que.SetInstructionH(eight);
		Que.SetInstructionI(ninth);
		Que.SetInstructionJ(tenth);
		
		//Initializing RF
		//TO-DO: Most likely turn this into an array / Read-up on arrays
		RegisterFile RF = new RegisterFile();
		RF.SetR0(0);
		RF.SetR1(1);
		RF.SetR2(2);
		RF.SetR3(3);
		RF.SetR4(4);
		RF.SetR5(5);
		RF.SetR6(6);
		RF.SetR7(7);
		
		//Initializing Cycle
		Cycles Cycle = new Cycles();
		Cycle.StartCycle();
		
		//Register Inputs Funkyness
		//This will be changed at some point.
		//They are doubles because every time we did them in class they were doubles, I know it says integer in the instructions.
		//I will be asking about this
		double RIA;
		double RIB;
		double RO;
		
		
		
		//Main Loop
		//This is a working add, sub, mul, and div, with cycle counters.
		//This does not use a RS, Exe, or RAT.
		//This does not use issuing, dispatching, broadcasting, or catching
		for(int i = 0; i < 10; i++)
		{
			switch(Que.instructionA.aBit)
			{
				case 0:
					
					//Add Cycle
					Cycle.AddCycle();
					RIA = RF.GetRFCBit(Que.instructionA);
					RIB = RF.GetRFDBit(Que.instructionA);
					RO = RIA + RIB;
					
					//This feels like a horrible way to do this...
					switch(Que.instructionA.bBit)
					{
						case 0:
							RF.R0 = RO;
							break;
						case 1:
							RF.R1 = RO;
							break;
						case 2:
							RF.R2 = RO;
							break;
						case 3:
							RF.R3 = RO;
							break;
						case 4:
							RF.R4 = RO;
							break;
						case 5:
							RF.R5 = RO;
							break;
						case 6:
							RF.R6 = RO;
							break;
						case 7:
							RF.R7 = RO;
							break;
					}
					
					
					System.out.println("Add processed, result: " + RO + "\n" + "Current Cycle Count: " + Cycle.Cycle);
					break;
					
				case 1:
					//Sub, but same thing -_シ_-
					Cycle.AddCycle();
					RIA = RF.GetRFCBit(Que.instructionA);
					RIB = RF.GetRFDBit(Que.instructionA);
					RO = RIA - RIB;
					
					//This feels like a horrible way to do this...
					switch(Que.instructionA.bBit)
					{
						case 0:
							RF.R0 = RO;
							break;
						case 1:
							RF.R1 = RO;
							break;
						case 2:
							RF.R2 = RO;
							break;
						case 3:
							RF.R3 = RO;
							break;
						case 4:
							RF.R4 = RO;
							break;
						case 5:
							RF.R5 = RO;
							break;
						case 6:
							RF.R6 = RO;
							break;
						case 7:
							RF.R7 = RO;
							break;
					}
					
					System.out.println("Sub processed, result: " + RO + "\n" + "Current Cycle Count: " + Cycle.Cycle);
					break;
					
				case 2:
					Cycle.MulCycle();
					RIA = RF.GetRFCBit(Que.instructionA);
					RIB = RF.GetRFDBit(Que.instructionA);
					RO = RIA * RIB;
					
					//This feels like a horrible way to do this...
					switch(Que.instructionA.bBit)
					{
						case 0:
							RF.R0 = RO;
							break;
						case 1:
							RF.R1 = RO;
							break;
						case 2:
							RF.R2 = RO;
							break;
						case 3:
							RF.R3 = RO;
							break;
						case 4:
							RF.R4 = RO;
							break;
						case 5:
							RF.R5 = RO;
							break;
						case 6:
							RF.R6 = RO;
							break;
						case 7:
							RF.R7 = RO;
							break;
					}
					
					System.out.println("Mul processed, result: " + RO + "\n" + "Current Cycle Count: " + Cycle.Cycle);
					break;
					
				case 3:
					Cycle.DivCycle();
					RIA = RF.GetRFCBit(Que.instructionA);
					RIB = RF.GetRFDBit(Que.instructionA);
					RO = RIA / RIB;
					
					//This feels like a horrible way to do this...
					switch(Que.instructionA.bBit)
					{
						case 0:
							RF.R0 = RO;
							break;
						case 1:
							RF.R1 = RO;
							break;
						case 2:
							RF.R2 = RO;
							break;
						case 3:
							RF.R3 = RO;
							break;
						case 4:
							RF.R4 = RO;
							break;
						case 5:
							RF.R5 = RO;
							break;
						case 6:
							RF.R6 = RO;
							break;
						case 7:
							RF.R7 = RO;
							break;
					}
					
					System.out.println("Div processed, result: " + RO + "\n" + "Current Cycle Count: " + Cycle.Cycle);
					break;
					
				default:
					System.out.println("Opcode out of bounds. Please check input and try again.");
			}
			//Shifts to next instruction in que
			Que.ShiftUp();
		}
		
		
		
	}

	
	public static void Issuing()
	{
		
	}
	
	public void Dispatching()
	{
		
	}
	
	public void Capturing()
	{
		
	}
	
	public void Broadcasting()
	{
		
	}
	
}
