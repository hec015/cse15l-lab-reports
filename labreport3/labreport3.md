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

## Part 2 - Researching Commands   
