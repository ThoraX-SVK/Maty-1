package org.fei.exceptions;

public class VariableExpectedException extends Exception {

    private String found;
    private int errorOnInstructionNumber;

    public VariableExpectedException(int errorOnInstructionNumber, String found) {
        this.found = found;
        this.errorOnInstructionNumber = errorOnInstructionNumber;
    }

    @Override
    public String toString() {
        return "Chyba v instrukcii cislo " + errorOnInstructionNumber + ": Ocakaval sa nazov premennej, naslo sa " + found;
    }
}
