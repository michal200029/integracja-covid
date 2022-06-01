package tm.integracja.Projekt.integracja.raport;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Report {
    private double minValue;

    private double maxValue;

    private double average;

    private double amplitude;

    private String startDate;

    private String endDate;

    @XmlElement
    public double getMinValue() {
        return minValue;
    }

    @XmlElement
    public double getMaxValue() {
        return maxValue;
    }

    @XmlElement
    public double getAverage() {
        return average;
    }

    @XmlElement
    public double getAmplitude() {
        return amplitude;
    }

    @XmlElement
    public String getStartDate() {
        return startDate;
    }

    @XmlElement
    public String getEndDate() {
        return endDate;
    }
}
