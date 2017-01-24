package model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;

@JsonAutoDetect
public class Trip
{
    private int orderNumber;
    private Date orderDate;
    private Status status;
    private String address;

    public Trip()
    {
    }

    public Trip(int orderNumber, String address)
    {
        this.orderNumber = orderNumber;
        this.address = address;
        this.orderDate = new Date();
        this.status = Status.NEW_ORDER;
    }

    public int getOrderNumber()
    {
        return orderNumber;
    }

    public Date getOrderDate()
    {
        return orderDate;
    }

    public Status getStatus()
    {
        return status;
    }

    public void setStatus(Status status)
    {
        this.status = status;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    @Override
    public String toString()
    {
        return "Trip{" +
                "orderNumber=" + orderNumber +
                ", orderDate=" + orderDate +
                ", status=" + status +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trip trip = (Trip) o;

        if (orderNumber != trip.orderNumber) return false;
        if (!orderDate.equals(trip.orderDate)) return false;
        if (status != trip.status) return false;
        return address.equals(trip.address);
    }

    @Override
    public int hashCode()
    {
        return orderDate.hashCode();
    }


    /**
     * Для отображения в таблице
     */
    public StringProperty orderNumberProp()
    {
        return new SimpleStringProperty(orderNumber + "");
    }

    public SimpleObjectProperty<Date> orderDateProp()
    {
        return new SimpleObjectProperty<>(orderDate);
    }

    public StringProperty orderStatusProp()
    {
        String statusText;
        switch (status)
        {
            case NEW_ORDER:
                statusText = "New order";
                break;
            case CANCELLED:
                statusText = "Cancelled order";
                break;
            case DONE:
                statusText = "Done order";
                break;
            default:
                statusText = "New order";
                break;
        }

        return new SimpleStringProperty(statusText);
    }

    public StringProperty orderAddressProp()
    {
        return new SimpleStringProperty(address);
    }
}
