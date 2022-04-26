package meione.action;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Milo on 2022/4/24.
 * @description
 */
@Data
public class ComplexOrderParamDTO extends ComplexParamDTO{

    private BigDecimal amount;

}
