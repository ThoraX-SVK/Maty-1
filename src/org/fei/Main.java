package org.fei;

import org.fei.exceptions.UnknownInstructionException;
import org.fei.instructions.Instruction;
import org.fei.instructions.math.Plus;
import org.fei.instructions.io.Read;
import org.fei.instructions.io.Write;
import org.fei.parser.Parser;
import org.fei.variables.Register;
import org.fei.variables.RegisterImpl;

import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws Exception {

        if (args.length == 0) {
            System.out.println("Prosim zadajte subor instrukcii ako parameter pri spustani programu! Ukoncujem program...");
            System.exit(0);
        }

        String inputFileName = args[0];

        List<Instruction> instructions = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(inputFileName))) {
            stream.forEach(line -> {
                try {
                    instructions.add(Parser.createInstruction(line));
                } catch (UnknownInstructionException e) {
                    System.out.println(e.toString());
                }
            });
        } catch (NoSuchFileException ex) {
            System.out.println("Nepodarilo sa nacitat zadany subor!");
            System.exit(0);
        }

        Register register = new RegisterImpl(instructions.size());

        int nextInstruction = 1;

        try {
            do {
                nextInstruction = instructions.get(nextInstruction-1).execute(register);
            } while (true);
        } catch (IndexOutOfBoundsException ex) {
            System.exit(0);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
