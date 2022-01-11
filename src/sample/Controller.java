package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import  javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller {
    @FXML
    private TextField display;
    @FXML
    private Button button0;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button button9;
    @FXML
    private Button buttonBackSpase;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonSub;
    @FXML
    private Button buttonMultiply;
    @FXML
    private Button buttonDivide;
    @FXML
    private Button buttonClear;
    @FXML
    private Button buttonComma;
    @FXML
    private Button buttonEnter;



    private Model calc = new Model();
    private String buf;
    private boolean lastButtonWasDigit;
    private boolean haveLastRes;
    private boolean flagErr;
    private boolean flagDot;


    private void setNumber(double number) {
        int n = (int) number;
        if (number - n == 0)
            display.setText(String.valueOf(n));
        else display.setText(String.valueOf(number));
        ;
    }

    private double getNumber() {
        return Double.parseDouble(display.getText());
    }

    private String getDisplay() {
        return display.getText();
    }

    private void clear() {
        lastButtonWasDigit = false;
        flagDot = false;
        haveLastRes = false;
        buf = "";
        setNumber(0);
        calc.setA(0);
        calc.setB(0);
        calc.clearRes();
        calc.setOperator('0');
    }

    private boolean notDivisionByZero() {
        if (calc.getOperator() == '/' && getNumber() == 0) {
            display.setText("Деление на ноль!");
            flagErr = true;
            return false;
        } else return true;
    }

    @FXML
    private void button0Click() {
        if (flagErr) {
            clear();
            flagErr = false;
        }
        buf = getDisplay();
        if (lastButtonWasDigit && !buf.equals("0"))
            display.setText(buf + "0");
        else
            setNumber(0);
        lastButtonWasDigit = true;
    }

    @FXML
    private void button1Click(ActionEvent e) {
        if (flagErr) {
            clear();
            flagErr = false;
        }
        buf = getDisplay();
        if (lastButtonWasDigit && !buf.equals("0"))
            display.setText(getDisplay() + "1");
        else
            setNumber(1);
        lastButtonWasDigit = true;
    }

    @FXML
    private void button2Click(ActionEvent e) {
        if (flagErr) {
            clear();
            flagErr = false;
        }
        buf = getDisplay();
        if (lastButtonWasDigit && !buf.equals("0"))
            display.setText(getDisplay() + "2");
        else
            setNumber(2);
        lastButtonWasDigit = true;
    }

    @FXML
    private void button3Click(ActionEvent e) {
        if (flagErr) {
            clear();
            flagErr = false;
        }
        buf = getDisplay();
        if (lastButtonWasDigit && !buf.equals("0"))
            display.setText(getDisplay() + "3");
        else
            setNumber(3);
        lastButtonWasDigit = true;
    }

    @FXML
    private void button4Click(ActionEvent e) {
        if (flagErr) {
            clear();
            flagErr = false;
        }
        buf = getDisplay();
        if (lastButtonWasDigit && !buf.equals("0"))
            display.setText(getDisplay() + "4");
        else
            setNumber(4);
        lastButtonWasDigit = true;
    }

    @FXML
    private void button5Click(ActionEvent e) {
        if (flagErr) {
            clear();
            flagErr = false;
        }
        buf = getDisplay();
        if (lastButtonWasDigit && !buf.equals("0"))
            display.setText(getDisplay() + "5");
        else
            setNumber(5);
        lastButtonWasDigit = true;
    }

    @FXML
    private void button6Click(ActionEvent e) {
        if (flagErr) {
            clear();
            flagErr = false;
        }
        buf = getDisplay();
        if (lastButtonWasDigit && !buf.equals("0"))
            display.setText(getDisplay() + "6");
        else
            setNumber(6);
        lastButtonWasDigit = true;
    }

    @FXML
    private void button7Click(ActionEvent e) {
        if (flagErr) {
            clear();
            flagErr = false;
        }
        buf = getDisplay();
        if (lastButtonWasDigit && !buf.equals("0"))
            display.setText(getDisplay() + "7");
        else
            setNumber(7);
        lastButtonWasDigit = true;
    }

    @FXML
    private void button8Click(ActionEvent e) {
        if (flagErr) {
            clear();
            flagErr = false;
        }
        buf = getDisplay();
        if (lastButtonWasDigit && !buf.equals("0"))
            display.setText(getDisplay() + "8");
        else
            setNumber(8);
        lastButtonWasDigit = true;
    }

    @FXML
    private void button9Click(ActionEvent e) {
        if (flagErr) {
            clear();
            flagErr = false;
        }
        buf = getDisplay();
        if (lastButtonWasDigit && !buf.equals("0"))
            display.setText(getDisplay() + "9");
        else
            setNumber(9);
        lastButtonWasDigit = true;
    }

    @FXML
    private void buttonCommaClick(ActionEvent e) {
        if (!flagErr && !flagDot && (lastButtonWasDigit || buf.equals(""))) {
            display.setText(getDisplay() + ".");
            flagDot = true;
        }
    }

    @FXML
    private void buttonBackSpaceClick(ActionEvent e) {
        if (!flagErr) {
            buf = getDisplay();
            if (lastButtonWasDigit && !buf.equals("0")) {
                if (buf.length() > 1) {
                    if (buf.endsWith(".")) flagDot = false;
                    display.setText(buf.substring(0, buf.length() - 1));
                } else setNumber(0);
            }
        }
    }

    @FXML
    private void buttonSqrtClick(ActionEvent e) {
        if (!flagErr) {
            double bufDoub = getNumber();
            if (bufDoub >= 0) {
                calc.setA(bufDoub);
                calc.setOperator('√');
                setNumber(calc.calculation());
                lastButtonWasDigit = false;
            } else {
                display.setText("Неверные данные!");
                flagErr = true;
            }
        }
    }

    @FXML
    private void buttonAddClick(ActionEvent e) {
        if (!flagErr && notDivisionByZero()) {
            if (haveLastRes && lastButtonWasDigit) {
                calc.setB(getNumber());
                setNumber(calc.calculation());
            }
            calc.setA(getNumber());
            calc.setOperator('+');
            haveLastRes = true;
            flagDot = false;
            lastButtonWasDigit = false;
        }
    }

    @FXML
    private void buttonSubClick(ActionEvent e) {
        if (!flagErr && notDivisionByZero()) {
            if (haveLastRes && lastButtonWasDigit) {
                calc.setB(getNumber());
                setNumber(calc.calculation());
            }
            calc.setA(getNumber());
            calc.setOperator('-');
            haveLastRes = true;
            flagDot = false;
            lastButtonWasDigit = false;
        }
    }

    @FXML
    private void buttonMultiplyClick(ActionEvent e) {
        if (!flagErr && notDivisionByZero()) {
            if (haveLastRes && lastButtonWasDigit) {
                calc.setB(getNumber());
                setNumber(calc.calculation());
            }
            calc.setA(getNumber());
            calc.setOperator('*');
            haveLastRes = true;
            flagDot = false;
            lastButtonWasDigit = false;
        }
    }

    @FXML
    private void buttonPowClick(ActionEvent e) {
        if (!flagErr && notDivisionByZero()) {
            if (haveLastRes && lastButtonWasDigit) {
                calc.setB(getNumber());
                setNumber(calc.calculation());
            }
            calc.setA(getNumber());
            calc.setOperator('^');
            haveLastRes = true;
            flagDot = false;
            lastButtonWasDigit = false;
        }
    }

    @FXML
    private void buttonDivideClick(ActionEvent e) {
        if (!flagErr && notDivisionByZero()) {
            if (haveLastRes && lastButtonWasDigit) {
                calc.setB(getNumber());
                setNumber(calc.calculation());
            }
            calc.setA(getNumber());
            calc.setOperator('/');
            haveLastRes = true;
            flagDot = false;
            lastButtonWasDigit = false;
        }
    }

    @FXML
    private void buttonEnterClick(ActionEvent e) {
        if (!flagErr) {
            if (haveLastRes && lastButtonWasDigit) {
                calc.setB(getNumber());
                if (calc.getOperator() == '/' && calc.getB() == 0 ) {
                    display.setText("Деление на ноль!");
                    flagErr = true;
                } else {
                    setNumber(calc.calculation());
                    calc.setA(getNumber());
                    lastButtonWasDigit = false;
                    if(calc.getOperator() == '/' && calc.getA() == 0 ){
                        calc.setOperator('0');
                    }
                }
            } else if (!lastButtonWasDigit) {
                setNumber(calc.calculation());
                calc.setA(getNumber());
            }
        }
    }
@FXML
    private void buttonClearClick(ActionEvent event) {
        clear();
    }


    @FXML
    private void keyReleased(KeyEvent e) {
        if (e.getCode() == KeyCode.BACK_SPACE)
            buttonBackSpase.fire();
        if (e.getCode() == KeyCode.ENTER)
            buttonEnter.fire();
          else
            switch (e.getText()) {
                case "0":
                    button0.fire();
                    break;
                case "1":
                    button1.fire();
                    break;
                case "2":
                    button2.fire();
                    break;
                case "3":
                    button3.fire();
                    break;
                case "4":
                    button4.fire();
                    break;
                case "5":
                    button5.fire();
                    break;
                case "6":
                    button6.fire();
                    break;
                case "7":
                    button7.fire();
                    break;
                case "8":
                    button8.fire();
                    break;
                case "9":
                    button9.fire();
                    break;
                case "+":
                    buttonAdd.fire();
                    break;
                case "-":
                    buttonSub.fire();
                    break;
                case "*":
                    buttonMultiply.fire();
                    break;
                case "/":
                    buttonDivide.fire();
                    break;
                case "c":
                    buttonClear.fire();
                    break;
                case ".":
                    buttonComma.fire();
                    break;
                case ",":
                    buttonComma.fire();
                    break;
            }
    }
}



