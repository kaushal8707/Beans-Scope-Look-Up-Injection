package squ;


public class IsCircleDerivedFromRectangle {
    public static void main(String[] args) {
        int height=10;
        int width=5;

        Rectangle rect=new Rectangle();
        rect.setHeightValue(height);
        rect.setWidthValue(width);
        int result=rect.Area(height,width);
        System.out.println(result);

        Rectangle rect1=new Square();
        rect.setHeightValue(height);
        rect.setWidthValue(width);
        int result1=rect1.Area(height,width);
        System.out.println(result);
    }
}
