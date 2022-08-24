package uz.isystem.centert.rooms;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomsDto {
    private Integer id;
    @NotBlank(message = ("The name cannot be empty or null"))
    private Integer name;
    private Boolean status;
}
