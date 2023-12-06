
n_instr=0; %Instructions in Input Data
cc_sim=0; %Number of Cycles to Simulate
iq = zeros(10, 4); iq(:, 1) = 9; %Instruction Queue (Pops)
rf = 0:7; %Register File
rat = zeros(1,8);
out = num2str(zeros(26,8));

eu_Time = [2, 2, 10, 40];

rs = zeros(5,7); %[Busy, OP, Tag1, Tag2, Vj, Vk, Dispatch]
%RS(1) - RS(3) ADD/SUB; RS(4) - RS(5) MUL/DIV 


%%Initialize



%%Read Text File
data = int8(dlmread ("Instructions.txt", " "))
n_instr = data(1,1);
scheduler = zeros(n_instr, 3); %Issue, Dispatch, Broadcast
cc_sim = data(2,1);

for i = 3:(3+n_instr-1)
  
  %(0: add; 1:sub; 2: multiply; 3: divide)
  iq(i-2,:) = data(i,:);
  #{
  { switch (i)
    case 0
      command_list
    case 1
      command_list
    case 2
      asfsad
    case 3
      command_list
    otherwise
      null
  endswitch
  #}
end
ir = iq %InstructionRecord (Static)

iq = POP_IQ(iq)


