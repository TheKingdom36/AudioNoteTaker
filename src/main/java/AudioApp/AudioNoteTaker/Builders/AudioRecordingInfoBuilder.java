package AudioApp.AudioNoteTaker.Builders;

import AudioApp.AudioNoteTaker.DAOs.AudioRecordingInfo;
import AudioApp.AudioNoteTaker.DAOs.Tag;
import AudioApp.AudioNoteTaker.DAOs.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AudioRecordingInfoBuilder {

    private long id;
    private String name;
    private User user;
    private List<Tag> tags;
    private LocalDate dateRecorded;
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
        this.tags = new ArrayList<>();

        return this;
    }

    public AudioRecordingInfoBuilder setContentType(String fileType){
        this.fileType = fileType;
        return this;
    }

    public AudioRecordingInfoBuilder withTags(List<Tag> tags) {
        this.tags = tags;

        return this;
    }

    public AudioRecordingInfoBuilder setDateRecorded(LocalDate dateRecorded) {
        this.dateRecorded = dateRecorded;

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
        info.setTags(tags);
        info.setName(name);
        info.setLength(length);
        info.setDateRecorded(dateRecorded);
        info.setSize(size);
        info.setUser(user);

        return info;
    }




}
