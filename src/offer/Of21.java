package offer;

/**
 * Created by lifei on 2017/3/28.
 * 题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。在该栈中，调用min，push及pop的时间复杂度都是O(1)
 *
 * 看到这个问题，我们的第一反应可能是每次压入一个新元素进栈时，将栈里的所有元素排序，让最小的元素位于栈顶，这样就能在O(1)时间得到最小元素了。但这种思路不能保证最后压入的元素能够最先出栈，因此这个数据结构已经不是栈了。
 * 我们接着想到在栈里添加一个成员变量存放最小的元素。每次压入一个新元素进栈的时候，如果该元素比当前最小的元素还要小，则更新最小元素。
 * 面试官听到这种思路之后就会问：如果当前最小的元素被弹出栈了，如何得到下一个最小的元素呢？
 分析到这里我们发现仅仅添加一个成员变量存放最小元素是不够的，也就是说当最小元素弹出栈的时候，我们希望能够得到次小元素。因此在压入这个最小元素之前，我们要把次小元素保存起来。
 因此，在压入这个最小元素之前，我们要把次小元素保存起来。是不是可以把每次的最小元素都保存起来，放在另外一个辅助栈里呢？我们不妨举几个例子来分析一下把元素压入或者弹出栈的过程。
 *
 * 题目含义理解,是找到最小元素,而非每次弹出最小元素,是正常按照队列保证先进后出原则弹出数据
 */
public class Of21 {

    static class Node{

    }
    public static void main(String[] args) {

    }
}