package org.fei.exceptions;

public class NumberExpectedException extends Exception {

    private String found;
    private int errorOnInstructionNumber;

    public NumberExpectedException(int errorOnInstructionNumber, String found) {
        this.found = found;
        this.errorOnInstructionNumber = errorOnInstructionNumber;
    }

    @Override
    public String toString() {
        return "Chyba v instrukcii cislo " + errorOnInstructionNumber + ": Ocakavalo sa cislo, naslo sa " + found;
    }
}
