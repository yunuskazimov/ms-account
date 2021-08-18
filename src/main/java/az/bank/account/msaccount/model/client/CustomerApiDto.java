package az.bank.account.msaccount.model.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerApiDto {
    private Long id;
    private String firstName;
    private String lastName;
    private TitleType title;
    private LocalDate birthDate;
    private Map<ContactType,String> contacts;
}
