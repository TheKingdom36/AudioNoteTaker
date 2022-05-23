package AudioApp.AudioNoteTaker.DAOs.Builders;

import AudioApp.AudioNoteTaker.DAOs.AudioRecordingInfo;
import AudioApp.AudioNoteTaker.DAOs.Authority;
import AudioApp.AudioNoteTaker.DAOs.User;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class UserBuilder {
    private String firstName;
    private String lastName;
    private LocalDateTime joinedDate;
    private String displayName;
    private String password;
    private Set<AudioRecordingInfo> audioRecordingInfoSet;
    private String username;
    private Boolean enabled;
    private Authority authority;

    public UserBuilder(){

    }

    public UserBuilder setName(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

        return this;
    }

    public UserBuilder setJoinedDate(LocalDateTime joinedDate){
        this.joinedDate = joinedDate;
        return this;
    }

    public UserBuilder setPassword(String password){
        this.password = password;
        return this;
    }

    public UserBuilder setUsername(String username){
        this.username = username;
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

    public UserBuilder setDisplayName(String displayName){
        this.displayName = displayName;

        return this;
    }

    public UserBuilder setEnabled(Boolean enabled){
        this.enabled = enabled;
        return this;
    }

    public UserBuilder setAuthority(Authority authority){
        this.authority = authority;
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
        user.setJoinedDate(joinedDate);
        user.setAudioRecordingInfoSet(audioRecordingInfoSet);
        user.setPassword(password);
        user.setDisplayName(displayName);
        user.setAuthority(authority);
        user.setEnabled(enabled);
        user.setUsername(username);

        return user;
    }
}
