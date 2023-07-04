
class PriceRange {
    private String startTime;
    private String endTime;

    @Override
    public String toString() {
        return "PriceRange{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", price=" + price +
                '}';
    }

    private int price;

    public PriceRange(String startTime, String endTime, int price) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
    }

    public PriceRange() {

    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }


    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

}