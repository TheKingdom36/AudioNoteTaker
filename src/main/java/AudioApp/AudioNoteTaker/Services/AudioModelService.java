package AudioApp.AudioNoteTaker.Services;

import AudioApp.AudioNoteTaker.Models.AudioModel;
import AudioApp.AudioNoteTaker.Services.Interfaces.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AudioModelService implements CrudService<AudioModel,Long> {

    @Autowired
    AudioFileService audioFileService;

    @Autowired
    AudioRecordingInfoService audioRecordingInfoService;


    @Override
<<<<<<< Updated upstream
    public <S extends AudioModel> S save(S entity) {
=======
    public AudioModel save(AudioModel audioModel) {

        audioRecordingInfoService.save(audioModel.getAudioRecordingInfo());

        audioFileService


>>>>>>> Stashed changes
        return null;
    }


    @Override
    public <S extends AudioModel> S update(S entity) {
        return null;
    }

    @Override
    public Optional<AudioModel> findOne(Long aLong) {
        return Optional.empty();
    }
<<<<<<< Updated upstream

    @Override
    public boolean existsByUuid(String uuid) {
        return false;
    }

    @Override
=======

    @Override
    public boolean existsByUuid(String uuid) {
        return false;
    }

    @Override
>>>>>>> Stashed changes
    public boolean exists(Long aLong) {
        return false;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public void delete(AudioModel entity) {

    }
<<<<<<< Updated upstream

    @Override
    public int delete(List<AudioModel> entityList) {
        return 0;
    }

    @Override
    public void deleteAll() {
=======

    @Override
    public void delete(List<AudioModel> entityList) {
>>>>>>> Stashed changes

    }

    @Override
<<<<<<< Updated upstream
=======
    public void deleteAll() {

    }

    @Override
>>>>>>> Stashed changes
    public Class<AudioModel> getEntityClass() {
        return null;
    }
}
