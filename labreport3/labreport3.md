# Lab Report 3 - Bugs and Commands  
## Part 1 - Bugs  
I chose to test the method reverseInPlace().  

```java
@Test
public void testReverseInPlace1() {
  int[] input = { 4 };
  ArrayExamples.reverseInPlace(input);
  assertArrayEquals(new int[]{ 4 }, input);
}

@Test 
public void testReverseInPlace2() {
  int[] input = { 6,5,4,3,2,1 };
  ArrayExamples.reverseInPlace(input);
  assertArrayEquals(new int[]{ 1,2,3,4,5,6 }, input);
}
```   
The JUnit test `testReverseInPlace2` outputs a failure with the input `{ 6,5,4,3,2,1 }`.  
The input `{ 4 }` in `testReverseInPlace1` however doesn't induce a failure.  

![failure-output](failure-output.png)  

The code that induces a failure for a test:  
```java
static void reverseInPlace(int[] arr) {
  for(int i = 0; i < arr.length; i += 1) {
    arr[i] = arr[arr.length - i - 1];
  }
}
```
The fixed code that doesn't induce a failure:  
```java
static void reverseInPlace(int[] arr) {
  int temp = 0;
  for(int i = 0; i < arr.length/2; i += 1) {
    temp = arr[i];
    arr[i] = arr[arr.length - i - 1];
    arr[arr.length - i - 1] = temp;
  }
}
```
![no-failure-output](no-failure-output.png)  

In the old code, `arr[i]` wasn't stored for safekeeping, so `arr[arr.length - i - 1]` remained the same when it should have the old value of `arr[i]`. Adding the variable `int temp` and adding `arr[arr.length - i - 1] = temp;` at the end of the loop addresses this issue since `arr[arr.length - i - 1]` will have the correct value. Since the code looks at two elements with each iteration of the for loop, the index will go out of bounds, so setting the for loop condition as `i < arr.length/2` addresses this issue.  

## Part 2 - Researching Commands   
I choose the look at four alternate command-line options of the command `less`. I used the information outputted from `man less` as reference.  

### One interesting command line option is `-p`.

`$less -p "What If?" technical/911report/chapter-1.txt`

```
What If?

    NORAD officials have maintained consistently that had the passengers not caused United 93 to crash, the military would have prevented it from reaching Washington, D.C. That conclusion is based on a version of events that we now know is incorrect. The Langley fighters were not scrambled in response to United 93; NORAD did not have 47 minutes to intercept the flight; NORAD did not even know the plane was hijacked until after it had crashed. It is appropriate, therefore, to reconsider whether United 93 would have been intercepted.

    Had it not crashed in Pennsylvania at 10:03, we estimate that United 93 could not have reached Washington any earlier than 10:13, and probably would have arrived before 10:23. There was only one set of fighters circling Washington during that time frame-the Langley F-16s. They were armed and under NORAD's control. After NEADS learned of the hijacking at 10:07, NORAD would have had from 6 to 16 minutes to locate the flight, receive authorization to shoot it down, and communicate the order to the pilots, who (in the same span) would have had to authenticate the order, intercept the flight, and execute the order.

    At that point in time, the Langley pilots did not know the threat they were facing, did not know where United 93 was located, and did not have shootdown authorization.

    First, the Langley pilots were never briefed about the reason they were scrambled. As the lead pilot explained, "I reverted to the Russian threat. . . . I'm thinking cruise missile threat from the sea. You know you look down and see the Pentagon burning and I thought the bastards snuck one by us. . . . [Y]ou couldn't see any airplanes, and no one told us anything." The pilots knew their mission was to divert aircraft, but did not know that the threat came from hijacked airliners.

    Second, NEADS did not have accurate information on the location of United 93. Presumably FAA would have provided such information, but we do not know how long that would have taken, nor how long it would have taken NEADS to locate the target.
```
It jumps to the "What If" section of the first chapter of the report.  
 
`less -p "Abbreviations" technical/biomed/1468-6708-3-1.txt`

