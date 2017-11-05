package com.limluc.vc2wt;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.limluc.vc2wt.service.ReconService;
import com.limluc.vc2wt.service.ReportBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

@Configuration
@ComponentScan
public class Application {

    public static void main(String[] args) {
        final ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

        final ContextProvider sc = getContextProvider(context);

        //recon missing items
        final ReconService reconService = getReconService(context);
        reconService.compare(sc);

        final ReportBuilder reportBuilder = getReportBuilder(context);
        reportBuilder.generateReport(reconService.resolve());
    }

    private static ContextProvider getContextProvider(ApplicationContext context) {
        return context.getBean(ContextProvider.class);
    }

    private static ReportBuilder getReportBuilder(ApplicationContext context) {
        return context.getBean(ReportBuilder.class);
    }

    private static ReconService getReconService(ApplicationContext context) {
        return context.getBean(ReconService.class);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ISVNAuthenticationManager svnAuthenticationManager() {
        //TODO:: Authentication Method
        return SVNWCUtil.createDefaultAuthenticationManager();
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        jsonConverter.setObjectMapper(objectMapper);
        return jsonConverter;
    }
}
