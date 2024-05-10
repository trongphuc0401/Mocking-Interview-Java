package Java_IO.serialize;

public class Engineer extends Person{

    private String certificate;
    Engineer(int id, String name,String certificate) {
        super(id, name);
        this.certificate = certificate;
    }

    @Override
    public String toString() {
        return "Engineer{" +
                "certificate='" + certificate + '\'' +
                '}';
    }
}
