package br.edu.ifba.workbench.geradores;

import br.edu.ifba.workbench.modelos.*;
import br.edu.ifba.workbench.utilitarios.Constantes;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class FakerGeradorDados implements IGeradorDados {

  private final Faker faker = new Faker(Constantes.PT_BR_LOCALE);

  @Override
  public List<Desaparecimento> gerarDesaparecimentos(int quantidade, int maxCodPessoa, int maxCodLocal) {
    return IntStream.range(1, quantidade + 1)
        .mapToObj(indice -> new Desaparecimento()
            .setCodDesaparecimento(indice)
            .setCodPessoa(this.faker.number().numberBetween(1, maxCodPessoa))
            .setCodLocal(this.faker.number().numberBetween(1, maxCodLocal))
            .setDataDesaparecimento(Constantes.FORMATADOR_DATA.format(this.obterDataRandomica()))
            .setInformacoes(this.faker.lorem().paragraph())
            .setFonte(this.obterValorAleatorioDeUmArray(Constantes.FONTES_DISPONIVEIS))
            .setBoletimOcorrencia(this.faker.bool().bool())
            .setUltimaHoraVista(Constantes.FORMATADOR_HORA.format(this.obterDataRandomica()))
        ).collect(Collectors.toList());
  }

  @Override
  public List<Uf> gerarUfs() {
    return Arrays.asList(
        new Uf(1, "AC"),
        new Uf(2, "AL"),
        new Uf(3, "AP"),
        new Uf(4, "AM"),
        new Uf(5, "BA"),
        new Uf(6, "CE"),
        new Uf(7, "DF"),
        new Uf(8, "ES"),
        new Uf(9, "GO"),
        new Uf(10, "MA"),
        new Uf(11, "MT"),
        new Uf(12, "MS"),
        new Uf(13, "MG"),
        new Uf(14, "PA"),
        new Uf(15, "PB"),
        new Uf(16, "PR"),
        new Uf(17, "PE"),
        new Uf(18, "PI"),
        new Uf(19, "RR"),
        new Uf(20, "RO"),
        new Uf(21, "RJ"),
        new Uf(22, "RN"),
        new Uf(23, "RS"),
        new Uf(24, "SC"),
        new Uf(25, "SP"),
        new Uf(26, "SE"),
        new Uf(27, "TO")
        );
  }

  @Override
  public List<Cidade> gerarCidades(int quantidade) {
    return IntStream.range(1, quantidade + 1)
        .mapToObj(indice -> new Cidade()
            .setCodCidade(indice)
            .setNomeCidade(this.faker.address().city())
            .setCodUf(this.faker.number().numberBetween(1, 27))
        ).collect(Collectors.toList());
  }

  @Override
  public List<Bairro> gerarBairros(int quantidade, int maxCodCidade) {
    return IntStream.range(1, quantidade + 1)
        .mapToObj(indice -> new Bairro()
            .setCodBairro(indice)
            .setNomeBairro(this.faker.address().city())
            .setCodCidade(this.faker.number().numberBetween(1, maxCodCidade))
        ).collect(Collectors.toList());
  }

  @Override
  public List<Local> gerarLocais(int quantidade, int maxCodBairro) {
    return IntStream.range(1, quantidade + 1)
        .mapToObj(indice -> new Local()
            .setCodLocal(indice)
            .setLongitude(this.faker.address().longitude())
            .setLatitude(this.faker.address().latitude())
            .setCodBairro(this.faker.number().numberBetween(1, maxCodBairro))
        ).collect(Collectors.toList());
  }

  @Override
  public List<Pessoa> gerarPessoas(int quantidade) {
    return IntStream.range(1, quantidade + 1)
        .mapToObj(indice -> new Pessoa()
            .setCodPessoa(indice)
            .setImagem(this.faker.avatar().image())
            .setSexo(this.obterValorAleatorioDeUmArray(Constantes.SEXOS_DISPONIVEIS))
            .setPesoAproximado((float) Math.random() * (110 - 45) + 45)
            .setCorPele(this.obterValorAleatorioDeUmArray(Constantes.CORES_PELE_DISPONIVEIS))
            .setCorOlhos(this.obterValorAleatorioDeUmArray(Constantes.CORES_OLHOS_DISPONIVEIS))
            .setDataNascimento(Constantes.FORMATADOR_DATA.format(this.obterDataRandomica()))
            .setNome(this.faker.name().fullName())
            .setTipoFisico(this.obterValorAleatorioDeUmArray(Constantes.TIPOS_FISICO_DISPONIVEIS))
            .setMarcaCaracteristica(
                this.obterValorAleatorioDeUmArray(Constantes.MARCAS_DISPONIVEIS)
                    + " em "
                    + this.obterValorAleatorioDeUmArray(Constantes.LOCAIS_MARCA_DISPONIVEIS))
            .setAlturaAproximada((float) (Math.random() * (2 - 1.5) + 1.5))
            .setCorCabelo(this.obterValorAleatorioDeUmArray(Constantes.CORES_CABELOS_DISPONIVEIS))
            .setTranstornoMental(this.obterValorAleatorioDeUmArray(Constantes.TRANSTORNOS_MENTAIS_DISPONIVEIS))
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
