package com.zwx.service;

        import com.zwx.domain.CommonResult;
        import com.zwx.domain.Payment;
        import org.springframework.cloud.openfeign.FeignClient;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author coderZWX
 * @date 2020-12-27 22:47
 */
@FeignClient(value = "${service-url-feign.nacos-user-service}",fallback = PaymentServiceImp.class)
public interface PaymentService {

    @GetMapping("/paymentSQL/{id}")
    CommonResult<Payment> paymentSQL(@PathVariable("id")Long id);

}
