import java.util.Arrays;

public class Calculator {
    public static void main(String[] args) {
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        String operation = args[2];

        if(operation.equalsIgnoreCase("add")){
            System.out.println(num1 + num2);
        } else if(operation.equalsIgnoreCase("sub")){
            System.out.println(num1 - num2);
        } else {
            System.out.println("Operation not supported");
        }

    }
}
