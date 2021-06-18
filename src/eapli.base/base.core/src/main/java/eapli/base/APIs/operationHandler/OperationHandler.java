package eapli.base.APIs.operationHandler;

public class OperationHandler {

    public static int handlePlusMinus(int num1, int num2, String symbol){
        if (symbol == "+"){
            return num1 + num2;
        }
        if (symbol == "-"){
            return num1 - num2;
        }
        return 0;
    }

    public static double handleDivMul(int num1, int num2, String symbol){
        if (symbol == "*"){
            return num1 * num2;
        }
        if (symbol == "/"){
            return (float) num1 / num2;
        }
        return 0;
    }

    public static double handlePower(int num1, int num2, String symbol){
        if (symbol == "^"){
            return Math.pow(num1,num2);
        }
        return 0;
    }

    public static double handlePercent(int num1, int num2, String symbol){
        if (symbol == "%"){
            return num1 % num2;
        }
        return 0;
    }

    public static boolean handleOper(int num1, int num2, String symbol){
        if (symbol == ">"){
            return num1 > num2;
        }
        if (symbol == "<>"){
            return num1 != num2;
        }
        if (symbol == "<"){
            return num1 < num2;
        }
        if (symbol == "="){
            return num1 == num2;
        }
        if (symbol == ">="){
            return num1 >= num2;
        }
        if (symbol == "<="){
            return num1 <= num2;
        }
        return false;
    }
}
