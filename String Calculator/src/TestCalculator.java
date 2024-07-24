import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
//	Task - 1: Create a simple String calculator with a method signature:
	//	———————————————
	//	int Add(string numbers)
	//	———————————————
	// TODO: for empty string it will return zero

@Test
public class TestCalculator {
    private Calculator calculator;
    @BeforeTest
    public void init()
    {
        calculator=new Calculator();
    }
    // An empty string returns zero
    public void emptyStringReturnsZero() throws Exception {
        assertEquals(calculator.calculate(""),0);
    }
    // A single number returns the value
    public void singleValueIsReplied() throws Exception {
     assertEquals(calculator.calculate("1"),1);
    }
    //Two numbers, comma delimited, returns the sum
    public void twoNumbersCommaDelimitedReturnSum() throws Exception {
        assertEquals(calculator.calculate("1,2"), 3);
    }
    //Two numbers, newline delimited, returns the sum
 public void twoNumbersNewLineDelimitedReturnSum() throws Exception {
        assertEquals(calculator.calculate("1\n2"),3);
 }
    //Three numbers, delimited either way, returns the sum
 public void threeNumbersNewLineDelimitedReturnSum() throws Exception {
        assertEquals(calculator.calculate("1,2,3"),6);
 }
    //Negative numbers throw an exception
 @Test(expectedExceptions = Exception.class)
    public void negativeInputReturnsException() throws Exception {
        calculator.calculate("-1");
 }
    // Numbers greater than 1000 are ignored
 public void ignoreNumbersGreaterThan1000() throws Exception {
        assertEquals(calculator.calculate("10,10,1001"),20);
 }
}
