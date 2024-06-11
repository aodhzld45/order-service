package Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Builder
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "memberShip")
public class MemberShipEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String memberShipId;

    @Enumerated(EnumType.STRING)
    private MemberShipType memberShipType;

    @Column(nullable = false)
    @ColumnDefault("0")
    private Integer point;

    @CreationTimestamp
    @Column(nullable = false, length = 20, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(length = 20)
    private LocalDateTime updatedAt;


    @Getter
    @RequiredArgsConstructor
    public enum MemberShipType {

        NAVER("네이버"),
        LINE("라인"),
        KAKAO("카카오"),;

        private final String companyName;
    }
}



