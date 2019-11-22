package com.neuedu.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangyu on 2019/8/14.
 */
@Configuration
@Import(FdfsClientConfig.class)
public class MyConfig {

    @Bean
    public CorsFilter getCorsFilter(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsFilter(corsConfigurationSource);
    }
    /**
     *  用fastJson解析
     *
     * */
    @Bean
    public HttpMessageConverters fastJsonMessageConverter(){
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter=new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig=new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.PrettyFormat,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.DisableCircularReferenceDetect
        );
        fastJsonConfig.setDateFormat("yyyy-MM-dd");
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        List<MediaType> mediaTypes=new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastJsonHttpMessageConverter.setSupportedMediaTypes(mediaTypes);
        StringHttpMessageConverter stringHttpMessageConverter=new StringHttpMessageConverter(Charset.forName("UTF-8"));
        return new HttpMessageConverters(fastJsonHttpMessageConverter,stringHttpMessageConverter);
    }
}
