package org.fei.parser;

import org.fei.exceptions.UnknownInstructionException;
import org.fei.instructions.Instruction;
import org.fei.instructions.Nop;
import org.fei.instructions.compare.*;
import org.fei.instructions.io.Assign;
import org.fei.instructions.io.Read;
import org.fei.instructions.io.Write;
import org.fei.instructions.jump.Jump;
import org.fei.instructions.jump.JumpIfFalse;
import org.fei.instructions.jump.JumpIfTrue;
import org.fei.instructions.math.Minus;
import org.fei.instructions.math.Multiply;
import org.fei.instructions.math.Plus;

public class Parser {

    public static int instructionNumber = 0;
    
    public static Instruction createInstruction(String string) throws UnknownInstructionException {

        String[] splitTo = string.split(",");
        String identifier = splitTo[0];

        instructionNumber++;

        try {
            switch (identifier) {
                case "READ":
                    return new Read(instructionNumber, splitTo[1]);
                case "WRITE":
                    return new Write(instructionNumber, splitTo[1]);
                case "+":
                    return new Plus(instructionNumber, splitTo[1], splitTo[2], splitTo[3]);
                case "-":
                    return new Minus(instructionNumber, splitTo[1], splitTo[2], splitTo[3]);
                case "*":
                    return new Multiply(instructionNumber, splitTo[1], splitTo[2], splitTo[3]);
                case "<":
                    return new LessThan(instructionNumber, splitTo[1], splitTo[2], splitTo[3]);
                case ">":
                    return new GreaterThan(instructionNumber, splitTo[1], splitTo[2], splitTo[3]);
                case ">=":
                    return new GreaterOrEqual(instructionNumber, splitTo[1], splitTo[2], splitTo[3]);
                case "<=":
                    return new LessOrEqual(instructionNumber, splitTo[1], splitTo[2], splitTo[3]);
                case "==":
                    return new Equals(instructionNumber, splitTo[1], splitTo[2], splitTo[3]);
                case "=":
                    return new Assign(instructionNumber, splitTo[1], splitTo[2]);
                case "JUMP":
                    return new Jump(instructionNumber, splitTo[1]);
                case "JUMPT":
                    return new JumpIfTrue(instructionNumber, splitTo[1], splitTo[2]);
                case "JUMPF":
                    return new JumpIfFalse(instructionNumber, splitTo[1], splitTo[2]);
                case "NOP":
                    return new Nop(instructionNumber);
                default:
                    throw new UnknownInstructionException(instructionNumber);
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new UnknownInstructionException(instructionNumber);
        }



    }


}
