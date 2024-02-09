import java.util.ArrayList;


class Shoppkepper
{
    public static ArrayList<Electronics> electronicsList = new ArrayList<>();
    public static ArrayList<Clothing> clothingicsList = new ArrayList<>();

    // For storing in the Electronics List
    public void addElectronics(Electronics ec)
    {
        electronicsList.add(ec);
    }

    // For adding in the Clothing list
    public void addClothing(Clothing cl)
    {
        clothingicsList.add(cl);
        // System.out.println(clothingicsList.size());
    }

    public void value()
    {
        System.out.println(electronicsList.get(1).getId());
        System.out.println(clothingicsList);
    }
}

abstract class Product
{
    private int productId;
    private String productName;
    private int price;

    // Constructor of Product for assigning value
    Product(int productId,String productName, int price)
    {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    // Getters for getting values
    public int getId()
    {
        return productId;
    }

    public String getProduct()
    {
        return productName;
    }

    public int getPrice()
    {
        return price;
    }

    public abstract void Display();
}

class Electronics extends Product
{
    private int warentyPeriod;
    //Constructor for Electornic class
    Electronics(int productId,String productName, int price,int warentyPeriod)
    {
        super(productId, productName, price-10);
        this.warentyPeriod = warentyPeriod;
    }

    public void Display()
    {
        System.err.println("We display the details of Electronics product");
    }

    
}

class Clothing extends Product
{
    private int size;
    private String color;
    Clothing(int productId,String productName, int price,int size,String color)
    {
        super(productId, productName, price-20);
        this.size = size;
        this.color = color;
    }

    public void Display()
    {
        System.out.println("We are in Clothing class");
    }
}


// Creating the Interface for methods
interface User
{
    void BrowsingProduct(int id);
    void AddingProduct(Product pd);
    void CheckOut();
}

class Guest extends Shoppkepper implements User
{

    public static ArrayList<Product> temp = new ArrayList<>();
    
    //Searching for Product whether it is present or not
    public void BrowsingProduct(int id)
    {
        for(int i=0;i<electronicsList.size();i++)
        {
            // System.out.println(electronicsList.get(i).getId());
            if(electronicsList.get(i).getId()== id)
            {
                System.out.println("Electronics Found");
            }
        }

        for(int i=0;i<clothingicsList.size();i++)
        {
            if(clothingicsList.get(i).getId() == id)
            {
                System.out.println("Cloth Found");
            }
        }
    }

    // Creating the cart for the user
    public void AddingProduct(Product pd)
    {
        temp.add(pd);
    }


    // Traversing in the chart
    public void ChartList()
    {
        for(int i=0;i<temp.size();i++)
        {
            System.out.println(temp.get(i).getProduct());
        }
    }

    // When the user buy the product so remove from chart and then creating total amount
    public void CheckOut()
    {
        System.out.println("CheckOut done");
        Order d = new Order();
        d.Amount();
        for(int i=0;i<temp.size();i++)
        {
            temp.remove(i);
        }
    }
}

class Order extends Guest
{
    int total = 0;
    // Calculating the total amount
    public void Amount()
    {
        for(int i=0;i<temp.size();i++)
        {
            total = total + temp.get(i).getPrice();
        }
        System.out.println("Your Total amount will be "+ total);
    }
}




public class Shopping {
    public static void main(String[] args) {
        Electronics TV = new Electronics(1, "Television", 100, 2);
        Electronics Fridge = new Electronics(2, "Fridge", 150, 1);

        Clothing tshirt = new Clothing(3, "tshirt", 50, 9, "Red");
        Clothing jeans = new Clothing(4, "Jean", 90, 8, "Blue");

        Shoppkepper sp = new Shoppkepper();
        sp.addElectronics(TV);
        sp.addElectronics(Fridge);

        sp.addClothing(tshirt);
        sp.addClothing(jeans);
        // sp.value();

        Guest u1 = new Guest();
        // u1.BrowsingProduct(4);
        u1.AddingProduct(jeans);
        u1.AddingProduct(Fridge);
        u1.CheckOut();
        
        Guest u2 = new Guest();
        u2.AddingProduct(tshirt);
        u2.AddingProduct(TV);

        u1.ChartList();

        // u1.ChartList();

        

    }
}



