import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Stack;
import java.awt.Color;

public class Sorting {

    enum Color {
        RED {
            @Override
            public String toString() {
                return "| RED |";
            }
        },
        BLUE{
            @Override
            public String toString() {
                return "|BLUE |";
            }
        },
        BLACK{
            @Override
            public String toString() {
                return "|BLACK|";
            }
        },
        EMPTY {
            @Override
            public String toString() {
                return "|EMPTY|";
            }

        },
    };


    private Stack<Color>[] magacin = new Stack[6];

    private int iteration = 0;
    private int width = 600;
    private int height = 800 * 20;
    BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);;

    Sorting() {
        for(int i = 0; i < magacin.length; i++) {
            magacin[i] = new Stack();
        }
    }

    private java.awt.Color getColor(Color c) {

        if(c.equals(Color.RED)) return java.awt.Color.RED;
        if(c.equals(Color.BLUE)) return java.awt.Color.BLUE;

        return java.awt.Color.lightGray;
    }



    public void getOutput(Color[] input){

        sortingAlorithm(input);
        //printOutResult();
        createOutputImage();
    }

    private void printOutResult() {
        for(int i = 0; i < 7; i++) {
            if(magacin[0].isEmpty()) System.out.print(Color.EMPTY + " ");
            else System.out.print(magacin[0].pop() + " ");

            if(magacin[1].isEmpty()) System.out.print(Color.EMPTY + " ");
            else System.out.print(magacin[1].pop() + " ");

            if(magacin[2].isEmpty()) System.out.print(Color.EMPTY + " ");
            else System.out.print(magacin[2].pop() + " ");

            if(magacin[3].isEmpty()) System.out.print(Color.EMPTY + " ");
            else System.out.print(magacin[3].pop() + " ");

            if(magacin[4].isEmpty()) System.out.print(Color.EMPTY + " ");
            else System.out.print(magacin[4].pop() + " ");

            if(magacin[5].isEmpty()) System.out.print(Color.EMPTY + " ");
            else System.out.print(magacin[5].pop() + " ");


            System.out.println("");
        }
    }


    /**
     * Test sorting Algorithm, just uses normal
     * @param input
     * @return
     */
    private void sortingAlorithm(Color[] input) {

        for(Color c: input) {
            if (c.equals(Color.RED)) {
                magacin[findPlaceForRed()].push(Color.RED);
            } else if(c.equals(Color.BLUE)) {
                magacin[findPlaceForBlue()].push(Color.BLUE);
            }
        }
    }

    /**
     *
     * @return the number of the magacin
     */
    private int findPlaceForRed() {
        if((magacin[1].isEmpty() || magacin[1].peek().equals(Color.BLUE) )
        && magacin[1].size() < 5) {
            return 1;
        } else if(!magacin[2].isEmpty() && (magacin[2].peek().equals(Color.BLUE)
                && magacin[2].size() < 5)) {
            return 2;
        } else if(magacin[0].size() > 0 && magacin[0].size() < 5) {
            return 0;
        }
        return 3;
    }

    private int findPlaceForBlue() {
        if(magacin[0].isEmpty()) {
            return 0;
        } else if (magacin[2].isEmpty() || (magacin[2].peek().equals(Color.RED)  && magacin[2].size() < 5)) {
            return 2;
        } else if (!magacin[1].isEmpty() && (magacin[1].peek().equals(Color.RED)  && magacin[1].size() < 5)) {
            return 1;
        }  else if (magacin[3].size() < 5) {
            return 3;
        } else if (magacin[4].size() < 5) {
            return 4;
        }
        return 5;

    }

    private void createOutputImage() {

        Graphics2D g2d = bufferedImage.createGraphics();


        System.out.println(iteration);
        int x = 0;
        int y = 800 * iteration;
        iteration++;


        for(int i = 0; i < 7; i++) {

            if(magacin[0].isEmpty()) {
                g2d.setColor(java.awt.Color.lightGray);
                g2d.fillRect(x, y, 96, 96);
            }
            else {
                g2d.setColor(getColor(magacin[0].pop()));
                g2d.fillRect(x, y, 96, 96);
            }

            if(magacin[1].isEmpty()) {
                g2d.setColor(java.awt.Color.lightGray);
                g2d.fillRect(x + 100, y, 96, 96);
            }
            else {
                g2d.setColor(getColor(magacin[1].pop()));
                g2d.fillRect(x + 100, y, 96, 96);
            }
            if(magacin[2].isEmpty()) {
                g2d.setColor(java.awt.Color.lightGray);
                g2d.fillRect(x + 200, y, 96, 96);
            }
            else {
                g2d.setColor(getColor(magacin[2].pop()));
                g2d.fillRect(x + 200, y, 96, 96);
            }

            if(magacin[3].isEmpty()) {
                g2d.setColor(java.awt.Color.lightGray);
                g2d.fillRect(x + 300, y, 96, 96);
            }
            else {
                g2d.setColor(getColor(magacin[3].pop()));
                g2d.fillRect(x + 300, y, 96, 96);
            }
            if(magacin[4].isEmpty()) {
                g2d.setColor(java.awt.Color.lightGray);
                g2d.fillRect(x + 400, y, 96, 96);
            }
            else {
                g2d.setColor(getColor(magacin[4].pop()));
                g2d.fillRect(x + 400, y, 96, 96);
            }

            if(magacin[5].isEmpty()) {
                g2d.setColor(java.awt.Color.lightGray);
                g2d.fillRect(x + 500, y, 96, 96);
            }
            else {
                g2d.setColor(getColor(magacin[5].pop()));
                g2d.fillRect(x + 500, y, 96, 96);
            }



            y += 100;


        }
        g2d.setColor(java.awt.Color.WHITE);
        g2d.setFont(new Font("TimesRoman", Font.PLAIN, 50));
        g2d.drawString("Durchlauf " + iteration, 180, y + 50);
        //
        //g2d.fillRect(96,0, 4, height);



    }

    public void createResult() {
        File file = new File("myimage.jpg");
        try {
            ImageIO.write(bufferedImage, "jpg", file);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}


