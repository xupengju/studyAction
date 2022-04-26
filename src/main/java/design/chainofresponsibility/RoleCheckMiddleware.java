package design.chainofresponsibility;

/**
 * 角色检查
 * @author Milo on 2021/9/2.
 * @description
 */
public class RoleCheckMiddleware extends Middleware {

    @Override
    public boolean check(String email, String password) {
        if (email.equals("admin@example.com")) {
            System.out.println("Hello, admin!");
            return true;
        }
        System.out.println("Hello, user!");
        return checkNext(email, password);
    }
}
