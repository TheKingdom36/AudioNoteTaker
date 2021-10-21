package AudioApp.AudioNoteTaker.DAOs.Builders;

import AudioApp.AudioNoteTaker.DAOs.AudioRecordingInfo;
import AudioApp.AudioNoteTaker.DAOs.AudioTag;
import AudioApp.AudioNoteTaker.DAOs.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AudioRecordingInfoBuilder {

    private long id;
    private String name;
    private User user;
    private List<AudioTag> audioTags;
    private LocalDate createdAt;
    private long size;
    private float length;
    private String fileType;



    public void setId(long id) {
        this.id = id;
    }

    public AudioRecordingInfoBuilder setName(String name) {
        this.name = name;

        return this;
    }

    public AudioRecordingInfoBuilder setUser(User user) {
        this.user = user;

        return this;
    }

    public AudioRecordingInfoBuilder withTags() {
        this.audioTags = new ArrayList<>();

        return this;
    }

    public AudioRecordingInfoBuilder setContentType(String fileType){
        this.fileType = fileType;
        return this;
    }

    public AudioRecordingInfoBuilder withTags(List<AudioTag> audioTags) {
        this.audioTags = audioTags;

        return this;
    }

    public AudioRecordingInfoBuilder setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;

        //TODO

        return this;
    }

    public AudioRecordingInfoBuilder setSize(long size) {
        this.size = size;

        return this;
    }

    public AudioRecordingInfoBuilder setLength(float length) {
        this.length = length;

        return this;
    }

    public AudioRecordingInfo build(){
        AudioRecordingInfo info = new AudioRecordingInfo();

        info.setId(id);
        info.setTags(audioTags);
        info.setName(name);
        info.setLength(length);
        info.setCreatedAt(createdAt);
        info.setSize(size);
        info.setUser(user);

        return info;
    }




}
