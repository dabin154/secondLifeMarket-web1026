package com.secondLifeMarket.general.admin.manage.alipay;

import com.secondLifeMarket.general.admin.request.alipay.AlipayRequest;
import com.secondLifeMarket.general.admin.result.alipay.AlipayReturnResult;

public interface AlipayService {
    
    public Boolean checkParams();
    
    public AlipayReturnResult connectAlipay(AlipayRequest request);

}
