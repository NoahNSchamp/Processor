function [new_rs new_eu dispatched] = Dispatch(rs, e_unit, rs_issue, n_cc)
  %(0: add; 1:sub; 2: multiply; 3: divide)
  dispatched = [0 0] %Dispatched T/F, RS
  rs_i = 0;
  rs_queue = zeros(1,5);
  j =0;
  for i = [3 2 1 5 4] %Checks is RS is ready for Dispatch, Increasing Priority
    j += 1;
    if (rs(i, 3) == 0) && (rs(i, 4) == 0) && (rs_issue != n_cc)
      rs_queue(j) = i;
      rs_i = i;
    endif
  endfor
  for i = 5:-1:1
    rs_i = rs_queue(i);
    if (rs_i != 0)
      if (((rs(rs_i, 2) == 2 || rs(rs_i, 2) == 3) && e_unit(2, 1) == 0) || ((rs(rs_i, 2) == 0 || rs(rs_i, 2) == 1) && e_unit(1, 1) == 0))
        rs(rs_i, 7) = 1;
        dispatched = [1 rs_i];
        switch (rs(rs_i, 2))
          case {0, 1} %Add/Sub
            e_unit(1) = [1 rs(rs_i, 2) n_cc];
          case {2, 3} %Mul/Div
            e_unit(2) = [1 rs(rs_i, 2) n_cc];
        endswitch
        break
      endif
    endif
  endfor
  new_rs = rs;
  new_eu = e_unit;
endfunction