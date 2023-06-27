import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        new DepositCalculator().calculateDepositResult();
    }

    double calculateComplexPercent(double depositAmount,double yearRate, int depositPeriod) {
       double finalAmount = depositAmount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
          return roundToNDecimalPlaces(finalAmount, 2);
    }

    double calculateSimplePercent(double depositAmount,double yearRate, int depositPeriod) {
        return roundToNDecimalPlaces(depositAmount + depositAmount * yearRate * depositPeriod, 2);
    }

    double roundToNDecimalPlaces(double value, int places) {
       double scaLe = Math.pow(10, places);
       return Math.round(value * scaLe) / scaLe;
    }

    void calculateDepositResult() {
        int depositAmount;
        int depositPeriod;
        int depositType;
        double depositResult = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        depositAmount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = scanner.nextInt();

        if (depositType == 1) depositResult = calculateSimplePercent(depositAmount, 0.06, depositPeriod);
        else if (depositType == 2) {
            depositResult = calculateComplexPercent(depositAmount, 0.06, depositPeriod);
        }

        System.out.println("Результат вклада: " + depositAmount + " за " + depositPeriod + " лет превратятся в "
            + depositResult);
    }
}
