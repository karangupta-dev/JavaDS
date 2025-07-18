package DesignPatterns;


interface Shape {
    void printShapeName();
}

class Circle implements Shape {

    public void printShapeName() {
        System.out.println("I am fancy Circle");
    }
}

class Square implements Shape {

    public void printShapeName() {
        System.out.println("I am fancy Square");
    }
}


interface IShapeFactory {
    Shape getShapeInstance();
}

class CircleShapeFactory implements IShapeFactory {

    public Shape getShapeInstance() {
        return new Circle();
    }

}

class SquareShapeFactory implements IShapeFactory {

    public Shape getShapeInstance() {
        return new Square();
    }

}


class ShapeFactory {

    IShapeFactory shapeFactory;

    ShapeFactory(IShapeFactory shapeFactory) {
        this.shapeFactory = shapeFactory;
    }

    Shape getInstance() {
        return shapeFactory.getShapeInstance();
    }
}

public class FactoryMethod {

    public static void main(String args[]) {

        ShapeFactory factory = new ShapeFactory(new SquareShapeFactory());
        Shape shape = factory.getInstance();
        shape.printShapeName();

        factory = new ShapeFactory(new CircleShapeFactory());
        shape = factory.getInstance();
        shape.printShapeName();

    }


}
