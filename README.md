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