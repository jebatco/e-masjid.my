package my.emasjid.ajkapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ajk")
public class Ajk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "penggal_id", nullable = false)
    private Penggal penggal;

    @ManyToOne
    @JoinColumn(name = "jawatan_id", nullable = false)
    private Jawatan jawatan;

    @Column(nullable = false, length = 128)
    private String nama;

    @Column(name = "tarikh_mula", nullable = false)
    private Long tarikhMula;

    @Column(name = "tarikh_tamat", nullable = false)
    private Long tarikhTamat;

    @ManyToOne
    @JoinColumn(name = "status_ajk_id")
    private StatusAjk statusAjk;

    @Column(name = "create_date")
    private Long createDate;
}

