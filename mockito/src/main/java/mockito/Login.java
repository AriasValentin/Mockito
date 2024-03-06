package mockito;

import javax.security.auth.callback.Callback;

public class Login {

    public WebService webService;
    public boolean isLogin;

    public Login(WebService webService){
        this.webService = webService;
        isLogin = false;

    }

    public void doLogin(){
        webService.login("Alberto", "12345", new Callback() {
        });

    }

}
