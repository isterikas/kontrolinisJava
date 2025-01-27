package lt.techin.bank;
import lt.itakademija.exam.*;
import java.util.ArrayList;

public class BankImpl implements Bank {
    private SequenceGenerator customerIdGenerator = new SequenceGenerator();
    private SequenceGenerator accountIdGenerator = new SequenceGenerator();
    private SequenceGenerator operationIdGenerator = new SequenceGenerator();
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Operation> operations = new ArrayList<>();
    private CurrencyConverter currencyConverter;
    private ArrayList<Account> accounts = new ArrayList<>();

    public BankImpl(CurrencyConverter currencyConverter) {
        this.currencyConverter = currencyConverter;
    }

    @Override
    public Customer createCustomer(PersonCode personCode, PersonName personName) {
        if (personCode == null || personName == null) {
            throw new NullPointerException("Method invoked with null values.");
        }
        if (customers.stream().noneMatch(customer -> customer.getPersonCode().equals(personCode))) {
            Customer customer = new Customer(customerIdGenerator.getNext(), personCode, personName);
            customers.add(customer);
            return customer;
        } else {
            throw new CustomerCreateException("Attempting to create a customer with a person code for which such customer already exist.");
        }
    }

    @Override
    public Account createAccount(Customer customer, Currency currency) {
        if (customer == null || currency == null) {
            throw new NullPointerException("Method invoked with null values.");
        }
        if (!customers.contains(customer)) {
            throw new AccountCreateException("Attempting to create an account for a customer which does not belong to this bank.");
        }
        Account account = new Account(accountIdGenerator.getNext(), customer, currency, new Money(0));
        customer.addAccount(account);
        accounts.add(account);
        return account;
    }

    @Override
    public Operation transferMoney(Account account, Account account1, Money money) {
            if (money.isLessThanOrEqual(account.getBalance()) && money.isGreaterThanOrEqual(new Money(0))) {
                account.setBalance(account.getBalance().substract(money));
                if (!account.getCurrency().equals(account1.getCurrency())){
                    account1.setBalance(account1.getBalance().add(currencyConverter.convert(account.getCurrency(), account1.getCurrency(), money)));
                    Operation operation = new Operation(operationIdGenerator.getNext(), account, account1, money);
                    operations.add(operation);
                    return operation;
                } else {
                account1.setBalance(account1.getBalance().add(money));
                Operation operation = new Operation(operationIdGenerator.getNext(), account, account1, money);
                operations.add(operation);
                return operation;}
            } else {
                throw new InsufficientFundsException("Insufficient funds");
            }
    }

    @Override
    public Money getBalance(Currency currency) {

       return accounts.stream().map(account -> currencyConverter.convert(account.getCurrency(), currency, account.getBalance())).reduce(new Money(0), Money::add);
    }
}
