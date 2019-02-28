package org.fei.instructions.jump;

import org.fei.exceptions.JumpToNonExistentInstruction;
import org.fei.variables.Register;
import org.fei.exceptions.NumberExpectedException;
import org.fei.instructions.AbstractInstruction;
import org.fei.instructions.Instruction;

public class Jump extends AbstractInstruction implements Instruction {

    private String jumpTo;

    public Jump(int instructionNumber, String jumpTo) {
        super(instructionNumber);
        this.jumpTo = jumpTo;
    }

    @Override
    public int execute(Register vars) throws Exception {

        if(!Register.isNumeral(jumpTo)) {
            throw new NumberExpectedException(instructionNumber, jumpTo);
        }

        int jumpToVal = Integer.parseInt(jumpTo);

        if(jumpToVal > vars.getLastPossibleInstructionNumber()) {
            throw new JumpToNonExistentInstruction(instructionNumber, jumpToVal);
        }

        return jumpToVal;
    }
}
