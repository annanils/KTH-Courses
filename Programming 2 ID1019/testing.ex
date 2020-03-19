defmodule Tenta do 

def drop([], _) do [] end 

def drop([h|t], n) when n > 0 do 
      if rem(h, n) == 0  do 
        drop(t, n) 
        else 
        [h|drop(t, n)] 
    end 
end 

def drop1(list, n) do drop1(list, n, n) end 

def drop1([], _, _) do [] end 
def drop1([_|rest], 1, n) do 
    drop1(rest, n, n) 
    end  

def drop1([elem|rest], i, n) do 
    [elem| drop1(rest, i-1, n)]
    end

def rotate(list, n) do rotate(list,n, []) end 
def rotate([], _, _) do [] end 

def rotate(rest, 0, first) do 
    append(rest, reverse(first)) end 

def rotate([elem|rest], i, first) do
    rotate(rest, i-1, [elem|first]) end 
    
def hp35(list) do hp35(list, []) end 
def hp35([], [h]) do  h end   


def hp35([h|t], list2) do 
    cond do 
    h == :add ->
        [h1, h2|t1] = list2
        list2 = [h1 + h2| t1] 
        hp35(t,list2) 
    
    h == :sub ->
        [h1, h2|t1] = list2 
        list2 = [h2 - h1|t1] 
        hp35(t, list2)
     
    
    true -> 
    hp35(t, [h|list2]) 

  end 
end 

def nth(1, {:leaf, val}) do {:found, val} end 
def nth(n, {:leaf, _}) do {:cont, n-1} end 
def nth(n, {:node, left, right}) do 
    case nth(n, left) do 
        {:found, val} ->
            {:found, val} 

        {:cont, k} ->
            nth(k, right)
        end 
end 

def decode([{w,n}|t]) do decode([{w, n}|t], []) end  
def decode([], list2) do list2 end
def decode([{w, 0}|t], list2) do decode(t, list2) end 
def decode([{w, n}|t], list2) do
     
    [w | decode([{w, n-1}|t], list2)]

end 


#def zip(x, y) do zip(x, y, []) end 
def zip([], []) do [] end
def zip([h1|t1], [h2|t2]) do 

    [{h1, h2}|zip(t1, t2)]
    end



def balance(:nil) do {0, 0} end 
#def balance({:node, val, :nil, :nil}) do 1 end 

def balance({:node, val, left, right}) do 
    depth= count({:node, val, left, right})
    imbalance = imbalance({:node, val, left, right}) 
    {depth, imbalance}
    end


def count(:nil) do 0 end 
def count({:node, val, left, right}) do 
    p = 1 + count(left)
    q = 1 + count(right) 
    abs(max2(p,q))

    end 


def imbalance({:node, val, left, right}) do
    a = 1 + count(left)
    b = 1 + count(right) 
    imbalance = abs(a - b)
    end 

def max2(n, m) when n < m do m end
def max2(n, m) do n end 

#def abs2(e) when e < 0 do (e + 10) end 
#def abs2(e) do e end 

 
def reverse([]) do [] end 
def reverse([h|t]) do 
    reverse(t) ++ [h] end 

def append(x, y) do 
    case x do 
      [] -> 
       y 
      
      [h|t] -> 
      [h|append(t, y)]
    end 
end 

def pascal(1) do [1] end 
def pascal(n) do 
    r = count(pascal(n-1)) 
    [1|r]
    end 

def count([1]) do [1] end 
def count(list) do 
    [h1, h2|t] = list 
    [h1 + h2|count([h2|t])]
    end 

def eval({:mul, x, y}) do  
    eval(x) * eval(y)  
    end

def eval({:add, x, y}) do 
    eval(x) + eval(y) 
    end 
  
def eval({:neg, x}) do 
    - eval(x) 
    end 

def eval(x) do x end 
   
def gray(0) do [[]] end 
def gray(n) do 
list1 = gray(n-1) 
list2 = reverse(gray(n-1)) 
append(update(0, list1), update(1, list2))
end

def update(x, []) do  [] end   
def update(x, list) do
    [h|t] = list 
    case x do 
    0 -> 
    [append([0], h)|update(0, t)]
    1 ->
    [append([1], h)|update(1, t)]
  end
end 

def fizzbuzz(0) do [] end  
def fizzbuzz(n) do fizzbuzz(1, n+1, 1, 1) end 

def fizzbuzz(n, n, _, _) do [] end 

def fizzbuzz(i, n, 3, 5) do
    [:fizzbuzz|fizzbuzz(i+1, n, 1, 1)] end 

