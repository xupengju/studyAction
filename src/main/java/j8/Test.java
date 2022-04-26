package j8;

/**
 * @author Milo on 2021/6/2.
 * @description
 */

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorBigInt;
import com.googlecode.aviator.runtime.type.AviatorObject;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

;


public class Test {
    static {
        //注册函数
        AviatorEvaluator.addFunction(new MinFunction());
    }

    public static void main(String[] args) {



        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");

        try {
            System.out.println(sdf.parse("2021年12月12日"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(sdf.parse("2021年2月12日"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(StringUtils.isEmpty(null));
        System.out.println(StringUtils.isBlank(null));
        System.out.println(StringUtils.isBlank(" "));
        System.out.println(StringUtils.isEmpty(" "));


        int index = 0;
        index = index + 1;
        System.out.println(index);  // 输出 1

        int j = 0;
        j++;
        System.out.println(j);  // 输出 1

        int z = 0;
        // z++ 先使用后自增
        System.out.println(z++);  // 输出0

        int c = 0;
        // ++c 先自增后使用
        System.out.println(++c);  // 输出 1


        // 升序打印10(包含) 以内的数字
        for (int i = 0; i <= 10; i++) {
            System.out.println(i);
        }

        // 练习: 降序打印10(包含) 以内的数字 ??

        // 输出 10(包含) 以内的偶数
        for (int i = 0; i <= 10; i++) {
            // 取余为 0 则为偶数
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }

        // 练习: 输出 10(包含) 以内的奇数  ??

        // 声明一个 long

        // 声明一个 int

        // 声明一个  short

        // 声明一个  byte

        // 声明一个 char

        // 声明一个  boolean

        // 声明一个 float

        // 声明一个 double

        // 按顺序打印字符串  1  2  3  4

        // 声明一个int变量 age ,用于 if 判断是否大于 18 输出字符串  "成年"   "未成年"

        // 声明一个int变量 cs, 用于 switch case 判断是 0 还是1 , 输出  "000"   "111"


        Map<String, Object> sourceMapItem = new HashMap<String, Object>();
//        sourceMapItem.put("pt", "121");
//        sourceMapItem.put("ab", "是");
//        sourceMapItem.put("xy", "xyz");
//        sourceMapItem.put("int1", 135);
//        sourceMapItem.put("int2", 68);
//        sourceMapItem.put("decimal2", 19.83);
//        sourceMapItem.put("mydate", "2020-10-10 28:35:00");
//        sourceMapItem.put("value", 999);
//        sourceMapItem.put("leaseTerm", "6");
        sourceMapItem.put("ptr", "1.1");
        sourceMapItem.put("hasMarketInTwoKm", "200");
        sourceMapItem.put("stallSize", "0");
        sourceMapItem.put("percent", "1");

        //sourceMapItem.put("mail", "x12.com");
//
        String expStr = "marketName != ''";
        Object result;
//        result = AviatorEvaluator.execute(expStr, sourceMapItem);
//        System.out.println(expStr + " ---  " + result);
//        //逻辑与 + 简单表达式
//        expStr = "pt == 'mi' && ab == 'abc' && int1 > 100 && decimal2 < 20.50";
//        result = AviatorEvaluator.execute(expStr, sourceMapItem);
//        System.out.println(expStr + " ---  " + result);
//
//
//        //逻辑与或组合 [0-9]+(\.[0-9]{2})?
//        sourceMapItem.put("decimal2", 19.83);
//        expStr = "str(decimal2)=~/(^[0-9]+(\\.[0-9]{2})?$)/ && decimal2 >= 0 && decimal2 < 100";
//        result = AviatorEvaluator.execute(expStr, sourceMapItem);
//        System.out.println(expStr + " ---  " + result);
//        //三目运算
//        expStr = "pt == 'mi1' ? ab == 'ab' : ab == 'abc'";
//        result = AviatorEvaluator.execute(expStr, sourceMapItem);
//        System.out.println(expStr + " ---  " + result);
//        //函数
//        expStr = "pt != 'mi1' && string.length(xy) >= 5 ";
//        result = AviatorEvaluator.execute(expStr, sourceMapItem);
//        System.out.println(expStr + " ---  " + result);
//        //自定义函数
//        expStr = "pt == 'mi1' || myMin(int2 , int1) > 10 ";
//        result = AviatorEvaluator.execute(expStr, sourceMapItem);
//        System.out.println(expStr + " ---  " + result);
//        // "'killme2008'=~/([\\w0-8]+@\\w+[\\.\\w+]+)/ "
//        // ^$
//        expStr ="mail=~/([\\w0-8]+@\\w+[\\.\\w+]+)/ ";
//        result = AviatorEvaluator.execute(expStr, sourceMapItem);
//        System.out.println(expStr + "---  :" + result);
//        //expStr = "ptr=~/[^\\d{n}]$/";
//        // =~/([\\w0-8]+@\\w+[\\.\\w+]+)/ /\d+/
//        expStr = "ptr != nil && ptr=~/([1-9]\\d*\\.?\\d*)|(0\\.\\d*[1-9])/";
//
//        result = AviatorEvaluator.execute(expStr, sourceMapItem);
//        System.out.println(expStr + "---  :" + result);
//percent == nil || percent == '' || (percent != nil && percent=~/([1-9]\d*\.?\d*)|(0\.\d*[1-9])/) expression :{percent=0} normalExecuteResult :false
        Map<String, Object> objectObjectHashMap = new HashMap<String, Object>();
        objectObjectHashMap.put("rentNormal", "23");
        String expriess = "rentNormal != nil && rentNormal != '' && (rentNormal != nil && rentNormal=~/([1-9]\\d*\\.?\\d*)|(0\\.\\d*[1-9])/)";

        result = AviatorEvaluator.execute(expriess, objectObjectHashMap);
        System.out.println(expriess + "---  :" + result);

        String exx = "hasMarketInTwoKm == '200' || stallSize=~/([1-9]\\d*\\.?\\d*)|(0\\.\\d*[1-9])/";
        result = AviatorEvaluator.execute(exx, sourceMapItem);
        System.out.println(exx + "---  :" + result);

        exx = "percent == nil || percent == '' || (percent != nil && percent=~/([0-9]\\d*\\.?\\d*)|(0\\.\\d*[1-9])/)";
        result = AviatorEvaluator.execute(exx, sourceMapItem);
        System.out.println(exx + "---  :" + result);
        exx = "(percent=~/([0-9]\\d*\\.?\\d*)|(0\\.\\d*[1-9])/)";
        result = AviatorEvaluator.execute(exx, sourceMapItem);
        System.out.println(exx + "---  :" + result);
//        expStr ="ab =='是' || ab == '否'";
//        result = AviatorEvaluator.execute(expStr, sourceMapItem);
//        System.out.println(expStr + "---  :" + result);
//
//        expStr ="leaseTerm != nil && leaseTerm != ''";
//        result = AviatorEvaluator.execute(expStr, sourceMapItem);
//        System.out.println(expStr + "---  :" + result);

        sourceMapItem.put("wuwei", "0.33");
        sourceMapItem.put("zhengshu", "0");

        exx = "wuwei == nil || wuwei == '' || wuwei=~/([0-9]\\d*)|([0-9]\\d*\\.\\d{0,2})/";
        result = AviatorEvaluator.execute(exx, sourceMapItem);
        System.out.println(exx + "---  :" + result);

        exx = "(zhengshu=~/([0-9]\\d*)/)";
        result = AviatorEvaluator.execute(exx, sourceMapItem);
        System.out.println(exx + "---  :" + result);
        //  2    %s == nil || %s == '' || %s=~/([0-9]\d*)|([0-9]\d*\.\d{0,2})/

        //  5    %s == nil || %s == '' || %s~/([0-9]\d*)|([0-9]\d*\.\d{0,5})/

        // 0 %s == nil || %s == '' || %s=~/([0-9]\d*)/)
        sourceMapItem.put("principal", "\"\"");
        exx = "principal != nil && principal != '' && principal != \"\"";
        result = AviatorEvaluator.execute(exx, sourceMapItem);
        System.out.println(exx + "---  :" + result);
//        List<String> resultSet = JsonPath.read(json, "$.scanInfo.proceedsAnalysis.breakevenAnalysisList[*]");
//        System.out.println(resultSet);
        sourceMapItem.put("rentRate", "991.00");
        exx = "double(rentRate) <= 100";
        result = AviatorEvaluator.execute(exx, sourceMapItem);
        System.out.println(exx + "---  :" + result);
        sourceMapItem.put("day1", "2021-06-21");
        sourceMapItem.put("day2", "2021-06-23");
        //
        exx = "string_to_date(day1,'yyyy-MM-dd') <= string_to_date(day2,'yyyy-MM-dd')";
        result = AviatorEvaluator.execute(exx, sourceMapItem);
        System.out.println(exx + "---  :" + result);

        sourceMapItem.put("url", "https://yxcc-image-1255613256.file.myqcloud.com/0/20210626175003429R6c5zsDi.jpg");
        exx = "string.indexOf(url,'file.myqcloud.com') > 0";
        result = AviatorEvaluator.execute(exx, sourceMapItem);
        System.out.println(exx + "---  :" + result);


        sourceMapItem.put("sall", "123");
        exx = "sall != nil && sall != '' && sall=~/([0-9]\\d*)/";
        result = AviatorEvaluator.execute(exx, sourceMapItem);
        System.out.println(exx + "---  :" + result);

        StringBuilder ss = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            ss.append(ThreadLocalRandom.current().nextInt(100));
            ss.append(",");
        }

        System.out.println(ss);
    }

    static class MinFunction extends AbstractFunction {
        @Override
        public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
            Number left = FunctionUtils.getNumberValue(arg1, env);
            Number right = FunctionUtils.getNumberValue(arg2, env);
            return new AviatorBigInt(Math.min(left.doubleValue(), right.doubleValue()));
        }

        @Override
        public String getName() {
            return "myMin";
        }
    }

//    static void runAsyncExample() {
//        CompletableFuture cf = CompletableFuture.runAsync(() -> {
//            assertTrue(Thread.currentThread().isDaemon());
//            randomSleep();
//        });
//        assertFalse(cf.isDone());
//        sleepEnough();
//        assertTrue(cf.isDone());
//    }

}
