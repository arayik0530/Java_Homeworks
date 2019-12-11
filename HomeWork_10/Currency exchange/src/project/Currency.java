package project;

public class Currency {

    private String code;

    private double exchangeValue;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getExchangeValue() {
        return exchangeValue;
    }

    public void setExchangeValue(double exchangeValue) {
        this.exchangeValue = exchangeValue;
    }

    public Currency(String code, double exchangeValue) {
        this.code = code;
        this.exchangeValue = exchangeValue;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "code='" + code.toUpperCase() + '\'' +
                ", exchangeValue=" + exchangeValue +
                '}';
    }
}
