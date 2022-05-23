package AudioApp.AudioNoteTaker.DataStroage;



import AudioApp.AudioNoteTaker.Config.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class LocalStorageProvider implements DataStorageProvider {

    String basePath;
    ConfigProperties configProperties;

    @Autowired
    public LocalStorageProvider(ConfigProperties configProperties){

       this.configProperties = configProperties;

       basePath = configProperties.getBaseLocalFileStoragePath();


    }

    @Override
    public void save(byte[] fileData, String filename, String dir) throws IOException {


        File file = new File(basePath+"/"+dir+"/"+filename);
        File dirFolder = new File(basePath+"/"+dir);

        if(dirFolder.exists() == false){

            mkdir(dir);

        }

        file.createNewFile();
        OutputStream outputStream = new FileOutputStream(file);
        outputStream.write(fileData);
        outputStream.close();
    }

    @Override
    public boolean delete(String fileName, String dir) {
        File file = new File(basePath+"/"+dir+"/"+fileName);
        return file.delete();


    }

    @Override
    public byte[] findOne(String filename, String dir) throws IOException {

        File file = new File(basePath+"/"+dir+"/"+filename);
        System.out.println(basePath+"/"+dir+"/"+filename);

        if(file.exists()==false){
            throw new IOException("File does not exist");
        }else if(file.isFile()==false){
            throw new IOException("Must be a file");
        }

        return  Files.readAllBytes(file.toPath());


    }

    @Override
    public List<byte[]> find(Map<String,String> fileDirMap) throws IOException {

        List<byte[]> files = new ArrayList<>();

        for (Map.Entry<String, String> entry: fileDirMap.entrySet()
             ) {
            files.add(findOne(entry.getKey(),entry.getValue()));
        }

        return files;
    }

    @Override
    public boolean mkdir(String dirName) {
        File dirFolder = new File(basePath+"/"+dirName);
        dirFolder.mkdir();

        return true;
    }



    @Override
    public List<String> listDirs() {

        File topDir = new File(basePath);
        List<String> fileNames = new ArrayList<>();

        for (File file: topDir.listFiles()
             ) {
            fileNames.add(file.getName());
        }

        return fileNames;

    }


    @Override
    public boolean deleteDir(String dirName) {

        File dir = new File(basePath+"/"+ dirName);


        if(dir.listFiles().length == 0){
            dir.delete();
            return true;
        }


        return false;
    }

    @Override
    public List<String> findAll(String dirName) {
        return null;
    }
}
