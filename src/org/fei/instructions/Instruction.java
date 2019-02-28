package org.fei.instructions;

import org.fei.variables.Register;

public interface Instruction {

    int execute(Register vars) throws Exception;
}
