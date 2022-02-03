package filemanipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class HumanFileManager {

    private List<Human> humans = new ArrayList<>();

    public List<Human> getHumans() {
        return humans;
    }

    public void readHumansFromFile(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                humans.add(createHumans(line));
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("Can't read file!", ioException);
        }
    }

    public void writeMaleHumansToFile(Path path) {
        try {
            Files.write(path, createMales());
        } catch (IOException ioException) {
            throw new IllegalStateException("Can't write file!", ioException);
        }
    }

    private List<String> createMales() {
        List<String> males = new ArrayList<>();
        for (Human human : humans) {
            int firstDigit = Integer.parseInt(String.valueOf(human.getIdentityNumber().charAt(0)));
            if (firstDigit == 1 || firstDigit ==3) {
                males.add(human.getName() + ";" + human.getIdentityNumber());
            }
        }
        return males;
    }

    private Human createHumans(String line) {
        String name = line.split(";")[0];
        String id = line.split(";")[1];
        return new Human(name, id);
    }
}
