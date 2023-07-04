

class NewPriceRange {
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

    public NewPriceRange(String startTime, String endTime, int price) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
    }

    public NewPriceRange() {

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


    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }


    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

}