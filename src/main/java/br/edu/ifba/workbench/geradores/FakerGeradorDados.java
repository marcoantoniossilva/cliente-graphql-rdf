package br.edu.ifba.workbench.geradores;

import br.edu.ifba.workbench.modelos.Desaparecimento;
import com.github.javafaker.Faker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FakerGeradorDados implements IGeradorDados {

  private static final DateFormat FORMATADOR_DATA = new SimpleDateFormat("yyyy-MM-dd");
  private static final DateFormat FORMATADOR_HORA = new SimpleDateFormat("HH:mm");

  private static final Locale PT_BR_LOCALE = new Locale("pt", "BR");
  private static final String[] FONTES_DISPONIVEIS = {"Mãe", "Pai", "Vizinho", "Tio", "Amigo"};

  private final Faker faker = new Faker(PT_BR_LOCALE);

  @Override
  public List<Desaparecimento> gerarDesaparecimentos(int quantidade) {
    return IntStream.range(0, quantidade)
      .mapToObj(indice -> new Desaparecimento()
        .setCodDesaparecimento(indice)
        .setCodPessoa(this.faker.number().numberBetween(1, 3000))
        .setCodLocal(this.faker.number().numberBetween(1, 20000))
        .setDataDesaparecimento(FORMATADOR_DATA.format(this.obterDataRandomica()))
        .setInformacoes(this.faker.lorem().paragraph())
        .setFonte(this.obterValorAleatorioDeUmArray(FONTES_DISPONIVEIS))
        .setBoletimOcorrencia(this.faker.bool().bool())
        .setUltimaHoraVista(FORMATADOR_HORA.format(this.obterDataRandomica()))
      ).collect(Collectors.toList());
  }

  private Date obterDataRandomica() {
    Date dataInicio = Date.from(
      LocalDate.now()
        .minusYears(50).atStartOfDay()
        .atZone(ZoneId.systemDefault())
        .toInstant()
      );

    return this.faker.date().between(dataInicio, new Date());
  }

  private String obterValorAleatorioDeUmArray(String[] array) {
    int indiceAleatorio = new Random().nextInt(array.length);
    return array[indiceAleatorio];
  }


}
