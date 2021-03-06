package uk.gov.hmcts.reform.divorce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDetails {

    private String id;
    private String email;
    private String forename;
    private String surname;
    private List<String> roles;

}
