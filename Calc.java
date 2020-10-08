package calc;

public class Calc {
    private Data SourceData = new Data();

    public Data getSourceData() {
        return SourceData;
    }

    public void setSourceData(Data SourceData) {
        this.SourceData = SourceData;
    }

    double calculate(Data d) {
        double rezult = 0;
        switch (d.getOperation()) {
            case add: rezult = d.getParam1() + d.getParam2();
                break;
            case subtraction: rezult = d.getParam1() - d.getParam2();
                break;
            case multiplication: rezult = d.getParam1() * d.getParam2();
                break;
            case division: rezult = d.getParam1() / d.getParam2();
                break;
            case modulus: rezult = d.getParam1() % d.getParam2();
                break;
        }
        return rezult;
    }

    void GetRezult(double r) {
        int iRez = (int) r;
        double ost = r - iRez;   //вычисление дробной части результата операции
        if (ost != 0) System.out.print(r);
        else System.out.print(iRez);
    }

    boolean isCorrectData (String[] arg) {
       try {
            SourceData.setParam1(Double.parseDouble(arg[0]));
            SourceData.setParam2(Double.parseDouble(arg[2]));
            System.out.print("P");
            System.out.print(arg[1]);
            switch (arg[1].charAt(0)) {
                case '+': SourceData.setOperation(Operators.add);
                          break;
                case '-': SourceData.setOperation(Operators.subtraction);
                          break;
                case '*': SourceData.setOperation(Operators.multiplication);
                          break;
                case '/': SourceData.setOperation(Operators.division);
                          break;
                case '%': SourceData.setOperation(Operators.modulus);
                          break;
                default: return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void main (String[] arg) {
        System.out.print(arg.length);
        if (arg.length != 3) {
            System.out.print(arg.length);
            System.out.print("Необходимо ввести параметры в формате: parametr1 operator(+, -, *, /, %) parametr2");
            System.exit(1);
        }
        Calc calc = new Calc();
        if (!calc.isCorrectData(arg)) {
            System.out.print("Вы неверно ввели параметры! Повторите, исправив ошибки...");
            System.exit(1);
        }
        calc.GetRezult(calc.calculate(calc.SourceData));
    }
}