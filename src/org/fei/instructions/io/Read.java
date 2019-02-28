package org.fei.instructions.io;

import org.fei.utils.Console;
import org.fei.variables.Register;
import org.fei.instructions.AbstractInstruction;
import org.fei.instructions.Instruction;

import java.io.IOException;

public class Read extends AbstractInstruction implements Instruction {

    private String readVariable;

    public Read(int instructionNumber, String readVariable) {
        super(instructionNumber);
        this.readVariable = readVariable;
    }

    @Override
    public int execute(Register vars) throws IOException {
        int input = Console.readInt("Prosim, zadaj cislo ktoré bude ulozene do premennej " + readVariable);
        vars.save(readVariable, input);

        return instructionNumber + 1;
    }
}
