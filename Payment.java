package CS;


import java.time.LocalDateTime;

public class Payment {
    private double snapTotal;
    private double nonFoodSubtotal;
    private double tax;
    private double grandTotal;
    private boolean usingSnap;
    private LocalDateTime paymentTimestamp;

    public Payment(Order order, boolean usingSnap) {
        this.usingSnap = usingSnap;
        calculatePayment(order);
        this.paymentTimestamp = LocalDateTime.now(); // Store the payment timestamp
    }

    private void calculatePayment(Order order) {
        double foodSubtotal = 0;
        double nonFoodSubtotal = 0;

        for (Product product : order.getProducts()) {
            if (product.isFoodItem()) {
                foodSubtotal += product.getPrice();
            } else {
                nonFoodSubtotal += product.getPrice();
            }
        }

        if (usingSnap) {
            this.snapTotal = foodSubtotal;
            this.nonFoodSubtotal = nonFoodSubtotal;
            this.tax = nonFoodSubtotal * 0.08;
            this.grandTotal = nonFoodSubtotal + tax;
        } else {
            this.snapTotal = 0;
            this.nonFoodSubtotal = foodSubtotal + nonFoodSubtotal;
            this.tax = foodSubtotal * 0.04 + nonFoodSubtotal * 0.08;
            this.grandTotal = foodSubtotal + nonFoodSubtotal + tax;
        }
    }

    public double getSnapTotal() {
        return snapTotal;
    }

    public double getNonFoodSubtotal() {
        return nonFoodSubtotal;
    }

    public double getTax() {
        return tax;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public LocalDateTime getPaymentTimestamp() {
        return paymentTimestamp;
    }
}
