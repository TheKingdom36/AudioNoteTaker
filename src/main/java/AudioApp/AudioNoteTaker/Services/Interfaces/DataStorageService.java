package AudioApp.AudioNoteTaker.Services.Interfaces;


import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Map;
@Service
public interface DataStorageService {

    void save(byte[] fileData,String fileName, String dirName);

    void delete(String fileName,String dirName);

    void deleteDir(String dirName);

    void deleteAll(String dirName);

    byte[] findOne(String fileName, String dir);

    List<byte[]> find(Map<String,String> fileDirNames);

    List<String> listDirs();

}
