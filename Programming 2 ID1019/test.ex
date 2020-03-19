defmodule Test do
def product_claues(0, _) do 0 end 
def product_claues(m,n) do
    product_claues(m-1, n) + n
end

def product(m, n) do
    if m == 0 do 0 
    else product(m-1, n) + n       
    end
end

def product_case(m, n) do
    case m do
    0 -> product_case(m, n)
    _ -> product_case(m-1, n)
     end
    end
    


def exp(x, n) do
    #case exp(x, 0) do 1 end
    #case exp(x, 1) do x end 
    #case exp()
    cond do
    n==0 ->
    1
    n==1 ->
    x
    (rem(n,2)== 0) ->
    exp(x,div(n,2))*exp(x,div(n,2)) 
    true->
    exp(x, n-1)*x  
end
end
end


