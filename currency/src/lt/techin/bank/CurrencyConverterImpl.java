package lt.techin.bank;

import lt.itakademija.exam.*;

import java.util.HashMap;
import java.util.Map;

public class CurrencyConverterImpl implements CurrencyConverter {
    private CurrencyRatesProvider ratesProvider;

    public CurrencyConverterImpl(CurrencyRatesProvider ratesProvider) {
        this.ratesProvider = ratesProvider;
    }

    @Override
    public Money convert(Currency currency, Currency currency1, Money money) {
        if (ratesProvider.getRate(currency, currency1) == null) {
            throw new CurrencyConversionException("Rate for specified currencies does not exist.");
        }
        return money.multiply(ratesProvider.getRate(currency, currency1));
    }
}
