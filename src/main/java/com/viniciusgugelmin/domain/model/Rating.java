package main.java.com.viniciusgugelmin.domain.model;

public class Rating {
    private String Source;
    private Integer Value;

    public Rating(String Source) {
        this.Source = Source;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String Source) {
        this.Source = Source;
    }

    public Integer getValue() {
        return Value;
    }

    public void setValue(Integer Value) {
        if (Value < 0 || Value > 100) {
            throw new IllegalArgumentException("Value must be between 0 and 100");
        }

        this.Value = Value;
    }
}
