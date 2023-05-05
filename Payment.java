package Store;

public class Payment {
    private Order order;
    private boolean useSnap;
    private static final double TAX_RATE = 0.07;
    
    // Payment(Order order, boolean useSnap)
    public Payment(Order order, boolean useSnap) {
        this.order = order;
        this.useSnap = useSnap;
    }
    
    //calculateTax()
    public double calculateTax() {
        if (useSnap) {
            return 0;
        }
        return order.getSubtotal() * TAX_RATE;
    }
    
    //calculateTotal()
    public double calculateTotal() {
        return order.getSubtotal() + calculateTax();
    }
}