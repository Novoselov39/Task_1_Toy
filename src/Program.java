import servicce.ServiceToy;

public class Program {
    public static void main(String[] args) throws Exception {
     
        ServiceToy service = new ServiceToy();
             
        service.create("Кукла", 2, 10);      
        service.create("Ежик", 4, 20);  
        service.create("Поросенок", 20, 30); 
        service.create("Солдат", 10, 40); 
      
           
        System.out.println(service.getAllToy().toString());
        service.addToyToPrizeList();
        service.addToyToPrizeList();
       
        // System.out.println("------------");
        System.out.println(service.getToyPrizeList().toString());
        service.giveOutToy();
        System.out.println(service.getToyPrizeList().toString());
        
  
    }
}
