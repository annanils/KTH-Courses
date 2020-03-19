defmodule KV do 

#=======================#
#== Key-value tree ==#
#=======================#

def lookup(key, :nil) do :no end 
def lookup(key, {:node, key, val, left, right}) do {:ok, val} end 
def lookup(key, {:node, k, _, left, right}) when 
    key < k do lookup(key, left) 
    end 
def lookup(key, {:node, k, _, left, right}) do lookup(key, right) end 


def delete(key, {:node, key, _, :nil, :nil}) do :nil end 
def delete(key, {:node, key, _, :nil, right}) do right end  
def delete(key, {:node, key, _, left, :nil}) do left end 
def delete(key, {:node, key, _, left, right}) do 
    {k, val} = rightmost(left) #får tillbaka det högraste värdet. går först åt vänster 
    {:node, k, val, delete(k, left), right} 
     
end 

def rightmost({:node, key, val, _, :nil}) do {key, val} end 
def rightmost({:node, key, val, _, right}) do rightmost(right) end 

def delete(key, {:node, k, v, left, right}) when key < k do 
    {:node, k, v, delete(key, left), right} end 

def delete(key, {:node, k, v, left, right}) do 
    {:node, k, v, left, delete(key, right)} 
    end 

def modify(_, _, :nil) do :nil end 
def modify(key, val, {:node, key, _, left, right}) do 
    {:node, key, val, left, right} 
end 

def modify(key, val, {:node, k, v, left, right}) when key < k do 
    {:node, k, v, modify(key, v, left), right} 
    end 
def modify(key, val, {:node, k, v, left, right}) do 
    {:node, k, v, left, modify(key, val, right)} end 


def insert(key, val, :nil) do {:node, key, val, :nil, :nil} end 

def insert(key, v, {:node, key, val, left, right}) do 
    {:node, key, v, left, right}
    end 

def insert(key, val, {:node, k, v, left, right}) when key < k do 
    {:node, k, v, insert(key, val, left), right} 
    end 
def insert(key, val, {:node, k, v, left, right}) do {:node, k, v, left, insert(key, val, right)} end







end



