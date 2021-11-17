package AudioApp.AudioNoteTaker.UtilServices.Interfaces;


import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public interface DataStorageService {

    void save(byte[] fileData,String fileName, String dirName);

    void delete(String fileName,String dirName);

    void deleteDir(String dirName);

    void deleteAll(String dirName);

    byte[] findOne(String fileName, String dir) throws NotFoundException;

    List<byte[]> find(Map<String,String> fileDirNames) throws NotFoundException;

    List<String> listDirs();

}
