package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public BufferedReader getFile() throws IOException {

        File file = new File("/root/Projects/NestingProject/src/com/company/test.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        return br;
    }
}
