package pl.phs.client;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "clients")
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String phone_number;
    @NonNull
    private String street;
    @NonNull
    private String city;
    @NonNull
    private String zip_code;
}
