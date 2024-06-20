package Collection.LinkedHashMap;

public class Customer {
    String name;

    int id;

    public Customer(String name, int id)
    {
        this.name = name;

        this.id = id;
    }

    @Override
    public int hashCode()
    {
        return id;
    }

    @Override
    public boolean equals(Object obj)
    {
        Customer customer = (Customer) obj;

        return (id == customer.id);
    }

    @Override
    public String toString()
    {
        return id+" : "+name;
    }
}
