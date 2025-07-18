package DesignPatterns;

public class Singleton {

    static Singleton instance;

    private Singleton() {
    }

// From thread safety purpose (Lazy, Thread-Safe but Slow)
//   public static synchronized Singleton getInstance() {
//        if (singleton == null) {
//            singleton = new Singleton();
//        }
//      return instance;
//    }

    // From thread safety purpose (Best Practice – Inner Static Helper)
    private static class InstanceHelper {
        private static final Singleton instance = new Singleton();
    }

    static Singleton getInstance() {
        return InstanceHelper.instance;
    }

    public static void main(String[] args) {

        System.out.println(Singleton.getInstance());
        System.out.println(new Singleton.InstanceHelper());
        System.out.println(Singleton.getInstance());


    }

}
