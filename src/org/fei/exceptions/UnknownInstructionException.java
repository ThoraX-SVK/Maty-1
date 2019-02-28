package org.fei.exceptions;

public class UnknownInstructionException extends Exception {

    private int errorOnInstructionNumber;

    public UnknownInstructionException(int errorOnInstructionNumber) {
        this.errorOnInstructionNumber = errorOnInstructionNumber;
    }

    @Override
    public String toString() {
        return "Chyba v instrukcii cislo " + errorOnInstructionNumber + ": Instrukcia nema spravny zapis!";
    }


}
