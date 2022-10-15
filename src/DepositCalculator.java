import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double a, double y, int d) { //параметрам лучше давать "говорящие" имена.
        double pay = a * Math.pow((1 + y / 12), 12 * d);
        return makeRound (pay, 2);
    }

    double calculateSimplePercent(double doubleAmount, double double_year_rate, int deposit_period) { // в параметрах лучше не указывать тип переменной, а также 
        return makeRound(doubleAmount + doubleAmount * double_year_rate * deposit_period, 2);             // использовать camelCase без подчеркиваний
    }

    double makeRound(double value, int places) {
        double ScaLe = Math.pow(10, places);
        return Math.round(value * ScaLe) / ScaLe;
    }

    void inputAndOutput() {
        int period;
        int depositType; //  можно отделить переменные от остального кода пустой строкой
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = scanner.nextInt();
        double result = 0;
        if (depositType == 1) {
            result = calculateSimplePercent(amount, 0.06, period);
        } else if (depositType == 2) {
            result = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + result);
    }

    public static void main (String[] args) {
        new DepositCalculator().inputAndOutput();
    }
}
