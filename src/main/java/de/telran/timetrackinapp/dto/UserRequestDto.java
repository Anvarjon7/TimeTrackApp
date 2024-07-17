package de.telran.timetrackinapp.dto;

import de.telran.timetrackinapp.model.entity.user.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserRequestDto(
        @NotBlank(message = "Invalid firstname : Empty name")
        @Size(max = 150)
        String firstName,

        @NotBlank(message = "Invalid lastname : Empty lastname")
        @Size(max = 150)
        String lastName,

        @NotBlank
        @Email(message = "Invalid email")
        String email,

        @NotBlank @Pattern(regexp = PASSWORD_REGEX, message = BAD_PASSWORD_MESSAGE)
        String password,

        @NotBlank @Pattern(regexp = PASSWORD_REGEX, message = BAD_PASSWORD_MESSAGE)
        String passwordConfirmation,

        Role role
) {


    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$";

    private static final String BAD_PASSWORD_MESSAGE = "Password must be min 8 symbols, contains lower case," +
            "digit and specials symbols (@#$%^&+=) ";

    public boolean isPasswordMatch() {
        return password.equals(passwordConfirmation);
    }
}
