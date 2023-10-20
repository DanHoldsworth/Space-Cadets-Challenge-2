import java.io.*;
import java.util.*;

public class BareBonesInterpreter {
    private static ArrayList<Variable> variables = new ArrayList<>();

    public static void main(String[] args) {
        try {
            File program = new File("program.txt");
            Scanner reader = new Scanner(program);
            Line currentLine;
            String opcode;

            while (reader.hasNextLine()) {
                currentLine = new Line(reader.nextLine());
                opcode = currentLine.getOpcode();
                startOperation(opcode, currentLine);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public static void startOperation(String opcode, Line currentLine) {
        if (opcode.equals("clear")) {
            clear(currentLine.getOperand());
        } else if (opcode.equals("incr")) {
            incr(currentLine.getOperand());
        } else if (opcode.equals("decr")) {
            decr(currentLine.getOperand());
        } else if (opcode.equals("while")) {
            doWhile(currentLine.getOperand());
        }
    }

    public static void clear(String[] operand) {
        String name = operand[0];
        Variable newVariable = new Variable(name, 0);
        variables.add(newVariable);
    }

    public static void incr(String[] operand) {
        int index = -1;
        Variable currentVariable;

        for (int i=0; i<variables.size(); i++) {
            if (operand[0].equals(variables.get(i).getName())) {
                index = i;
                currentVariable = variables.get(i);
                currentVariable.setValue(currentVariable.getValue()+1);
            }
            if (index==-1) {
                System.out.println("Variable not found");
            }
        }
    }

    public static void decr(String[] operand) {
        int index = -1;
        Variable currentVariable;

        for (int i=0; i<variables.size(); i++) {
            if (operand[0].equals(variables.get(i).getName())) {
                index = i;
                currentVariable = variables.get(i);
                currentVariable.setValue(currentVariable.getValue()-1);
            }
            if (index==-1) {
                System.out.println("Variable not found");
            }
        }
    }

    public static void doWhile(String[] operand) {
        
    }
}