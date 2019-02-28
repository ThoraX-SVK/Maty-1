package org.fei.instructions.compare;

public class LessOrEqual extends AbstractCompareOperationInstruction {

    public LessOrEqual(int instructionNumber, String first, String second, String saveTo) {
        super(instructionNumber, first, second, saveTo);
    }

    @Override
    protected boolean comparationIsTrue(int first, int second) {
        return first <= second;
    }
}
