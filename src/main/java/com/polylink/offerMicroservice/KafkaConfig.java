package com.polylink.offerMicroservice;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@EnableKafka
public class KafkaConfig
{

    @Bean
    public NewTopic offerState()
    {
        return TopicBuilder.name("offerState").config(TopicConfig.RETENTION_MS_CONFIG, "1").build();
    }

}
