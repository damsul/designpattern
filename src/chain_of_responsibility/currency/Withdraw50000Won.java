package chain_of_responsibility.currency;

public class Withdraw50000Won extends WithdrawChain {
    @Override
    public void withdraw(Currency currency) {
        if (currency.getAmount() >= 50000) {
            int cnt = currency.getAmount() / 50000;
            System.out.println("5만원짜리 " + cnt + "장이 인출 되었습니다.");
            int remainder = currency.getAmount() % 50000;
            if (remainder != 0) {
                this.withdrawChain.withdraw(new Currency(remainder));
            }
        } else {
            this.withdrawChain.withdraw(currency);
        }
    }
}
