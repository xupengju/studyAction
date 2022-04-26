package design.chainofresponsibility;

/**
 * 账户检查
 * @author Milo on 2021/9/2.
 * @description
 */
public class UserExistsMiddleware extends Middleware{

    private Server server;


    public UserExistsMiddleware(Server server) {
        this.server = server;
    }
    @Override
    public boolean check(String email, String password) {
        if (!server.hasEmail(email)) {
            System.out.println("This email is not registered!");
            return false;
        }
        if (!server.isValidPassword(email, password)) {
            System.out.println("Wrong password!");
            return false;
        }
        return checkNext(email, password);
    }
}
