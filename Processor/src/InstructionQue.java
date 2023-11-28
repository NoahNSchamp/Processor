
public class InstructionQue {

	//Hopefully this helps when something goes wrong, as it will through a null-pointer
	Instruction instructionA = null;
	Instruction instructionB = null;
	Instruction instructionC = null;
	Instruction instructionD = null;
	Instruction instructionE = null;
	Instruction instructionF = null;
	Instruction instructionG = null;
	Instruction instructionH = null;
	Instruction instructionI = null;
	Instruction instructionJ = null;
	
	//Setters (Public, so not necessary, but helps with readability.)
	public void SetInstructionA(Instruction NewInstruction)
	{
		instructionA = NewInstruction;
	}
	
	public void SetInstructionB(Instruction NewInstruction)
	{
		instructionB = NewInstruction;
	}
	
	public void SetInstructionC(Instruction NewInstruction)
	{
		instructionC = NewInstruction;
	}
	
	public void SetInstructionD(Instruction NewInstruction)
	{
		instructionD = NewInstruction;
	}
	
	public void SetInstructionE(Instruction NewInstruction)
	{
		instructionE = NewInstruction;
	}
	
	public void SetInstructionF(Instruction NewInstruction)
	{
		instructionF = NewInstruction;
	}
	
	public void SetInstructionG(Instruction NewInstruction)
	{
		instructionG = NewInstruction;
	}
	
	public void SetInstructionH(Instruction NewInstruction)
	{
		instructionH = NewInstruction;
	}
	
	public void SetInstructionI(Instruction NewInstruction)
	{
		instructionI = NewInstruction;
	}
	
	public void SetInstructionJ(Instruction NewInstruction)
	{
		instructionJ = NewInstruction;
	}
	
	
	//Shifts all the instructions up by one
	public void ShiftUp()
	{
		instructionA = instructionB;
		instructionB = instructionC;
		instructionC = instructionD;
		instructionD = instructionE;
		instructionE = instructionF;
		instructionF = instructionG;
		instructionG = instructionH;
		instructionH = instructionI;
		instructionI = instructionJ;
		instructionJ = null;
	}
	
}
