package org.fei.instructions.math;

public class Minus extends AbstractMathOperationInstruction {

    public Minus(int instructionNumber, String first, String second, String saveTo) {
        super(instructionNumber, first, second, saveTo);
    }

    @Override
    protected int mathOperationResult(int first, int second) {
        return first - second;
    }
}
