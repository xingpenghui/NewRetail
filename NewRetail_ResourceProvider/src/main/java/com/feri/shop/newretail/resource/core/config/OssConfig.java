package com.feri.shop.newretail.resource.core.config;

import org.springframework.context.annotation.Configuration;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-15 14:42
 */

public class OssConfig {
    // Endpoint以杭州为例，其它Region请按实际情况填写。
    public static final String endpoint = "http://oss-cn-beijing.aliyuncs.com";
    public static final String ossurl = "oss-cn-beijing.aliyuncs.com";
    // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
    public static final String accessKeyId = "LTAIhTvqTSmlmjeQ";
    public static final String accessKeySecret = "X7X9w0Ck5GEIWgP9tl0Q6sgmFjQuMv";
}
