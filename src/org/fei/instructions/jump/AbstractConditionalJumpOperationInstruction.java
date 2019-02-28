package org.fei.instructions.jump;

import org.fei.exceptions.JumpToNonExistentInstruction;
import org.fei.variables.Register;
import org.fei.exceptions.NumberExpectedException;
import org.fei.exceptions.VariableExpectedException;
import org.fei.exceptions.VariableNotFoundException;
import org.fei.instructions.AbstractInstruction;
import org.fei.instructions.Instruction;

public abstract class AbstractConditionalJumpOperationInstruction extends AbstractInstruction implements Instruction {

    private String variable;
    private String jumpTo;

    public AbstractConditionalJumpOperationInstruction(int instructionNumber, String variable, String jumpTo) {
        super(instructionNumber);
        this.variable = variable;
        this.jumpTo = jumpTo;
    }

    protected abstract boolean shouldJump(int variable);

    @Override
    public int execute(Register vars) throws Exception {

        if(Register.isNumeral(variable)) {
            throw new VariableExpectedException(instructionNumber, variable);
        }

        if(!Register.isNumeral(jumpTo)) {
            throw new NumberExpectedException(instructionNumber, jumpTo);
        }

        if(shouldJump(vars.getVariable(variable).orElseThrow(() -> new VariableNotFoundException(instructionNumber,variable)))) {

            int jumpToVal = Integer.parseInt(jumpTo);

            if(jumpToVal > vars.getLastPossibleInstructionNumber()) {
                throw new JumpToNonExistentInstruction(instructionNumber, jumpToVal);
            }

            return jumpToVal;
        } else {
            return instructionNumber + 1;
        }
    }
}
