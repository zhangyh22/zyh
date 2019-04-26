package com.sinosoft;

import com.sinosoft.entity.HttpClientResult;
import com.sinosoft.util.HttpClientUtil;
import org.junit.Test;

public class HttpClientUtilTest {
    @Test
    public void testGet() throws Exception {
        HttpClientResult result = HttpClientUtil.doGet("http://127.0.0.1:8081/hello/get");
        System.out.println(result.getCode());
        System.out.println(result.getContent());
    }
}
