package writemore.apiservice.members.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginDto {
    private String loginId;
    private String password;
}
