package org.fei.instructions.math;

import org.fei.variables.Register;
import org.fei.exceptions.VariableExpectedException;
import org.fei.exceptions.VariableNotFoundException;
import org.fei.instructions.AbstractThreeVariablesInstruction;
import org.fei.instructions.Instruction;

public abstract class AbstractMathOperationInstruction extends AbstractThreeVariablesInstruction implements Instruction {

    public AbstractMathOperationInstruction(int instructionNumber, String first, String second, String saveTo) {
        super(instructionNumber, first, second, saveTo);
    }

    protected abstract int mathOperationResult(int first, int second);

    @Override
    public int execute(Register vars) throws VariableNotFoundException, VariableExpectedException {

        int firstVal, secondVal;

        firstVal = getFirstValue(vars);
        secondVal = getSecondValue(vars);
        assertSaveToIsVariable();

        int result = mathOperationResult(firstVal, secondVal);
        vars.save(saveTo, result);

        return instructionNumber + 1;
    }
}
