package com.zwx.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author coderZWX
 * @date 2020-12-10 21:47
 */
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
