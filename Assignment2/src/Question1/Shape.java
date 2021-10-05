package Question1;

class Shape {
    public String name;
    public String color;
    public double area;
    public double perimeter;

    // constructor
    public Shape() {
    }
    public Shape(String name, String color) {
        this.name = name;
        this.color = color;
    }
    public Shape(String name, String color, double perimeter, double area) {
        this.name = name;
        this.color = color;
        this.perimeter = perimeter;
        this.area = area;
    }
    //
    public String printShape() {
        return "The " + name + " has a " + color + " color ";
    }
    // get / set
    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }
}

class Rectangle extends Shape {
    public double width;
    public double height;
    // constructor
    public Rectangle(double side) {
        this.width = side;
        this.height = side;
    }
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    public Rectangle(String name, String color, double width, double height) {
        this.name = name;
        this.color = color;
        this.width = width;
        this.height = height;
    }
    // override getArea() and getPerimeter()
    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
    // get / set
    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}

class Square extends Shape{
    public double side;
    // constructor
    public Square(double side) {
        this.side = side;
    }
    public Square(String name, String color, double side) {
        this.name = name;
        this.color = color;
        this.side = side;
    }
    // override getArea() and getPerimeter()
    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return side * 4;
    }
    // get / set
    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
}