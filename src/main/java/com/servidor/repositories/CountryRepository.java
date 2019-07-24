package com.servidor.repositories;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.servidor.generated.Country;
import com.servidor.generated.Currency;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * Representa o repositorio de paises.
 *
 */
@Component
public class CountryRepository {
  private static final Map<String, Country> countries = new HashMap<>();

  /**
   * Inicializa a lista de paises.
   */
  @PostConstruct
  public void initCountry() {
    Country pais;
    
    // Brasil - censo 2019 - fonte https://pt.wikipedia.org/wiki/Lista_de_pa%C3%ADses_da_Am%C3%A9rica_do_Sul_por_popula%C3%A7%C3%A3o
    pais = new Country();
    pais.setName("Brasil");
    pais.setCapital("Brasília");
    pais.setCurrency(Currency.BRL);
    pais.setPopulation(208500000);

    countries.put(pais.getName(), pais);

    // Colombia - censo 2019 - fonte https://pt.wikipedia.org/wiki/Lista_de_pa%C3%ADses_da_Am%C3%A9rica_do_Sul_por_popula%C3%A7%C3%A3o
    pais = new Country();
    pais.setName("Colômbia");
    pais.setCapital("Bogotá");
    pais.setCurrency(Currency.COP);
    pais.setPopulation(45640400);
    countries.put(pais.getName(), pais);

    // Argentina - censo 2019 - fonte https://pt.wikipedia.org/wiki/Lista_de_pa%C3%ADses_da_Am%C3%A9rica_do_Sul_por_popula%C3%A7%C3%A3o
    pais = new Country();
    pais.setName("Argentina");
    pais.setCapital("Buenos Aires");
    pais.setCurrency(Currency.ARS);
    pais.setPopulation(40117096);
    countries.put(pais.getName(), pais);
  }

  /**
   * Recupera um pais.
   *
   * @param name nome do pais procurado
   * @return Retorna o pais encontrado.
   */
  public Country findCountry(String name) {
    // consiste pais nao informado
    Assert.notNull(name, "The country's name must not be null");

    // procura pelo pais na lista de paises  
    return countries.get(name);
  }
}