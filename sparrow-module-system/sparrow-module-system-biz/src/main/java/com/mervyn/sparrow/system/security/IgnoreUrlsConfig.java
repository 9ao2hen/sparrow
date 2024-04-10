package com.mervyn.sparrow.system.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 2hen9ao
 * @date 2024/4/11 06:41
 */
@Component
@ConfigurationProperties(prefix = "security.ignoring")
public class IgnoreUrlsConfig {

    List<String> urls = new ArrayList<>();

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }
}
