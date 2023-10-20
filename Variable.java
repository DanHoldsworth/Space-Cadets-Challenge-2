public class Variable {
    private String name;
    private int value;

    public Variable(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName(){
        return name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int newValue) {
        value = newValue;
    }
}
