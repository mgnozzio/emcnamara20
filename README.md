# emcnamara20

### Grade for Laundry Sorter Lab
Criterion | Points
--- | ---
Generates a new color swatch only if previous one placed correctly | 0/2
Swatch displayed in/returns to the correct initial position | 2/2
Updates num correct and incorrect appropriately | 2/2
Drags swatch properly | 2/2
Appropriate behavior if user does unexpected things | 1/2
EC: Does not update counts if user misses all baskets | +1

Notes: You need to move the call to setColor inside the if statements, so as to change
the color only when the user guesses correctly.  Also, your program does not register
correct guesses unless the mouse ends up inside the basket (even if the majority of
the clothing item is there).  Instead of checking to see if the baskets contain the
mouse location, you should check to see if they overlap with the clothing itme.  
In terms of style, class names start with capitals -- method names and variables should 
always start with lowercase (e.g. GetColor should be getColor).  Also, you should avoid 
using instance variables when local ones will suffice (e.g. you don't need the 
white/dark/color labels after you create them).   

#### Total: 8/10

### Grade for Magnets Lab
Criterion | Points
--- | ---
Drawing magnets correctly at startup | 1/1
Dragging a magnet | 1/1
Ability to move either magnet | 1/1
Moving a magnet to the right place when attracted | 1/1
On attraction, moving the magnet not pointed to | 1/1
Flipping a magnet | 1/1
Attracting and repelling at the right times | 1/1
No other problems | 1/1
Style | 1/1

#### Total: 9/9

### Grade for Frogger Lab
Criterion | Points
--- | ---
Frog begins in correct initial position | 1/1
Frog jumps in response to clicks | 1/1
Frog jumps correct distance | 1/1
Frog dies when run over | 1/1
Frog says "Ouch" when killed | 1/1
Frog reincarnates on click | 0.5/1
Lane repeatedly generates vehicles | 1/1
Vehicles move smoothly | 1/1
Vehicles are appropriately spaced | 1/1
Vehicles get removed from canvas | 1/1
EC 1:  Lanes move in opposite directions | 1/1
EC 2:  Different cars in a single lane | 1/1

Notes:  Per the lab instructions, the reincarnation should only occur if the click is 
below the highway.  

#### Total: 11.5/10