package szawara.karol;

public class SampleBlock implements Block {
    public SampleBlock(String color, String material) {
        this.color = color;
        this.material = material;
    }

    String color;
    String material;
    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public String getMaterial() {
        return this.material;
    }
}
