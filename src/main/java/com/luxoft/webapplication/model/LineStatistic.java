package com.luxoft.webapplication.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "string_statistics")
public class LineStatistic {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private long id;

    @Column(name = "filename")
    private String filename;

    @Column(name = "string")
    private String line;

    @Column(name = "shortest")
    private String shortest;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "longest")
    private String longest;

    @Column(name = "average_length")
    private int average;

    @Column(name = "lenght")
    private int lineLength;

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }
    public String getShortest() {
        return shortest;
    }

    public void setShortest(String shortest) {
        this.shortest = shortest;
    }

    public String getLongest() {
        return longest;
    }

    public void setLongest(String longest) {
        this.longest = longest;
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    public int getLineLength() {
        return lineLength;
    }

    public void setLineLength(int lineLength) {
        this.lineLength = lineLength;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LineStatistic report = (LineStatistic) o;

        if (average != report.average) return false;
        if (lineLength != report.lineLength) return false;
        if (line != null ? !line.equals(report.line) : report.line != null) return false;
        if (shortest != null ? !shortest.equals(report.shortest) : report.shortest != null) return false;
        return longest != null ? longest.equals(report.longest) : report.longest == null;
    }

    @Override
    public int hashCode() {
        int result = line != null ? line.hashCode() : 0;
        result = 31 * result + (shortest != null ? shortest.hashCode() : 0);
        result = 31 * result + (longest != null ? longest.hashCode() : 0);
        result = 31 * result + average;
        result = 31 * result + lineLength;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Line: ").append(line).append("\n");
        builder.append("Shortest word is: ").append(shortest);
        builder.append(", longest is: ").append(longest);
        builder.append("\naverage word length: ").append(average);
        builder.append(" line length is: ").append(lineLength).append("\n");
        return builder.toString();
    }
}