```
Abbreviations
        BMI Body mass index
        CESD Center for Epidemiologic Studies Depression
        Scale
        CHS Cardiovascular Health Study
        EVGFP Is your health excellent, very good, good, fair or
        poor?
        QALY Quality-adjusted life years
        YHL Years of healthy life
        YOL Years of life
```
It jumps to the "Abbreviations" section of the paper.  

`-p pattern` tells `less` to start at the first occurence of `pattern` in the file we want to look at. This is useful because if we want to find a certain section of a file, we won't have to manually look through the file to find it.  

### An alternate way to use `less` is to have it look at multiple files.   
`less biomed/1468-6708-3-1.txt biomed/1468-6708-3-3.txt`  
It will show the contents of `biomed/1468-6708-3-1.txt` like it would if you just used `less biomed/1468-6708-3-1.txt`, but at the bottom, it displays
```
biomed/1468-6708-3-1.txt (file 1 of 2)
```  
If we enter `:n`, `less` will display `biomed/1468-6708-3-3.txt`, and at the bottom it will display 
```
biomed/1468-6708-3-3.txt (file 2 of 2)
```  
If we enter `:p`, it will go back to the previous file and again display at the bottom 
```
biomed/1468-6708-3-1.txt (file 1 of 2)
```
Another example,  
`less 911report/chapter-1.txt 911report/chapter-2.txt 911report/chapter-3.txt`  
and at the bottom it will show  
```
911report/chapter-1.txt (file 1 of 3)
```

This is useful because we may want to look at multiple files at a time, and tt also saves our position in a file if we decide to look at another file, which could be helpful.  

### Setting bookmarks  
`less biomed/1468-6708-3-1.txt`  
I'm at line that reads "Body mass index" and want to bookmark it, so I enter `m`, and it displays   
```
set mark:
```
Then I enter `b` as the bookmark name.  
Now I am somewhere else in the file 
```
Conclusion
Recommendations for desirable weight have been...
```
I want to go back to my bookmark, so I enter `'`, and it displays
```
goto mark:
```
I enter 'b', and it brings me back to section that I had bookmarked.  
```
Body mass index
BMI was calculated as measured weight in kilograms...
```
Now I want to bookmark the "Discussion" section of the paper, so I enter `m` and then `d` as the name, and whenever I press `'` and then `d`, it will bring me back to that section  
```
Discussion
        
  Optimal weight and overweight...
```
This is useful because we may want to bookmark certain lines or sections of file to go back to later, and using `m` and `'` allows us to save and go back to the parts of the file we marked and named.  

### `+G` command-line option  
`less +G 911report/chapter-1.txt`  
```
  The details of what happened on the morning of September 11 are complex, but they play out a simple theme. NORAD and the FAA were unprepared for the type of attacks launched against the United States on September 11, 2001. They struggled, under difficult circumstances, to improvise a homeland defense against an unprecedented challenge they had never before encountered and had never trained to meet.

  At 10:02 that morning, an assistant to the mission crew commander at NORAD's Northeast Air Defense Sector in Rome, New York, was working with his colleagues on the floor of the command center. In a brief moment of reflection, he was recorded remarking that "This is a new type of war."

  He was, and is, right. But the conflict did not begin on 9/11. It had been publicly declared years earlier, most notably in a declaration faxed early in 1998 to an Arabic-language newspaper in London. Few Americans had noticed it. The fax had been sent from thousands of miles away by the followers of a Saudi exile gathered in one of the most remote and impoverished countries on earth.
```

`less +G biomed/1458-6708-3-1.txt`  
```
Abbreviations
BMI Body mass index
CESD Center for Epidemiologic Studies Depression
Scale
CHS Cardiovascular Health Study
EVGFP Is your health excellent, very good, good, fair or
poor?
QALY Quality-adjusted life years
YHL Years of healthy life
YOL Years of life
```
The `+G` command-line option tells `less` to start at the end of the file rather than the beginning. This is useful especially because we may want to go to the bottom of the file first and don't want to spend time scrolling all the way to the bottom, especially for a very long file.  




      
