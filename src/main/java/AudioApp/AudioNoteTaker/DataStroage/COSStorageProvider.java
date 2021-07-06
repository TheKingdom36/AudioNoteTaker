package AudioApp.AudioNoteTaker.DataStroage;


import java.io.IOException;
import java.util.List;
import java.util.Map;

public class COSStorageProvider implements DataStorageProvider {


    @Override
    public void save(byte[] fileData, String filename, String dir) throws IOException {

    }

    @Override
    public boolean delete(String fileName, String dir) {
        return false;
    }

    @Override
    public byte[] findOne(String filename, String dir) throws IOException {
        return new byte[0];
    }

    @Override
    public List<byte[]> find(Map<String, String> fileDirMap) throws IOException {
        return null;
    }

    @Override
    public boolean mkdir(String dirName) {
        return false;
    }

    @Override
    public List<String> listDirs() {
        return null;
    }

    @Override
    public boolean deleteDir(String dirName) {
        return false;
    }



    @Override
    public List<String> findAll(String dirName) {
        return null;
    }
}
