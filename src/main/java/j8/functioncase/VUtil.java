package j8.functioncase;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Milo on 2021/12/13.
 * @description
 */
public class VUtil {

    public static BranchHandle isTrue(boolean flag) {
        return (trueHandler, falseHandler) -> {
            if (flag) {
                trueHandler.run();
            } else {
                falseHandler.run();
            }
        };
    }

    public static PresentOrElseHandler<?> orElseHandler(String str){
        return (consumer , runnable) ->{
            if (StringUtils.isBlank(str)){
                runnable.run();
            }else{
                consumer.accept(str);
            }
        };
    }
}
