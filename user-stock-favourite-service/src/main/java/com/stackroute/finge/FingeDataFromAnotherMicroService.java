package com.stackroute.finge;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/*add @FeignClient annotation
 *
 */

@FeignClient(url = "http://localHost:8080", name = "AB")
public interface FingeDataFromAnotherMicroService {
    /*
     * Add @GetMapping This to get Data from another Microservice1
     */
    @GetMapping("/applicationName/funcationName")
    public Map getDataFromUserManagementService();

    /*
     * Add @GetMapping This to get Data from another Microservice1
     */
    @GetMapping("/applicationName/funcationName")
    public Map getDataFromSearchService();

}
