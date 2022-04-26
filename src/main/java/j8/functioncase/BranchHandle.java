package j8.functioncase;

/**
 * @author Milo on 2021/12/13.
 * @description
 */
@FunctionalInterface
public interface BranchHandle {

    void trueOrFalseHandle(Runnable trueHandle, Runnable falseHandle);

}
