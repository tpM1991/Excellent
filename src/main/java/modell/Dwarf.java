package modell;

public class Dwarf {

    private String name;
    private String faveFruit;
    private double faveNum;

    public Dwarf() {
    }


    @Override
    public String toString() {
        return  "\'s favourite fruit is " +faveFruit + " he can eat " + faveNum + " pieces of it at one time.\'n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaveFruit() {
        return faveFruit;
    }

    public void setFaveFruit(String faveFruit) {
        this.faveFruit = faveFruit;
    }

    public double getFaveNum() {
        return faveNum;
    }

    public void setFaveNum(double faveNum) {
        this.faveNum = faveNum;
    }
}
