interface TwoPinPlug {
    void connectTwoPin();
}

class ThreePinPlug {
    public void connectThreePin() {
        System.out.println("Three pin plug connected.");
    }
}

// Adapter
class PlugAdapter implements TwoPinPlug {
    private ThreePinPlug threePinPlug;

    public PlugAdapter(ThreePinPlug threePinPlug) {
        this.threePinPlug = threePinPlug;
    }

    @Override
    public void connectTwoPin() {
        threePinPlug.connectThreePin();  // Adapting 3-pin to 2-pin
    }
}

public class AdapterPatternDemo {
    public static void main(String[] args) {
        ThreePinPlug threePinPlug = new ThreePinPlug();
        TwoPinPlug adapter = new PlugAdapter(threePinPlug);
        adapter.connectTwoPin();  // Three pin plug connected.
    }
}
