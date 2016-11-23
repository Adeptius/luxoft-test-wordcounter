package com.luxoft.consoleapplication.model;


public class LineReport {

    String line;
    String shortest;
    String longest;
    int average;
    int lineLength;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LineReport report = (LineReport) o;

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
}
