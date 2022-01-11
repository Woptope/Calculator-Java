package sample;

public class Model {
    private double a;
    private double b;
    private char operator;
    private double res;
    public void setA(double a) {this.a = a;}
    public void setB(double b) {this.b = b;}
    public double getB() {return b;}
    public double getA() {return a;}
    public void setOperator(char operator) {this.operator = operator;}
    public char getOperator() {return operator;}

    public void clearRes() {
        this.res = 0;
    }

    public Model() {
        operator = '0';
        a = 0;
        b = 0;
    }
    public double calculation() {
        switch (operator) {
            case '+':
                res = a + b;
                break;
            case '-':
                res = a - b;
                break;
            case '*':
                res = a * b;
                break;
            case '/':
                res = a / b;
                break;
            case '^':
                res = Math.pow(a, b);
                break;
            case '√':
                res = Math.sqrt(a);
                break;
        }
        return res;
    }

}
