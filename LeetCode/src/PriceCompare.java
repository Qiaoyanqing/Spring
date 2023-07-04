import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 比价金额计算: 同一个商品在不同平台的同一个时间有多个价格，请描绘一个品在整个生命周期内的最低价格。
 * 例如，商品A
 * 在平台A 10:00 - 12:00的价格为5
 * 在平台B 11:30 - 14:30的价格为3
 * 在平台C 14:00 - 16:00的价格为2
 * 那么全生命周期的最低价格 (忽略平台) 为
 * 10:00 - 11:30的价格为5
 * 11:30 - 14:00的价格为3
 * 14:00 - 16:00的价格为2
 * 请尝试多种corner case下的解题结果
 */
public class PriceCompare {

    public List<PriceRange> findLowPrice(List<PriceRange> params) {
        if (params.isEmpty()) {
            return params;
        }
        // 排序入参按照开始时间递增
        params.sort(Comparator.comparing(PriceRange::getStartTime));
        List<PriceRange> result = new ArrayList<>();
        result.add(params.get(0));
        for (int i = 1; i < params.size(); i++) {
            result.add(params.get(i));
            PriceRange current = params.get(i);
            PriceRange pre = params.get(i - 1);
            // 时间节点冲突情况
            if (LocalTime.parse(current.getStartTime()).compareTo(LocalTime.parse(pre.getEndTime())) < 0) {
                // 价格高
                if (current.getPrice() < pre.getPrice()) {
                    // 修改上一条数据的结束时间节点
                    pre.setEndTime(current.getStartTime());
                }
                // 价格低
                if (current.getPrice() > pre.getPrice()) {
                    // 修改当前数据的开始时间节点
                    current.setStartTime(pre.getEndTime());
                }
            }
        }
        return result;
    }
}
