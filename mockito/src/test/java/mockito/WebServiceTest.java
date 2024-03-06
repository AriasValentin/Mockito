package mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.cglib.proxy.Callback;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class WebServiceTest {

    private WebService webService;

    @Mock
    private Callback callback;

    @BeforeEach
    public void setUp(){
        webService = new WebService();
    }

    @Test
    public void checkLoginTest(){
        assertTrue(webService.checkLogin("Alberto","1234"));
    }
    @Test
    public void checkLoginErrorTest(){
        assertTrue(webService.checkLogin("Maria","AAA"));
    }

    @Test
    public void logTest(){
        assertFalse(webService.checkLogin("Alberto","1234"),callback);
        verify(callback).onSuccess("Usuario correcto");
    }

    @Test
    public void logErrorTest(){
        assertFalse(webService.checkLogin("Maria","AAA"),callback);
        verify(callback).onFail("Error");
    }
}