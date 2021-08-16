import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Figure {
    String type;
    @JsonIgnoreProperties(ignoreUnknown = true)

    int radius;
    @JsonIgnoreProperties(ignoreUnknown = true)

    int l;
    @JsonIgnoreProperties(ignoreUnknown = true)

    int b;

    @JsonIgnoreProperties(ignoreUnknown = true)
    int side;

    public Figure() {
    }

    public Figure(String type, int radius, int l, int b, int side) {
        this.type = type;
        this.radius = radius;
        this.l = l;
        this.b = b;
        this.side = side;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public String toString() {
        return "Figure{" +
                "type='" + type + '\'' +
                ", radius=" + radius +
                ", l=" + l +
                ", b=" + b +
                ", side=" + side +
                '}';
    }
}