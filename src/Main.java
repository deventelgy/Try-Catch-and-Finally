import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args)
    {
        //nuestro bloque de prueba: try(BufferedReader reader = new BufferedReader((new FileReader(args[0]))))
        try(BufferedReader reader = new BufferedReader((new FileReader(args[0])))){
            String inputLine=null;
            while((inputLine = reader.readLine()) !=null)
            {
                performOperation(inputLine);
            }
        }catch (Exception ex)
        {
            System.out.println("Error!. "+ex.getMessage());
        }
    }


    private static void performOperation(String inputLine){
        String[] parts = inputLine.split(" ");
        MathOperation operation = MathOperation.valueOf(parts[0].toUpperCase());
        int leftVal = valueFromWord(parts[1]);
        int rightVal = leftValFromWorld(parts[2]);

        int result = execute(operation, leftVal,rightVal);
    }
    static int execute(MathOperation operation, int leftVal, int rightVal){
        int result =0;
        switch (operation){
            case ADD:
                result = leftVal + rightVal;
            break;
            case SUBTRACT:
                result = leftVal - rightVal;
            break;
            case MULTIPLY:
                result = leftVal * rightVal;
            break;
            case DIVIDE:
                result = leftVal / rightVal;
            break;

        }
        return result;
    }
}