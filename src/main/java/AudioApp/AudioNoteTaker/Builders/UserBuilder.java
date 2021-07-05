package AudioApp.AudioNoteTaker.Builders;

import AudioApp.AudioNoteTaker.Entities.AudioRecordingInfo;
import AudioApp.AudioNoteTaker.Entities.User;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class UserBuilder {
    private long ID;
    private String firstName;
    private String lastName;
    private LocalDateTime joinedDate;
    private String email;
    private String password;
    private Set<AudioRecordingInfo> audioRecordingInfoSet;

    public UserBuilder(){

    }

    public UserBuilder setName(String firstName,String LastName){
        this.firstName = firstName;
        this.lastName = lastName;

        return this;
    }

    public UserBuilder setJoinedDate(LocalDateTime joinedDate){
        this.joinedDate = joinedDate;
        return this;
    }

    public UserBuilder setPassword(String Password){
        this.password = password;
        return this;
    }

    public UserBuilder setEmail(String Email){
        this.email = email;
        return this;
    }

    public UserBuilder withAudioRecordings(Set<AudioRecordingInfo> audioRecordingInfoSet){
        this.audioRecordingInfoSet = audioRecordingInfoSet;
        return this;
    }

    public UserBuilder withAudioRecordings(){
        this.audioRecordingInfoSet = new HashSet<>();
        return this;
    }

    public static UserBuilder newBuilder(){
        UserBuilder builder = new UserBuilder();

        return builder;
    }

    public User build(){
        User user = new User();

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setJoinedDate(joinedDate);
        user.setPassword(password);
        user.setAudioRecordingInfoSet(audioRecordingInfoSet);


        return user;
    }
}
