package mockito;


import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.transform.impl.AccessFieldTransformer;

public class WebService {

    public void login(String user, String password, Callback callback){
        if (checkLogin(user,password)){
            callback.onSuccess("SUCCESS");
        }
        else {
            callback.onFail("ERROR");
        }
    }

    public boolean checkLogin(String user,String password){
        if (user.equals("Alberto") && password.equals("1234")){
            return true;
        }
        return false;
    }
}
