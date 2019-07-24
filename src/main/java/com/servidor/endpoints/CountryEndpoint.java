package com.servidor.endpoints;

import com.servidor.generated.GetCountryRequest;
import com.servidor.generated.GetCountryResponse;
import com.servidor.repositories.CountryRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Representa os acessos disponibilizados para os paises.
 *
 */
@Endpoint
public class CountryEndpoint {
  private static Logger LOGGER = LoggerFactory.getLogger(CountryEndpoint.class);

  /**
   * NOME DO ESPACO DEFINIDO NO ARQUIVO XSD
   */
  public static final String NAMESPACE_URI = "http://servidor.com/generated";

  @Autowired
  private CountryRepository countryRepository;

  /**
   * Consulta de um pais.
   *
   * @param request dados da solicitacao
   * @return Retorna os dados de um pais.
   */
  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
  @ResponsePayload
  public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
    LOGGER.info("getCountryRequest [name={}]", request.getName());

    // resposta da solicitacao
    GetCountryResponse response = new GetCountryResponse();

    // define o pais que sera retornado
    response.setCountry(countryRepository.findCountry(request.getName()));

    // responde a solicitacao
    return response;
  }
}