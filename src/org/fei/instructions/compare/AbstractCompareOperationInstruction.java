package org.fei.instructions.compare;

import org.fei.variables.Register;
import org.fei.exceptions.VariableExpectedException;
import org.fei.exceptions.VariableNotFoundException;
import org.fei.instructions.AbstractThreeVariablesInstruction;
import org.fei.instructions.Instruction;

public abstract class AbstractCompareOperationInstruction extends AbstractThreeVariablesInstruction implements Instruction {

    public AbstractCompareOperationInstruction(int instructionNumber, String first, String second, String saveTo) {
        super(instructionNumber, first, second, saveTo);
    }

    protected abstract boolean comparationIsTrue(int first, int second);

    @Override
    public int execute(Register vars) throws VariableNotFoundException, VariableExpectedException {
        int firstVal, secondVal;

        firstVal = getFirstValue(vars);
        secondVal = getSecondValue(vars);
        assertSaveToIsVariable();

        if (comparationIsTrue(firstVal, secondVal)) {
            vars.save(saveTo, 1);
        } else {
            vars.save(saveTo, 0);
        }

        return instructionNumber + 1;
    }

}
