defmodule Lista do 

def nth(1, [r|_]) do r end
def nth(n, [_|t]) do nth(n-1, t) end #tail

def len([]) do 0 end 
def len([_h|t]) do 1 + len(t) end  #ej tailrekusriv

def sum([]) do 0 end 
def sum([h|t]) do h + sum(t) end #bryr oss om huvudet 

def duplicate([]) do [] end
def duplicate([h|t]) do [h,h|duplicate(t)] end

def add(x, []) do [x] end 
def add(x, [x|t]) do [x|t] end 
def add(x, [h|t]) do [h | add(x, t)] end #sparar undan ett huvud  

def remove(_, []) do [] end 
def remove(x, [h|t]) do
cond do
    x == h -> #huvud 
    remove(x, t) #jämför första elementet med alla andra element i listan
    true ->
    [h | remove(x, t)]
end
end
def preserve(x,[]) do [] end
def preserve(x, [h|t]) do 
cond do 
    x == h ->
    [h| preserve(x, t)]

    true ->
    preserve(x, t)
    end
end

def unique([]) do [] end 
def unique([x|t]) do
   [x|unique(remove(x,tail))] 
end

def reverse([]) do [] end  
def rev([], [h|t]) do ([h|t]) end
def rev([h|t], []) do rev(t, [h, []]) end 

def revrev([]) do [] end
def revrev([h|t]) do revrev(t) ++[h] end 








