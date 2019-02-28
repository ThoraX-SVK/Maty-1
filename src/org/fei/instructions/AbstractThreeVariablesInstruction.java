package org.fei.instructions;

import org.fei.variables.Register;
import org.fei.exceptions.VariableExpectedException;
import org.fei.exceptions.VariableNotFoundException;

public abstract class AbstractThreeVariablesInstruction extends AbstractInstruction implements Instruction {

    private String first;
    private String second;
    protected String saveTo;

    public AbstractThreeVariablesInstruction(int instructionNumber, String first, String second, String saveTo) {
        super(instructionNumber);
        this.first = first;
        this.second = second;
        this.saveTo = saveTo;
    }

    protected int getFirstValue(Register vars) throws VariableNotFoundException {
        return Register.getNumberOrVariableValue(first, vars).orElseThrow(() -> new VariableNotFoundException(instructionNumber,first));
    }

    protected int getSecondValue(Register vars) throws VariableNotFoundException {
        return Register.getNumberOrVariableValue(second, vars).orElseThrow(() -> new VariableNotFoundException(instructionNumber,second));
    }

    protected void assertSaveToIsVariable() throws VariableExpectedException {
        if(Register.isNumeral(saveTo)) {
            throw new VariableExpectedException(instructionNumber, saveTo);
        }
    }
}
