package j8.functioncase;

/**
 * @author Milo on 2021/12/13.
 * @description
 */
public class VUtilTest {

    public static void main(String[] args) {
        BranchHandle aTrue = VUtil.isTrue(false);
        aTrue.trueOrFalseHandle(() ->{
            System.out.println("true");
        },() ->{
            System.out.println("false");
        });

        VUtil.orElseHandler("aiyawocoa").presentOrElseHandle(System.out::println,()->{
            System.out.println("空字符串");
        });
    }
}
