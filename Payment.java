package CS;

public class Payment {
    private Order order;
    private double tax;
    private double grandTotal;
    private double snapTotal;
    private double nonFoodSubtotal;
    private boolean isUsingSnap;
    private static final double FOOD_TAX_RATE = 0.04;
    private static final double NON_FOOD_TAX_RATE = 0.08;

    public Payment(Order order, boolean isUsingSnap) {
        this.order = order;
        this.isUsingSnap = isUsingSnap;
        this.snapTotal = calculateSnapTotal();
        this.nonFoodSubtotal = order.calculateTotal() - snapTotal;
        this.tax = calculateTax();
        this.grandTotal = nonFoodSubtotal + tax;
    }

    private double calculateSnapTotal() {
        double total = 0;
        if (isUsingSnap) {
            for (Product product : order.getProducts()) {
                if (product.isFoodItem()) {
                    total += product.getPrice();
                }
            }
        }
        return total;
    }

    private double calculateTax() {
        double tax = 0;
        for (Product product : order.getProducts()) {
            if (!product.isFoodItem()) {
                tax += product.getPrice() * NON_FOOD_TAX_RATE;
            } else if (!isUsingSnap) {
                tax += product.getPrice() * FOOD_TAX_RATE;
            }
        }
        return tax;
    }

    public double getTax() {
        return tax;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public double getSnapTotal() {
        return snapTotal;
    }

    public double getNonFoodSubtotal() {
        return nonFoodSubtotal;
    }

    public boolean isUsingSnap() {
        return isUsingSnap;
    }
}
