package com.example.mybatisplusdemo.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.example.mybatisplusdemo.enmu.HttpStatusEnum;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 *  测试 nacos配置是否成功
 *
 * @author qinzh
 * @version 1.0
 * @date 2022/11/22 15:12
 */
@Data
@Slf4j
@RestController
@RequestMapping("config")
public class ConfigController {
    @NacosValue(value = "${spring.datasource.url}")
    private String url;
    @NacosValue(value = "${spring.datasource.username}")
    private String username;
    @NacosValue(value = "${spring.datasource.password}")
    private String password;

    @RequestMapping("/getConfig")
    public Map<String,Object> getConfig(){
        Map<String,Object> map = new HashMap<>();
        map.put("url",url);
        map.put("username",username);
        map.put("password",password);
        map.put(String.valueOf(HttpStatusEnum.SUCC_200.getCode()), HttpStatusEnum.getStatusByCode(HttpStatusEnum.SUCC_200.getCode()));
        return map;
    }
}
