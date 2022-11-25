package org.ucc.a03;

/**
 * The Colour Class
 *
 * Internal representation of a Colour object consists
 * of three individual integer values R, G, B ranging from 0 - 255
 */
public class Colour {
    private int red, green, blue;

    /**
     * Constructor
     *
     * @param r , floating-point number ranging from 0.0 to 1.0
     * @param g , floating-point number ranging from 0.0 to 1.0
     * @param b , floating-point number ranging from 0.0 to 1.0
     */
    public Colour (float r, float g, float b){
        if ((r <= 1.0 && r >= 0.0) && (g <= 1.0 && g >= 0.0) && (b <= 1.0 && b >= 0.0)) {
            this.red = Math.round(r * 255.0f);
            this.green = Math.round(g * 255.0f);
            this.blue = Math.round(b * 255.0f);
        } else {
            throw new IllegalArgumentException("Float values are not valid!");
        }
    }

    /**
     * Constructor
     *
     * @param rgb , integer value between 0 and 16777215
     */
    public Colour (int rgb){
        if (rgb <= 16777215) {
            var hex = Integer.toHexString(rgb);
            hex = String.format("%06X",  rgb);

            this.red = Integer.parseInt(hex.substring(0, 2), 16);
            this.green = Integer.parseInt(hex.substring(2, 4), 16);
            this.blue = Integer.parseInt(hex.substring(4, 6), 16);
        } else {
            throw new IllegalArgumentException("Integer value is not valid!");
        }
    }

    public static boolean compareColours(Colour c1, Colour c2){
        if (c1.red == c2.red && c1.green == c2.green && c1.blue == c1.blue) {
            return true;
        }
        return false;
    }

    public int getRed(){
        return this.red;
    }

    public int getGreen(){
        return this.green;
    }

    public int getBlue(){
        return this.blue;
    }
}
