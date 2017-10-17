package site.kason.netlib.example;

import java.io.IOException;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import site.kason.netlib.example.echo.EchoServer;
import site.kason.netlib.example.time.TimeServer;

/**
 *
 * @author Kason Yang
 */
public class App {

  private final static String SYNTAX = "netlib-example [option...] COMMAND"
          + "\r\n"
          + "\r\navailable commands:"
          + "\r\n echo  --run EchoServer"
          + "\r\n time  --run TimeServer"
          + "\r\n\r\n"
          + "options:"
          ;

  private final static Options OPTIONS;

  static {
    OPTIONS = new Options()
            .addOption("h", false, "show this help message");
  }

  public static void printUsage() {
    HelpFormatter formatter = new HelpFormatter();
    formatter.printHelp(SYNTAX, OPTIONS);
  }

  public static void main(String[] args) throws ParseException, IOException {
    DefaultParser parser = new DefaultParser();
    CommandLine cli = parser.parse(OPTIONS, args);
    String[] cliArgs = cli.getArgs();
    if (cli.hasOption("h") || cliArgs.length<=0) {
      printUsage();
      return;
    }
    String command = cliArgs[0];
    run(command);
  }

  private static void run(String command) throws IOException {
    String[] args = new String[0];
    switch (command) {
      case "time":
        TimeServer.main(args);
        break;
      case "echo":
        EchoServer.main(args);
        break;
    }
  }

}
