package j8.functioncase;

import java.util.function.Consumer;

/**
 * @author Milo on 2021/12/13.
 * @description
 */
public interface PresentOrElseHandler <T>{

    void presentOrElseHandle(Consumer<? super T> action, Runnable emptyAction);

}
