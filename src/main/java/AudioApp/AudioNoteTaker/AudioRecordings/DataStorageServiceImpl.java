package AudioApp.AudioNoteTaker.AudioRecordings;


import AudioApp.AudioNoteTaker.DataStroage.DataStorageProvider;
import AudioApp.AudioNoteTaker.GeneralServices.Interfaces.DataStorageService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class DataStorageServiceImpl implements DataStorageService {

    @Autowired
    protected DataStorageProvider dataStorageProvider;

    @Override
    public void save(byte[] fileData,String fileName, String dirName) {
        try {
            dataStorageProvider.save(fileData,fileName,dirName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String fileName,String dirName) {
        dataStorageProvider.delete(fileName,dirName);
    }

    @Override
    public void deleteDir(String dirName) {
        dataStorageProvider.deleteDir(dirName);
    }

    @Override
    public void deleteAll(String dirName){
        List<String> fileNames =  dataStorageProvider.findAll(dirName);

        for (String fileName: fileNames
             ) {
            delete(fileName,dirName);
        }
    }

    /**#
     * Returns a file if found otherwise returns null
     * @param fileName name of file to find
     * @param dirName name of directory which to find the file
     * @return
     */
    @Override
    public byte[] findOne(String fileName, String dirName) throws NotFoundException {

        byte[] bytes;
        
        try {
            bytes = dataStorageProvider.findOne(fileName,dirName);
            return bytes;
        } catch (IOException e) {
            throw new NotFoundException("Data with provided fileName and dirName could not be found");
        }
        
    }

    /**
     * Returns a list of found files
     * @param fileDirMap mapping between files and file directories
     * @return
     */
    @Override
    public List<byte[]> find(Map<String,String> fileDirMap) throws NotFoundException {
        
        List<byte[]> files = new ArrayList<>();
        

        for (Map.Entry<String,String> entry: fileDirMap.entrySet()
        ) {
            try {
                files.add(findOne(entry.getKey(),entry.getValue()));
            } catch (NotFoundException e) {
                throw new NotFoundException("File Could not be found");
            }
        }

        return files;
    }

    @Override
    public List<String> listDirs() {
        return dataStorageProvider.listDirs();
    }
}
