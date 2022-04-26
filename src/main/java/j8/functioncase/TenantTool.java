package j8.functioncase;

import com.sun.istack.internal.NotNull;

import java.util.function.Consumer;
import java.util.function.Function;

public class TenantTool {
    public static void tenantConsumer(String specTenantId, @NotNull Consumer<String> consumer){
        String tenantId = Extractor.getTenantId();
        try{
            Extractor.setTenantId(specTenantId);
            consumer.accept(specTenantId);
        } finally {
            Extractor.setTenantId(tenantId);
        }
    }

    public static Object tenantFunction(String specTenantId, @NotNull Function<String, Object> function){
        String tenantId = Extractor.getTenantId();
        try{
            Extractor.setTenantId(specTenantId);
            return function.apply(specTenantId);
        } finally {
            Extractor.setTenantId(tenantId);
        }
    }

    public static void main(String[] args) {
        TenantTool.tenantConsumer("zzww",System.out::println);
        TenantTool.tenantFunction("zzww",Extractor::work);
    }
}