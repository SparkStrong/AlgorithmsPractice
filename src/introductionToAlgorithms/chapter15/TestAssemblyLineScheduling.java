package introductionToAlgorithms.chapter15;

/**
 * Created by Nack on 2017/10/31.
 */
public class TestAssemblyLineScheduling {
    public static void main(String[] args) {
        AssemblyLineScheduling tmp = new AssemblyLineScheduling();
        tmp.fastestWay();
        tmp.printStations();
        System.out.println("asc: ");
        int i = tmp.getLl();
        tmp.printStationsAsc(i, 6);
    }
}
