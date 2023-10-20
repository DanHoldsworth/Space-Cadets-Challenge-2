public class Line {
    private String[] splitLine;
    private String opcode = "";
    private String[] operand;

    public Line(String currentLine) {
        createSplitLine(currentLine);
        findOpcode(splitLine);
        operand = new String[splitLine.length];
        findOperand(splitLine);
    }

    public void createSplitLine(String currentLine) {
        splitLine = currentLine.split(" ");
    }

    public void findOpcode(String[] splitLine) {
        opcode = splitLine[0];
    }

    public void findOperand(String[] splitLine) {
        for (int i=0; i<operand.length; i++) {
            if (i==(operand.length-1)) {
                String tempString = splitLine[i];
                operand[i] = tempString.substring(0, tempString.length()-1);
            } else {
                operand[i] = splitLine[i+1];
            }
        }
    }

    public String getOpcode() {
        return opcode;
    }

    public String[] getOperand() {
        return operand;
    }
}