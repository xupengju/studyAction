package javassist;

/**
 * 增强工具类
 * @author Milo on 2021/10/11.
 * @description
 */
public class ServiceUtils {
    public static void done() throws NotFoundException, CannotCompileException {
        //获取默认的类池
        ClassPool classPool = ClassPool.getDefault();

        //通过全限定类名从类池获取对应需要增强的类
        CtClass base = classPool.getOrNull("javassist.BaseService");

        if (base  == null){
            System.out.println("can not found");
            return;
        }

        //通过方法getDeclaredMethod和类中需要增强的方法名字得到CtMethod类型的方法抽象
        CtMethod basemethod = base.getDeclaredMethod("basePrint");

        StringBuffer sbf = new StringBuffer();
        sbf.append("{");
        sbf.append("javassist.ExBaseService.exPrint($1);");
        sbf.append("}");

        //进行增强,调用之前增强
        basemethod.insertBefore(sbf.toString());

        StringBuffer sbf2 = new StringBuffer();
        sbf2.append("{");
        sbf2.append("javassist.ExBaseService.exPrintL($1);");
        sbf2.append("}");

        //进行增强,调用需要增强方法之后增强
        basemethod.insertAfter(sbf2.toString());
        //替换增强后的字节码
        base.toClass();
    }
}
