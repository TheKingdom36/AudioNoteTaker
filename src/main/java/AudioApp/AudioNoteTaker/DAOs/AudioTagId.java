package AudioApp.AudioNoteTaker.DAOs;

import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;
import java.util.Objects;

@Getter @Setter
public class AudioTagId implements Serializable {

    private Long audioInfo;

    private String name;

    public AudioTagId(){

    }

    public AudioTagId(Long audioInfo,String name){
        this.audioInfo = audioInfo;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AudioTagId that = (AudioTagId) o;
        return Objects.equals(audioInfo ,that.audioInfo) &&
                Objects.equals(name ,that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(audioInfo ,name);
    }
}
