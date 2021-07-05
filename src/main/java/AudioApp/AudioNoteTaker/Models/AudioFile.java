package AudioApp.AudioNoteTaker.Models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.sound.sampled.Clip;

@Builder
public class AudioFile {

    @Getter @Setter
    private Clip clip;
}
