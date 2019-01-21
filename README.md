# TRC20CodeParser

```
    String path = "src/main/resources/test.sol";
    String content = Arrays.stream(Files.lines(Paths.get(path)).toArray()).map(Object::toString)
        .collect(Collectors.joining(System.lineSeparator()));

    CodeParserTool tool = new CodeParserTool();
    System.out.println(tool.parseTRC20(content) ? "TRC20" : "non-TRC20");
```
