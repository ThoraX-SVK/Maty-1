package org.fei.instructions.jump;

public class JumpIfTrue extends AbstractConditionalJumpOperationInstruction {

    public JumpIfTrue(int instructionNumber, String variable, String jumpTo) {
        super(instructionNumber, variable, jumpTo);
    }

    @Override
    protected boolean shouldJump(int variable) {
        return variable != 0;
    }
}
