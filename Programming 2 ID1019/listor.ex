defmodule Hej do

def sum1([]) do 0 end 
def sum1([n|t]) do 
    n + sum1(t) 
end 

def sum2([]) do 0 end 
def sum2([n|t]) do 
    s = sum2(t)
    n + s 
end 

def max(n, m) do
    if n < m do
        m
    else
        n
    end
end

def odd([]) do [] end 
def odd([h|t]) do 
    if rem(h, 2) == 1 do 
    [h|odd(t)]
    else  
    odd(t)
   end
end 

def even([]) do [] end 
def even([h|t]) do 
    if rem(h, 2) == 0 do
    [h|even(t)] 
    else 
    even(t)
  end
end  


def odd_n_even(l) do 
    odd = odd(l) 
    even = even(l)
    {odd, even} = {odd(l), even(l)}
    end

def odd_n_even([]) do {0, 0} end 
def odd_n_even([h|t]) do 
    {odd, even} = odd_n_even(t)
    if rem(h, 2) == 1 do 
    odd([h|odd(t)])
    else 
    even([h|even(t)])
  end     
end 

def odd_n_even(l) do 
    odd_n_even(l, [], []) end 

def odd_n_even([], odd, even) do {odd, even} end   
    
def odd__n_even([h|t], odd, even) do 
    if rem(h, 2) == 1 do 
    odd_n_even(t, [h|odd_n_even(t)], even)
    else 
    odd_n_even(t, odd, [h|odd_n_even(t)])
    end 

end
end
