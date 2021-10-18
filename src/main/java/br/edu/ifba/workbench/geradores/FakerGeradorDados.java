package br.edu.ifba.workbench.geradores;

import br.edu.ifba.workbench.modelos.*;
import br.edu.ifba.workbench.utilitarios.Constantes;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
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
    List<Uf> ufs = new ArrayList<Uf>();
    ufs.add(new Uf(1,"AC"));
    ufs.add(new Uf(2,"AL"));
    ufs.add(new Uf(3,"AP"));
    ufs.add(new Uf(4,"AM"));
    ufs.add(new Uf(5,"BA"));
    ufs.add(new Uf(6,"CE"));
    ufs.add(new Uf(7,"DF"));
    ufs.add(new Uf(8,"ES"));
    ufs.add(new Uf(9,"GO"));
    ufs.add(new Uf(10,"MA"));
    ufs.add(new Uf(11,"MT"));
    ufs.add(new Uf(12,"MS"));
    ufs.add(new Uf(13,"MG"));
    ufs.add(new Uf(14,"PA"));
    ufs.add(new Uf(15,"PB"));
    ufs.add(new Uf(16,"PR"));
    ufs.add(new Uf(17,"PE"));
    ufs.add(new Uf(18,"PI"));
    ufs.add(new Uf(19,"RR"));
    ufs.add(new Uf(20,"RO"));
    ufs.add(new Uf(21,"RJ"));
    ufs.add(new Uf(22,"RN"));
    ufs.add(new Uf(23,"RS"));
    ufs.add(new Uf(24,"SC"));
    ufs.add(new Uf(25,"SP"));
    ufs.add(new Uf(26,"SE"));
    ufs.add(new Uf(27,"TO"));
    return ufs;
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
            .setPesoAproximado(String.valueOf(Math.random() * (110 - 45) + 45))
            .setCorPele(this.obterValorAleatorioDeUmArray(Constantes.CORES_PELE_DISPONIVEIS))
            .setCorOlhos(this.obterValorAleatorioDeUmArray(Constantes.CORES_OLHOS_DISPONIVEIS))
            .setDataNascimento(Constantes.FORMATADOR_DATA.format(this.obterDataRandomica()))
            .setNome(this.faker.name().fullName())
            .setTipoFisico(this.obterValorAleatorioDeUmArray(Constantes.TIPOS_FISICO_DISPONIVEIS))
            .setMarcaCaracteristica(
                this.obterValorAleatorioDeUmArray(Constantes.MARCAS_DISPONIVEIS)
                    + " em "
                    + this.obterValorAleatorioDeUmArray(Constantes.LOCAIS_MARCA_DISPONIVEIS))
            .setAlturaAproximada(String.valueOf(Math.random() * (2 - 1.5) + 1.5))
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
