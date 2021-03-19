package io.github.jast90.web.config;

import org.springframework.cloud.openfeign.FeignFormatterRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;

import java.time.format.DateTimeFormatter;

/**
 * Created by jast90 on 2021/3/18
 */
@Configuration(proxyBeanMethods = false)
public class DateFormatConfiguration {

    private final DateTimeFormatter dateFormatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private final DateTimeFormatter timeFormatter =
            DateTimeFormatter.ofPattern("HH:mm:ss");

    private final DateTimeFormatter dateTimeFormatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Bean
    public FeignFormatterRegistrar feignFormatterRegistrar() {
        return new FeignFormatterRegistrar() {

            @Override
            public void registerFormatters(
                    FormatterRegistry formatterRegistry) {
                DateTimeFormatterRegistrar registrar =
                        new DateTimeFormatterRegistrar();
                registrar.setUseIsoFormat(false);
                registrar.setDateFormatter(dateFormatter);
                registrar.setTimeFormatter(timeFormatter);
                registrar.setDateTimeFormatter(dateTimeFormatter);
                registrar.registerFormatters(formatterRegistry);
            }
        };
    }
}
