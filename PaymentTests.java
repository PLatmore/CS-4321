package CS;

public class PaymentTests {

    public static final double TAX_RATE = 0.07;

    public static void main(String[] args) {
        testCalculateTax();
        testCalculateTotal();
    }

    public static Payment createTestPayment(Order order, boolean useSnap) {
        return new Payment(order, useSnap);
    }

    public static void testCalculateTax() {
        Order order = OrderTests.createTestOrder();
        Payment paymentWithSnap = createTestPayment(order, true);
        Payment paymentWithoutSnap = createTestPayment(order, false);

        double taxWithSnap = paymentWithSnap.calculateTax();
        double taxWithoutSnap = paymentWithoutSnap.calculateTax();

        if (taxWithSnap != 0) {
            System.out.println("Failed: testCalculateTax - With Snap");
        } else {
            System.out.println("Passed: testCalculateTax - With Snap");
        }

        if (Math.abs(taxWithoutSnap - (order.getSubtotal() * TAX_RATE)) > 0.01) {
            System.out.println("Failed: testCalculateTax - Without Snap");
        } else {
            System.out.println("Passed: testCalculateTax - Without Snap");
        }
    }

    public static void testCalculateTotal() {
        Order order = OrderTests.createTestOrder();
        Payment paymentWithSnap = createTestPayment(order, true);
        Payment paymentWithoutSnap = createTestPayment(order, false);

        double totalWithSnap = paymentWithSnap.calculateTotal();
        double totalWithoutSnap = paymentWithoutSnap.calculateTotal();

        if (Math.abs(totalWithSnap - order.getSubtotal()) > 0.01) {
            System.out.println("Failed: testCalculateTotal - With Snap");
        } else {
            System.out.println("Passed: testCalculateTotal - With Snap");
        }

        if (Math.abs(totalWithoutSnap - (order.getSubtotal() + paymentWithoutSnap.calculateTax())) > 0.01) {
            System.out.println("Failed: testCalculateTotal - Without Snap");
        } else {
            System.out.println("Passed: testCalculateTotal - Without Snap");
        }
    }
}
