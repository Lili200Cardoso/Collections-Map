package br.com.dio.collection.map;

import java.util.*;
/*import java.util.Map;
import java.util.Objects;*/

/*
Dadas as seguintes informações sobre meus livros favoritos e seus autores,
crei um dicionárioo e ordene este dicionário:
Exibindo (Nome autor - Nome Livro);

Autor = Hawking, Stephen - Livro = nome: Uma breve Historia do tempo. páginas: 256
Autor = Duhigg, Charles - Livro = nome: O poder do hábito, páginas: 408
Autor = Harari, Yuval Noah - Livro = 21 Lições para o seculo 21, páginas: 432*/
public class ExemploOrdenacaoMap {

    public static void main(String[] args) {

        System.out.println("--\tOrdem Aleatória\t--");
        Map<String, Livro> meusLivros = new HashMap<>(){{

            put(" Hawking, Stephen", new Livro("Uma Breve Hístoria do Tempo",  256));
            put(" Duhigg, Charles", new Livro("O Poder do Hábito",  408));
            put(" Harari, Yuval Noah", new Livro("21 Lições Para o Século 21",  432));

        }};
        //Como nesse exercicio, só pede para mostrar (Nome autor - Nome Livro);
        // Usaremos o metódo entrySet(), para exibir, elementos separadamente.
        for(Map.Entry<String, Livro> livro : meusLivros.entrySet())//Faremos um for para exibir somente a chave e no meu valor só o nome do livro;
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());


        System.out.println("--\tOrdem Inserção\t--");
        Map<String, Livro> meusLivros1 = new LinkedHashMap<>(){{//Na ordem de iNserção, usaremos o LinkedHashMap();

            put(" Hawking, Stephen", new Livro("Uma Breve Hístoria do Tempo",  256));
            put(" Duhigg, Charles", new Livro("O Poder do Hábito",  408));
            put(" Harari, Yuval Noah", new Livro("21 Lições Para o Século 21",  432));

        }};
        for(Map.Entry<String, Livro> livro : meusLivros1.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());


        System.out.println("--\tOrdem Alfabética Autores\t--");//De acordo com as chaves;Usaremos então: TreeMap();
        Map<String, Livro> meusLivros2 = new TreeMap<>(meusLivros);
        for(Map.Entry<String, Livro> livro : meusLivros2.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());


        System.out.println("--\tOrdem Alfabética Livros\t--");//Trabalharemos com o valor,
        // então precisaremos usar o TreeSet, para usar o Comparator;
        Set<Map.Entry<String, Livro>> meusLivros3 =  new TreeSet<>(new ComparatorNome());
        meusLivros3.addAll(meusLivros.entrySet());
        for(Map.Entry<String, Livro> livro : meusLivros3)
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

    }
}
class Livro{

    private String nome;
    private Integer paginas;

    public Livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(nome, livro.nome) && Objects.equals(paginas, livro.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", paginas=" + paginas +
                '}';
    }
}


class ComparatorNome implements  Comparator<Map.Entry<String, Livro>>{

    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
    }
}