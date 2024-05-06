package Ticket;

import java.util.Random;
import java.util.Scanner;

public class PassengerSitting
{
    private int seatNo;
    private int Cabin;
    private int carriageNo;

    public PassengerSitting(int seatNo,int cabin, int carriageNo)
    {
        setCabin(cabin);
        setCarriageNo(carriageNo);
        setSeatNo(seatNo);
    }
    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public int getCabin() {
        return Cabin;
    }

    public void setCabin(int cabin) {
        Cabin = cabin;
    }

    public int getCarriageNo() {
        return carriageNo;
    }

    public void setCarriageNo(int carriageNo) {
        this.carriageNo = carriageNo;
    }
}
