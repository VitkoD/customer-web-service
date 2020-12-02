package com.fabriik.customerwebservice.configuration;


import com.hazelcast.config.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastConfig {

    @Bean
    public Config hazelcastCon() {
        Config config = new Config()
                .setClusterName("Customers");
        config.getNetworkConfig().getJoin()
                .setMulticastConfig(new MulticastConfig().setEnabled(false).setMulticastPort(5152))
                .setTcpIpConfig(new TcpIpConfig().setEnabled(true));
        config.getNetworkConfig().setPortAutoIncrement(true)
                .setPort(5523);
        return config;
    }
}
