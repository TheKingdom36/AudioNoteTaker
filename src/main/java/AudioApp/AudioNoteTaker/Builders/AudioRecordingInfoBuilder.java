package AudioApp.AudioNoteTaker.Builders;

import AudioApp.AudioNoteTaker.Entities.AudioRecordingInfo;
import AudioApp.AudioNoteTaker.Entities.Tag;
import AudioApp.AudioNoteTaker.Entities.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AudioRecordingInfoBuilder {

    private long id;
    private String name;
    private User user;
    private List<Tag> tags;
    private Date dateRecorded;
    private long size;
    private long length;

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

    public AudioRecordingInfoBuilder withTags(List<Tag> tags) {
        this.tags = tags;

        return this;
    }

    public AudioRecordingInfoBuilder setDateRecorded(Date dateRecorded) {
        this.dateRecorded = dateRecorded;

        //TODO

        return null;
    }

    public AudioRecordingInfoBuilder setSize(long size) {
        this.size = size;

        return this;
    }

    public AudioRecordingInfoBuilder setLength(long length) {
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
