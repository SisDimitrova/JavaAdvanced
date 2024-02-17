package sharkHaunt;


import java.util.ArrayList;
import java.util.List;

public class Basin {
    private String name;
    private int capacity;
    private List<Shark> sharks;

    public Basin(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.sharks = new ArrayList<>();
    }
    public void addShark(Shark shark) {
        if (capacity  > sharks.size() ) {
            sharks.add(shark);
        } else {
            System.out.println("This basin is at full capacity!");
        }
    }
    public boolean removeShark(String kind)  {
        return this.sharks.removeIf(shark -> shark.getKind().equals(kind));
    }
    public Shark getLargestShark() {
        Shark largestShark = null;

        for (Shark shark: sharks) {
            if (largestShark == null) {
                largestShark = shark;
            }
            if (shark.getLength() > largestShark.getLength()) {
                largestShark = shark;
            }
        }
        return largestShark;
    }
    public Shark getShark (String kind) {
        for (Shark shark : this.sharks) {
            if (shark.getKind().equals(kind)) {
                return shark;
            }
        }
        return null;
    }
    public int getCount() {
        return this.sharks.size();
    }
    public int getAverageLength() {
        int sum = 0;
        for (Shark shark : sharks) {
            sum += shark.getLength();
        }
        return sum / sharks.size();
    }
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sharks in " + this.name + ":");
        for (Shark shark: sharks) {
            sb.append(System.lineSeparator());
            sb.append(String.format("The %s is %d centimeters long, eats %s and inhabits %s.",
                    shark.getKind(), shark.getLength(), shark.getFood(), shark.getHabitation()));
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
