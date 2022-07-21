package br.com.dio.collection.map;

import java.util.*;
public class ExemploMap {

    public static void main(String[] args) {

     /*   Dado os modelos dos carros e seus respectivos consumos na estrada, faça:
        modelo = gol - consumo = 14,4km/l
        modelo = uno - consumo = 15,6km/l
        modelo = mobi - consumo = 16,1km/l
        modelo = hb20 - consumo = 14,5km/l
        modelo = kwid - consumo = 15,6km/l*/


        //FORMAS DE INICIALIZAR UM MAP:
//Map carrosPopulares2020 = new HashMap(); antes do java 5
//Map<String, Double> carrosPopulares = new HashMap<>();  Generics(jdk 5)- Diamont Operator(jdk)
//HashMap<String, Double> carrosPopulares = new HashMap<>();
//Map<String, Double> carrosPopulares = Map.of("gol", 14.4, "uno",15.6, "mobi", 16.1, "hb20", 14.5,"kwid",15.6);


        System.out.println("Crie um dicionario que relacione os modelos e seus respectivos consumos ");
        Map<String, Double> carrosPopulares = new HashMap<>(){
            {//Iniciamos o Map com o tipo da chave e o tipo do valor;
                put("gol", 14.4);  // Não é possivel usar o metódo add(), aqui usaremos o put();
                put("uno", 15.6);  // O valor das chaves não podem ser duplicadas;
                put("mobi", 16.1);// O HashMap armazena de forma aleatória.
                put("hb20", 14.5);
                put("kwid", 15.6);
            }};
        System.out.println(carrosPopulares);

        System.out.println("Substitua o consumo do gol por 16,1 km/l: ");
        carrosPopulares.put("gol", 16.1);//Não é possivel adicionar um item, porém podemos alterar.
        System.out.println(carrosPopulares);


        System.out.println("Confira se o modelo  Tcson está no dicionário: " + carrosPopulares.containsKey("tucson"));
        //containsKey() verifica se determinada chave está contida no dicionário.
        System.out.println("Confira se o modelo  Uno está no dicionário: " + carrosPopulares.containsKey("uno"));


        System.out.println("Exiba o consumo do uno: " + carrosPopulares.get("uno"));
        //Usaremos  get, e como parametro um objeto, no caso de Map, a chave é o objeto;

        System.out.println("Exiba o terceiro modelo adicionado:" );//Não é possivél, pois o Map não trabalha com indices;

        System.out.println("Exiba os modelos:" );//Usaremos o metódo keySet(), que retornará um SET.
        Set<String> modelos = carrosPopulares.keySet();
        System.out.println(modelos);

        System.out.println("Exiba os consumos dos carros: ");//Usaremos o metódo values(), que nos retornará uma collection;
        Collection<Double> consumos = carrosPopulares.values();
        System.out.println(consumos);

        System.out.println("Exiba o modelo mais economico e seu consumo: ");// O carro mais economico é aque
        // le que faz mais quilometros por litro. Usaremos entao o metódo da Collections: max()
        Double consumoMaisEconomico = Collections.max(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
        //O metódo especial entrySet, retornara um set...
        //Criaremos uma variável de controle:
        String modeloMaisEconomico = "";

        for(Map.Entry<String, Double> entry: entries){
            if(entry.getValue().equals(consumoMaisEconomico))
                modeloMaisEconomico = entry.getKey();
            System.out.println("Modelo mais economico: " + modeloMaisEconomico + " - " + consumoMaisEconomico );
        }


        System.out.println("Exiba o modelo menos economco e seu consumo: ");
        Double consumoMenosEconomico = Collections.min(carrosPopulares.values());
        String modeloMenosEconomico = "";
        for(Map.Entry<String, Double> entry:carrosPopulares.entrySet()){
            if(entry.getValue().equals(consumoMenosEconomico)) {
                modeloMenosEconomico = entry.getKey();
                System.out.println("Modelo menos economico: " + modeloMenosEconomico + " - "
                + consumoMenosEconomico);
            }
        }


        Iterator<Double> iterator = carrosPopulares.values().iterator();
        Double soma = 0D;
        while(iterator.hasNext()){
            soma += iterator.next();
        }
        System.out.println("Exiba a soma dos consumos: " + soma);


        System.out.println("Exiba a média do consumo desse dicionário de carros: " + (soma/carrosPopulares.size()));

        System.out.println("Remova os modelos com consumo igual a 15,6 km/l: ");
        Iterator<Double> iterator1 = carrosPopulares.values().iterator();
        while(iterator1.hasNext()){
            if(iterator1.next().equals(15.6)) iterator1.remove();
        }
        System.out.println(carrosPopulares);


        System.out.println("Exiba todos os carros na ordem em que foram informados: ");
        Map<String, Double> carrosPopulares1 = new LinkedHashMap<>(){
            {
                put("gol", 14.4);
                put("uno", 15.6);
                put("mobi", 16.1);
                put("hb20", 14.5);
                put("kwid", 15.6);
            }};
        System.out.println(carrosPopulares1);


        System.out.println("Exiba o dicionário ordenado pelo modelo: ");//Lembrando, que o modelo é a chave;
        // E quem ordena a chave é o TreeMap();
        Map<String, Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1);
        System.out.println(carrosPopulares2);


        System.out.println("Apague o dicionário de carros: ");
        carrosPopulares.clear();
        System.out.println("Confira se o dicionário está vazia: " + carrosPopulares.isEmpty());



    }
}
