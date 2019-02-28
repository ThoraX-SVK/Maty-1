package org.fei.variables;

import java.util.Optional;

public interface Register {

    int getLastPossibleInstructionNumber();

    Optional<Integer> getVariable(String name);

    void save(String name, int value);

    static boolean isNumeral(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    static Optional<Integer> getNumberOrVariableValue(String string, Register vars) {

        if(isNumeral(string)) {
            return Optional.of(Integer.parseInt(string));
        }

        return vars.getVariable(string);
    }
}
