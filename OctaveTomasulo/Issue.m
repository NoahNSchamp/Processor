function [iq_new rs_new rat_new issued] = Issue(iq, rs, rat, rf)
  issued = [0 0]; %Issued T/F, RS
  rs_i = 0
  switch iq(1,1)
    case 9
      %break
    case {0, 1} %Add%%%%%%%%%%%%%%%%
      for i = 1:3 %Check & Choose Reservation Station
        if rs(i,1) == 0
          rs_i = i;
          break
        endif
      endfor
      if rs_i != 0 %Update Selected Reservation Station
        rs(rs_i,1) = 1; %Now Busy
        rs(rs_i, 2) = iq(1,1) %OP Code
        for i = 1:2 %Update Operands
          rf_i = iq(1,2+i) + 1
          if rat(rf_i) == 0 %Check for RAT/Dependency
            rs(rs_i, 4 + i) = rf(rf_i) %Update Reservation Station directly from RF
          else
            rs(rs_i, 2 + i) = rat(rf_i) %Update Reservation Station from RAT
          endif  
        endfor
        rat(iq(1,2)+1) = rs_i; %Update RAT with output Register
        issued = [1 rs_i]
      endif

    case {2, 3} %Multiply%%%%%%%%%%%%%%%
      for i =4:5 %Check & Choose Reservation Station
        if rs(i,1) == 0
          rs_i = i; %Now Busy
          break
        endif
      endfor
      if rs_i != 0 %Update Selected Reservation Station
        rs(rs_i,1) = 1; %Now Busy
        rs(rs_i, 2) = iq(1,1) %OP Code
        for i = 1:2 %Update Operands
          rf_i = iq(1,2+i) + 1
          if rat(rf_i) == 0 %Check for RAT/Dependency
            rs(rs_i, 5 + i) = rf(rf_i) %Update Reservation Station directly from RF
          else
            rs(rs_i, 3 + i) = rat(rf_i) %Update Reservation Station from RAT
          endif  
        endfor
        rat(iq(1,2)+1) = rs_i; %Update RAT with output Register
        issued = [1 rs_i]
      endif
  endswitch  
  rs_new = rs;
  rat_new = rat;
  iq_new = iq;
endfunction