package claroja.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(value = "provider")//和provider的spring.application.name字段保持一致, 并且注入容器
public interface ProviderClient {
    @GetMapping("/service")
    public String service();
}


