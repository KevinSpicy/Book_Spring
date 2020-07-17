package com.example.demo.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "taco.recent")
public class TacoProps {

    private int recentTacoSize = 12;

    public TacoProps() {
    }

    public int getRecentTacoSize() {
        return recentTacoSize;
    }

    public void setRecentTacoSize(int recentTacoSize) {
        this.recentTacoSize = recentTacoSize;
    }
}
