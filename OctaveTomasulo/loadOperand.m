1;
%function [rs_new rat_new] = loadOperand(rs, rat, rf, rs_i, rf_i, tag)
function loadOperand()
  rf_i = rf_i + 1
  if rat(rf_i) == 0 %Check for RAT/Dependency
    rs(rs_i, 5 + tag) = rf(rf_i)
  else
    rs(rs_i, 3 + tag) = rat(rf_i)
  endif
 % rs_new = rs;
 % rat_new = rat;
endfunction