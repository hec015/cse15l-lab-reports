# Lab Report 4 - Vim
## Log into ieng6  
I pressed the arrow up key `<up>` to get `ssh cs15lfa23eb@ieng6.ucsd.edu`, and then pressed `<enter>`. 
That command, which lets me log into ineng6, was one up my command history, so I was able to go back to it by pressing `<up>` once.  

![login](login.png) 

## Clone your fork of the repository from your Github account (using the SSH URL)
I typed `git clone ` and then pressed `<command>, v` to paste the SSH URL of my fork of lab7, and then I pressed `<enter>` to clone my fork onto ieng6.   

![clone](clone.png) 

## Run the tests, demonstrating that they fail  
I typed `cd lab7`, and pressed `<enter>`. Then I typed `bash t`, pressed `<tab>` to autocomplete it to `bash test.sh`, and then pressed `<enter>` to run the test.    
`<tab>` lets me type faster by making the shell complete what I want to type.  

![test1](test1.png)

## Edit the code file to fix the failing test   
I typed `vim L`, pressed `<tab>` to autocomplete it to `vim ListExamples`, typed `.j` before pressing `<tab>` to get `vim ListExamples.java`, and then pressed `<enter>`. 
Then I pressed these keys: `G, 6, k, r, 2, :, w, q, <enter>`. 

In Vim, `G` lets me jump to the last line, and `6` and `k` lets me go up 6 six lines to the line where I need to make the edit.  
`e` goes to the end of the word, 'index1', and `r, 2` replaces the character at the cursor, '1', with '2'. 
`:wq` then saves the edit and exits Vim.  

![vim](vim.png)  

## Run the tests, demonstrating that they now succeed   
I pressed `<up><up><enter>` to run the tests. `bash test.sh` was two up my command history, which is why I was able to use `<up><up>`.

![test2](test2.png)

## Commit and push the resulting change to your Github account  
I typed `git add L`, pressed `<tab>` to get `git add ListExamples.java`, and pressed `<enter>` to prepare my edit for a commit.
Then I typed `git com`, pressed `<tab>` to get `git commit`, and typed `-m "ok"` to get `git commit -m "ok"`, and then I pressed `<enter>` to commit the edit.  
I then typed `git push` to push the resulting change to my Github account.  

![git](git.png)
