package com.servidor.config;

import com.servidor.endpoints.CountryEndpoint;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/**
 * Representa a configuracao do web service.
 *
 */
@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

  /**
   * Configura o modulo utilizado para tratar as solicitacoes SOAP.
   *
   * @param applicationContext contexto da aplicacao
   */
  @Bean
  public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
    // modulo utilizado para tratar as solicitacoes SOAP
    MessageDispatcherServlet servlet = new MessageDispatcherServlet();

    // atribui ao modulo o contexto da aplicacao - assim ele consiguira utilizar os beans do Spring Boot
    servlet.setApplicationContext(applicationContext);
    
    // altera o atributo "soap:address" para que ele reflita a URL da solicitacao
    servlet.setTransformWsdlLocations(true);

    // retorna o modulo
    return new ServletRegistrationBean(servlet, "/ws/*");
  }

  /**
   * Configura WSDL 1.1 utilizando o arquivo XSD.
   *
   * @param countriesSchema descricao do servico.
   */
  @Bean(name = "countries")
  public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema countriesSchema) {
    // implementacao padrao para servicos WSDL 1.1 e 1.2
    DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();

    // define a porta utilizada para a definicao do servico
    wsdl11Definition.setPortTypeName("CountriesPort");

    // define a URL do servico
    wsdl11Definition.setLocationUri("/ws");

    // define o namespace do servico - o mesmo definino tanto no endpoint quanto no XSD
    wsdl11Definition.setTargetNamespace(CountryEndpoint.NAMESPACE_URI);

    // define a descricao do servico
    wsdl11Definition.setSchema(countriesSchema);
    
    // retorna servico WSDL
    return wsdl11Definition;
  }

  /**
   * Expoem a descricao do servico via XSD.
   */
  @Bean
  public XsdSchema countriesSchema() {
    return new SimpleXsdSchema(new ClassPathResource("countries.xsd"));
  }
}