package LocalMunicipality;

public class Person  {
    private String name;
    private long egn;
    private String address;

    Person(String name, long egn, String address) {
        this.name = name;
        this.egn = egn;
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public long getEgn() {
        return this.egn;
    }

    public String getAddress() {
        return this.address;
    }

    @Override
    public String toString() {
        return this.getName() + "/" +  getEgn() + "/" + getAddress();
    }
}