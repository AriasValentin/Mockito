package mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class SumarTest {

    @InjectMocks
    private Sumar sumar;

    @Mock
    private ValidateNumber validateNumber;
    @Mock
    private Print print;
    @Captor
    private ArgumentCaptor<Integer> captor;

    @Spy
    List<String> spyList = new ArrayList<>();
    @Mock
    List<String> mockList = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addTest() {
        when(validateNumber.checkNumber(3)).thenReturn(false);
        boolean checkNumber = validateNumber.checkNumber(3);
        assertEquals(false, checkNumber);
    }

    @Test
    public void addMockException() {
        when(validateNumber.checkNumber(0)).thenThrow(new ArithmeticException("NO se puede por 0."));
        Exception exception = null;
        try {
            validateNumber.checkZero(0);

        } catch (ArithmeticException e) {
            exception = e;

        }
        assertNotNull(exception);
    }

    @Test
    public void addRealMethod() {
        when(validateNumber.checkNumber(3)).thenCallRealMethod();
        assertEquals(true, validateNumber.checkNumber(3));

        when(validateNumber.checkNumber("3")).thenCallRealMethod();
        assertEquals(false, validateNumber.checkNumber("3"));

    }

    @Test
    public void sumarDoubleToIntAnswerTest() {

        Answer<Integer> answer = new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {
                return 7;
            }
        };
        when(validateNumber.doubleToInt(7.7)).then(answer);
        assertEquals(14, sumar.sumarInt(7.7));
    }

    //ARRANGE --> organizar todo lo que queremos testear.
    //ACT
    //Assert

    //Given
    //When
    //Then

    @Test
    public void patternTest() {
        //Arrange
        when(validateNumber.checkNumber(4)).thenReturn(true);
        when(validateNumber.checkNumber(5)).thenReturn(true);
        //Act
        int result = sumar.sumar(4, 5);
        //Assert
        assertEquals(9, result);
    }

    @Test
    public void patternBDDTest() {
        //Given
        given(validateNumber.checkNumber(4)).willReturn(true);
        given(validateNumber.checkNumber(5)).willReturn(true);
        //When
        int result = sumar.sumar(4, 5);
        //Then
        assertEquals(9, result);
    }

    @Test
    public void argumentMatcher() {

        //Given
        given(validateNumber.checkNumber(anyInt())).willReturn(true);
        given(validateNumber.checkNumber(5)).willReturn(true);
        //When
        int result = sumar.sumar(4, 5);
        //Then
        assertEquals(9, result);

    }

    @Test
    public void sumarPrintTest() {

        //given
        given(validateNumber.checkNumber(4)).willReturn(true);
        given(validateNumber.checkNumber(5)).willReturn(true);
        //when
        sumar.sumarPrint(4, 5);
        //then
//        verify(validateNumber).checkNumber(4);
        verify(validateNumber, times(2)).checkNumber(4);
    }

    @Test
    public void sumarPrintTest2() {

        //given
        given(validateNumber.checkNumber(4)).willReturn(true);
        given(validateNumber.checkNumber(5)).willReturn(true);
        //when
        sumar.sumarPrint(4, 5);
        //then
        verify(validateNumber, never()).checkNumber(99);
        verify(validateNumber, atLeast(1)).checkNumber(4);
        verify(validateNumber, atMost(3)).checkNumber(4);
        verify(print).showMessage(9);
    }

    @Test
    public void captorTest() {
        given(validateNumber.checkNumber(4)).willReturn(true);
        given(validateNumber.checkNumber(5)).willReturn(true);
        //when
        sumar.sumarPrint(4, 5);
        //then
        verify(print).showMessage(captor.capture());
        assertEquals(captor.getValue().intValue(), 9);

    }

    @Test
    public void mockTest(){
        mockList.add("1");
        mockList.add("2");
        verify(mockList).add("1");
        verify(mockList).add("2");
        given(mockList.size()).willReturn(2);
        assertEquals(2,mockList.size());
    }

    @Test
    public void spyTest(){
        spyList.add("1");
        spyList.add("2");
        verify(spyList).add("1");
        verify(spyList).add("2");
        assertEquals(2,spyList.size());
    }
}