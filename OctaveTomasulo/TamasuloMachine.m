
n_instr=0; %Instructions in Input Data
instr_issued = 0;
cc_sim=0; %Number of Cycles to Simulate
iq = zeros(10, 4); iq(:, 1) = 9; %Instruction Queue (Pops)
rf = 0:7; %Register File
rat = zeros(1,8);
out = num2str(zeros(26,8));
e_unit = zeros(2,4); %Execution Units
rs_issue = zeros(1, 5); %Tracks Issuing of RS Units

eu_time = [2, 2, 10, 40];

rs = zeros(5,7); %[Busy, OP, Tag1, Tag2, Vj, Vk, Dispatch]
%RS(1) - RS(3) ADD/SUB; RS(4) - RS(5) MUL/DIV 
%(0: add; 1:sub; 2: multiply; 3: divide)

%%Initialize

%%Read Text File
data = int16(dlmread ("Instructions.txt", " "));
n_instr = data(1,1);
scheduler = zeros(n_instr, 5); %Issue, Dispatch, Broadcast, Associated RS, Associated EU
cc_sim = data(2,1);

for i = 3:(3+n_instr-1) %Load Instructions to IQ
  %(0: add; 1:sub; 2: multiply; 3: divide)
  iq(i-2,:) = data(i,:);
endfor
for i = 1:8
  rf(i) = data(n_instr+2+i, 1);
endfor

ir = iq; %InstructionRecord (Static) For Record Keeping

%TamasuloMachine Loop
n_cc = 1;
for n_cc = 1:cc_sim

  [iq rs rat issued] = Issue(iq, rs, rat, rf);
  if issued(1) == 1
    instr_issued += 1;
    scheduler(instr_issued, 1) = n_cc;
    scheduler(instr_issued, 4) = issued(2);
    rs_issue(issued(2)) = n_cc;
    iq = POP_IQ(iq);
  endif

  [rs e_unit dispatched] = Dispatch(rs, e_unit, rs_issue, n_cc);
  if dispatched(1) == 1
    for i = 1:instr_issued %Update Scheduler Log
      if dispatched(2) == scheduler(i, 4) && scheduler(i, 3) == 0
        scheduler(i, 2) = n_cc;
      endif
    endfor
  endif

  [rs rf rat e_unit broadcasted] = Broadcast(rs, rf, rat, e_unit, n_cc, eu_time);
  if broadcasted(1) == 1
    for i = 1:instr_issued %Update Scheduler Log
      if broadcasted(2) == scheduler(i, 4) && scheduler(i, 2) != 0
        scheduler(i, 3) = n_cc;
      endif
    endfor
  endif

endfor

scheduler
rs
rf
rat

#{
While (scheduler(n_instr,3) != 9) && (n_cc <= cc_sim)
  Issue
endwhile

#}
%Issue