def fizzbuzz(i, n, 3, b) do 
    [:fizz|fizzbuzz(i+1, n, 1, b+1)] end 

def fizzbuzz(i, n, f, 5) do  
    [:buzz| fizzbuzz(i+1, n, f+1, 1)] end 
 
def fizzbuzz(i, n, f, b) do 
    [i|fizzbuzz(i+1, n, f+1, b+1)]

    end 

def once(list) do once(list, {0,0}) end 

def once([], res) do res end 
def once([h|t], {s, l}) do 
    once(t, {s + h, l+1}) 
    end 

def eval1(list) do eval1(list, []) end

def eval1([], [ack]) do ack end  
def eval1([h1|t1], list) do 
    case list do

        ['+', h2] -> eval1(t1,[h2 + h1])
        ['-', h2] -> eval1(t1,[h2 - h1])
        _ -> eval1(t1, [h1|list])
    end
end

def mirror(:nil) do :nil end 
def mirror({:node, _, left, right}) do
    {:node, mirror(right), mirror(left)}  
    end 


def work([], _) do {0, 0} end #slutet på listan (vi har ej någon delsumma än). 

def work([h|t], x) do 
    {a, c} = work(t, x) #a = delsumman till höger. läser från höger till vänster
    {a + h*exp(x,c), c+1} #
    end  

def exp(_, 0) do 1 end 
def exp(x, n) do 
    x*exp(x, n-1)
    end

def calc(poly, x) do 
    {a, b} = work(poly, x) 
    a
end 

def trans(_, _, []) do [] end 
def trans(x, y, list) do 
    [h|t] = list 
    cond do 
        h==x -> 
        trans(x, y, t) 

        h==y ->
        [h*y|trans(x,y,t)] 

        true->
        [h*y|trans(x,y,t)] 
    end
    end    

def sumsum(list) do sumsum(list, 0) end  
def sumsum([], s) do s end 
def sumsum([h|t], s) do 
    sumsum(t, h+s) 
    end

#def min({:node, val, left, right}) do min({:node, val, left, right}, :inf) end 
#def min(:nil, :inf) do :inf end 
#def min(:nil, val) do val end 
#def min({:node, val, left, right}, :inf)  do 
#    cond do
#    val < :inf -> 
#    min(left, min(right, val)) #går längst ned i mitt högra träd först för att kolla vad jag får, antingen :nil eller ett värde. sedan kan jag börja jämföra detta med mitt vänstra träd.
          
#    true -> min(left, min(right, :inf))
         
#    end 
#end

#def sumhej(:nil) do 0 end 




def sumhej(:nil) do 0 end
def sumhej({:node, val, left, right}) do
    val + sumhej(left) + sumhej(right)
    end


def reverse1(a) do reverse1(a, []) end 
def reverse1([], list) do list end 
def reverse1([h|t], b) do 
    reverse1(t, [h|b]) 
    end 

def append1(a, b) do 
    reverse1(reverse1(a), b)
    end

def dec([]) do [] end 
def dec([{w, 0}|t]) do dec(t) end 
def dec([{w, n}|t]) do 
    [w|dec([{w, n-1}|t])]
    end     

def zipp([], []) do [] end 
def zipp([h1|t1], [h2|t2]) do 
    [{h1, h2}|zipp(t1, t2)] 
    end 

def traverse(:nil) do [] end 
def traverse({:node, val, left, right}) do
    traverse(left) ++ [val|traverse(right)]
    end


def better({:node, val, left, right}) do traverse2({:node, val, left, right}, []) end 
    

def traverse2(:nil, list) do list end 
def traverse2({:node, val, left, right}, list) do 
    traverse2(left, [val|traverse2(right, list)])
    end 

def insert(:nil, v) do {:node, v, :nil, :nil} end  

def insert({:node, val, left, right}, v) when v < val do 
    {:node, val, insert(left, v), right} 
    end
def insert({:node, val, left, right}, v) do 
    {:node, val, left, insert(right, v)}
    end

#def insert({:node, val, left, right}, val) do 
#    {:node, val, left, right}
#      end 


def freq(_, []) do [] end
#def freq(key, [{key, n}|t]) do [{key, n+1}|t] end 
def freq(key, [{w, n}|t]) do
    
    cond do 
    key == w ->

    [{w, n+1}|freq(key,t)] 

    true ->
    [{w, n}|freq(key, t)]
    end  
end

def fraq([]) do [] end
def fraq([h|t]) do 

    freq(h, [{h,0}|fraq(t)]) 
    
    end  
       

    

 

    

        
end

