package base;

public class FrameCounter {
    int countMax;
    public int count;

    public FrameCounter(int countMax) {
        this.countMax = countMax;
        this.count = 0;
    }

    public boolean run() {
        //true - count done
        //false - not yet done
        if (count < countMax) {
            count ++;
            System.out.println("count"+ count);
            return false;
        } else {
            return true;
        }
    }

    public void reset() {
        this.count = 0;
    }
}
