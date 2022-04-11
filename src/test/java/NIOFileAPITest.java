import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;
import com.bridgelabz.employeepayrollservice.FileUtil;
import org.junit.Test;

public class NIOFileAPITest {

    private static String HOME = "D:\\IdeaProjects\\File IO Problem\\src\\main\\java\\com\\bridgelabz\\employeepayrollservice";
    private static String PLAY_WITH_NIO = "TempPlayGround";

    @Test
    public void givenPathWhenCheckedThenConfirm() throws IOException {

        Path homePath = Paths.get(HOME);
        assertTrue(Files.exists(homePath));
        System.out.println(homePath);

        //delete a file
        Path playPath = Paths.get(HOME + "/" + PLAY_WITH_NIO);
        if (Files.exists(playPath)) FileUtil.deleteFiles(playPath.toFile());
        assertTrue(Files.notExists(playPath));

        //Create a directory
        Files.createDirectory(playPath);
        assertTrue(Files.exists(playPath));

        //Create Empty File
        IntStream.range(1, 5).forEach(count -> {
            Path tempFile = Paths.get(playPath + "/temp" + count);
            assertTrue(Files.notExists(tempFile));
            try {
                Files.createFile(tempFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            assertTrue(Files.exists(tempFile));
        });


        System.out.println("Files.list");
        Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
        System.out.println("Files.newDirectory");
        Files.newDirectoryStream(playPath).forEach(System.out::println);
        System.out.println("Files.newDirectory with temp");
        Files.newDirectoryStream(playPath, path -> path.toFile().isFile() && path.toString().contains("temp"))
                .forEach(System.out::println);
    }
}