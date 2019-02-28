package org.fei.instructions.math;

public class Plus extends AbstractMathOperationInstruction {

    public Plus(int instructionNumber, String first, String second, String saveTo) {
        super(instructionNumber, first, second, saveTo);
    }

    @Override
    protected int mathOperationResult(int first, int second) {
        return first + second;
    }
}
