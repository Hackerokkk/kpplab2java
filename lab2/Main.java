import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Route {
    private String stationName;
    private int availableSeats;
    private int arrivalHour;
    private int arrivalMinute;
    private int departureHour;
    private int departureMinute;

    public Route(String stationName, int arrivalHour, int arrivalMinute, int departureHour, int departureMinute, int availableSeats) {
        this.stationName = stationName;
        this.availableSeats = availableSeats;
        this.arrivalHour = arrivalHour;
        this.arrivalMinute = arrivalMinute;
        this.departureHour = departureHour;
        this.departureMinute = departureMinute;
    }

    public String getStationName() {
        return stationName;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public int getArrivalHour() {
        return arrivalHour;
    }

    public int getArrivalMinute() {
        return arrivalMinute;
    }

    public int getDepartureHour() {
        return departureHour;
    }

    public int getDepartureMinute() {
        return departureMinute;
    }
}

class TicketOffice {
    private List<Route> routes;

    public TicketOffice() {
        routes = new ArrayList<>();
    }

    public void addRoute(Route route) {
        routes.add(route);
    }

    public void removeRoute(Route route) {
        routes.remove(route);
    }

    public void sortRoutes() {
        Collections.sort(routes, Comparator
                .comparingInt(Route::getAvailableSeats)
                .thenComparing(Route::getDepartureHour)
                .thenComparing(Route::getDepartureMinute)
                .thenComparing(Route::getArrivalHour)
                .thenComparing(Route::getArrivalMinute)
                .thenComparing(Route::getStationName)
        );
    }

    public void showRoutes() {
        for (Route route : routes) {
            System.out.println("Station: " + route.getStationName() +
                    ", Arrival: " + String.format("%02d:%02d", route.getArrivalHour(), route.getArrivalMinute()) +
                    ", Departure: " + String.format("%02d:%02d", route.getDepartureHour(), route.getDepartureMinute()) +
                    ", Seats: " + route.getAvailableSeats());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        TicketOffice ticketOffice = new TicketOffice();

        // Додавання даних про маршрути
        ticketOffice.addRoute(new Route("Station A", 8, 0, 8, 30, 50));
        ticketOffice.addRoute(new Route("Station B", 9, 0, 9, 30, 40));
        ticketOffice.addRoute(new Route("Station C", 10, 0, 10, 30, 30));

        // Виведення несортованих маршрутів
        System.out.println("Unsorted Routes:");
        ticketOffice.showRoutes();

        // Сортування та виведення відсортованих маршрутів
        System.out.println("\nSorted Routes:");
        ticketOffice.sortRoutes();
        ticketOffice.showRoutes();
    }
}
