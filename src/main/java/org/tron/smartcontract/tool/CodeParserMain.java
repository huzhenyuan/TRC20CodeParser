package org.tron.smartcontract.tool;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CodeParserMain {

  public static void main(String[] args) throws Exception {
    String path = "src/main/resources/test.sol";
    String content = Arrays.stream(Files.lines(Paths.get(path)).toArray()).map(Object::toString)
        .collect(Collectors.joining(System.lineSeparator()));

    CodeParserTool tool = new CodeParserTool();
    System.out.println(tool.parseTRC20(content) ? "TRC20" : "non-TRC20");
    System.out.println(tool.toString());
  }
}