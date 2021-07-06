package AudioApp.AudioNoteTaker.DataStroage;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface DataStorageProvider {

    void save(byte[] fileData,String filename,String dir) throws IOException;

    boolean delete(String fileName, String dir);

    byte[] findOne(String filename, String dir) throws IOException;

    List<byte[]> find(Map<String,String> fileDirMap) throws IOException;

    boolean mkdir(String dirName);

    /**
     * Lists all Directories on root storage Directory
     * @return
     */
    List<String> listDirs();

    boolean deleteDir(String dirName);

    List<String> findAll(String dirName);
}
