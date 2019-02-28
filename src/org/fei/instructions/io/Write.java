package org.fei.instructions.io;

import org.fei.variables.Register;
import org.fei.exceptions.VariableNotFoundException;
import org.fei.instructions.AbstractInstruction;
import org.fei.instructions.Instruction;


public class Write extends AbstractInstruction implements Instruction {

    private String readFromVar;

    public Write(int instructionNumber, String readFromVar) {
        super(instructionNumber);
        this.readFromVar = readFromVar;
    }

    @Override
    public int execute(Register vars) throws Exception {
        System.out.println("Premenna " + readFromVar + " --> " + vars.getVariable(readFromVar).orElseThrow(() -> new VariableNotFoundException(instructionNumber,readFromVar)));

        return instructionNumber + 1;
    }
}
