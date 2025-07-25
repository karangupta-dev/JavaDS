package Misc.AsyncProgramming;
// Java program to illustrate Asynchronous callback


class Bravo {

    private OnGeekEventListener mListener; // listener field

    // setting the listener
    public void registerOnGeekEventListener(OnGeekEventListener mListener)
    {
        this.mListener = mListener;
    }

    // My Asynchronous task
    public void doGeekStuff()
    {

        // An Async task always executes in new thread
        new Thread(new Runnable() {
            public void run()
            {

                // perform any operation
                System.out.println("Performing operation in Asynchronous Task");

                // check if listener is registered.
                if (mListener != null) {

                    // invoke the callback method of class A
                    mListener.onGeekEvent();
                }
            }
        }).start();
    }

    // Driver Program
    public static void main(String[] args)
    {

        Bravo obj = new Bravo();
        OnGeekEventListener mListener = new Alpha();
        obj.registerOnGeekEventListener(mListener);
        obj.doGeekStuff();
    }
}

class Alpha implements OnGeekEventListener {

    @Override
    public void onGeekEvent()
    {
        System.out.println("Performing callback after Asynchronous Task");
        // perform some routine operation
    }
    // some class A methods
}