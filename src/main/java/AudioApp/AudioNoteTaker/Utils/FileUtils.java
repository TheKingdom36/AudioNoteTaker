package AudioApp.AudioNoteTaker.Utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUtils {
    public static File convertMultipartFileToFile(MultipartFile multipartFile) throws IOException {
        String fileName = multipartFile.getOriginalFilename();
        String prefix = fileName.substring(fileName.lastIndexOf("."));
        File file = null;
        file = File.createTempFile(fileName, prefix);
        multipartFile.transferTo(file);

        return file;
    }
}
