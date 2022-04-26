package design.chainofresponsibility;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Milo on 2021/9/2.
 * @description
 */
public class Server {
    private Map<String, String> users = new HashMap<>();
    private Middleware middleware;

    public void setMiddleware(Middleware middleware) {
        this.middleware = middleware;
    }

    public void register(String email,String password){
        users.put(email,password);
    }

    public boolean hasEmail(String email){
        return users.containsKey(email);
    }

    public boolean isValidPassword(String email, String password) {
        return users.get(email).equals(password);
    }

    public boolean logIn(String email, String password) {
        if (middleware.check(email, password)) {
            System.out.println("Authorization have been successful!");

            // Do something useful here for authorized users.

            return true;
        }
        return false;
    }
}
