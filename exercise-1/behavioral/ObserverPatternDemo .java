import java.util.ArrayList;
import java.util.List;

// Subject
interface WeatherStation {
    void addObserver(WeatherObserver observer);
    void removeObserver(WeatherObserver observer);
    void notifyObservers();
}

class ConcreteWeatherStation implements WeatherStation {
    private List<WeatherObserver> observers = new ArrayList<>();
    private int temperature;

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    @Override
    public void addObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature);
        }
    }
}

// Observer
interface WeatherObserver {
    void update(int temperature);
}

class PhoneDisplay implements WeatherObserver {
    @Override
    public void update(int temperature) {
        System.out.println("Phone Display: Temperature updated to " + temperature);
    }
}

class WindowDisplay implements WeatherObserver {
    @Override
    public void update(int temperature) {
        System.out.println("Window Display: Temperature updated to " + temperature);
    }
}

public class ObserverPatternDemo {
    public static void main(String[] args) {
        ConcreteWeatherStation station = new ConcreteWeatherStation();
        PhoneDisplay phoneDisplay = new PhoneDisplay();
        WindowDisplay windowDisplay = new WindowDisplay();
        
        station.addObserver(phoneDisplay);
        station.addObserver(windowDisplay);
        
        station.setTemperature(25);  // Notifies both displays
    }
}
