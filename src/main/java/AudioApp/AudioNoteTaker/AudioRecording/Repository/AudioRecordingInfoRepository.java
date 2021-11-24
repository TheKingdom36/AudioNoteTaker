package AudioApp.AudioNoteTaker.AudioRecording.Repository;

import AudioApp.AudioNoteTaker.DAOs.AudioRecordingInfo;
import AudioApp.AudioNoteTaker.Repository.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AudioRecordingInfoRepository extends AudioRepoCustom, BaseRepository<AudioRecordingInfo,Long> {



}
