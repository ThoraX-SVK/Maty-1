package org.fei.variables;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RegisterImpl implements Register {

    private int NUMBER_OF_INSTRUCTIONS;
    private Map<String, Integer> vars = new HashMap<>();

    public RegisterImpl(int NUMBER_OF_INSTRUCTIONS) {
        this.NUMBER_OF_INSTRUCTIONS = NUMBER_OF_INSTRUCTIONS;
    }

    @Override
    public int getLastPossibleInstructionNumber() {
        return NUMBER_OF_INSTRUCTIONS;
    }

    @Override
    public Optional<Integer> getVariable(String name) {
        return Optional.ofNullable(vars.get(name));
    }

    @Override
    public void save(String name, int value) {
        vars.put(name, value);
    }


}
