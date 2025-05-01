public abstract class Item {
    private double price;
    private int invQuantity;
    private int soldQuantity;

    public Item(double price, int invQuantity) {
        this.price = price;
        this.invQuantity = invQuantity;
        this.soldQuantity = 0;
    }

    public double getPrice() {
        return price;
    }

    public int getInvQuantity() {
        return invQuantity;
    }

    public int getSoldQuantity() {
        return soldQuantity;
    }

    public void setInvQuantity(int invQuantity) {
        this.invQuantity = invQuantity;
    }

    public void setSoldQuantity(int soldQuantity) {
        this.soldQuantity = soldQuantity;
    }
}

