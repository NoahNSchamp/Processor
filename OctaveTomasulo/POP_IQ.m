function [x] = POP_IQ(IQ)
 
  for i = 1:length(IQ)-1
    IQ(i,:) = IQ(i+1,:);
  endfor
  IQ(length(IQ),:) = [9, 0 0 0];
  x = IQ;
endfunction
