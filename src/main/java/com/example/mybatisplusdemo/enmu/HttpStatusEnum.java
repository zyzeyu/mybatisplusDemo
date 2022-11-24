package com.example.mybatisplusdemo.enmu;

import lombok.Getter;

/**
 * @author qinzh
 */

public enum HttpStatusEnum {

    SUCC_200(200,"成功"),
    FAIL_404(404,"路径获取错误"),
    FAIL_500(500,"服务器内部错误"),
    FAIL_408(408,"服务请求超时"),
    FAIL_403(403,"权限校验未通过");


    @Getter
    private Integer code;
    @Getter
    private String status;

    HttpStatusEnum(Integer code, String status) {
        this.code = code;
        this.status = status;
    }

    public static String getStatusByCode(Integer code) {
        for(HttpStatusEnum enmu: HttpStatusEnum.values()) {
            if (enmu.getCode()== code) {
                return enmu.getStatus();
            }
        }
        return null;
    }
}
