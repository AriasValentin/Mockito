package mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class SumarMockTest2 {

    //2da forma de mock con anotations.
    @InjectMocks
    private Sumar sumar;

    @Mock
    private ValidateNumber validateNumber;

    @BeforeEach
        public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addTest(){
        sumar.sumar(3,2);
        Mockito.verify(validateNumber).checkNumber(3);
    }



}