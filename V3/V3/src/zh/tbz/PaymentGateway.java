package zh.tbz;

public interface PaymentGateway {
    boolean charge(double amount);
}
