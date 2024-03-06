package mockito;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateNumberTest {

    private ValidateNumber validateNumber;

     @BeforeEach
    public void setUp(){
         validateNumber = new ValidateNumber();
     }
     @AfterEach
    public void tearDown(){
         validateNumber = null;
     }

     @Test
    public void checkTest(){
         assertEquals(true,validateNumber.checkNumber(5));
     }
    @Test
    public void checkNegativeTest(){
        assertEquals(false,validateNumber.checkNumber(-5));
    }
    @Test
    public void checkStringTest(){
        assertEquals(false,validateNumber.checkNumber("5"));
    }

    @Test
    public void checkZeroTest(){
         assertEquals(true,validateNumber.checkNumber(-5));
    }
    @Test
    public void checkZeroStringTest(){
        assertEquals(false,validateNumber.checkNumber("5"));

    }
    @Test
    public void checkZero0Test(){
       assertThrows(ArithmeticException.class,()->validateNumber.checkNumber(0));
    }

    @Test
    public void doubleToIntTest(){
         assertEquals(0,validateNumber.doubleToInt(9.999));
    }
    @Test
    public void doubleToIntErrorTest(){
        assertEquals(0,validateNumber.doubleToInt("9.999"));
    }


}