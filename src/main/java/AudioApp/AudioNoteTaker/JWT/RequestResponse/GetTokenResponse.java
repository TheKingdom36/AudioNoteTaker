package AudioApp.AudioNoteTaker.JWT.RequestResponse;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GetTokenResponse {
    private String token;

    public GetTokenResponse(){

    }

    public GetTokenResponse(String token){
        this.token = token;
    }
}
