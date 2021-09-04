package AudioApp.AudioNoteTaker.Services;

import AudioApp.AudioNoteTaker.DAOs.AudioRecordingInfo;
import AudioApp.AudioNoteTaker.DAOs.AudioTag;
import AudioApp.AudioNoteTaker.DAOs.AudioTagId;
import AudioApp.AudioNoteTaker.Repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public List<AudioTag> getOrCreateTags(AudioRecordingInfo audioRecordingInfo ,List<String> audioTags) {

        List<AudioTag> tagsToReturn = new ArrayList<>();

        for (String tag:audioTags
             ) {
            Optional<AudioTag> tagOptional = tagRepository.findById(new AudioTagId( audioRecordingInfo,tag));

            if(tagOptional.isPresent()){
                tagsToReturn.add(tagOptional.get());
            }else{

                AudioTag newTag = createTag(audioRecordingInfo,tag);

                tagRepository.save(newTag);

                tagsToReturn.add(newTag);
            }
        }

        return tagsToReturn;
    }

    public Optional<AudioTag> getTag(AudioRecordingInfo audioRecordingInfo, String audioTag){
        return tagRepository.findById(new AudioTagId( audioRecordingInfo,audioTag));
    }

    public AudioTag createTag(AudioRecordingInfo audioRecordingInfo,String audioTag){

        AudioTag newTag = new AudioTag(audioRecordingInfo,audioTag);

        return tagRepository.save(newTag);
    }


    public AudioTag getOrCreateTag(AudioRecordingInfo audioRecordingInfo ,String audioTag) {

        return tagRepository
                .findById(new AudioTagId( audioRecordingInfo,audioTag))
                .orElseGet(() -> {
                    AudioTag newTag = createTag(audioRecordingInfo,audioTag);

                    tagRepository.save(newTag);

                    return newTag;
                });

    }

}