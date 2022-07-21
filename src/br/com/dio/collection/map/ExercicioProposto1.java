package br.com.dio.collection.map;
/*
Dada a população estimada de alguns estados do nordeste brasileiro, faça:
 Estado = PE - população = 9.616.621
 Estado = AL - população = 3.351.543
 Estado = CE - população  = 9.187.103
 Estado = RN - população = 3.534.265
 */
import java.util.*;

public class ExercicioProposto1 {

    public static void main(String[] args) {

        System.out.println("Crie um dicionário que relacione os estados e suas respectivas populações: ");
        Map<String, Integer> populacaoNordeste = new HashMap<>(){{

            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};
        System.out.println(populacaoNordeste);

        System.out.println("Substitua a população do estado RN por : 3.534.165");
        populacaoNordeste.put("RN",3534165 );
        System.out.println(populacaoNordeste);


        System.out.println("Confira se o estado da Paraíba (PB) está no dicionário, caso não, adicione " +
                populacaoNordeste.containsKey("PB"));
        populacaoNordeste.put("PB", 3944000);
        System.out.println(populacaoNordeste);


        System.out.println("Exiba a população do estado PE: " + populacaoNordeste.get("PE"));


        System.out.println("Exiba todos os estados e suas populaçãos na ordem em que foram informados: ");
        Map<String, Integer> populacaoNordeste1 = new LinkedHashMap<>(){{

            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
            put("PB", 3944000);
        }};
        System.out.println(populacaoNordeste1);


        System.out.println("Exiba todos os estados e suas populações na ordem alfabética: ");
        Map<String, Integer> populacaoNordeste2 = new TreeMap<>(){{

            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
            put("PB", 3944000);
        }};
        System.out.println(populacaoNordeste2);



        Integer menorPopulacao = Collections.min(populacaoNordeste.values());
        Set<Map.Entry<String, Integer>> entries = populacaoNordeste.entrySet();
        String estadoMenor = "";

        for(Map.Entry<String, Integer> entry: entries) {
            if (entry.getValue().equals(menorPopulacao))
                estadoMenor = entry.getKey();
        }
        System.out.println("Exiba o estado com o menor população  e seu respectivo valor: " + estadoMenor + " - "
                + menorPopulacao);



        Integer maiorPopulacao = Collections.max(populacaoNordeste.values());
        Set<Map.Entry<String, Integer>> entries1 = populacaoNordeste.entrySet();
        String estadoMaior = "";

        for(Map.Entry<String, Integer> entry: entries1) {
            if (entry.getValue().equals(maiorPopulacao))
                estadoMaior = entry.getKey();
        }
        System.out.println("Exiba o estado com a maior população  e seu respectivo valor: " + estadoMaior + " - " + maiorPopulacao);



        Iterator<Integer> iterator = populacaoNordeste.values().iterator();
        Integer soma = 0;
        while(iterator.hasNext()){
            soma += iterator.next();
        }
        System.out.println("Exiba a soma da população desses estados: " + soma);


        System.out.println("Exiba a média da população deste dicionário de estados: " + soma/populacaoNordeste.size());


        System.out.println("Remova os estados com a população menor que 4.000.000: ");
        Iterator<Integer> iterator1 = populacaoNordeste.values().iterator();
        while(iterator1.hasNext()){
            if(iterator1.next()<= 4000000) iterator1.remove();
        }
        System.out.println(populacaoNordeste);


        System.out.println("Apague o dicionario de estados com suas respectivas populações estimadas: ");
        populacaoNordeste.clear();
        System.out.println(populacaoNordeste);

        System.out.println("Confira se a lista está vazia: " + populacaoNordeste.isEmpty());




    }
}
