# contract-first-web-service

O repositório contém um exemplo de serviço SOAP gerado a partir da especificação do contrato XSD que descreve o serviço.

## comandos

Para compilar o exemplo, execute:

```bash
mvn package
```

Quando compilado, será gerado classes em **src/main/java/com/servidor/generated** para suportar o contrato especificado.

Estas classes são geradas neste diretório, pois o [gerador utilizado](https://www.mojohaus.org/jaxb2-maven-plugin/Documentation/v2.2/example_xjc_basic.html) baseia-se no `namespace` do XSD.

Para executar o serviço, execute:

```bash
mvn spring-boot:run
```

Após isso, será possível acessar o mesmo pelo endereço [http://localhost:8080/ws/countries.wsdl](http://localhost:8080/ws/countries.wsdl).

## sobre o serviço

O exemplo mostra a construção de um Web Service SOAP no modelo **contrato primeiro**, no qual antes de codificarmos as classes devemos especificar a interface dos serviços, bem como suas funcionalidades/terminações expostas.

A primeira coisa ha ser feita é definir a interface do serviço. Neste exemplo descritas no arquivo XSD [countries.xsd](src/main/resources/countries.xsd).

>
> **IMPORTANTE**, o valor do atributo `targetNamespace` será especificado no código.
>

Em seguida devemos configurar o Web Service SOAP. Para isso, devemos decorar nossa classe de configuração com o atributo `@EnableWs`, responsável por habilitar serviços SOAP para o Spring Boot. Nossa configuração encontra-se em [WebServiceConfig.java](src/main/java/com/servidor/config/WebServiceConfig.java).

Por fim devemos configurar as funcionalidades - `endpoint` - do Web Service SOAP. Para isso, devemos decorar nossa classe que expõe as funcionalidades com o atributo `@Endpoint`. Nosso `endpoint` encontra-se em [CountryEndpoint.java](src/main/java/com/servidor/endpoints/CountryEndpoint.java).


## mais informações

O exemplo foi baseado em:

- [Producing a SOAP web service](https://spring.io/guides/gs/producing-web-service/)
- [Creating a SOAP Web Service with Spring](https://www.baeldung.com/contract-first-web-service)

Banner gerado [aqui](http://patorjk.com/software/taag/#p=display&f=Ivrit&t=soap%20Server).
