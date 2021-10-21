package AudioApp.AudioNoteTaker.AudioRecordings.Repository;

import AudioApp.AudioNoteTaker.DAOs.AudioRecordingInfo;
import AudioApp.AudioNoteTaker.Repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AudioRecordingInfoRepository extends AudioRepoCustom, BaseRepository<AudioRecordingInfo,Long> {

}
