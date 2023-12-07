function [new_rs new_rf new_rat new_e_unit broadcasted] = Broadcast(rs, rf, rat, e_unit, n_cc, eu_time)
  %(0: add; 1:sub; 2: multiply; 3: divide)
  broadcasted = [0 0 0]; %Broadcast T/F, RS, Sum/Product
  eu_i = 0;
  for i = [1 2] %Checks if EU is ready for Broadcast, Increasing Priority
    if n_cc - e_unit(i, 3) >= eu_time(e_unit(i,2)+1)
      eu_i = i;
    endif
  endfor
 
  if eu_i != 0 %Eligible Broadcasting
    %Arithmetic
    rs_i = e_unit(eu_i, 4);
    switch (e_unit(eu_i, 2))
      case 0 %Add
        broadcasted(3) = int8( rs(rs_i, 5) + rs(rs_i, 6));
      case 1 %Sub
        broadcasted(3) = int8( rs(rs_i, 5) - rs(rs_i, 6));
      case 2 %Mul
        broadcasted(3) = int8( rs(rs_i, 5) * rs(rs_i, 6));
      case 3 %Div
        broadcasted(3) = int8( rs(rs_i, 5) / rs(rs_i, 6));
    endswitch
    broadcasted(1) = 1; %Valid Broadcast
    broadcasted(2) = rs_i; %Broadcast RS Tag
    
    %Updating RS, RAT, RF
    for i = 1:length(rat)
      if rat(i) == rs_i %Find RS Tag in RAT
        rf_i = i;%Save Index of obsolete Tag and Register
        rat(i) = 0;%Rrmove RS Tag
        rf(rf_i) = broadcasted(3); %Update RF
        for j = 1:5
          for k = 3:4
            if rs(j,k) == rs_i
              rs(j,k) = 0;
              rs(j,k+2) = rf(rf_i);
            endif
          endfor
        endfor
        break
      endif
    endfor
    
    rs(rs_i, :) = zeros(1, length(rs)); %Free RS
    e_unit(eu_i, :) = zeros(1, length(e_unit)); %Free EU
    
  endif
  new_rs = rs;
  new_rf = rf;
  new_rat = rat;
  new_e_unit = e_unit;
endfunction