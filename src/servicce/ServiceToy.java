package servicce;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import data.Toy;

public class ServiceToy {
    static List<Toy> toyList = new ArrayList<Toy>();
    static List<Toy> toyPrizeList = new ArrayList<Toy>(); 


    public static void create(String name, int quantity, int weight){           
       
        int id = getId();
        Toy toy = new Toy(id, name, quantity, weight);
        toyList.add(toy);
    }

    public static List<Toy> getAllToy(){
        return toyList;
    }

    public static void giveOutToy(){
        writeToFile(toyPrizeList.get(0));
        changeCountToyById(toyPrizeList.get(0).getId(),toyPrizeList.get(0).getQuantity()-1);
        toyPrizeList.remove(0);
    }

    private static void changeCountToyById(int id, int newQuantity){
        for (Toy toy : toyList) {
            if (toy.getId()==id){
                toy.setCount(newQuantity);
            }
        }
    }

    private static void writeToFile(Toy toy){
        String fileName = "prizeToy\\PrizeToy.txt";

        try (FileWriter writer = new FileWriter(fileName, true)) {
            
            writer.write(toy.toString()+"\n");

        } catch (IOException e) {
            System.out.println("Ошибка записи в файл");
        }
        


         
    }

    public static void addToyToPrizeList(){
        Toy prizeToy=genPrizeToy(toyList);
        if (toyPrizeList.size()<toyList.size() && prizeToy.getQuantity()>0){      
            while (toyPrizeList.contains(prizeToy)) {
                prizeToy = genPrizeToy(toyList);
            }
            toyPrizeList.add(prizeToy);
        }else System.out.println("Добавлены уже все игрушки");
    }

    private static Toy genPrizeToy(List<Toy> listToy){
        Random random = new Random();

        Map<Integer,Integer> map = new TreeMap<>();

        Integer weight = 0;   
        int sumWweight=0;
        
     

        for (Toy toy : listToy) {
            sumWweight =  sumWweight+toy.getWeight();    

            map.put(toy.getId(), toy.getWeight()+weight);
            weight = weight+toy.getWeight();
            
            
        }

        
        int randomValue = random.nextInt(sumWweight);
        // Смотрим между какими значениями попало наше случайноее число, ближайшее большее и будем искомым значением
        for (int id : map.keySet()) {
            if (randomValue<map.get(id)){
                for (Toy toy : listToy) {
                    if (toy.getId()==id){
                        return toy;
                    }
                    
                }
            }
        }
        return null;       

    }


    private static int getId(){

        int id=-1;
        

        for (Toy toy : toyList) {
            if (toy.getId()>id){
                id =toy.getId();
            }
        }
        return ++id;
    }

    public static List<Toy> getToyList() {
        return toyList;
    }

    public static List<Toy> getToyPrizeList() {
        return toyPrizeList;
    }
    
}