package edu.nick.cursach.dataSet;

import edu.nick.cursach.model.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataSet {

    private List<Bus> buses = new ArrayList<>(Arrays.asList(
//            new Bus("1", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Bogdan-5", null, 321, 35, "eco-class", null),
//            new Bus("2", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Mercedes-Benz Sprinter", null, 543, 29, "business-class", null),
//            new Bus("3", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "CityLAZ-12", null, 123, 37, "eco-class", null),
//            new Bus("4", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Volvo B10M", null, 234, 40, "business-class", null),
//            new Bus("5", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Setra S416", null, 243, 38, "premium-class", null),
//            new Bus("6", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Ford Transit", null,534, 50, "eco-class", null),
//            new Bus("7", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "CityLAZ-12", null,423, 37, "premium-class", null),
//            new Bus("8", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Volvo 9700S", null,524, 45, "medium-class", null),
//            new Bus("9", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Bogdan-5", null,6345, 28, "business-class", null),
//            new Bus("10", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "CityLAZ-12", null,25, 39, "eco-class", null),
//            new Bus("11", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Volvo B10M", null,2435, 40, "business-class", null),
//            new Bus("12", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Setra S416", null,234, 38, "premium-class", null),
//            new Bus("13", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Ford Transit", null,123, 50, "eco-class", null),
//            new Bus("14", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "CityLAZ-12", null,523, 37, "premium-class", null),
//            new Bus("15", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Mercedes Benz-Sprinter", null,253, 29, "business-class", null)
    ));


    private List<Taxi> taxis = new ArrayList<>(Arrays.asList(
//            new Taxi("1", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Audi", null, 432, 5, "sedan"),
//            new Taxi("2", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "BMW", null,423, 5, "sedan"),
//            new Taxi("3", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Nissan", null,153, 7, "mini-bus"),
//            new Taxi("4", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Chevrolet", null,6423, 5, "sedan"),
//            new Taxi("5", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "BMW", null,354, 5, "sedan"),
//            new Taxi("6", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Opel", null,264, 5, "sedan"),
//            new Taxi("7", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Nissan", null, 235,4, "coupe")
    ));

    private List<RouteTaxi> routeTaxis = new ArrayList<>(Arrays.asList(
//            new RouteTaxi("1", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Bogdan-5", null, 627,30, 22, null),
//            new RouteTaxi("2", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Mercedes-Benz Sprinter", 624, null, 35,18, null),
//            new RouteTaxi("3", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Mercedes-Benz Sprinter",572, null, 45, 5, null),
//            new RouteTaxi("4", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "CityLAZ-12", null, 534, 35,3, null),
//            new RouteTaxi("5", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Bogdan-3", null,643, 48,8, null),
//            new RouteTaxi("6", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "CityLAZ-12", null,364, 39,9, null),
//            new RouteTaxi("7", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "CityLAZ-12", null,367, 35,21, null),
//            new RouteTaxi("8", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Mercedes-Benz Sprinter", null,634, 29,13, null),
//            new RouteTaxi("9", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Ford Transit", null,243, 40,15, null),
//            new RouteTaxi("10", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Mercedes-Benz Sprinter", null,734, 32,7, null),
//            new RouteTaxi("11", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Bogdan-5", null,364, 25,14, null)
    ));

    private List<FreightTransport> freightTransports = new ArrayList<>(Arrays.asList(
//            new FreightTransport("1", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Wolf", null,242, 1350, "truck"),
//            new FreightTransport("2", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Mercedes", null,534, 500, "vane"),
//            new FreightTransport("3", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Tamiya 35291", null,634, 1570, "truck"),
//            new FreightTransport("4", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Mercedes", null,521, 700, "vane"),
//            new FreightTransport("5", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Wolf", null,623, 1350, "truck"),
//            new FreightTransport("6", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Nissan", null,627, 500, "vane"),
//            new FreightTransport("7", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Wolf", null,835, 1100, "truck"),
//            new FreightTransport("8", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Tamiya 35291", null,268, 1350, "truck")
    ));

    private List<AncillaryTransport> ancillaryTransports = new ArrayList<>(Arrays.asList(
//            new AncillaryTransport("1", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Golf-truck", null,7345, "cleaning"),
//            new AncillaryTransport("2", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "BELAZ", null,912, "building")
    ));

    private List<Driver> drivers = new ArrayList<>(Arrays.asList(
            new Driver("1", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Andriy", "Stepanov", "Olegovich", null, 12500, 5),
            new Driver("2", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Boris", "Tugov", "Denisovich", null, 10500, 3)
    ));

    private List<Worker> workers = new ArrayList<>(Arrays.asList(
            new Worker("1", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "technician", "Andriy", "Stepanov", "Olegovich", 13500, 10, null),
            new Worker("2", "name", "description", LocalDateTime.now(), LocalDateTime.now(),"fix-master", "Andriy", "Stepanov", "Olegovich", 7500, 1, null)
    ));

    private List<WorkingTeam> workingTeams = new ArrayList<>(Arrays.asList(
            new WorkingTeam("1", "name", "description", LocalDateTime.now(), LocalDateTime.now(), 1, null),
            new WorkingTeam("2", "name", "description", LocalDateTime.now(), LocalDateTime.now(), 2, null),
            new WorkingTeam("3", "name", "description", LocalDateTime.now(), LocalDateTime.now(), 3, null),
            new WorkingTeam("4", "name", "description", LocalDateTime.now(), LocalDateTime.now(), 4, null),
            new WorkingTeam("5", "name", "description", LocalDateTime.now(), LocalDateTime.now(), 5, null)
    ));

    private List<TeamLeader> teamLeaders = new ArrayList<>(Arrays.asList(
            new TeamLeader("1", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Sergey", "Morozov", "Eduardovich", 17500, 10, null),
            new TeamLeader("2", "name", "description", LocalDateTime.now(), LocalDateTime.now(),"Yuriy", "Durov", "Denisovich", 19500, 15, null)
    ));

    private List<Master> masters = new ArrayList<>(Arrays.asList(
            new Master("1", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Oleg", "Sergiyev", "Stepanovich", 20500, 22, null),
            new Master("2", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Yaroslav", "Mirosh", "Volodimirovich", 20000, 17, null)
    ));

    private List<Chief> chiefs = new ArrayList<>(Arrays.asList(
            new Chief("1", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Ivan", "Surotiv", "Yuriyovich", 29500, 27),
            new Chief("2", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Stanislav", "Tutorov", "Volodimirovich", 27000, 23)
    ));

    private List<StorageObj> storageObjs = new ArrayList<>(Arrays.asList(
            new StorageObj("1", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "garage",45, 1, 5, null),
            new StorageObj("2", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "garage", 60, 2, 7, null),
            new StorageObj("3", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "garage", 40, 3, 5, null),
            new StorageObj("4", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "box", 95, 4, 10, null),
            new StorageObj("5", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "box", 75, 5, 8, null)
    ));

    private List<Route> routes = new ArrayList<>(Arrays.asList(
            new Route("1", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Chernivtsi", "Kyiv", 397),
            new Route("2", "name", "description", LocalDateTime.now(), LocalDateTime.now(), "Chernivtsi", "Ternopil", 173)
    ));

    private List<PassangerTransportation> passangerTransportations = new ArrayList<>(Arrays.asList(
//            new PassangerTransportation("1", "name", "description", LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), null, 35),
//            new PassangerTransportation("2", "name", "description", LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), null, 55),
//            new PassangerTransportation("3", "name", "description", LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), null, 18),
//            new PassangerTransportation("4", "name", "description", LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), null, 23),
//            new PassangerTransportation("5", "name", "description", LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), null, 43)
    ));

    private List<UsageOfAncillaryTransport> usageOfAncillaryTransports = new ArrayList<>(Arrays.asList(
//            new UsageOfAncillaryTransport("1", "name", "description", LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), null),
//            new UsageOfAncillaryTransport("2", "name", "description", LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), null),
//            new UsageOfAncillaryTransport("3", "name", "description", LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), null)
    ));

    private List<Kilometrage> kilometrages = new ArrayList<>(Arrays.asList(
//            new Kilometrage("1", "name", "description", LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), null, 274),
//            new Kilometrage("2", "name", "description", LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), null, 158),
//            new Kilometrage("3", "name", "description", LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), null, 59)
    ));

    private List<Repair> repairs = new ArrayList<>(Arrays.asList(
//            new Repair("1", "name", "description", LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), null, 3500, null, 0, 1, 1, 3),
//            new Repair("2", "name", "description", LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), null, 1250, null, 1, 0, 0, 0),
//            new Repair("3", "name", "description", LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), null, 5700, null, 1, 3, 2, 1)
    ));

    private List<Transportation> transportations = new ArrayList<>(Arrays.asList(
//            new Transportation("1", "name", "description", LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), 350, null),
//            new Transportation("2", "name", "description", LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), 150, null)
    ));

    private List<RemovedTransport> removedTransports = new ArrayList<>(Arrays.asList(
//            new RemovedTransport("1", "name", "description", LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), "Audi R8", null),
//            new RemovedTransport("2", "name", "description", LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), "Nissan 350Z", null)
    ));

    private List<AddedTransport> addedTransports = new ArrayList<>(Arrays.asList(
//            new AddedTransport("1", "name", "description", LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), "Bogdan-5", null),
//            new AddedTransport("2", "name", "description", LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), "Mersedes-Benz Sprinter", null)
    ));

    public List<Bus> getBuses() {
        return buses;
    }

    public void setBuses(List<Bus> buses) {
        this.buses = buses;
    }

    public List<Taxi> getTaxis() {
        return taxis;
    }

    public void setTaxis(List<Taxi> taxis) {
        this.taxis = taxis;
    }

    public List<RouteTaxi> getRouteTaxis() {
        return routeTaxis;
    }

    public void setRouteTaxis(List<RouteTaxi> routeTaxis) {
        this.routeTaxis = routeTaxis;
    }

    public List<FreightTransport> getFreightTransports() {
        return freightTransports;
    }

    public void setFreightTransports(List<FreightTransport> freightTransports) {
        this.freightTransports = freightTransports;
    }

    public List<AncillaryTransport> getAncillaryTransports() {
        return ancillaryTransports;
    }

    public void setAncillaryTransports(List<AncillaryTransport> ancillaryTransports) {
        this.ancillaryTransports = ancillaryTransports;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    public List<WorkingTeam> getWorkingTeams() {
        return workingTeams;
    }

    public void setWorkingTeams(List<WorkingTeam> workingTeams) {
        this.workingTeams = workingTeams;
    }

    public List<TeamLeader> getTeamLeaders() {
        return teamLeaders;
    }

    public void setTeamLeaders(List<TeamLeader> teamLeaders) {
        this.teamLeaders = teamLeaders;
    }

    public List<Master> getMasters() {
        return masters;
    }

    public void setMasters(List<Master> masters) {
        this.masters = masters;
    }

    public List<Chief> getChiefs() {
        return chiefs;
    }

    public void setChiefs(List<Chief> chiefs) {
        this.chiefs = chiefs;
    }

    public List<StorageObj> getStorageObjs() {
        return storageObjs;
    }

    public void setStorageObjs(List<StorageObj> storageObjs) {
        this.storageObjs = storageObjs;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public List<PassangerTransportation> getPassangerTransportations() {
        return passangerTransportations;
    }

    public void setPassangerTransportations(List<PassangerTransportation> passangerTransportations) {
        this.passangerTransportations = passangerTransportations;
    }

    public List<UsageOfAncillaryTransport> getUsageOfAncillaryTransports() {
        return usageOfAncillaryTransports;
    }

    public void setUsageOfAncillaryTransports(List<UsageOfAncillaryTransport> usageOfAncillaryTransports) {
        this.usageOfAncillaryTransports = usageOfAncillaryTransports;
    }

    public List<Kilometrage> getKilometrages() {
        return kilometrages;
    }

    public void setKilometrages(List<Kilometrage> kilometrages) {
        this.kilometrages = kilometrages;
    }

    public List<Repair> getRepairs() {
        return repairs;
    }

    public void setRepairs(List<Repair> repairs) {
        this.repairs = repairs;
    }

    public List<Transportation> getTransportations() {
        return transportations;
    }

    public void setTransportations(List<Transportation> transportations) {
        this.transportations = transportations;
    }

    public List<RemovedTransport> getRemovedTransports() {
        return removedTransports;
    }

    public void setRemovedTransports(List<RemovedTransport> removedTransports) {
        this.removedTransports = removedTransports;
    }

    public List<AddedTransport> getAddedTransports() {
        return addedTransports;
    }

    public void setAddedTransports(List<AddedTransport> addedTransports) {
        this.addedTransports = addedTransports;
    }
}
