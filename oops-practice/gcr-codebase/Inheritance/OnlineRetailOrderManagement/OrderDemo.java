public class OrderDemo {

    public static void main(String[] args) {

        Order order =
                new Order(
                        "ORD101",
                        "01-08-2025");

        ShippedOrder shipped =
                new ShippedOrder(
                        "ORD102",
                        "02-08-2025",
                        "TRK123");

        DeliveredOrder delivered =
                new DeliveredOrder(
                        "ORD103",
                        "03-08-2025",
                        "TRK456",
                        "05-08-2025");

        System.out.println(
                order.getOrderStatus());

        System.out.println(
                shipped.getOrderStatus());

        System.out.println(
                delivered.getOrderStatus());
    }
}