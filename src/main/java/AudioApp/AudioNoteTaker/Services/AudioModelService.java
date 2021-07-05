package AudioApp.AudioNoteTaker.Services;

import AudioApp.AudioNoteTaker.Entities.AudioRecordingInfo;
import AudioApp.AudioNoteTaker.Entities.User;
import AudioApp.AudioNoteTaker.Models.AudioFile;
import AudioApp.AudioNoteTaker.Models.AudioModel;
import AudioApp.AudioNoteTaker.Repository.AudioRecordingAudio.AudioRecordingInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AudioModelService implements CrudService<AudioModel,Long>{

    @Autowired
    AudioFileService audioFileService;

    @Autowired
    AudioRecordingInfoService audioRecordingInfoService;

    @Override
    public AudioModel save(AudioModel audioModel) {
        return null;
    }

    @Override
    public AudioModel find(Long aLong) {
        return null;
    }

    @Override
    public void update(AudioModel audioModel) {

    }

    @Override
    public void delete(Long aLong) {

    }



}
