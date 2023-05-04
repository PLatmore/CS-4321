package CS;
public class Payment {
    private Order order;
    private boolean useSnap;
    private static final double TAX_RATE = 0.07;

    public Payment(Order order, boolean useSnap) {
        this.order = order;
        this.useSnap = useSnap;
    }

    public double calculateTax() {
        if (useSnap) {
            return 0;
        }
        return order.getSubtotal() * TAX_RATE;
    }

    public double calculateTotal() {
        return order.getSubtotal() + calculateTax();
    }
}