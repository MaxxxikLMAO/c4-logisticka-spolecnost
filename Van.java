public class Van {

    private double weight;
    private int id;
    double capacity;

    public Van(double capacity) {
        this.capacity = capacity;
        this.weight = 0;
    }

    public double getCapacity() {
        return this.capacity;
    }

    public double getWeight()  {
        return this.weight;
    }

    public void setWeight(Double w) {
        System.out.println(this.weight);
        this.weight += w;
        System.out.println("Vaha vozidla je: " + this.weight);
    }
}
