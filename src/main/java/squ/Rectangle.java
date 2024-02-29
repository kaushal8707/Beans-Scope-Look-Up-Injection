package squ;

// The code violates the Liskov Substitution Principle because the Square class modifies the behavior of the
// SetWidth and SetHeight methods from the Rectangle class. In the Rectangle class, SetWidth and SetHeight
// methods can set the width and height of the rectangle independently. But in the Square class, both methods
// set both the width and height to the same value.

class Rectangle{
    int height;
    int width;

    public void setHeightValue(int height) {
        this.height = height;
    }

    public void setWidthValue(int width) {
        this.width = width;
    }

    public int Area(int height, int width){
        return (height * width);
    }
}