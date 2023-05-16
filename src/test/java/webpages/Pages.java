package webpages;

import org.openqa.selenium.WebDriver;

public class Pages {
    private final WebDriver webDriver;
    private Home home;
    private Blog blog;
    private Trips trips;
    private Destinations destinations;
    private Activities activities;
    private TripTypes tripTypes;

    public Pages(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public Home homePage() {
        return home == null ? new Home(webDriver) : this.home;
    }

    public Blog blogPage() {
        return blog == null ? new Blog(webDriver) : this.blog;
    }

    public Trips tripsPage() { return trips == null ? new Trips(webDriver) : this.trips; }

    public Destinations destinationsPage() { return destinations == null ? new Destinations(webDriver) : this.destinations; }

    public TripTypes tripTypesPage() { return tripTypes == null ? new TripTypes(webDriver) : this.tripTypes; }

    public Activities activitiesPage() { return activities == null ? new Activities(webDriver) : this.activities;}


}
