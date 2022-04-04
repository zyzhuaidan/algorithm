/**
 * @author xingzhou
 * @version 1.0.0
 * @ClassName Test1.java
 * @Description TODO
 * @createTime 2022年04月01日 19:17:00
 */
public class Test1 {
    public static void main(String[] args) {
        double fps = 0.0;
        if (1 == 1) {

            int[] avgFrameRate = {1, 0};
            if (avgFrameRate[1] == 0 || (avgFrameRate[0] == 0 && avgFrameRate[1] == 1)) {
                int[] rFrameRate = {0, 0};
                fps = rFrameRate[0] * 1.0 / rFrameRate[1];
            } else {
                fps = avgFrameRate[0] * 1.0 / avgFrameRate[1];
            }
        }
        fps = Double.isNaN(fps) ? 0 : fps;
        System.out.println(fps);
    }
}
