package data;

public class Toy {

    // id игрушки,
    // текстовое название,
    // количество
    // частота выпадения игрушки (вес в % от 100)

    private int id;
    private String name;
    private int quantity;
    private int weight;

    


    @Override
    public String toString() {
        return "Toy [id=" + id + ", name=" + name + ", quantity=" + quantity + ", weight=" + weight + "]";
    }


    public Toy(int id, String name, int count, int weight) {
        this.id = id;
        this.name = name;
        this.quantity = count;
        this.weight = weight;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getCount() {
        return quantity;
    }


    public void setCount(int count) {
        this.quantity = count;
    }


    public int getQuantity() {
        return quantity;
    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public int getWeight() {
        return weight;
    }


    public void setWeight(int weight) {
        this.weight = weight;
    }


    @Override
    public boolean equals(Object obj) {
        Toy toy = (Toy) obj;
       
        return this.getId()==toy.getId();
    }
    
    
    


  

    
    


    
}
