package tm.integracja.Projekt.integracja.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class Report {

    @Id
    private String id;

    private double minValue;

    private double maxValue;

    private double average;

    private double amplitude;

    private LocalDate startDate;

    private LocalDate endDate;
}
