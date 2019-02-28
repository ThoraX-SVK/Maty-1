package org.fei.exceptions;

public class VariableNotFoundException extends Exception {

    private String varName;
    private int errorOnInstructionNumber;

    public VariableNotFoundException(int errorOnInstructionNumber, String variableName) {
        this.varName = variableName;
        this.errorOnInstructionNumber = errorOnInstructionNumber;
    }

    @Override
    public String toString() {
        return "Chyba v instrukcii cislo " + errorOnInstructionNumber + ": Premenna s nazvom " + varName + " nebola inicializovana!";
    }

}
