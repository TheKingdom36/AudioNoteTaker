package AudioApp.AudioNoteTaker.Services;

import AudioApp.AudioNoteTaker.Entities.AudioRecordingInfo;
import AudioApp.AudioNoteTaker.Repository.AudioRecording.AudioRecordingInfoRepository;

import AudioApp.AudioNoteTaker.Services.Interfaces.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AudioRecordingInfoService implements CrudService<AudioRecordingInfo,String> {

    @Autowired
    AudioRecordingInfoRepository audioRecordingInfoRepository;

    @Override
    public AudioRecordingInfo save(AudioRecordingInfo audioRecordingInfo) {

        return audioRecordingInfoRepository.save(audioRecordingInfo);

    }


    @Override
    public <S extends AudioRecordingInfo> S update(S entity) {
        return audioRecordingInfoRepository.save(entity);
    }

    @Override
    public Optional<AudioRecordingInfo> findOne(String ID) {
        Optional<AudioRecordingInfo> infoOptional = audioRecordingInfoRepository.findById(ID);

        if(infoOptional.isEmpty()){
            return null;
        }else{
            return infoOptional;
        }
    }

    @Override
    public boolean existsByUuid(String uuid) {
        return audioRecordingInfoRepository.existsById(uuid);
    }

    @Override
    public boolean exists(String id) {
        return audioRecordingInfoRepository.existsById(id);
    }

    @Override
    public long count() {
        return audioRecordingInfoRepository.count();
    }

    @Override
    public void delete(String id) {
        audioRecordingInfoRepository.deleteById(id);
    }

    @Override
    public void delete(AudioRecordingInfo entity) {
        audioRecordingInfoRepository.delete(entity);
    }

    @Override
    public int delete(List<AudioRecordingInfo> entityList) {

        audioRecordingInfoRepository.deleteAllInBatch(entityList);

        return 0;
    }

    @Override
    public void deleteAll() {
        audioRecordingInfoRepository.deleteAll();
    }

    @Override
    public Class<AudioRecordingInfo> getEntityClass() {
        return AudioRecordingInfo.class;
    }


}
