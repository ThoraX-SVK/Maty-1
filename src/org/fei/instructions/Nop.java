package org.fei.instructions;

import org.fei.variables.Register;

public class Nop extends AbstractInstruction implements Instruction {

    public Nop(int instructionNumber) {
        super(instructionNumber);
    }

    @Override
    public int execute(Register vars) throws Exception {
        return instructionNumber++;
    }
}
