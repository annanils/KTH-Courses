defmodule Sorting do

#===========================#
#== Insertionsort ==#
#===========================#

def insert(e, []) do [e] end
def insert(e, [h|t]) when e<=h do [e,h|t] end
def insert(e, [h|t]) do [h|insert(e, t)] end


def isort(list) do isort(list, []) end #en orsorterad lista är en tom lista
def isort([], sorted) do sorted end
def isort([h|t], sorted) do isort(t, insert(h, sorted)) end


#============================#
#== Mergesort ==#
#============================#

def msort([]) do [] end #msort kommer att göra så att vi kan "lägga ihop" våra funktioner
def msort([x]) do [x] end
def msort(list) do  
    {list1, list2} = msplit(list, [], []) #kommer att resultera i en tuppel med två listor, som skickas in i msort för att splittas 
    merge(msort(list1), msort(list2)) #och sedan mergas ihop (sorteras på vägen upp)
end

def merge([], list2) do list2 end #merge sätter ihop våra listor (sorterar)
def merge(list1, []) do list1 end 
def merge([h1|list1], [h2|list2]) do
    if h1 < h2 do [h1| merge(list1, [h2|list2])]
    else [h2| merge([h1|list1], list2)] end #appendar elementen det sista funktionen gör, ej tail
end
         


def msplit([], list1, list2) do {list1, list2} end #har kommit till slutet/skickar in en tom lista 
def msplit([h|t], list1, list2) do msplit(t, [h|list2], list1) end #msplit är tailrekursiv, så när den kommit ned så har vi våra två listor som funktionen skickar tillbaka 

#=============================#
#== Quicksort ==#
#=============================#

def qsort([]) do [] end 
def qsort ([pivot|list]) do #delar upp listan i pivot och lista och skickar in i qsplit
    {small, large} = qsplit(pivot, list, [], []) #small är listan med elementen mindre än pivot, large är listan med elementen större än pivot
    small = qsort(small)
    large = qsort(large)
    append(small, [pivot | large]) # en lista med elemet mindre än pivot, samt en lista med pivot elementet och element större än pivot. (pivot elementet i mitten?)
    end 

def qsplit(_, [], small, large) do {small, large} end 
def qsplit(pivot, [h | t], small, large) do 
    if h < pivot do qsplit(pivot, t, [h|small], large)
    else qsplit(pivot, t, small, [h|large]) 
 end 
end 

def append(small, []) do small end
def append([], large) do large end  
def append([h|t], large) do [h| append(t, large)] 
end  

end



 