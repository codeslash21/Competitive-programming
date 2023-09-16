class SeatManager {
    int[] seats;
    int lowest;
    public SeatManager(int n) {
        seats = new int[n];
        lowest=0;
    }
    
    public int reserve() {
        if(seats[lowest]!=1) 
            seats[lowest]=1;
        else {
            while(seats[lowest]!=0)
                lowest++;
            seats[lowest]=1;
        }
        lowest++;
        return lowest;
    }
    
    public void unreserve(int seatNumber) {
        seats[seatNumber-1]=0;
        if(seatNumber-1<lowest)
            lowest=seatNumber-1;
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
