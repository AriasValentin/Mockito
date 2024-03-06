package mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class SumarMockTest1 {

    private Sumar sumar;
    private ValidateNumber validateNumber;

    @BeforeEach
    public void setUp(){
        validateNumber = Mockito.mock(ValidateNumber.class);
        sumar = new Sumar(validateNumber);
    }

    @Test
    public void addTest(){
        sumar.sumar(3,2);
        Mockito.verify(validateNumber).checkNumber(3);
        Mockito.verify(validateNumber).checkNumber(5);
    }
}