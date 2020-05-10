package edu.nick.cursach.service.Transport.impls;

import edu.nick.cursach.model.Transport;
import edu.nick.cursach.service.AncillaryTransport.impls.AncillaryTransportServiceImpl;
import edu.nick.cursach.service.Bus.impls.BusServiceImpl;
import edu.nick.cursach.service.FreightTransport.impls.FreightTransportServiceImpl;
import edu.nick.cursach.service.RouteTaxi.impls.RouteTaxiServiceImpl;
import edu.nick.cursach.service.Taxi.impls.TaxiServiceImpl;
import edu.nick.cursach.service.Transport.interfaces.ITransportService;
import edu.nick.cursach.service.Transportation.interfaces.ITransportationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransportServiceImpl implements ITransportService {

    @Autowired
    AncillaryTransportServiceImpl ancillaryTransportService;
    @Autowired
    BusServiceImpl busService;
    @Autowired
    FreightTransportServiceImpl freightTransportService;
    @Autowired
    RouteTaxiServiceImpl routeTaxiService;
    @Autowired
    TaxiServiceImpl taxiService;

    @Override
    public List<Transport> getAll() {

        //Get list of all types of transport
        List<Transport> transportList = new ArrayList<Transport>(ancillaryTransportService.getAll());
        transportList.addAll(busService.getAll());
        transportList.addAll(freightTransportService.getAll());
        transportList.addAll(routeTaxiService.getAll());
        transportList.addAll(taxiService.getAll());

        return transportList;
    }

    public List<Transport> getPassangerTransportList() {

        //Get list of passanger types of transport
        List<Transport> transportList = new ArrayList<Transport>(busService.getAll());
        transportList.addAll(routeTaxiService.getAll());

        return transportList;
    }

    @Override
    public Transport get(String id) {
        Transport toReturn = this.getAll().stream()
                .filter(transport -> id.equals(transport.getId()))
                .findAny()
                .orElse(null);
        return toReturn;
    }
}
