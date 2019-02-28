package org.fei.exceptions;

public class JumpToNonExistentInstruction extends Exception {

    private Integer toNumber;
    private int errorOnInstructionNumber;

    public JumpToNonExistentInstruction(int errorOnInstructionNumber, Integer toNumber) {
        this.toNumber = toNumber;
        this.errorOnInstructionNumber = errorOnInstructionNumber;
    }

    @Override
    public String toString() {
        return "Chyba v instrukcii cislo " + errorOnInstructionNumber + ": Skok na instrukciu " + toNumber + " nie je mozny pretoze neexistuje!";
    }
}
