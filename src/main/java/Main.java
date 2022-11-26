public class Main {
    public static void main(String[] args) {

        //var rgb = 16777215; // hex = 0F1419, r = 15, g = 20, g = 25

        Colour c1 = new Colour(0.5f,1.0f,0.2f);
        Colour c2 = new Colour(6915853);
        System.out.println(Colour.compareColours(c1, c2));
        System.out.println(c2);
    }
}