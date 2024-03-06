package mockito;

public class Sumar {

    private ValidateNumber validateNumber;
    private Print print;

    public Sumar(ValidateNumber validateNumber) {
        this.validateNumber = validateNumber;
    }

    public Sumar(ValidateNumber validateNumber, Print print) {
        this.validateNumber = validateNumber;
        this.print = print;
    }


    public int sumar(Object a, Object b) {
        if (validateNumber.checkNumber(a) && validateNumber.checkNumber(b)) {

            return (Integer) a + (Integer) b;
        }
        return 0;
    }

    public int sumarInt(Object a) {
        return validateNumber.doubleToInt(a) + validateNumber.doubleToInt(a);
    }

    public void sumarPrint(Object a, Object b) {
        if (validateNumber.checkNumber(a) && validateNumber.checkNumber(b)) {

            int result = (Integer) a + (Integer) b;
            print.showMessage(result);
        }
        else {
            print.showError();
        }
    }
}
