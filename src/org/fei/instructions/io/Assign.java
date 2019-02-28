package org.fei.instructions.io;

import org.fei.variables.Register;
import org.fei.exceptions.VariableExpectedException;
import org.fei.exceptions.VariableNotFoundException;
import org.fei.instructions.AbstractInstruction;
import org.fei.instructions.Instruction;

public class Assign extends AbstractInstruction implements Instruction {

    private String saveTo;
    private String setTo;

    public Assign(int instructionNumber, String saveTo, String setTo) {
        super(instructionNumber);
        this.saveTo = saveTo;
        this.setTo = setTo;
    }


    @Override
    public int execute(Register vars) throws Exception {
        int value = Register.getNumberOrVariableValue(setTo, vars).orElseThrow(() -> new VariableNotFoundException(instructionNumber,setTo));

        if(Register.isNumeral(saveTo)) {
            throw new VariableExpectedException(instructionNumber, saveTo);
        }

        vars.save(saveTo, value);
        return instructionNumber + 1;
    }
}
