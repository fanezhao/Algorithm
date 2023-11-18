package com.zmoyi.algorithm.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口解题模板
 *
 * @author zhaofeng
 * @date 2023/11/18 22:04
 */
public class SlidingWindow {

    void slidingWindow(String s) {
        // 用合适的数据结构记录窗口中的数据
        Map<Character, Integer> window = new HashMap<>();

        int left = 0;
        int right = 0;
        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            // 增大窗口
            right++;

            // 进行窗口内数据的一系列更新
            // ...

            /*** debug 输出的位置 ***/
            // 注意在最终的解法代码中不要 print
            // 因为 IO 操作很耗时，可能导致超时

            boolean windowNeedsShrink = true;
            while (left < right && windowNeedsShrink) {
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                window.put(d, window.get(d) - 1);
                // 缩小窗口
                left++;
                // 进行窗口内数据的一系列更新
                // ...
            }
        }
    }

}
