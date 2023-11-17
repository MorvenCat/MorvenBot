package indi.morven.core;

import org.jline.reader.EndOfFileException;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.UserInterruptException;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

public class Cli {
    private static final String MESSAGE_WELCOME = "原神，启动！\n";
    private static final String BOTNAME = "Morven";

    public void botCli() throws Exception {
        // 创建终端
        Terminal terminal = TerminalBuilder.builder()
                .system(true)
                .build();

        // 读取终端输入
        LineReader lineReader = LineReaderBuilder.builder()
                .terminal(terminal)
                .build();

        // 输出欢迎语
        terminal.writer().append(Cli.MESSAGE_WELCOME);

        // 提示符
        String prompt = BOTNAME+" > ";
        while (true) {
            final String line;
            try {
                line = lineReader.readLine(prompt);
            } catch (UserInterruptException e) {
                // Ctrl+C
                continue;
            } catch (EndOfFileException e) {
                // Ctrl+D or kill
                break;
            } catch (Throwable t) {
                throw new Exception("无法从命令行读取.", t);
            }
            if (line == null) {
                continue;
            }
            // 获取输入,根据输入做对应的操作,CommandCall
            System.out.println(line);
        }
    }
}
